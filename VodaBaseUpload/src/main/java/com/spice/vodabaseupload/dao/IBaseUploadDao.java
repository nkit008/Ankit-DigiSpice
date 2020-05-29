package com.spice.vodabaseupload.dao;

import org.springframework.web.multipart.MultipartFile;

public interface IBaseUploadDao {
	
	public String upload(MultipartFile base, String serviceName);
	

}
