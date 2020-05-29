package com.digispice.clicktocall.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.clicktocall.dao.LoginDao;
import com.digispice.clicktocall.model.UserModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	LoginDao dao;

	private static final Logger logger = Logger.getLogger(HomeController.class.getName());

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("\r\n\r\n");
		logger.info("---Welcome home! The client locale is {}.");

		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		List<UserModel> list = dao.checkLogin(username, password);
		if (list.isEmpty()) {
			logger.info("---Wrong username/password---");
			model.addAttribute("wrong", "Username/Password is incorrect");
			return "index";
		} else {
			logger.info("---Login Successfully---");
			session.setAttribute("userObj", list.get(0));
			return "redirect:/home";
		}
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			List<String> pname = dao.getActivePlaylistName();
			model.addAttribute("playname", pname);
			model.addAttribute("userObj", ((UserModel) session.getAttribute("userObj")));
			return "home-addnew";
		}
	}

	@RequestMapping(value = "logout")
	public String logout() {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "index";
		}

		else {
			session.removeAttribute("userObj");
			session.invalidate();
			logger.info("---logout successfully!---");
			return "index";
		}
	}

	@RequestMapping(value = "downloadArtworkSample")
	public String getPlayListDataById(RedirectAttributes redir, HttpServletResponse response) {

		try {
			File file = ResourceUtils.getFile("classpath:artwork.zip");

			if (!file.exists()) {
				String errorMessage = "Sorry. The file you are looking for does not exist";
				logger.info(errorMessage);
				redir.addFlashAttribute("success", "Sorry. The file you are looking for does not exist");
				return "redirect:/home";
			} else {

				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					logger.info("mimetype is not detectable, will take default");
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				/*
				 * "Content-Disposition : inline" will show viewable types [like
				 * images/text/pdf/anything viewable by browser] right on
				 * browser while others(zip e.g) will be directly downloaded
				 * [may provide save as popup, based on your browser setting.]
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				/*
				 * "Content-Disposition : attachment" will be directly download,
				 * may provide save as popup, based on your browser setting
				 */
				// response.setHeader("Content-Disposition",
				// String.format("attachment; filename=\"%s\"",
				// file.getName()));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				// Copy bytes from source to destination(outputstream in this
				// example), closes both streams.
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/home";

	}

	@RequestMapping(value = "downloadMetaFileSample")
	public String downloadMetaFileSample(RedirectAttributes redir, HttpServletResponse response) {

		try {
			File file = ResourceUtils.getFile("classpath:Playlist metadata.xlsx");

			if (!file.exists()) {
				String errorMessage = "Sorry. The file you are looking for does not exist";
				logger.info(errorMessage);
				redir.addFlashAttribute("success", "Sorry. The file you are looking for does not exist");
				return "redirect:/home";
			} else {

				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					logger.info("mimetype is not detectable, will take default");
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				/*
				 * "Content-Disposition : inline" will show viewable types [like
				 * images/text/pdf/anything viewable by browser] right on
				 * browser while others(zip e.g) will be directly downloaded
				 * [may provide save as popup, based on your browser setting.]
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				/*
				 * "Content-Disposition : attachment" will be directly download,
				 * may provide save as popup, based on your browser setting
				 */
				// response.setHeader("Content-Disposition",
				// String.format("attachment; filename=\"%s\"",
				// file.getName()));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				// Copy bytes from source to destination(outputstream in this
				// example), closes both streams.
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/home";

	}

	@RequestMapping(value = "downloadBannerFileSample")
	public String downloadBannerFileSample(RedirectAttributes redir, HttpServletResponse response, Model model) {
		model.addAttribute("userObj", session.getAttribute("userObj"));

		try {

			File file = ResourceUtils.getFile("classpath:Banner.zip");

			if (!file.exists()) {
				String errorMessage = "Sorry. The file you are looking for does not exist";
				logger.info(errorMessage);
				return "add-playlist";
			} else {

				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					logger.info("mimetype is not detectable, will take default");
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				/*
				 * "Content-Disposition : inline" will show viewable types [like
				 * images/text/pdf/anything viewable by browser] right on
				 * browser while others(zip e.g) will be directly downloaded
				 * [may provide save as popup, based on your browser setting.]
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				/*
				 * "Content-Disposition : attachment" will be directly download,
				 * may provide save as popup, based on your browser setting
				 */
				// response.setHeader("Content-Disposition",
				// String.format("attachment; filename=\"%s\"",
				// file.getName()));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				// Copy bytes from source to destination(outputstream in this
				// example), closes both streams.
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return "add-playlist";

	}

	@RequestMapping(value = "downloadBannerFileSamplePlaylist")
	public String downloadBannerFileSamplePlaylist(RedirectAttributes redir, HttpServletResponse response,
			Model model) {
		model.addAttribute("userObj", session.getAttribute("userObj"));

		try {

			File file = ResourceUtils.getFile("classpath:Banner.zip");

			if (!file.exists()) {
				String errorMessage = "Sorry. The file you are looking for does not exist";
				logger.info(errorMessage);
				return "redirect:/viewPlaylist";
			} else {

				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					logger.info("mimetype is not detectable, will take default");
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				/*
				 * "Content-Disposition : inline" will show viewable types [like
				 * images/text/pdf/anything viewable by browser] right on
				 * browser while others(zip e.g) will be directly downloaded
				 * [may provide save as popup, based on your browser setting.]
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				/*
				 * "Content-Disposition : attachment" will be directly download,
				 * may provide save as popup, based on your browser setting
				 */
				// response.setHeader("Content-Disposition",
				// String.format("attachment; filename=\"%s\"",
				// file.getName()));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				// Copy bytes from source to destination(outputstream in this
				// example), closes both streams.
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/viewPlaylist";

	}

	@RequestMapping("/thumb/{directory}/{imageFileCode}")
	@ResponseBody
	public HttpEntity<byte[]> getPhoto(@PathVariable String directory, @PathVariable String imageFileCode)
			throws IOException {
		byte[] image = org.apache.commons.io.FileUtils
				.readFileToByteArray(new File("/home/ec2-user/SafariCom_Click2Call/click2call/artwork/" + directory
						+ File.separator + imageFileCode + ".jpg"));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(image.length);
		return new HttpEntity<byte[]>(image, headers);
	}

	@RequestMapping("/banner/{imageFileCode}")
	@ResponseBody
	public HttpEntity<byte[]> getBanner(@PathVariable String imageFileCode) throws IOException {
		byte[] image = org.apache.commons.io.FileUtils.readFileToByteArray(new File(
				"/home/ec2-user/SafariCom_Click2Call/click2call/Banner" + File.separator + imageFileCode + ".jpg"));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(image.length);
		return new HttpEntity<byte[]>(image, headers);
	}

}
