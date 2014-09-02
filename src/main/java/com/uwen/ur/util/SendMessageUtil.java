package com.uwen.ur.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SendMessageUtil {

	private static String ACCOUNT = "fxcm";
	private static String PASSWORD = "fxcm888";
	private static String USER_ID = "626";
	private static String BASE_URL = "http://www.hndxsms.com:9001/sms.aspx?action=send";
	
	/**
	 * http://www.hndxsms.com:9001/sms.aspx?action=send&userid=企业ID&account=账号&password=密码&mobile=150232111110,13523245163&content=内容&sendTime=&taskName=本次任务描述&checkcontent=1&mobilenumber=10&countnumber=12&telephonenumber=2
	 * http://222.240.164.2:9001/sms.aspx?action=send&userid=626&account=fxcm&password=fxcm888&mobile=15820491260&content=验证码测试&sendTime=&taskName=&checkcontent=0&mobilenumber=1&countnumber=1&telephonenumber=0
	 * http://www.hndxsms.com:9001/sms.aspx?action=send&userid=626&account=fxcm&password=fxcm888&mobile=18721665513&content=今天的心情非常的好&sendTime=&taskName=&checkcontent=0&mobilenumber=1&countnumber=1&telephonenumber=0
	 * @throws Exception 
	*/	
	
	public static void doSend(String mobile,String content) throws Exception{
		String url = BASE_URL
							+"&userid="+USER_ID
							+"&account="+ACCOUNT
							+"&password="+PASSWORD
							+"&mobile="+mobile
							+"&content="+content
							+"&sendTime=&taskName=&checkcontent=0&mobilenumber=1&countnumber=1&telephonenumber=0";
		String result = executeGet(url);
	}
	
	
	 public static String executeGet(String url) throws Exception {  
	        BufferedReader in = null;  
	        String content = null;  
	        try {  
	            // 定义HttpClient  
	            HttpClient client = new DefaultHttpClient();  
	            // 实例化HTTP方法  
	            HttpGet request = new HttpGet(url);  
	            HttpResponse response = client.execute(request);  
	            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
	            StringBuffer sb = new StringBuffer("");  
	            String line = "";  
	            while ((line = in.readLine()) != null) {  
	                sb.append(line);  
	            }  
	            in.close();  
	            content = sb.toString();  
	        } finally {  
	            if (in != null) {  
	                try {  
	                    in.close();// 最后要关闭BufferedReader  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            return content;  
	        }  
	    }  
	
	 public static void main(String[] args) {
		 try {
			String content = executeGet("http://192.168.10.136:8080/mycar/client/businessService/newsList?pageNo=1&pageSize=10");
			System.out.println(content);
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
