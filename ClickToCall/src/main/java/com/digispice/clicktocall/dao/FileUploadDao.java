package com.digispice.clicktocall.dao;

import java.util.List;

import com.digispice.clicktocall.model.MetaFileModel;

public interface FileUploadDao {

	public String metaFileUpload(List<MetaFileModel> model, int pid);

	public int addSmartPhoneThumbnail(String uploadPath, String fname);

	public int addFeaturedThumbnail(String uploadPath, String fname);

}
