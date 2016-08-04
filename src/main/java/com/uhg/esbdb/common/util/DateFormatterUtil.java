package com.uhg.esbdb.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DateFormatterUtil {
	public static ArrayList<Object> convertStringToTimeStamp(String csHeaderTimeDate){
		ArrayList<Object> arrayList=new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		simpleDateFormat.setLenient(false);
		long l=0L;
		try {
			l = simpleDateFormat.parse(csHeaderTimeDate).getTime();
			Timestamp timestamp = new Timestamp(l);
			arrayList.add(timestamp);
			arrayList.add("1");
		} catch (ParseException e) {
			arrayList.add("Invalid Date");
			arrayList.add("0");
		}
		return arrayList;
	}

}
	
