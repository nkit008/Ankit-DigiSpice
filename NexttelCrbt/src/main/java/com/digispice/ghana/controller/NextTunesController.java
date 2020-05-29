package com.digispice.ghana.controller;

import java.util.ArrayList;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.ghana.bean.CreateUserBean;
import com.digispice.ghana.dao.CheckStatusDao;
import com.digispice.ghana.dao.CustomerCareDao;

@Controller
public class NextTunesController {

	Logger logger = LoggerFactory.getLogger(NextTunesController.class.getName());

	@Autowired
	HttpSession session;

	@Autowired
	CustomerCareDao dao;

	@Autowired
	CheckStatusDao dao2;

	@RequestMapping(value = "neXtTunesUserUnSubscribe")
	public String subscriptionDelete() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {

			return "user_unsubcription";
		}

	}

	@RequestMapping(value = "createNewUser")
	public String createUser() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {

			return "create_user";
		}

	}

	@RequestMapping(value = "subscriptionDeleteAction", method = RequestMethod.GET)
	public String subscriptionDeleteAction(@RequestParam String msisdn, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		} else {
			String resp = dao.unSubsCustomer(msisdn);
			if (resp.equalsIgnoreCase("0")) {
				logger.info("User is not a subscribed user, Unsubscription is not possible");
				redir.addFlashAttribute("msg", "User not Unsubscribed");
			}

			else {
				logger.info("User is successfully unsubscribed");
				redir.addFlashAttribute("msg", "User is successfully unsubscribed");
			}

			return "redirect:/neXtTunesUserUnSubscribe";
		}

	}

	@RequestMapping(value = "neXtTunesCheckUserStatus")
	public String checkStatus() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			logger.info("---in checking user status--");
			return "check_userStatus";
		}

	}

	@RequestMapping(value = "checkUserStatusAction", method = RequestMethod.POST)
	public String checkStatusAction(@RequestParam String msisdn, RedirectAttributes redir) {
		ArrayList<Map<String, String>> subData = new ArrayList<Map<String, String>>();
		ArrayList<Map<String, String>> crbtSubData = new ArrayList<Map<String, String>>();
		ArrayList<Map<String, String>> unsubData = new ArrayList<Map<String, String>>();
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			String detail = "Subs";
			logger.info("Chekcing user Status and detail type::" + detail);
			String userId = ((CreateUserBean) session.getAttribute("userobj")).getUserId();

			if (detail.trim().equalsIgnoreCase("Subs")) {
				logger.info("user Details from---  Subs");
				int countSubData = dao2.fetchCountSUBDetail(msisdn, userId);
				int countCrbtSubData = dao2.fetchCountCRBTSUBDetail(msisdn, userId);

				if (countSubData != 0 || countCrbtSubData != 0) {
					redir.addFlashAttribute("mobile", msisdn);
					redir.addFlashAttribute("curStatus", "Subscribed");

				} else {
					logger.info("User is not currently active fetching Unsub Record for Mobile Number " + msisdn);
					int countUnsubData = dao2.fetchCountUNSUBDetail(msisdn, userId);

					if (countUnsubData != 0) {
						logger.info("Record Found for Mobile Number " + msisdn);
						redir.addFlashAttribute("mobile", msisdn);
						redir.addFlashAttribute("curStatus", "UnSubscribed");
					} else {
						logger.info("No Record Found for Mobile Number " + msisdn);
						redir.addFlashAttribute("msg", "No Record Found for Mobile Number " + msisdn);
					}

				}

			}

		}
		redir.addFlashAttribute("subData", subData);
		redir.addFlashAttribute("crbtSubData", crbtSubData);
		redir.addFlashAttribute("unsubData", unsubData);
		return "redirect:/neXtTunesCheckUserStatus";
	}

	@RequestMapping(value = "neXtTunesViewCurStatusRecord", method = RequestMethod.GET)
	public String viewCurStatusRecord(@RequestParam String mobile, @RequestParam String status,
			HttpServletRequest request, Model model, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			logger.info("Chekcing user Status for ANI {[" + mobile + "]} and detail type {[" + status + "}]");
			String userId = ((CreateUserBean) session.getAttribute("userobj")).getUserId();
			String IP = request.getRemoteAddr();

			if (status.trim().equalsIgnoreCase("Subscribed")) {
				logger.info("user Details from---  Subs");
				ArrayList<Map<String, String>> subData = dao.fetchSUBDetail(mobile, userId, IP);
				ArrayList<Map<String, String>> crbtSubData = dao.fetchCRBTSUBDetail(mobile, userId, IP);

				logger.info("size of subData is--" + subData.size());
				logger.info("size of crbtSubData is--" + crbtSubData.size());

				model.addAttribute("subData", subData);
				model.addAttribute("crbtSubData", crbtSubData);
				logger.info("Record Found for Mobile Number " + mobile);
			}

			else if (status.equalsIgnoreCase("UnSubscribed")) {
				logger.info("User is not currently active fetching Unsub Record for Mobile Number " + mobile);
				ArrayList<Map<String, String>> unsubData = dao.fetchUNSUBDetail(mobile, userId, IP);
				logger.info("Result Set Fetched and size of resultset is" + unsubData.size());

				if (!unsubData.isEmpty()) {
					logger.info("Record Found for Mobile Number " + mobile);
					model.addAttribute("unsubData", unsubData);
				} else {
					logger.info("No Record Found for Mobile Number " + mobile);
					model.addAttribute("msg", "No Record Found for Mobile Number " + mobile);
				}

			}

		}
		model.addAttribute("status", status);
		model.addAttribute("mobile", mobile);
		return "check_userStatusShow";
	}

	@RequestMapping(value = "neXtTunesUserBillingDetails")
	public String billingDetails() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			return "billing_details";
		}

	}

	@RequestMapping(value = "billingStatusAction")
	public String checkBillingAction(@RequestParam String msisdn, HttpServletRequest request, Model model,
			RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			String userId = ((CreateUserBean) session.getAttribute("userobj")).getUserId();
			String IP = request.getRemoteAddr();
			ArrayList<Map<String, String>> subData = dao.fetchCustomerSummaryDetail(msisdn, userId, IP);
			ArrayList<Map<String, String>> unsubData = dao.fetchUNSUBDetail(msisdn, userId, IP);

			if (subData.isEmpty() && unsubData.isEmpty()) {
				logger.info("No Record Found for Mobile Number " + msisdn);
				redir.addFlashAttribute("msg", "No Record Found for Mobile Number " + msisdn);
				return "redirect:/neXtTunesUserBillingDetails";

			} else {
				logger.info("Record Found for Mobile Number " + msisdn);
				model.addAttribute("subData", subData);
				model.addAttribute("unsubData", unsubData);
				return "billing_detailsShow";
			}
		}
	}

	@RequestMapping(value = "neXtTunesSearchTone")
	public String searchTone() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			return "search_tone";
		}

	}

	@ResponseBody
	@RequestMapping(value = "getSubCat", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<String> getSubCat(@RequestParam String category) {
		logger.info("in rest controller to Get Sub Categories of --" + category);

		ArrayList<String> subcat = dao.fetchSubcategory(category);
		return subcat;
	}

	@RequestMapping(value = "searchSongAction")
	public String searchSongAction(@RequestParam String category, @RequestParam String searchBy,
			@RequestParam String subcat, @RequestParam String text, Model model, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			String searchType = searchBy.trim();
			String searchString = text.trim();
			String cat = category.trim();
			String subCategory = subcat.trim();

			redir.addFlashAttribute("searchType", searchType);
			redir.addFlashAttribute("searchString", searchString);
			redir.addFlashAttribute("cat", cat);
			redir.addFlashAttribute("subCategory", subCategory);

			ArrayList<Map<String, String>> subData = dao.getSearchMethod(searchType, searchString, cat, subCategory);
			if (!subData.isEmpty()) {
				logger.info("Record Found and size of list is " + subData.size());
				redir.addFlashAttribute("subData", subData);
				return "redirect:/neXtTunesSearchTone";
			} else {
				logger.info("No Record Found");
				redir.addFlashAttribute("msg", "No Record Found");
				return "redirect:/neXtTunesSearchTone";
			}
		}

	}

	@RequestMapping(value = "setRbt")
	public String setRbt(@RequestParam String requestType, @RequestParam String song_id, @RequestParam String song_name,
			Model model, @RequestParam String searchType, @RequestParam String searchString, @RequestParam String cat,
			@RequestParam String subCategory, @RequestParam String msg, RedirectAttributes redir) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			logger.info("--Setting RBT tune-- ");
			logger.info("request type is " + requestType);
			logger.info("Song Name is " + song_name);
			logger.info("Song id is " + song_id);
			logger.info("cat is " + cat);
			redir.addFlashAttribute("requestType", requestType);
			redir.addFlashAttribute("song_id", song_id);
			redir.addFlashAttribute("msg", msg);
			redir.addFlashAttribute("song_name", song_name);
			redir.addFlashAttribute("searchType", searchType);
			redir.addFlashAttribute("searchString", searchString);
			redir.addFlashAttribute("cat", cat);
			redir.addFlashAttribute("subCategory", subCategory);
			redir.addFlashAttribute("serviceName", session.getAttribute("SERVICE_TYPE"));
			logger.info("subCategory is " + subCategory);
			return "redirect:/neXtTunesToneDownload";
		}

	}

	@RequestMapping(value = "/neXtTunesToneDownload")
	public String setRbtAction() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			return "download";
		}
	}

	@RequestMapping(value = "setRbtAction")
	public String setRbtAction(@RequestParam String mobile_number, @RequestParam String song_ID,
			@RequestParam String pack, @RequestParam String rbt_name, @RequestParam String searchType,
			@RequestParam String searchString, @RequestParam String cat, @RequestParam String subCategory,
			RedirectAttributes redir, Model model) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			String result = dao.setRBTCustomer(mobile_number, song_ID, pack, rbt_name);
			logger.info(result);
			redir.addAttribute("msg", result);
			redir.addAttribute("song_id", song_ID);
			redir.addAttribute("song_name", rbt_name);
			redir.addAttribute("requestType", "DWLD");
			redir.addAttribute("searchType", searchType);
			redir.addAttribute("searchString", searchString);
			redir.addAttribute("cat", cat);
			redir.addAttribute("subCategory", subCategory);
			return "redirect:/setRbt";
		}
	}

	@RequestMapping(value = "/getToneDetails", method = RequestMethod.GET)
	public String getToneDetails(@RequestParam String textString, @RequestParam String status,
			@RequestParam String mobile, RedirectAttributes redir) {
		logger.info("getting details for Tone {[" + textString + "]} status is {[" + status + "]} and ANI is {["
				+ mobile + "]}");
		String searchType = "tone_name";
		String searchString = textString.trim();
		String cat = "all";
		String subCategory = "all";

		ArrayList<Map<String, String>> toneData = dao.getSearchMethod(searchType, searchString, cat, subCategory);
		redir.addFlashAttribute("tonedata", toneData);
		redir.addAttribute("status", status);
		redir.addAttribute("mobile", mobile);
		return "redirect:/neXtTunesViewCurStatusRecord";
	}

	@RequestMapping(value = "/delToneAction", method = RequestMethod.GET)
	public String delToneAction(@RequestParam String msisdn, @RequestParam String toneCode, RedirectAttributes redir) {
		String result = dao.delTone(msisdn, toneCode);
		redir.addFlashAttribute("msg", result);
		redir.addAttribute("mobile", msisdn);
		redir.addAttribute("status", "Subscribed");
		return "redirect:/neXtTunesViewCurStatusRecord";
	}

}
