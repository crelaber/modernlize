package com.uwen.ur.util;

import java.io.*;
import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * 文件读取
 * @author Administrator
 *
 */
public class FileReadUtil {
	public static void main(String[] args) {
		getMenus("d:\\menus.json");
	}
	public static Map<String,String> getMenus(String path){
		String str = getReadFileStr(path);
		JSONArray arr = JSONArray.fromObject(str);
		Map<String,String> menus = new HashMap<String,String>();
		if(null!=arr&&arr.size()>0){
			for(int i=0;i<arr.size();i++){
				//System.out.println(arr.get(i));
				JSONObject obj = arr.getJSONObject(i);
				//System.out.println(obj);
				JSONArray cAttr = obj.getJSONArray("children");
				if(null!=cAttr&&cAttr.size()>0){
					for(int j=0;j<cAttr.size();j++){
						JSONObject cobj = cAttr.getJSONObject(j);
						menus.put(cobj.getString("url"), cobj.getString("id"));
						System.out.println(cobj.getString("id"));
					}
				}
			}
		}
		return menus;
	}
    private  static String getReadFileStr(String path){
    	BufferedReader br = null;
    	String rtnStr="";
    	try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader  isr = new InputStreamReader(fis,"UTF-8");
			br = new BufferedReader(isr);
			String tmpStr = null;
			while((tmpStr=br.readLine())!=null){
				rtnStr=rtnStr+tmpStr;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(null!=br){
				try {
					br.close();
					br=null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	return rtnStr;
    }
}
