package com.spice.vchatinterfacebulk.configuration;

public class DataBaseHubLink {
	
	DataBaseHubLink(){
	}
	
	
	public String getHubDbLink(String hubname){
		if (hubname.equalsIgnoreCase("West")) {
			return "westdb1.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("Upeast")) {
			return "upeast_db.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("North")) {
			return "north_db.hutch_bgm.";
		} else if (hubname.equalsIgnoreCase("East")) {
			return "east_db.bgm.";
		} else if (hubname.equalsIgnoreCase("South")) {
			return "south_db.hutch.";
		} else {
			return "no record";
		}
	}
}
