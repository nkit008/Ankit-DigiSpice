package com.digispice.clicktocall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.clicktocall.dao.AddPlaylistDao;
import com.digispice.clicktocall.model.MetaInfoModel;
import com.digispice.clicktocall.model.MusicDetailsModel;

@Controller
public class RemoveController {
	private static final Logger logger = Logger.getLogger(RemoveController.class.getName());

	@Autowired
	HttpSession session;

	@Autowired
	AddPlaylistDao dao;

	@RequestMapping(value = "viewMusic")
	public String removePlaylist(Model model) {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "index";
		}

		else {
			Map<String, String> map = dao.getnameByid();
			List<MusicDetailsModel> list = dao.viewMusic();
			if (list.isEmpty()) {
				logger.info("No records found in tbl_music_details");
				model.addAttribute("userObj", session.getAttribute("userObj"));
				return "remove";
			} else {
				model.addAttribute("playlist", list);
				model.addAttribute("mapitems", map);
				model.addAttribute("userObj", session.getAttribute("userObj"));
				return "remove";
			}
		}
	}

	@RequestMapping(value = "removeMusic1", method = RequestMethod.POST)
	public String removeMusic(@RequestParam String sno, @RequestParam String status, Model model,
			RedirectAttributes redir) {

		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			int del = dao.removeMusic(sno, status);
			redir.addFlashAttribute("userObj", session.getAttribute("userObj"));
			if (del > 0) {
				redir.addFlashAttribute("success", "Music Updated Successfully");
				return "redirect:/viewMusic";

			}

			else {
				redir.addFlashAttribute("success", "Music not Deleted");
				return "redirect:/viewMusic";
			}

		}
	}

	@RequestMapping(value = "viewMetadata")
	public String viewMetadata(Model model) {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "index";
		}

		else {
			Map<String, String> map = dao.getnameByid();
			List<MetaInfoModel> list = dao.viewMetadataRecords();
			model.addAttribute("playlist", list);
			model.addAttribute("mapitems", map);
			model.addAttribute("userObj", session.getAttribute("userObj"));
			return "viewMetadataRecord";
		}
	}

}
