package com.uwen.ur.util.crawer;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class ParserCallbackTemplate implements ParserCallback {

	
	public Object call(Object obj) {
		Matcher m = (Matcher) obj;
		List<String> urlList = new ArrayList<String>();
		while (m.find()) {
			urlList.add(m.group(1));
		}
		return urlList;
	}

}
