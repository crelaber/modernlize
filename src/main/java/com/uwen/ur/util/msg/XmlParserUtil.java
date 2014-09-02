package com.uwen.ur.util.msg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlParserUtil {

	public static String parserResult(String uri) throws Exception {

		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		// 鍒涘缓涓�釜瑙ｆ瀽XML鐨勫璞�		
		SAXParser parser = parserFactory.newSAXParser();
		// 鍒涘缓涓�釜瑙ｆ瀽鍔╂墜绫�		
		Myhandler myhandler = new Myhandler("returnsms");
		parser.parse(uri, myhandler);

		List<Map<String, String>> list = myhandler.getList();
		String resultValue = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, String> temp = (HashMap<String, String>) list
					.get(i);
			Iterator<String> iterator = temp.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next().toString();
				String value = temp.get(key);
				if (key.equals("message")) {
					resultValue = value;
				}
			}
		}

		return resultValue;
	}

	static class Myhandler extends DefaultHandler {
		// 瀛樺偍姝ｅ湪瑙ｆ瀽鐨勫厓绱犵殑鏁版嵁
		private Map<String, String> map = null;
		// 瀛樺偍鎵�湁瑙ｆ瀽鐨勫厓绱犵殑鏁版嵁
		private List<Map<String, String>> list = null;
		// 姝ｅ湪瑙ｆ瀽鐨勫厓绱犵殑鍚嶅瓧
		String currentTag = null;
		// 姝ｅ湪瑙ｆ瀽鐨勫厓绱犵殑鍏冪礌鍊�		
		String currentValue = null;
		// 寮�瑙ｆ瀽鐨勫厓绱�		
		String nodeName = null;

		public Myhandler(String nodeName) {
			// TODO Auto-generated constructor stub
			this.nodeName = nodeName;
		}

		public List<Map<String, String>> getList() {
			return list;
		}

		// 寮�瑙ｆ瀽鏂囨。锛屽嵆寮�瑙ｆ瀽XML鏍瑰厓绱犳椂璋冪敤璇ユ柟娉�		
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			// 鍒濆鍖朚ap
			list = new ArrayList<Map<String, String>>();
		}

		// 寮�瑙ｆ瀽姣忎釜鍏冪礌鏃堕兘浼氳皟鐢ㄨ鏂规硶
		
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			// 鍒ゆ柇姝ｅ湪瑙ｆ瀽鐨勫厓绱犳槸涓嶆槸寮�瑙ｆ瀽鐨勫厓绱�			
			if (qName.equals(nodeName)) {
				map = new HashMap<String, String>();
			}

			// 鍒ゆ柇姝ｅ湪瑙ｆ瀽鐨勫厓绱犳槸鍚︽湁灞炴�鍊�濡傛灉鏈夊垯灏嗗叾鍏ㄩ儴鍙栧嚭骞朵繚瀛樺埌map瀵硅薄涓紝濡�<person
			// id="00001"></person>
			if (attributes != null && map != null) {
				for (int i = 0; i < attributes.getLength(); i++) {
					map.put(attributes.getQName(i), attributes.getValue(i));
				}
			}
			currentTag = qName; // 姝ｅ湪瑙ｆ瀽鐨勫厓绱�		
			}

		// 瑙ｆ瀽鍒版瘡涓厓绱犵殑鍐呭鏃朵細璋冪敤姝ゆ柟娉�		
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
			if (currentTag != null && map != null) {
				currentValue = new String(ch, start, length);
				// 濡傛灉鍐呭涓嶄负绌哄拰绌烘牸锛屼篃涓嶆槸鎹㈣绗﹀垯灏嗚鍏冪礌鍚嶅拰鍊煎拰瀛樺叆map涓�			
				if (currentValue != null && !currentValue.trim().equals("")
						&& !currentValue.trim().equals("\n")) {
					map.put(currentTag, currentValue);
					System.out.println("-----" + currentTag + " "
							+ currentValue);
				}
				// 褰撳墠鐨勫厓绱犲凡瑙ｆ瀽杩囷紝灏嗗叾缃┖鐢ㄤ簬涓嬩竴涓厓绱犵殑瑙ｆ瀽
				currentTag = null;
				currentValue = null;
			}
		}

		// 姣忎釜鍏冪礌缁撴潫鐨勬椂鍊欓兘浼氳皟鐢ㄨ鏂规硶
		
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			// 鍒ゆ柇鏄惁涓轰竴涓妭鐐圭粨鏉熺殑鍏冪礌鏍囩
			if (qName.equals(nodeName)) {
				list.add(map);
				map = null;
			}
		}

		// 缁撴潫瑙ｆ瀽鏂囨。锛屽嵆瑙ｆ瀽鏍瑰厓绱犵粨鏉熸爣绛炬椂璋冪敤璇ユ柟娉�		
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
		}
	}
}
