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
import com.digispice.cci.zambia.entity.BeatsUserStatusBean;
import com.digispice.cci.zambia.entity.ZamtelBeatsBillingHistory;
import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;
import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;
import com.digispice.cci.zambia.mispoi.ZemtalBeatsPOI;
import com.digispice.cci.zambia.service.ZamtelBeatsService;

@Controller
public class ZamtelBeatsController {

	@Autowired
	HttpSession session;

	@Autowired
	ZamtelBeatsService zamtelBeatsService;
	
	@Autowired
	ZemtalBeatsPOI poi;

	private static final Logger logger = LoggerFactory.getLogger(ZamtelBeatsController.class.getName());
	private final String UPLOAD_DIRECTORY;
	String metaPath = null;
	private static final String REDIRECT_LOGOUT = "redirect:/logout";
	String fromdate = null, todate = null;

	public ZamtelBeatsController() {
		UPLOAD_DIRECTORY = GetConnection.loadProp("UPLOAD_DIRECTORY");
	}

	@GetMapping(value = "/zamtelBeatsUserDetails")
	public String zamtelBeatsUserDetails() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelBeats-checkUserDetails";
		}
	}

	@GetMapping("/zemtalBeatsUserDetail")
	public String zemtalBeatsDetailsAction1() {
		logger.info("Get Request for Check User Status");
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelBeats-checkUserDetails";
		}
	}

	@PostMapping("/zemtalBeatsDetailsAction")
	public String zemtalBeatsDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			logger.info("ani is {}", ani);
			try {
				BeatsUserStatusBean userStatusBean = zamtelBeatsService.checkUserDetailsBeats(ani);
				if (userStatusBean.getCode().equals("0") || userStatusBean.getCode() == null) {
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

			return "redirect:/zemtalBeatsUserDetail";
		}
	}

	@GetMapping("/zamtelBeatsSingleSubscription")
	public String zamtelBeatsSingleSubscription() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelBeats-singleSubscription";
		}
	}

	@GetMapping("/zamtelBeatsSingleSubscriptionAction")
	public String zamtelBeatsSingleSubscriptionAction(@RequestParam String ani, @RequestParam String pricePoint,
			RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			String response = zamtelBeatsService.singleSubscriptionBeats(ani, pricePoint);
			redir.addFlashAttribute("msg", response);
			return "redirect:/zamtelBeatsSingleSubscription";
		}
	}

	@GetMapping("/zamtelBeatsSingleUnsubscription")
	public String zamtelBeatsSingleUnsubscription() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelBeats-singleUnSubscription";
		}
	}

	@GetMapping("/zamtelBeatsUnSubscriptionAction")
	public String zamtelBeatsUnSubscriptionAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			String response = zamtelBeatsService.singleUnSubscriptionBeats(ani);
			redir.addFlashAttribute("msg", response);
			return "redirect:/zamtelBeatsSingleUnsubscription";
		}

	}

	@GetMapping("/zamtelBeatsBillingDetails")
	public String zamtelBeatsBillingDetails() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelBeats-userBillingDetails";
		}
	}

	@PostMapping("/zamtelBeatsBillingDetailsAction")
	public String zamtelBeatsBillingDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			List<ZamtelBeatsBillingHistory> billingHistory = zamtelBeatsService.beatsBillingDetails(ani);
			if (billingHistory.size() == 0)
				redir.addFlashAttribute("msg", "No record found for " + ani);

			redir.addFlashAttribute("billingList", billingHistory);
			return "redirect:/zamtelBeatsBillingDetails";
		}
	}

	@GetMapping("/zamtelBeatsBillingDetailsAction")
	public String zamtelBeatsBillingDetailsActionGet() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "redirect:/zamtelBeatsBillingDetails";
		}
	}

	@GetMapping("/zamtelBeatsBulkSubscription")
	public String zamtelBeatsBulkSubscription() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		}

		else {
			return "zamtelBeats-bulkSubscription";
		}
	}

	@PostMapping(value = "zamtelBeatsBulkSubscriptionAction")
	public String neXtVoiceBulkSubscriptionAction(@RequestParam String pricePoint, @RequestParam MultipartFile ani,
			RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		} else {

			String uploadBeatsBulkFile = GetConnection.loadProp("zamtel.beats.bulkSubPath");
			String fileName = ani.getOriginalFilename();
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = sdf.format(d);

			if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("txt")) {
				logger.info("Bulk Subscription for Service Zamtel Beats");
				logger.info("UPLOAD_DIRECTORY_ZamtelBeats path is  {}", uploadBeatsBulkFile);

				Path filePath = Paths.get(uploadBeatsBulkFile + date + "_" + fileName);
				try (OutputStream os = Files.newOutputStream(filePath)) {
					os.write(ani.getBytes());
				} catch (Exception e) {
					logger.info("Exception Occured in Copy Bulk File {}", e);
				}

				String response = zamtelBeatsService.zamtelBeatsBulkSub(filePath.toString(), pricePoint);
				redir.addFlashAttribute("msg", response);

			}
		}

		return "redirect:/zamtelBeatsBulkSubscription";
	}
	
	
	@GetMapping("zemtalBeatsMIShome")
	public String zemtalBeatsMIShome() {
		if (session.getAttribute("userObj") == null) {
			return REDIRECT_LOGOUT;
		} else {

			return "zemtalBeats-misHome";
		}

	}
	
	
	
	@PostMapping("/zamtelBeatsMISAction")
	public String zamtelBeatsMISAction(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			Model model) throws ParseException {
		if (session.getAttribute("userObj") == null) {
			fromdate = null;
			todate = null;
			return REDIRECT_LOGOUT;
		} else {
			fromdate = changeFormat(fDate);
			todate = changeFormat(endDate);
			List<ZamtelBeatsMISEntity> misWapInternal = zamtelBeatsService.getzamtelBeatsMIS(fromdate, todate);
			if (misWapInternal != null) {
				logger.info("Size of list in Zemtal Games List {}", misWapInternal.size());
				model.addAttribute("reportdata", misWapInternal);
			}

			else {
				logger.info("no data list in TBL_MIS_ZEMTAL_BEATZ");
				model.addAttribute("reportdata", misWapInternal);
			}

			return "zemtalBeats-misView";
		}

	}

	@GetMapping("/zamtelBeatsMISAction")
	public String getZamtelBeatsMISAction() {
		return "redirect:/zemtalBeatsMishome";
	}


	public String changeFormat(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = df.parse(dateString);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		return df1.format(date);

	}
	
	
	@GetMapping("/reportxlsZemtalBeats")
	public String reportxlsZemtalBeats(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		if (session.getAttribute("userObj") == null) {
			fromdate = null;
			todate = null;
			return REDIRECT_LOGOUT;
		} else {
			if (fromdate != null && todate != null) {
				List<ZamtelBeatsMISEntity> misWapInternal = zamtelBeatsService.getzamtelBeatsMIS(fromdate, todate);
				if (misWapInternal != null) {
					ClassPathResource resource = null;
					resource = new ClassPathResource("/excel/Beats_Zamtel.xlsx");
					InputStream is = null;
					try {
						is = ((InputStreamSource) resource).getInputStream();
					} catch (Throwable e) {
						e.printStackTrace();
					}

					int startRowIndex = 0;
					int startColIndex = 3;
					poi.genrateZemtalBeatsXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate,
							todate);
				}

			}

			else {
				return "zemtalBeats-misView";
			}

		}

		return null;

	}
	
	
	
	@GetMapping("/reportxlsZemtalBeatsAutoDownload")
	public void reportxlsZemtalBeatsAuto(HttpServletRequest request, HttpServletResponse response)
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
			List<ZamtelBeatsMISEntity> misWapInternal = zamtelBeatsService.getzamtelBeatsMIS(fromdate, todate);
			if (misWapInternal != null) {
				ClassPathResource resource = null;
				resource = new ClassPathResource("/excel/Beats_Zamtel.xlsx");
				InputStream is = null;
				try {
					is = ((InputStreamSource) resource).getInputStream();
				} catch (Throwable e) {
					e.printStackTrace();
				}

				int startRowIndex = 0;
				int startColIndex = 2;
				poi.genrateZemtalBeatsXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate,
						todate);
			}

		}

	}

}