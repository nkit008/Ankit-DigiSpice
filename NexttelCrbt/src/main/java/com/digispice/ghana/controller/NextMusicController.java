package com.digispice.ghana.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.ghana.bean.NextMusicSubDetails;
import com.digispice.ghana.bean.NextMusicUnsubDetail;
import com.digispice.ghana.bean.NextMusicUserBillingDetails;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.NextMusicActionDao;

@Controller
public class NextMusicController {

	@Autowired
	HttpSession session;

	@Autowired
	NextMusicActionDao modActionDao;

	private static final Logger logger = LoggerFactory.getLogger(NextMusicController.class.getName());
	private final String UPLOAD_DIRECTORY;
	String metaPath = null;

	public NextMusicController() {
		UPLOAD_DIRECTORY = GetConnection.loadProp("UPLOAD_DIRECTORY");
	}

	@RequestMapping(value = "/neXtMusicCheckUserDetails")
	public String home() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		}

		else {
			return "mod-checkUserDetails";
		}
	}

	@RequestMapping(value = "/neXtMusicUserDetails")
	public String neXtMusicUserDetails(@ModelAttribute("token") String token) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		}

		else {
			if (token.equalsIgnoreCase("yes"))
				return "mod-checkUserDetailsShow";
			else
				return "mod-checkUserDetails";
		}
	}

	@RequestMapping(value = "mod-UserDetailsAction", method = RequestMethod.POST)
	public String neXtMusicUserDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("Fetching user detail for Service neXtMusic ANI {}", ani);
			ArrayList<NextMusicSubDetails> subdetail = modActionDao.modUserDetailsforsub(ani);
			logger.info("No. of records in Subcription table is {}", subdetail.size());
			redir.addFlashAttribute("mobile", ani);
			if (subdetail.isEmpty() == false) {
				redir.addFlashAttribute("status", "Subscribed");
				// redir.addFlashAttribute("subdata", subdetail);
			} else {
				ArrayList<NextMusicUnsubDetail> unsubdetail = modActionDao.modUserDetailsforUnsub(ani);
				logger.info("No. of records in UnSubcription table is {}", unsubdetail.size());
				if (unsubdetail.isEmpty() == false) {
					redir.addFlashAttribute("status", "UnSubscribed");
					// redir.addFlashAttribute("unsubdata", unsubdetail);
				}

				else {
					redir.addFlashAttribute("msg", "No Record found Regarding the Number " + ani);
				}
			}

			return "redirect:/neXtMusicCheckUserDetails";
		}
	}

	@RequestMapping(value = "neXtMusicUserDetailsActionDetails", method = RequestMethod.GET)
	public String neXtMusicUserDetailsActionDetails(@RequestParam String ani, @RequestParam String status,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("Fetching user detail for Service neXtMusic ANI {} for type {}", ani, status);

			if (status.trim().equalsIgnoreCase("Subscribed")) {
				ArrayList<NextMusicSubDetails> subdetail = modActionDao.modUserDetailsforsub(ani);
				logger.info("No. of records in Subcription table is {}", subdetail.size());
				if (subdetail.isEmpty() == false) {
					redir.addFlashAttribute("subdata", subdetail);
					redir.addFlashAttribute("token", "yes");
				}

			}

			else if (status.trim().equalsIgnoreCase("UnSubscribed")) {
				ArrayList<NextMusicUnsubDetail> unsubdetail = modActionDao.modUserDetailsforUnsub(ani);
				logger.info("No. of records in UnSubcription table is {}", unsubdetail.size());
				if (unsubdetail.isEmpty() == false) {

					redir.addFlashAttribute("unsubdata", unsubdetail);
					redir.addFlashAttribute("token", "yes");
				}
			}

			else {
				logger.info("No Record Found for Mobile Number " + ani);
				redir.addFlashAttribute("msg", "No Record Found for Mobile Number " + ani);
			}

			return "redirect:/neXtMusicUserDetails";
		}
	}

	@RequestMapping(value = "neXtMusicSingleSubscription")
	public String neXtMusicmodSingleSubscription() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			return "mod-singleSubscription";
		}
	}

	@RequestMapping(value = "mod_SingleSubscriptionAction")
	public String neXtMusicmodSingleSubscriptionAction(@RequestParam String ani, @RequestParam String pricePoint,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("Single Subscription for Service neXtMusic, ANI {} and Pack {}", ani, pricePoint);
			String response = modActionDao.modSinleSubscription(ani, pricePoint);
			if (response != null) {
				redir.addFlashAttribute("msg",
						"We have initiated your subscription request. You will get confirmation SMS Shortly.");
			} else {
				redir.addFlashAttribute("msg", "something went wrong!!! " + ani + " is not subscribed");
			}
			return "redirect:/neXtMusicSingleSubscription";
		}
	}

	@RequestMapping(value = "neXtMusicBulkSubscription")
	public String neXtMusicmodBulkSubscription() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			return "mod-bulkSubscription";
		}
	}

	@RequestMapping(value = "mod_BulkSubscriptionAction", method = RequestMethod.POST)
	public String neXtMusicmodBulkSubscriptionAction(@RequestParam String pricePoint, @RequestParam MultipartFile ani,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			String fileName = ani.getOriginalFilename();

			if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("txt")) {
				logger.info("Bulk Subscription for Service neXtMusic");
				metaPath = copyMetaFile(ani, UPLOAD_DIRECTORY);
				logger.info("File Copied to {[" + metaPath + "}]");
				String response = modActionDao.bulkModSinleSubscription(pricePoint, metaPath);
				if (response.equalsIgnoreCase("success")) {
					redir.addFlashAttribute("msg",
							"We have initiated your subscription request. You will get confirmation SMS Shortly.");
				} else if (response.equalsIgnoreCase("exception")) {
					redir.addFlashAttribute("msg", "Something went wrong!!! Please contact to your Administrator");
				}

				else if (response.equalsIgnoreCase("incorrectNumber")) {
					redir.addFlashAttribute("msg", "File contains Incorrect numbers, please insert valid numbers");
				}
			} else {
				logger.info("Extension is not txt");
				redir.addFlashAttribute("msg", "Please upload a .txt file");
			}

			return "redirect:/neXtMusicBulkSubscription";
		}
	}

	@RequestMapping(value = "neXtMusicSingleUnSubscription")
	public String neXtMusicmodSingleUnSubscription() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("UnSubscription for Service neXtMusic");
			return "mod-singleUnSubscription";
		}
	}

	@RequestMapping(value = "mod_UnSubscriptionAction")
	public String neXtMusicmodUnSubscriptionAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("UnSubscription from Service neXtMusic for ANI {}", ani);
			String response = modActionDao.modUnSubscription(ani);
			if (response.equalsIgnoreCase("1")) {
				redir.addFlashAttribute("msg",
						"We have initiated your Un-Subscription request. You will get confirmation SMS Shortly.");
			}

			else if (response.equalsIgnoreCase("0")) {
				redir.addFlashAttribute("msg", "user not Unsubscribed successfully");
			}

			else {
				redir.addFlashAttribute("msg", "Something went wrong!!! Please contact to your Administrator");
			}

			return "redirect:/neXtMusicSingleUnSubscription";
		}
	}

	@RequestMapping(value = "neXtMusicUserBillingDetails")
	public String neXtMusicmodUserBillingDetails() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("User Billing Deatils for Service neXtMusic");
			return "mod-userBillingDetails";
		}
	}

	@RequestMapping(value = "mod_userBillingDetailsAction", method = RequestMethod.POST)
	public String neXtMusicuserBillingDetails(@RequestParam String ani, RedirectAttributes redir) {
		List<NextMusicUserBillingDetails> userBillingDetails = null;
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("UserBilling Details for Service neXtMusic and ANI {}", ani);
			userBillingDetails = modActionDao.getModUserBillingDetails(ani);
			logger.info(userBillingDetails.toString());

			if (userBillingDetails.isEmpty() == false) {
				redir.addFlashAttribute("data", userBillingDetails);
			}

			else {
				logger.info("No Billing Details for Service neXtMusic and ANI {}", ani);
				redir.addFlashAttribute("msg", "No User Details found for " + ani);
			}

			return "redirect:/neXtMusicUserBillingDetails";
		}
	}

	public String copyMetaFile(MultipartFile metafile, String UPLOAD_DIRECTORY) {
		try {
			logger.info("File name is " + metafile.getOriginalFilename());
			String filename = metafile.getOriginalFilename().substring(0,
					metafile.getOriginalFilename().lastIndexOf("."));
			logger.info("Uploaded File name for Bulk Subscription is " + filename);
			String ext = metafile.getOriginalFilename().substring(metafile.getOriginalFilename().lastIndexOf(".") + 1);
			logger.info("Uploaded File Extension for Bulk Subscription is " + ext);

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyHHmm");
			Date date = new Date();
			File file = new File(UPLOAD_DIRECTORY);
			if (!file.exists()) {
				logger.info("creating directory {} if doesn't exist", UPLOAD_DIRECTORY);
				file.mkdirs();
			}

			byte[] bytes = metafile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
					new File(UPLOAD_DIRECTORY + File.separator + filename + "_" + formatter.format(date) + "." + ext)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			metaPath = UPLOAD_DIRECTORY + File.separator + filename + "_" + formatter.format(date) + "." + ext;
			logger.info("uploaded File Path is " + metaPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return metaPath;
	}

}