package com.uwen.ur.util.msg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SMSUtil {

	private static final String url = "http://www.hndxsms.com:9001/sms.aspx";
	
	private static  final String ISOK="ok"; 

	public static void main(String[] args) {

		SMSUtil test = new SMSUtil();
		String msg = "测试短信1";
		List<String> list = new ArrayList<String>();
		list.add("18201753497");
		String str=null;
		try {
			str=test.sendSms(list, msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//String ss = XmlParserUtil
					//.parserResult("/Users/xi/Documents/java_workplace/GsooDemo/download.xml");
			System.out.println("str="+str);
			//String ss = XmlParserUtil.parserResult(str);
			String ss=test.getSendSign(str);
			System.out.println(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String result="<?xml version=\"1.0\" encoding=\"utf-8\" ?><returnsms><returnstatus>Success</returnstatus><message>ok</message><remainpoint>10006</remainpoint><taskID>3726733</taskID><successCounts>1</successCounts></returnsms>";
		//test.getSendSign(result);
	}
	//获取发送标识
	private static String getSendSign(String result){
		
		if(null==result) return "error";
		String sign = "error";
		try{
		String[] list = result.split("<message>");
		String s1 = list[1];
		System.out.println("s1="+s1);
		 sign = s1.split("</message>")[0];
		System.out.println("sign="+sign);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return sign;
	}
	
	public static boolean isSended(List<String> list,String code){
		
		//String msg = "测试短信";
		//List<String> list = new ArrayList<String>();
		if(null==list||0==list.size()){
			return false;
		}
		if(null==code || 0=="".compareTo(code.trim())){
			return false;
		}
		//list.add("18201753497");
		String str="";
		try {
		str=sendSms(list, code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ss="error";
		try {
		// ss = XmlParserUtil
					//.parserResult("/Users/xi/Documents/java_workplace/GsooDemo/download.xml");
		 ss=getSendSign(str);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!ss.equals(ISOK)) {
			return false;
		}
		return true;
		
	}

	/**
	 * 
	 * @param phoneNums
	 * @param sendContent
	 * @return ok代表成功 其它就是状态信息
	 * @throws Exception
	 */
	private static String sendSms(List<String> phoneNums, String sendContent)
			throws Exception {

		if (phoneNums == null || phoneNums.size() == 0) {

			throw new Exception("发送号码不能未空");
		}
		if (sendContent == null || sendContent.length() == 0) {
			throw new Exception("发送内容不能未空");
		}
		StringBuffer phones = new StringBuffer();
		for (int i = 0; i < phoneNums.size(); i++) {
			if (i != phoneNums.size() - 1) {
				phones.append(phoneNums.get(i));
				phones.append(",");
			} else {
				phones.append(phoneNums.get(i));
			}
		}
		/*
		 * 1. 获取短信验证码 
			企业ID: 637
			账号: mycar
			密码: mycarmycar

		 */
		Map<String, String> params = new HashMap<String, String>();
		params.put("action", "send");
		params.put("userid", "637");
		params.put("account", "mycar");
		params.put("password", "mycarmycar");
		params.put("mobile", phones.toString());
		params.put("content", sendContent);
		params.put("sendTime", "");
		params.put("taskName", "");
		params.put("checkcontent", "0");
		params.put("mobilenumber", "1");
		params.put("countnumber", phoneNums.size() + "");// 发送号码总数量
		params.put("telephonenumber", "2");
		String result = HttpUtil.post(url, params);
		System.out.println(result);

		return result;
	}
}
