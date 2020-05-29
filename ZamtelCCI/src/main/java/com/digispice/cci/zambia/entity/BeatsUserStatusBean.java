package com.digispice.cci.zambia.entity;

import org.springframework.stereotype.Component;

@Component
public class BeatsUserStatusBean {
	
	private String code;
	private String message;
	private String popUpmessage;
	private MusicBean musicBean;
	private BundleBean bundleBean;
	private KaraokeBean karaokeBean;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPopUpmessage() {
		return popUpmessage;
	}
	public void setPopUpmessage(String popUpmessage) {
		this.popUpmessage = popUpmessage;
	}
	public MusicBean getMusicBean() {
		return musicBean;
	}
	public void setMusicBean(MusicBean musicBean) {
		this.musicBean = musicBean;
	}
	public BundleBean getBundleBean() {
		return bundleBean;
	}
	public void setBundleBean(BundleBean bundleBean) {
		this.bundleBean = bundleBean;
	}
	public KaraokeBean getKaraokeBean() {
		return karaokeBean;
	}
	public void setKaraokeBean(KaraokeBean karaokeBean) {
		this.karaokeBean = karaokeBean;
	}
	@Override
	public String toString() {
		return "BeatsUserStatusBean [code=" + code + ", message=" + message + ", popUpmessage=" + popUpmessage
				+ ", musicBean=" + musicBean + ", bundleBean=" + bundleBean + ", karaokeBean=" + karaokeBean + "]";
	}
	
	
	
	
	
}
