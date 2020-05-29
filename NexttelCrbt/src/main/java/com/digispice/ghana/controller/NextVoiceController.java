package com.digispice.ghana.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.ghana.bean.NextVoiceSubDetails;
import com.digispice.ghana.bean.NextVoiceUnsubDetail;
import com.digispice.ghana.bean.NextVoiceUserBillingDetails;
import com.digispice.ghana.connection.GetConnection;
import com.digispice.ghana.dao.NextVoiceActionDao;

@Controller
public class NextVoiceController {

	@Autowired
	HttpSession session;

	@Autowired
	NextVoiceActionDao nextVoiceActionDao;

	@Autowired
	NextMusicController nextMusicController;

	private static final Logger logger = LoggerFactory.getLogger(NextVoiceController.class.getName());
	private final String UPLOAD_DIRECTORY_MUSIC;
	String metaPath = null;

	public NextVoiceController() {
		UPLOAD_DIRECTORY_MUSIC = GetConnection.loadProp("UPLOAD_DIRECTORY_MUSIC");
	}

	@RequestMapping(value = "/neXtVoiceCheckUserDetails")
	public String neXtVoicehome() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		}

		else {
			return "music-checkUserDetails";
		}
	}

	@RequestMapping(value = "/neXtVoiceUserDetails")
	public String neXtVoiceUserDetails(@ModelAttribute("token") String token) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		}

		else {
			if (token.equalsIgnoreCase("yes"))
				return "music-checkUserDetailsShow";
			else
				return "music-checkUserDetails";
		}
	}

	@RequestMapping(value = "neXtVoiceDetailsAction", method = RequestMethod.POST)
	public String neXtVoiceDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("Fetching user detail for Service neXtVoice ANI {}", ani);

			ArrayList<NextVoiceSubDetails> subdetail = nextVoiceActionDao.nextVoiceUserDetailsforsub(ani);
			logger.info("No. of records in Subcription table is {}", subdetail.size());
			redir.addFlashAttribute("mobile", ani);
			if (subdetail.isEmpty() == false) {
				redir.addFlashAttribute("status", "Subscribed");
				// redir.addFlashAttribute("subdata", subdetail);
			} else {
				ArrayList<NextVoiceUnsubDetail> unsubdetail = nextVoiceActionDao.nextVoiceDetailsforUnsub(ani);
				logger.info("No. of records in UnSubcription table is {}", unsubdetail.size());
				if (unsubdetail.isEmpty() == false) {
					redir.addFlashAttribute("status", "UnSubscribed");
					// redir.addFlashAttribute("unsubdata", unsubdetail);
				} else {
					redir.addFlashAttribute("msg", "No Record found Regarding the Number " + ani);
				}
			}

		}
		return "redirect:/neXtVoiceCheckUserDetails";
	}

	@RequestMapping(value = "neXtVoiceDetailsActionDetail", method = RequestMethod.GET)
	public String neXtVoiceDetailsActionDetailsSub(@RequestParam String ani, @RequestParam String status,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("Fetching user detail for Service neXtVoice ANI {} for type {}", ani);

			if (status.trim().equalsIgnoreCase("Subscribed")) {
				ArrayList<NextVoiceSubDetails> subdetail = nextVoiceActionDao.nextVoiceUserDetailsforsub(ani);
				logger.info("No. of records in Subcription table is {}", subdetail.size());
				redir.addFlashAttribute("mobile", ani);
				if (subdetail.isEmpty() == false) {
					redir.addFlashAttribute("subdata", subdetail);
					redir.addFlashAttribute("token", "yes");
				}
			}

			else if (status.trim().equalsIgnoreCase("UnSubscribed")) {
				ArrayList<NextVoiceUnsubDetail> unsubdetail = nextVoiceActionDao.nextVoiceDetailsforUnsub(ani);
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
		}
		return "redirect:/neXtVoiceUserDetails";
	}

	@RequestMapping(value = "/neXtVoiceUserBillingDetails")
	public String neXtVoiceUserBillingDetails() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("User Billing Deatils for Service neXtVoice");
			return "music-userBillingDetails";
		}
	}

	@RequestMapping(value = "neXtVoiceUserBillingDetailsAction", method = RequestMethod.POST)
	public String neXtVoiceUserBillingDetailsAction(@RequestParam String ani, RedirectAttributes redir) {
		List<NextVoiceUserBillingDetails> userBillingDetails = null;
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("UserBilling Details for Service neXtVoice and ANI {}", ani);
			userBillingDetails = nextVoiceActionDao.nextVoiceUserBillingDetails(ani);
			if (userBillingDetails.isEmpty() == false) {
				redir.addFlashAttribute("data", userBillingDetails);
			}

			else {
				logger.info("No Billing Details for Service neXtVoice and ANI {}", ani);
				redir.addFlashAttribute("msg", "No User Details found for " + ani);
			}

			return "redirect:/neXtVoiceUserBillingDetails";
		}
	}

	@RequestMapping(value = "neXtVoiceSingleSubscription")
	public String neXtVoiceSingleSubscription() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			return "music-singleSubscription";
		}
	}

	@RequestMapping(value = "/neXtVoiceSingleSubscriptionAction")
	public String neXtVoiceSingleSubscriptionAction(@RequestParam String ani, @RequestParam String pricePoint,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("Single Subscription for Service neXtVoice, ANI {} and Pack {}", ani, pricePoint);
			String response = nextVoiceActionDao.neXtVoiceSinleSubscription(ani, pricePoint);
			if (response != null) {
				redir.addFlashAttribute("msg",
						"We have initiated your subscription request. You will get confirmation SMS Shortly.");
			} else {
				redir.addFlashAttribute("msg", "something went wrong!!! " + ani + " is not subscribed");
			}
			return "redirect:/neXtVoiceSingleSubscription";
		}
	}

	@RequestMapping(value = "neXtVoiceSingleUnSubscription")
	public String neXtVoiceSingleUnSubscription() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			return "music-singleUnSubscription";
		}
	}

	@RequestMapping(value = "neXtVoiceUnSubscriptionAction")
	public String neXtVoicemodUnSubscriptionAction(@RequestParam String ani, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			logger.info("UnSubscription from Service neXtVoice for ANI {}", ani);
			String response = nextVoiceActionDao.neXtVoiceUnSubscription(ani);
			if (response != null) {
				if (response.equalsIgnoreCase("1")) {
					redir.addFlashAttribute("msg",
							"We have initiated your Un-Subscription request. You will get confirmation SMS Shortly.");
				}

				else if (response.equalsIgnoreCase("0")) {
					redir.addFlashAttribute("msg", "User not unsubscribe successfully");
				}

			} else {
				redir.addFlashAttribute("msg", "Something went wrong!!! Please contact to your Administrator");
			}

			return "redirect:/neXtVoiceSingleUnSubscription";
		}
	}

	@RequestMapping(value = "neXtVoiceBulkSubscription")
	public String neXtMusicmodBulkSubscription() {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			return "music-bulkSubscription";
		}
	}

	@RequestMapping(value = "neXtVoiceBulkSubscriptionAction", method = RequestMethod.POST)
	public String neXtVoiceBulkSubscriptionAction(@RequestParam String pricePoint, @RequestParam MultipartFile ani,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			return "redirect:/logout";
		} else {
			String fileName = ani.getOriginalFilename();

			if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("txt")) {
				logger.info("Bulk Subscription for Service neXtVocie");
				logger.info("UPLOAD_DIRECTORY_MUSIC path is  {}", UPLOAD_DIRECTORY_MUSIC);
				metaPath = nextMusicController.copyMetaFile(ani, UPLOAD_DIRECTORY_MUSIC);
				logger.info("File Copied to {[" + metaPath + "}]");
				String response = nextVoiceActionDao.neXtVoiceBulkSubscription(pricePoint, metaPath);
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

			return "redirect:/neXtVoiceBulkSubscription";
		}
	}

}
