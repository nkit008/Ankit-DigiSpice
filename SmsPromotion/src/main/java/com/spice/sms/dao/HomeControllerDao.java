package com.spice.sms.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spice.sms.entites.LoginEntitiy;
import com.spice.sms.entites.SmsCli;

public interface HomeControllerDao {

	
	public LoginEntitiy checkLogin(String username,String pass);
	
	public List<SmsCli> getAllCli(String cName);
	
	public String baseUpload(String base,String circle,String cli,String smsType,String smsScript);
}
