package com.digispice.clicktocall.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.digispice.clicktocall.dao.AddPlaylistDao;
import com.digispice.clicktocall.dao.LoginDao;
import com.digispice.clicktocall.model.BannerModel;
import com.digispice.clicktocall.model.PlaylistModel;
import com.digispice.clicktocall.model.UnassignCodeModel;
import com.digispice.clicktocall.model.UserModel;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

@Controller
public class AddPlaylist {
	int i = 0;

	@Autowired
	HttpSession session;

	@Autowired
	AddPlaylistDao dao;

	@Autowired
	LoginDao dao1;

	private static final Logger logger = Logger.getLogger(AddPlaylist.class.getName());

	/*
	 * private static final String UPLOAD_path = "E:\\excel\\"; private static
	 * final String UPLOAD_banner = "E:\\excel\\click2call";
	 */

	private static final String UPLOAD_path = "/home/ec2-user/SafariCom_Click2Call/";
	private static final String UPLOAD_banner = "/home/ec2-user/SafariCom_Click2Call/click2call";

	String feature_path = null;
	String smart_path = null;

	@RequestMapping(value = "addNewPlaylist")
	public String addNewPlaylist(Model model) {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			model.addAttribute("userObj", session.getAttribute("userObj"));
			logger.info("---adding new playlist---");
			return "add-playlist";
		}
	}

	@RequestMapping(value = "uploadNewPlaylist")
	public String uploadNewPlaylist(@RequestParam String playlistTitle, @RequestParam String playlistDesc,
			@RequestParam MultipartFile banner, Model model, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {
			model.addAttribute("userObj", session.getAttribute("userObj"));

			logger.info("size of banner " + banner.getSize());

			if (banner.isEmpty()) {
				String result = dao.addNewPlaylist(playlistTitle, playlistDesc);
				logger.info("---checking if playlist already exists----->" + result);
				if (result.equals("exists")) {

					model.addAttribute("error", "Playlist Already Exists");
					return "add-playlist";
				}

				if (result.equals("success")) {
					redir.addFlashAttribute("success", "Playlist Added Successfully");
					return "redirect:/home";
				}

				else {
					redir.addFlashAttribute("success", "Playlist not Added Successfully");
					logger.info("playlist not added successfully");
					return "redirect:/home";
				}
			}

			else {

				String result = dao.addNewPlaylist(playlistTitle, playlistDesc);
				logger.info("---checking if playlist already exists----->" + result);
				if (result.equals("exists")) {
					model.addAttribute("error", "Playlist Already Exists");
					return "add-playlist";
				}

				if (result.equals("success")) {
					int pid = dao.getpid(playlistTitle);
					String filename = banner.getOriginalFilename();

					String fileExt = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

					logger.info("---Compressed file extension is----->" + fileExt);
					if (fileExt.equalsIgnoreCase("zip")) {
						List<String> pname = dao1.getActivePlaylistName();
						model.addAttribute("playname", pname);

						try {
							zipExtract(banner, filename);
							logger.info("smart_phone and feature-phone path before file copy is " + feature_path + ", "
									+ smart_path);
							fileCopy(banner, pid);
							logger.info("smart_phone and feature-phone path after file copy is " + feature_path + ", "
									+ smart_path);
							if ((feature_path == null) && (smart_path == null)) {
								logger.info("---banner zip is incorrect---");
								throw new Exception("incorrect banner zip");
							}
							if (feature_path == null) {
								feature_path = "NA";
							}
							if (smart_path == null) {
								smart_path = "NA";
							}
							String result1 = dao.addBanner(pid, feature_path, smart_path);
							feature_path = null;
							smart_path = null;

							if (result1.equals("success")) {
								logger.info("--playlist uploaded with banner---");
								redir.addFlashAttribute("success", "Playlist Added Successfully");
								return "redirect:/home";
							}

							if (result1.equals("nosuccess")) {
								model.addAttribute("error", "Playlist not Upload Succssfully");
							}
						} catch (Exception e) {

							e.printStackTrace();
							logger.info(e.getMessage());
							dao.deletePlalylist(pid);
							model.addAttribute("error", "Playlist not Upload Succssfully");
						}

					}

					else {
						logger.info("--banner file is not a zip file---");
						model.addAttribute("error", "Please Upload ZIP File");
						dao.deletePlalylist(pid);
						return "add-playlist";
					}
				}
			}

			return "add-playlist";
		}
	}

	@RequestMapping(value = "viewPlaylist")
	public String viewPlaylist(Model model) {
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		}

		else {
			Map<String, String> map = dao.getnameByid();
			List<PlaylistModel> list = dao.viewPlaylist();

			model.addAttribute("playlist", list);
			model.addAttribute("mapitems", map);
			model.addAttribute("userObj", session.getAttribute("userObj"));
			return "viewPlaylist";
		}
	}

	@RequestMapping(value = "viewBanner", method = RequestMethod.GET)
	public String viewBanner(Model model) {
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		}

		else {
			List<BannerModel> list = dao.viewBanner();

			if (list.isEmpty()) {
				logger.info("No record found in Banner table");
				model.addAttribute("userObj", session.getAttribute("userObj"));
				return "viewBanner";
			} else {
				Map<String, String> map = dao.getnameByid();
				model.addAttribute("mapitems", map);
				model.addAttribute("playlist", list);
				model.addAttribute("userObj", session.getAttribute("userObj"));
				return "viewBanner";
			}
		}

	}

	public void zipExtract(MultipartFile banner, String filename) throws IOException {

		File upload = new File(
				UPLOAD_path + banner.getOriginalFilename().substring(0, banner.getOriginalFilename().lastIndexOf(".")));
		logger.info("Upload Banner Exixts---- " + upload.exists());
		if (upload.exists()) {
			FileUtils.cleanDirectory(upload);
			FileUtils.forceDelete(upload);
		}

		File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");

		FileOutputStream o = new FileOutputStream(zip);
		IOUtils.copy(banner.getInputStream(), o);
		o.close();

		String destination = UPLOAD_path;

		/*** unizp file from temp by zip4j ***/
		try {
			FileUtils.copyFile(zip, new File(destination + File.separator + filename));
			ZipFile zFile = new ZipFile(zip);
			zFile.extractAll(destination);
		} catch (ZipException e) {
			e.printStackTrace();
		} finally {

			/**
			 * delete temp file
			 */

			zip.delete();
			File f1 = new File(destination + File.separator + filename);
			if (f1.exists())
				f1.delete();
		}
	}

	public void fileCopy(MultipartFile banner, int pid) {
		try {
			logger.info("--Inside fileCopy() method--");
			logger.info("banner file path is " + banner.getOriginalFilename());
			logger.info("Playlist id is " + pid);

			String filename = banner.getOriginalFilename();
			String fileExt = (filename.substring(filename.lastIndexOf(".") + 1, filename.length()));

			File bannerfile = new File(UPLOAD_path + filename.substring(0, filename.lastIndexOf(".")));
			File[] listOfFiles = bannerfile.listFiles();

			logger.info("List of files in Banner is " + listOfFiles.length);

			for (int i = 0; i < listOfFiles.length; i++) {

				logger.info("Number of files in Banner is " + i);

				if (listOfFiles[i].isFile()) {

					String fext = listOfFiles[i].getName().substring(listOfFiles[i].getName().lastIndexOf("."),
							listOfFiles[i].getName().length());

					logger.info("extension of " + i + " file is " + fext);

					if (fext.equalsIgnoreCase(".jpg")) {
						Date date = new Date();
						DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");
						String curdate = df.format(date);
						logger.info("file name is:::" + listOfFiles[i].getName());
						String fname = listOfFiles[i].getName().substring(0, listOfFiles[i].getName().lastIndexOf("."));

						if (fname.toLowerCase().indexOf("smartphone") >= 0) {
							String sorucePath = UPLOAD_path + filename.substring(0, filename.lastIndexOf("."))
									+ File.separator + listOfFiles[i].getName();
							String destPath = UPLOAD_banner + File.separator + "Banner" + File.separator;
							File f1 = new File(destPath);// destination
							File f = new File(sorucePath);
							if (!f1.exists()) {
								f1.mkdirs();
							}

							FileUtils.copyFile(f,
									new File(f1 + File.separator + fname + "_" + pid + "_" + curdate + fext));
							// smart_path = f1 + File.separator + fname + "_" +
							// pid + "_" + curdate + fext;

							smart_path = "http://safaricom.liveafricamusic.com/ClickToCall/banner/" + fname + "_" + pid
									+ "_" + curdate;

							logger.info("smartphone path is " + smart_path);
						}

						if (fname.toLowerCase().indexOf("featured") >= 0) {
							String destPath = UPLOAD_banner + File.separator + "Banner";

							File f1 = new File(destPath);
							File f = new File(UPLOAD_path + filename.substring(0, filename.lastIndexOf("."))
									+ File.separator + listOfFiles[i].getName());
							if (!f1.exists()) {
								f1.mkdirs();
							}
							FileUtils.copyFile(f,
									new File(f1 + File.separator + fname + "_" + pid + "_" + curdate + fext));
							// feature_path = f1 + File.separator + fname + "_"
							// + pid + "_" + curdate + fext;

							feature_path = "http://safaricom.liveafricamusic.com/ClickToCall/banner/" + fname + "_"
									+ pid + "_" + curdate;
							logger.info("featuredphone path is " + feature_path);

						}
					} else {
						logger.info("File extension is Incorrect");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "viewunassignCode", method = RequestMethod.GET)
	public String viewunassignCode(@RequestParam String uid, Model model) {
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		}

		else {
			List<UnassignCodeModel> list = dao.viewUnassignCodeDetails(uid);

			if (list.isEmpty()) {
				logger.info("No records found in tbl_unassign_code");
				model.addAttribute("userObj", session.getAttribute("userObj"));
				return "viewUnassignCode";
			} else {
				Map<String, String> map = dao.getnameByid();
				model.addAttribute("mapitems", map);
				model.addAttribute("playlist", list);
				model.addAttribute("userObj", session.getAttribute("userObj"));
				return "viewUnassignCode";
			}
		}

	}

	@RequestMapping(value = "updateplaylist")
	public String updateplaylist(@RequestParam String sno, @RequestParam String title, @RequestParam boolean active,
			@RequestParam String desc, @RequestParam MultipartFile banner, Model model, RedirectAttributes redir) {
		if (session.getAttribute("userObj") == null) {
			return "redirect:/logout";
		}

		else {
			if (banner.isEmpty()) {
				logger.info(desc + "   " + sno + "   " + active);
				int i = dao.updatePlaylist(sno, desc, active);
				if (i < 0) {
					redir.addFlashAttribute("msg", "Playlist not Updated");
					return "redirect:/viewPlaylist";
				}

				else {

					redir.addFlashAttribute("msg", "Playlist Updated Succssfully");
					return "redirect:/viewPlaylist";
				}

			}

			else {
				String filename = banner.getOriginalFilename();
				int pid = Integer.parseInt(sno);
				String fileExt = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
				if (fileExt.equalsIgnoreCase("zip")) {

					try {
						zipExtract(banner, filename);
						logger.info("feature_path before " + feature_path);
						fileCopy(banner, pid);
						logger.info("feature_path after " + feature_path);
						if (feature_path == null && smart_path == null) {
							throw new Exception("incorrect banner zip");
						}
						if (feature_path == null) {
							feature_path = "NA";
						}
						if (smart_path == null) {
							smart_path = "NA";
						}
						String result1 = dao.updatePlaylistWithBanner(sno, desc, active, feature_path, smart_path);
						feature_path = null;
						smart_path = null;

						if (result1.equals("success")) {

							redir.addFlashAttribute("msg", "Playlist Updated Successfully");
							return "redirect:/viewPlaylist";
						}

						if (result1.equals("fail")) {
							redir.addFlashAttribute("msg", "Playlist not Upload Succssfully");
						}
					} catch (Exception e) {

						e.printStackTrace();
						logger.info(e.getMessage());
						redir.addFlashAttribute("msg", "Playlist not Upload Succssfully");
					}

				}

				else {
					redir.addFlashAttribute("msg", "Please Upload ZIP File");
					return "redirect:/viewPlaylist";
				}
			}

			return "redirect:/viewPlaylist";
		}
	}

}
