package com.uwen.ur.util.crawer;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlTest {

	
	public static void main(String[] args) {
		
		
		String s = "车";
		
		String encode = URLEncoder.encode(s);
		System.out.println(encode);
		String decode = URLDecoder.decode(encode);
		System.out.println(decode);
	}
}
