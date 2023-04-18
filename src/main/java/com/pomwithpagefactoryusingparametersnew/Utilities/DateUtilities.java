package com.pomwithpagefactoryusingparametersnew.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {
	
	public static String getCurrentDateStr()
	{
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		return dateName;
		
		
	}

}
