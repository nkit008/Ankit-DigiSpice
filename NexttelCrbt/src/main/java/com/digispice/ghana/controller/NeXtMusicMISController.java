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

import com.digispice.ghana.bean.NextMusicMISEntity;
import com.digispice.ghana.dao.CrbtMisDao;
import com.digispice.ghana.mispoi.NextMusicpoi;

@Controller
public class NeXtMusicMISController {

	@Autowired
	HttpSession session;

	@Autowired
	CrbtMisDao misdao;

	@Autowired
	NextMusicpoi poi;

	private static final Logger logger = LoggerFactory.getLogger(NeXtMusicMISController.class);

	private String fromdate;
	private String todate;

	@RequestMapping(value = "/neXtMusicMIShome")
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
			return "neXtMusicMIShome";
		}
	}

	@RequestMapping(value = "/neXtMusicMisAction", method = RequestMethod.POST)
	public String neXtMusicMisAction(@RequestParam("fromDate") String fDate, @RequestParam("toDate") String endDate,
			Model model) throws ParseException {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			fromdate = null;
			todate = null;
			return "redirect:/logout";
		}

		else {
			fromdate = changeFormat(fDate);
			todate = changeFormat(endDate);
			List<NextMusicMISEntity> misWapInternal = misdao.getNextMusicMis(fromdate, todate);
			if (misWapInternal != null) {
				logger.info("Size of list in NeXtMusicMISController {}", misWapInternal.size());
				model.addAttribute("reportdata", misWapInternal);
			}

			else {
				logger.info("no data list in NeXtMusicMISController");
				model.addAttribute("reportdata", misWapInternal);
			}

			return "neXtMusicMisView";
		}

	}
	
	
	@RequestMapping(value = "/neXtMusicMisAction", method = RequestMethod.GET)
	public String neXtMusicMisAction() throws ParseException {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			fromdate = null;
			todate = null;
			return "redirect:/logout";
		}

		else {
			return "redirect:/neXtMusicMIShome";
		}

	}

	public String changeFormat(String dateString) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date = df.parse(dateString);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		return df1.format(date);

	}

	@RequestMapping(value = "/reportxlsNextMusic")
	public String reportxlsNextMusic(HttpServletRequest request, HttpServletResponse response, Model model)
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
				List<NextMusicMISEntity> misWapInternal = misdao.getNextMusicMis(fromdate, todate);
				if (misWapInternal.size() != 0) {
					resource = new ClassPathResource("/excel/Nexttel_neXtMusic.xlsx");
					InputStream is = null;
					try {
						is = ((InputStreamSource) resource).getInputStream();
					} catch (Throwable e) {
						e.printStackTrace();
					}

					int startRowIndex = 0;
					int startColIndex = 3;
					poi.genrateNextMusicXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate,
							todate,"manual");
				}
			}

			else {
				return "redirect:/mishome";
			}

		}
		return null;
	}

	@RequestMapping(value = "/reportxlsNextMusicURL")
	public void reportxlsUrl(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ParseException {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date myDate = calendar.getTime();
		String todate = df1.format(myDate);

		fromdate = todate.substring(0, 4) + "-" + todate.substring(5, 7) + "-01";

		if (fromdate != null && todate != null) {
			ClassPathResource resource = null;
			List<NextMusicMISEntity> misWapInternal = misdao.getNextMusicMis(fromdate, todate);
			logger.info("size of list is " + misWapInternal.size());
			if (misWapInternal.size() != 0) {
				resource = new ClassPathResource("/excel/Nexttel_neXtMusic.xlsx");
				InputStream is = null;
				try {
					is = ((InputStreamSource) resource).getInputStream();
				} catch (Throwable e) {
					e.printStackTrace();
				}

				int startRowIndex = 0;
				int startColIndex = 3;
				System.out.println("poiiiiii");
				poi.genrateNextMusicXLS(is, startRowIndex, startColIndex, response, misWapInternal, fromdate, todate,"automailer");
			}
		}
	}

}
