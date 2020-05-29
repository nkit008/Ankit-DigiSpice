package com.digispice.ghana.controller;

import java.io.InputStream;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digispice.ghana.bean.CrbtMisBean;
import com.digispice.ghana.dao.CrbtMisDao;
import com.digispice.ghana.mispoi.MISCrbtPOI;

@Controller
public class MisController {

	@Autowired
	HttpSession session;

	@Autowired
	CrbtMisDao misdao;

	@Autowired
	MISCrbtPOI poi;

	private static final Logger logger = LoggerFactory.getLogger(MisController.class);

	private String fromdate;
	private String todate;
	private String aceespage;

	@RequestMapping(value = "/neXtTunesMishome")
	public String mis_home() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			fromdate = null;
			todate = null;
			return "redirect:/logout";
		}

		else {
			fromdate = null;
			todate = null;
			return "mis_home";
		}
	}

	@RequestMapping(value = "/neXtTunesMisAction", method = RequestMethod.GET)
	public String mishome1(Model model) throws ParseException {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			fromdate = null;
			todate = null;
			return "redirect:/logout";
		}

		else {
			List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate);

			logger.info("Size of list in mishome1 " + misWapInternal.size());
			model.addAttribute("reportdata", misWapInternal);
			return "CrbtMishome";
		}

	}

	@RequestMapping(value = "/mis", method = RequestMethod.POST)
	public String misFunstore(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			/* @RequestParam("accessService") String aceesService, */Model model) throws ParseException {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			fromdate = null;
			todate = null;
			return "redirect:/logout";
		}

		else {
			logger.info("fetching mis between " + fDate + " and " + endDate);
			fromdate = changeFormat(fDate);
			todate = changeFormat(endDate);
			logger.info("fromdate " + fDate + " enddate " + endDate);

			/* aceespage = aceesService; */
			List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate/* , aceespage */);
			logger.info("Size of list is " + misWapInternal.size());
			model.addAttribute("reportdata", misWapInternal);
			return "redirect:/neXtTunesMisAction";
		}

	}

	public String changeFormat(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = df.parse(dateString);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		return df1.format(date);

	}

	@RequestMapping(value = "mislogout")
	public String logout() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			fromdate = null;
			todate = null;
			return "index";
		}

		else {
			session.removeAttribute("userobj");
			session.invalidate();
			logger.info("---logout successfully!---");
			fromdate = null;
			todate = null;
			return "index";
		}
	}

	@RequestMapping(value = "/reportxlsCrbt")
	public String reportxlsBhakti(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ParseException {
		if (session.getAttribute("userobj") == null) {
			fromdate = null;
			todate = null;
			logger.info("--session expired--");
			return "index";
		}

		else {
			if (fromdate != null && todate != null) {
				ClassPathResource resource = null;
				List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate/* , aceespage */);
				if (misWapInternal.size() != 0) {
					resource = new ClassPathResource("/excel/CrbtMIS.xls");
					InputStream is = null;
					try {
						is = ((InputStreamSource) resource).getInputStream();
					} catch (Throwable e) {
						e.printStackTrace();
					}

					int startRowIndex = 0;
					int startColIndex = 3;
					poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate,
							todate,"manual");
				}
			}

			else {
				return "redirect:/mishome";
			}

		}
		return null;
	}

	@RequestMapping(value = "/reportxlsCrbtURL")
	public void reportxlsUrl(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ParseException {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date myDate = calendar.getTime();
		String todate = df1.format(myDate);

		fromdate = todate.substring(0, 4) + "-" + todate.substring(5, 7) + "-01";

		logger.info("to date is {} ,from date is {}", todate, fromdate);

		if (fromdate != null && todate != null) {
			ClassPathResource resource = null;
			List<CrbtMisBean> misWapInternal = misdao.getMis(fromdate, todate);
			logger.info("sizr of list is " + misWapInternal.size());
			if (misWapInternal.size() != 0) {
				resource = new ClassPathResource("/excel/CrbtMIS.xls");
				InputStream is = null;
				try {
					is = ((InputStreamSource) resource).getInputStream();
				} catch (Throwable e) {
					e.printStackTrace();
				}

				int startRowIndex = 0;
				int startColIndex = 3;
				poi.genrateXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate, todate,"automailer");
			}
		}
	}

}