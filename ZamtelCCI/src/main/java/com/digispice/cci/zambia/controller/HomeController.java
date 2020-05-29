package com.digispice.cci.zambia.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.cci.zambia.entity.UserEntity;
import com.digispice.cci.zambia.service.ZamtelGamesService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	ZamtelGamesService zamtelGamesService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String DEFAUTLT_VIEW_NAME = "index";
	private static final String REDIRECT_LOGOUT = "redirect:/logout";

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}", locale);
		return DEFAUTLT_VIEW_NAME;
	}

	@PostMapping("login")
	public String login(@RequestParam String username, @RequestParam String password, Model model,
			RedirectAttributes redir) {
		logger.info("Checking login credentials  username {} and password {}", username, password);

		UserEntity userEntity = zamtelGamesService.checkLogin(username, password);
		logger.info("user Entity is {}", userEntity);
		if (userEntity == null) {
			logger.info("Invalid User Name and Password");
			model.addAttribute("wrong", "Invalid User Name and Password");
			return DEFAUTLT_VIEW_NAME;
		}

		else {
			logger.info("login successfully with User Name {}", userEntity.getName());
			session.setAttribute("userObj", userEntity);
			redir.addFlashAttribute("success", "Login Successfully");
			return "redirect:/zemtalGamesUserDetail";
		}

	}

	@GetMapping(value = "/home")
	public String home(Model model) {
		if (session.getAttribute("userObj") == null) {
			logger.info("session expired");
			return REDIRECT_LOGOUT;
		} else {
			return "zamtelGames-checkUserDetails";
		}
	}

	@GetMapping(value = "logout")
	public String logout() {
		if (session.getAttribute("userObj") == null) {
			logger.info("Session Expired");
			return DEFAUTLT_VIEW_NAME;
		}

		else {
			session.removeAttribute("userObj");
			session.invalidate();
			logger.info("---logout successfully!---");
			return DEFAUTLT_VIEW_NAME;
		}
	}
}