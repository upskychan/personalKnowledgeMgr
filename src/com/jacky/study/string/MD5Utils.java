package com.jacky.study.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {
	
	/**
	 * 将字符串md5加密
	 */
	public static String StringToMD5(String plainText) {
		String returnValue = "";
		  try {
		   MessageDigest md = MessageDigest.getInstance("MD5");
		   md.update(plainText.getBytes());
		   byte b[] = md.digest();

		   int i;

		   StringBuffer buf = new StringBuffer("");
		   for (int offset = 0; offset < b.length; offset++) {
		    i = b[offset];
		    if (i < 0)
		     i += 256;
		    if (i < 16)
		     buf.append("0");
		    buf.append(Integer.toHexString(i));
		   }
		   returnValue = buf.toString();
		  } catch (NoSuchAlgorithmException e) {
		   e.printStackTrace();

		  }
		  return returnValue;
		 }

}
