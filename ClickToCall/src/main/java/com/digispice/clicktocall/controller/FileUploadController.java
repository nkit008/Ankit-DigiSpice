package com.digispice.clicktocall.controller;

import java.io.BufferedOutputStream
;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digispice.clicktocall.dao.AddPlaylistDao;
import com.digispice.clicktocall.dao.FileUploadDao;
import com.digispice.clicktocall.dao.LoginDao;
import com.digispice.clicktocall.model.MetaFileModel;
import com.digispice.clicktocall.model.MetaInfoModel;
import com.digispice.clicktocall.model.UserModel;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

@Controller
public class FileUploadController {

	@Autowired
	HttpSession session;

	@Autowired
	FileUploadDao dao;

	@Autowired
	LoginDao dao1;

	@Autowired
	AddPlaylistDao dao2;

	int pid = 0;

	private static final Logger logger = Logger.getLogger(FileUploadController.class.getName());

	/*
	 * private static final String UPLOAD_DIRECTORY ="E:\\excel\\"; private
	 * static final String UPLOAD_artwork = "E:\\excel\\click2call";
	 */

	private static final String UPLOAD_DIRECTORY = "/home/ec2-user/SafariCom_Click2Call/";
	private static final String UPLOAD_artwork = "/home/ec2-user/SafariCom_Click2Call/click2call";

	String metaPath = null;
	String smartphone_test = null;
	String featuredphone_test = null;

	@RequestMapping(value = "uploadMusic", method = RequestMethod.POST)
	public String uploadMusic(@RequestParam String playlistName, @RequestParam MultipartFile artworkzipfile,
			Model model, @RequestParam MultipartFile metafile, RedirectAttributes redir) throws IOException {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {

			String fName = artworkzipfile.getOriginalFilename();
			logger.info("Artwork File Name:::::::::::" + fName);
			String metaname = metafile.getOriginalFilename();
			String artworkfileExtension = fName.substring(fName.lastIndexOf(".") + 1, fName.length());
			String metafileExtension = metaname.substring(metaname.lastIndexOf(".") + 1, metaname.length());
			logger.info("---meta file extension is " + metafileExtension);
			logger.info("---artwork file extension is " + artworkfileExtension);
			if (artworkfileExtension.equalsIgnoreCase("zip")) {
				if ((metafileExtension.equalsIgnoreCase("xls")) || (metafileExtension.equalsIgnoreCase("xlsx"))) {

					logger.info("---copy excel file into dest folder---");
					/* copy excel file into dest folder */
					String response = copyMetaFile(metafile);

					logger.info("---copy artwork file into dest root folder---");
					/* copy ZIP file into dest root folder */
					copyzip(artworkzipfile);

					logger.info("---Check artwork file format---");
					checkArtwork(artworkzipfile);
					logger.info("smartphone_test and featuredphone_test is " + smartphone_test + " and "
							+ featuredphone_test);
					if (smartphone_test != null || featuredphone_test != null) {
						smartphone_test = null;
						featuredphone_test = null;
						logger.info("---read dest excel file---");
						/* read dest excel file */
						String res = readMetaFile(response, playlistName);
						logger.info("Res value is " + res);

						if (res.equals("Meta file is Incorrrect")) {
							redir.addFlashAttribute("success", "Meta file is Incorrrect");
							redir.addFlashAttribute("userObj", ((UserModel) session.getAttribute("userObj")));
							return "redirect:/home";
						} else if (res.equals("fail")) {
							redir.addFlashAttribute("success", "not Uploded Successfully");
							redir.addFlashAttribute("userObj", ((UserModel) session.getAttribute("userObj")));
							return "redirect:/home";
						}

						else if (res.equals("success")) {
							logger.info("---copy artwork file into dest artwork folder---");
							/* copy artwork file into dest folder */

							pid = dao2.getpid(playlistName);
							artworkCopy(artworkzipfile, pid);
							return "redirect:/viewMetadataById";
						}

					}

					else {
						redir.addFlashAttribute("success", "ArtWork File is Incorrect");
					}
				}

				else {

					redir.addFlashAttribute("success", "Uploaded file is Incorrect");
				}
			} else {
				redir.addFlashAttribute("success", "Zip file is Incorrect");
			}

			redir.addFlashAttribute("userObj", ((UserModel) session.getAttribute("userObj")));
			return "redirect:/home";
		}
	}

