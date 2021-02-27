package com.saveo.utility;

public class GeneralUtility {

	
	public static  Long dateStringToLongConverter(String date) {
		 String[] arrOfStr = date.split("/", 3); 
		Long dateLong=Long.parseLong(arrOfStr[0])+Long.parseLong(arrOfStr[1])*100+Long.parseLong(arrOfStr[2])*1000;
		return dateLong;
	}
}
