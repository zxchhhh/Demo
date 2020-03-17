package com.zcx.tool;

import java.text.SimpleDateFormat;

public class Tool {
	
	public static java.util.Date strToDate(String dateStr,String parttern) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat(parttern);
		return sdf.parse(dateStr);
	}

}