	public String copyMetaFile(MultipartFile metafile) {
		try {
			String filename = metafile.getOriginalFilename().substring(0,
					metafile.getOriginalFilename().lastIndexOf("."));
			String ext = metafile.getOriginalFilename().substring(metafile.getOriginalFilename().lastIndexOf(".") + 1,
					metafile.getOriginalFilename().length());

			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");
			Date date = new Date();

			byte[] bytes = metafile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
					new File(UPLOAD_DIRECTORY + File.separator + filename + "_" + formatter.format(date) + "." + ext)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			metaPath = UPLOAD_DIRECTORY + File.separator + filename + "_" + formatter.format(date) + "." + ext;
			return metaPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void copyzip(MultipartFile artworkzipfile) throws IOException {
		String fName = artworkzipfile.getOriginalFilename();
		String destination = UPLOAD_DIRECTORY;
		File zip;

		zip = File.createTempFile(UUID.randomUUID().toString(), "temp");

		FileOutputStream o = new FileOutputStream(zip);
		IOUtils.copy(artworkzipfile.getInputStream(), o);
		o.flush();
		o.close();

		/*** unizp file from temp by zip4j ***/
		try {
			File f2 = new File(destination + fName.substring(0, fName.lastIndexOf(".")));
			FileUtils.deleteDirectory(f2);

			FileUtils.copyFile(zip, new File(destination + File.separator + fName));
			ZipFile zFile = new ZipFile(zip);
			zFile.extractAll(destination);
		} catch (ZipException e) {
			e.printStackTrace();
		} finally {
			/**
			 * delete temp file
			 */
			zip.delete();
			File f1 = new File(destination + File.separator + fName);
			if (f1.exists())
				f1.delete();
		}
	}

	public String readMetaFile(String path, String playlistName) {
		boolean resourceCode = false;
		boolean resourceTitle = false;
		boolean mainArtist = false;
		boolean album = false;

		Workbook workbook = null;

		try {
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			workbook = WorkbookFactory.create(new File(path));

			// Getting the Sheet at index zero
			Sheet sheet = workbook.getSheetAt(0);

			// Create a DataFormatter to format and get each cell's value as
			// String
			DataFormatter dataFormatter = new DataFormatter();
			List<MetaFileModel> list = new ArrayList<MetaFileModel>();

			int resCode = 0;
			int resTitle = 0;
			int resAlbum = 0;
			int resArtist = 0;

			/* Iterating over Rows(1) using for-each loop */
			Row row = sheet.getRow(0);

			/* Iterating over Rows(1) and Columns using for-each loop */
			for (Cell cell : row) {
				String cellvalue = dataFormatter.formatCellValue(cell);

				if (cellvalue.equalsIgnoreCase("ResourceCode")) {
					resourceCode = true;
					resCode = cell.getColumnIndex();

				}

				if (cellvalue.equalsIgnoreCase("ResourceTitle")) {
					resourceTitle = true;
					resTitle = cell.getColumnIndex();
				}

				if (cellvalue.equalsIgnoreCase("ReleaseTitle(Album)")) {
					album = true;
					resAlbum = cell.getColumnIndex();
				}

				if (cellvalue.equalsIgnoreCase("MainArtist")) {
					mainArtist = true;
					resArtist = cell.getColumnIndex();
				}
			}

			if ((resourceCode == true) && (resourceTitle = true) && (mainArtist = true) && (album = true)) {
				MetaFileModel model = new MetaFileModel();
				int f = 0;
				int r = 0;
				String cellvalue = null;
				for (Row row1 : sheet) {
					model = new MetaFileModel();

					if (r != 0) {
						for (Cell cell1 : row1) {
							cellvalue = null;
							if (f == resCode) {
								cellvalue = dataFormatter.formatCellValue(cell1);
								model.setCode(cellvalue.replace("'", ""));
							} else if (f == resArtist) {
								cellvalue = dataFormatter.formatCellValue(cell1);
								model.setArtist(cellvalue.replace("'", ""));
							}

							else if (f == resAlbum) {
								cellvalue = dataFormatter.formatCellValue(cell1);
								model.setAlbum(cellvalue.replace("'", ""));
							}

							else if (f == resTitle) {
								cellvalue = dataFormatter.formatCellValue(cell1);
								model.setTitle(cellvalue.replace("'", ""));
							}

							f++;
						}

						list.add(model);
					}
					r++;
					f = 0;
				}

				logger.info("---number of records in metafile is " + list.size());
				int pid = dao2.getpid(playlistName);
				String j = dao.metaFileUpload(list, pid);

				return j;

			}

			else {
				return "Meta file is Incorrrect";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void artworkCopy(MultipartFile banner, int pid) {
		try {
			String filename = banner.getOriginalFilename().substring(0, banner.getOriginalFilename().lastIndexOf("."));
			File bannerfile = new File(UPLOAD_DIRECTORY + File.separator + filename);
			File[] listOfFiles = bannerfile.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {

				if (listOfFiles[i].isDirectory()) {
					File[] listofNestedFile = listOfFiles[i].listFiles();

					for (int j = 0; j < listofNestedFile.length; j++) {

						if (listofNestedFile[j].isFile()) {
							String fext = listofNestedFile[j].getName().substring(
									listofNestedFile[j].getName().lastIndexOf("."),
									listofNestedFile[j].getName().length());

							if (fext.equalsIgnoreCase(".jpg")) {

								logger.info("file name:::" + listofNestedFile[j].getName());

								String fname = listofNestedFile[j].getName().substring(0,
										listofNestedFile[j].getName().lastIndexOf("."));

								String sorucePath = UPLOAD_DIRECTORY + filename + File.separator
										+ listOfFiles[i].getName() + File.separator + listofNestedFile[j].getName();

								String destPath = UPLOAD_artwork + File.separator + "artwork" + File.separator
										+ listOfFiles[i].getName() + File.separator;

								File f1 = new File(destPath); // destination
								File f = new File(sorucePath);
								if (!f1.exists()) {
									f1.mkdirs();
								}

								FileUtils.copyFile(f, new File(f1 + File.separator + fname + fext));

								if (listOfFiles[i].getName().equals("smartphone")) {

									// String uploadPath=destPath+ fname + fext;

									String uploadPath = "http://safaricom.liveafricamusic.com/ClickToCall/thumb/smartphone/"
											+ fname;
									int res = dao.addSmartPhoneThumbnail(uploadPath, fname);
									if (res > 0) {
										logger.info("---" + fname + "is added successfully---");
									} else {
										logger.info("---" + fname + "is not added successfully---");
									}

								}

								if (listOfFiles[i].getName().equals("featured")) {

									// String uploadPath=destPath+ fname + fext;

									String uploadPath = "http://safaricom.liveafricamusic.com/ClickToCall/thumb/featured/"
											+ fname;
									int res = dao.addFeaturedThumbnail(uploadPath, fname);
									if (res > 0) {
										logger.info("---" + fname + "is added successfully---");
									} else {
										logger.info("---" + fname + "is not added successfully---");
									}
								}

							}

							else {
								logger.info("File extension is Incorrect");
							}

						}
					}
				} else {
					logger.info("artwork zip is incorrect");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/viewMetadataById", method = RequestMethod.GET)
	public String viewMetadataById(Model model) {

		Map<String, String> map = dao2.getnameByid();
		List<MetaInfoModel> list = dao2.viewMetadataRecordsBypid(pid);

		model.addAttribute("playlist", list);
		model.addAttribute("mapitems", map);
		model.addAttribute("userObj", session.getAttribute("userObj"));
		model.addAttribute("msg", "Successfully Uploaded");
		return "viewMetadataRecord";
	}

	@RequestMapping(value = "/viewMetadata", method = RequestMethod.GET)
	public String category(Model model) {
		if (session.getAttribute("userObj") == null) {
			logger.info("--session expired--");
			return "redirect:/logout";
		}

		else {

			Map<String, String> map = dao2.getnameByid();
			List<MetaInfoModel> list = dao2.viewMetadataRecords();

			model.addAttribute("playlist", list);
			model.addAttribute("mapitems", map);
			model.addAttribute("userObj", session.getAttribute("userObj"));
			return "viewMetadataRecord";
		}
	}

	public void checkArtwork(MultipartFile banner) {
		String filename = banner.getOriginalFilename().substring(0, banner.getOriginalFilename().lastIndexOf("."));
		File bannerfile = new File(UPLOAD_DIRECTORY + File.separator + filename);
		File[] listOfFiles = bannerfile.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isDirectory()) {
				File[] listofNestedFile = listOfFiles[i].listFiles();

				for (int j = 0; j < listofNestedFile.length; j++) {

					if (listofNestedFile[j].isFile()) {
						String fext = listofNestedFile[j].getName().substring(
								listofNestedFile[j].getName().lastIndexOf("."), listofNestedFile[j].getName().length());

						if (fext.equalsIgnoreCase(".jpg")) {

							if (listOfFiles[i].getName().equals("smartphone")) {

								smartphone_test = "yes";
							}

							if (listOfFiles[i].getName().equals("featured")) {
								featuredphone_test = "yes";
							}

						}
					}

				}

			}

		}

	}
}