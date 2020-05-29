package com.digispice.ghana.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Locale;

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
import com.digispice.ghana.bean.UserDetails;
import com.digispice.ghana.dao.LoginDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	LoginDao logindao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is " + locale);
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, Model model,
			RedirectAttributes redir) {
		logger.info("Checking login credentials-- username " + username + " password " + password);

		List<CreateUserBean> list = logindao.CheckLogin(username, password);

		if (list.isEmpty()) {
			logger.info("Invalid User Name and Password");
			model.addAttribute("wrong", "Invalid User Name and Password");
			return "index";
		}

		else {
			logger.info("login successfully");
			HashMap<String, String> map = logindao.getAllPack();
			session.setAttribute("SERVICE_TYPE", map);
			session.setAttribute("userobj", list.get(0));
			redir.addFlashAttribute("userobj", list.get(0));
			return "redirect:/home";
		}

	}

	@RequestMapping(value = "/home")
	public String home(Model model) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		} else {
			return "redirect:/neXtTunesSearchTone";
		}
	}

	@RequestMapping(value = "logout")
	public String logout() {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "index";
		}

		else {
			session.removeAttribute("userobj");
			session.invalidate();
			logger.info("---logout successfully!---");
			return "index";
		}
	}

	@RequestMapping(value = "createuserAction", method = RequestMethod.POST)
	public String createUser(CreateUserBean bean, RedirectAttributes redir, Model model) {
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "index";
		}

		else {
			System.out.println(bean.toString());

			int res = logindao.createUser(bean);
			if (res > 0) {
				logger.info("new user created successfully");
				redir.addFlashAttribute("msg", "User Created Successfully");
			}

			else {
				redir.addFlashAttribute("msg", "User not Created Successfully");
			}

			return "redirect:/createUser";
		}

	}

	@RequestMapping(value = "viewUser")
	public String viewUser(Model model) {

		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "index";
		}

		else {
			logger.info("---View user---");
			List<CreateUserBean> list = logindao.viewUser();
			model.addAttribute("list", list);
			return "view_user";
		}
	}

	@ResponseBody
	@RequestMapping(value = "getUserId", method = RequestMethod.GET, produces = "application/json")
	public int getUserId(@RequestParam String userId) {
		logger.info("in rest controller " + userId);
		int i = logindao.checkUserId(userId);
		if (i == 1) {
			logger.info("userId is not exixts");
		} else {
			logger.info("userId is already exixts");
		}
		return i;
	}

	@RequestMapping(value = "editUser", method = RequestMethod.POST)
	public String editUser(CreateUserBean bean, RedirectAttributes redir) {
		System.out.println("edit " + bean.getCci_rights());
		System.out.println(bean.getUserId());
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			logger.info("---View user---");
			int res = logindao.editUser(bean);
			if (res > 0) {
				redir.addFlashAttribute("msg", "User Details Updated");
			} else {
				redir.addFlashAttribute("msg", "User Details not Updated");
			}
			return "redirect:/viewUser";
		}
	}

	@RequestMapping(value = "deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam String userid, RedirectAttributes redir) {
		System.out.println("id is " + userid);
		if (session.getAttribute("userobj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			logger.info("---Deleting user with id " + userid + "---");
			int res = logindao.deleteUser(userid);
			if (res > 0) {
				redir.addFlashAttribute("msg", "User Successfully deleted");
			} else {
				redir.addFlashAttribute("msg", "User not deleted");
			}
			return "redirect:/viewUser";
		}
	}
}