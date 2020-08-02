package com.Urbanladder.base;

import java.util.Date;

public class dateUtils {
	
	
	public static String getTimestamp()
	{
		Date date=new Date();
		return date.toString().replaceAll(":","_").replaceAll(" ", "_");
	}
}

