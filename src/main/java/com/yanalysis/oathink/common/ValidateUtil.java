package com.yanalysis.oathink.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	public static String regexphone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

	public static boolean validatePhone(String phone) {
		if (phone.length() != 11) {
			return false;
		} else {
			Pattern p = Pattern.compile(regexphone);
			Matcher m = p.matcher(phone);
			boolean isMatch = m.matches();
			return isMatch;
		}
	}

}