package com.tgb.interfaceSystem.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class StringHelper {

	
	/**
	 * 字符串分割
	 * @param str
	 * @param splisFlag
	 * @author Lucky
	 * @return
	 */
	public static List split(String str, String splisFlag) {

		List rsList = new ArrayList();
		if (str != null) {
			String[] strArray = str.split(splisFlag);
			if (strArray.length > 0) {
				for (int i = 0; i < strArray.length; i++) {
					rsList.add(strArray[i]);

				}
				return rsList;
			}
		}

		return null;
	}
	
	
	
	
	
	/**
	 * 字符串分割
	 * @param str
	 * @param splisFlag
	 * @return
	 */
	public static ArrayList splitReturnArray(String str, String splisFlag) {

		ArrayList rsList = new ArrayList();
		if (str != null) {
			String[] strArray = str.split(splisFlag);
			if (strArray.length > 0) {
				for (int i = 0; i < strArray.length; i++) {
					rsList.add(strArray[i]);

				}
				return rsList;
			}
		}

		return null;
	}

	
	
	/**
	 * split a String by the set pattern.
	 * 数据类型转换
	 * @return a list that contains the splitted results.
	 */

	public static String converDateToString(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String converDateToString(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date converStringToDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date formatdate = sdf.parse(date);
			return formatdate;
		} catch (ParseException e) {

		}
		return null;
	}
	

	//有毫秒
	public static Date converStringToDateWithMs(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date formatdate = sdf.parse(date);
			return formatdate;
		} catch (ParseException e) {

		}
		return null;
	}

	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String ID = str.replace("-", "");
		
		return ID;
	}

	
	
	 //UTF8转码
  public static String toUtf8String(String s) {
			 
		  StringBuffer sb = new StringBuffer();
		  for (int i=0;i<s.length();i++) {
		     char c = s.charAt(i);
		     if (c >= 0 && c <= 255) {
		     sb.append(c);
		     } else {
		      byte[] b;
		        try {
		          b = Character.toString(c).getBytes("utf-8");
		       } catch (Exception ex) {
		          System.out.println(ex);
		          b = new byte[0];
		        }
		         
		      for (int j = 0; j < b.length; j++) {
		        int k = b[j];
		        if (k < 0) k += 256;
		           sb.append("%" + Integer.toHexString(k).toUpperCase());
		        }
		      }
		  }
		  
		  String s_utf8 = sb.toString();
		  sb.delete(0,sb.length());
		  sb.setLength(0);
		  sb = null;
		  return s_utf8;
	  }
	

	public static void main(String[] args) {
	
		Random random = new Random();
		System.out.println(random.nextInt(1000000));
		String str=randomUUID();
		System.out.println(str);

	}
}
