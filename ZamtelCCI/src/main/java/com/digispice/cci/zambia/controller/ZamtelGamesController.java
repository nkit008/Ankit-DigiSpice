package com.digispice.cci.zambia.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.cci.zambia.connection.GetConnection;
import com.digispice.cci.zambia.entity.UserStatusBean;
import com.digispice.cci.zambia.entity.ZamtelGamesBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;
import com.digispice.cci.zambia.mispoi.ZemtalGamesPOI;
import com.digispice.cci.zambia.service.ZamtelGamesService;

@Controller
public class ZamtelGamesController {

	@Autowired
	HttpSession session;

	@Autowired
	ZamtelGamesService zamtelGamesService;

	@Autowired
	ZemtalGamesPOI poi;

	private static final Logger logger = LoggerFactory.getLogger(ZamtelGamesController.class.getName());
	private final String UPLOAD_DIRECTORY;
	String metaPath = null;
	private static final String REDIRECT_LOGOUT = "redirect:/logout";
	String fromdate = null, todate = null;

	public ZamtelGamesController() {
		UPLOAD_DIRECTORY = GetConnection.loadProp("UPLOAD_DIRECTORY");
	}

	@GetMapping(value = "/zamtelGamesUserDetails")
	public String zamtelGamesUserDetails() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelGames-checkUserDetails";
		}
	}

	@GetMapping("/zemtalGamesUserDetail")
	public String zemtalGamesDetailsAction1() {
		logger.info("Get Request for Check User Status");
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelGames-checkUserDetails";
		}
	}

	@PostMapping("/zemtalGamesDetailsAction")
	public String zemtalGamesDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			logger.info("ani is {}", ani);
			try {
				UserStatusBean userStatusBean = zamtelGamesService.checkUserDetails(ani);
				if (userStatusBean.getMobileNumber().equals("") || userStatusBean.getMobileNumber() == null) {
					logger.info("No record found for Number {}", ani);
					redir.addFlashAttribute("msg", "No Record Found for " + ani);
				} else {
					logger.info("Record found for Number {}", ani);
					redir.addFlashAttribute("data", userStatusBean);
					redir.addFlashAttribute("tableExist", "yes");
				}
			} catch (Exception e) {
				logger.info("Exception Occured {}", e);
			}

			return "redirect:/zemtalGamesUserDetail";
		}
	}

	@GetMapping("/zamtelGamesSingleSubscription")
	public String zamtelGamesSingleSubscription() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelGames-singleSubscription";
		}
	}

	@GetMapping("/zamtelGamesSingleSubscriptionAction")
	public String zamtelGamesSingleSubscriptionAction(@RequestParam String ani, @RequestParam String pricePoint,
			RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			String response = zamtelGamesService.singleSubscription(ani, pricePoint);
			redir.addFlashAttribute("msg", response);
			return "redirect:/zamtelGamesSingleSubscription";
		}
	}

	@GetMapping("/zamtelGamesSingleUnsubscription")
	public String zamtelGamesSingleUnsubscription() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelGames-singleUnSubscription";
		}
	}

	@GetMapping("/zamtelGamesUnSubscriptionAction")
	public String zamtelGamesUnSubscriptionAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			String response = zamtelGamesService.singleUnSubscription(ani);
			redir.addFlashAttribute("msg", response);
			return "redirect:/zamtelGamesSingleUnsubscription";
		}

	}

	@GetMapping("/zamtelGamesBillingDetails")
	public String zamtelGamesBillingDetails() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelGames-userBillingDetails";
		}
	}

	@PostMapping("/zamtelGamesBillingDetailsAction")
	public String zamtelGamesBillingDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			List<ZamtelGamesBillingHistory> billingHistory = zamtelGamesService.gamesBillingDetails(ani);
			if (billingHistory.size() == 0)
				redir.addFlashAttribute("msg", "No record found for " + ani);

			redir.addFlashAttribute("billingList", billingHistory);
			return "redirect:/zamtelGamesBillingDetails";
		}
	}

	@GetMapping("/zamtelGamesBillingDetailsAction")
	public String zamtelGamesBillingDetailsActionGet(@RequestParam String ani) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "redirect:/zamtelGamesBillingDetails";
		}
	}

	@GetMapping("/zamtelGamesBulkSubscription")
	public String zamtelGamesBulkSubscription() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelGames-bulkSubscription";
		}
	}

	@PostMapping(value = "zamtelGamesBulkSubscriptionAction")
	public String zamtelGamesBulkSubscriptionAction(@RequestParam String pricePoint, @RequestParam MultipartFile ani,
			RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		} else {

			String uploadGamesBulkFile = GetConnection.loadProp("zamtel.games.bulkSubPath");
			String fileName = ani.getOriginalFilename();
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = sdf.format(d);

			if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("txt")) {
				logger.info("Bulk Subscription for Service Zamtel Games");
				logger.info("UPLOAD_DIRECTORY_ZamtelGames path is  {}", uploadGamesBulkFile);

				Path filePath = Paths.get(uploadGamesBulkFile + date + "_" + fileName);
				try (OutputStream os = Files.newOutputStream(filePath)) {
					os.write(ani.getBytes());
				} catch (Exception e) {
					logger.info("Exception Occured in Copy Bulk File {}", e);
				}

				String response = zamtelGamesService.zamtelGamesBulkSub(filePath.toString(), pricePoint);
				redir.addFlashAttribute("msg", response);

			}
		}

		return "redirect:/zamtelGamesBulkSubscription";
	}

	@GetMapping("zemtalGamesMishome")
	public String zemtalGamesMishome() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		} else {

			return "zemtalGames-misHome";
		}

	}

	@PostMapping("/zamtelGamesMISAction")
	public String zamtelGamesMISAction(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			Model model) throws ParseException {
		if (session.getAttribute("userObj") == null) {
			fromdate = null;
			todate = null;
			return REDIRECT_LOGOUT;
		} else {
			fromdate = changeFormat(fDate);
			todate = changeFormat(endDate);
			List<ZamtelGamesMISEntity> misWapInternal = zamtelGamesService.getzamtelGamesMIS(fromdate, todate);
			if (misWapInternal != null) {
				logger.info("Size of list in Zemtal Games List {}", misWapInternal.size());
				model.addAttribute("reportdata", misWapInternal);
			}

			else {
				logger.info("no data list in TBL_BILLING_MIS_DATA");
				model.addAttribute("reportdata", misWapInternal);
			}

			return "zemtalGames-misView";
		}

	}

	@GetMapping("/zamtelGamesMISAction")
	public String getZamtelGamesMISAction() {
		return "redirect:/zemtalGamesMishome";
	}

	public String changeFormat(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = df.parse(dateString);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		return df1.format(date);

	}

	@GetMapping("/reportxlsZemtalGames")
	public String reportxlsZemtalGames(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		if (session.getAttribute("userObj") == null) {
			fromdate = null;
			todate = null;
			return REDIRECT_LOGOUT;
		} else {
			if (fromdate != null && todate != null) {
				List<ZamtelGamesMISEntity> misWapInternal = zamtelGamesService.getzamtelGamesMIS(fromdate, todate);
				if (misWapInternal != null) {
					ClassPathResource resource = null;
					resource = new ClassPathResource("/excel/GameHub_Zamtel.xlsx");
					InputStream is = null;
					try {
						is = ((InputStreamSource) resource).getInputStream();
					} catch (Throwable e) {
						e.printStackTrace();
					}

					int startRowIndex = 0;
					int startColIndex = 2;
					poi.genrateZemtalGamesXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate,
							todate);
				}

			}

			else {
				return "zemtalGames-misView";
			}

		}

		return null;

	}

	@GetMapping("/reportxlsZemtalGamesAutoDownload")
	public void reportxlsZemtalGamesAuto(HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		date = cal.getTime();
		todate = dateFormat.format(date);
		fromdate = todate.substring(0, 8) + "01";
		if (fromdate != null && todate != null) {
			List<ZamtelGamesMISEntity> misWapInternal = zamtelGamesService.getzamtelGamesMIS(fromdate, todate);
			if (misWapInternal != null) {
				ClassPathResource resource = null;
				resource = new ClassPathResource("/excel/GameHub_Zamtel.xlsx");
				InputStream is = null;
				try {
					is = ((InputStreamSource) resource).getInputStream();
				} catch (Throwable e) {
					e.printStackTrace();
				}

				int startRowIndex = 0;
				int startColIndex = 2;
				poi.genrateZemtalGamesXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate, todate);
			}

		}

	}

}