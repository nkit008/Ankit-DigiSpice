package com.spice.vchatinterfacebulk.beans;

public class GetDblink {

	public static String getDblink( String hubname)
	{
		String dblink="";
		if (hubname.equals("West")) {
			dblink = "westdb1.hutch_bgm.";
		} else if (hubname.equals("Upeast")) {
			dblink = "upeast_db.hutch_bgm.";
		} else if (hubname.equals("North")) {
			dblink = "north_db.hutch_bgm.";
		} else if (hubname.equals("East")) {
			dblink = "east_db.bgm.";
		} else if (hubname.equals("South")) {
			dblink = "south_db.hutch.";
		} else {
			dblink = "no record";
		}
		return dblink;
	}
}
