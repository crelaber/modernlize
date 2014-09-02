package com.uwen.ur.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import freemarker.template.Configuration;

public class CityGeneral {

    private Configuration cfg;
    
    
    public static JSONArray getAutoCfg() throws IOException{
    	InputStream is = CityGeneral.class.getClassLoader().getResourceAsStream("mg/china_city.json");
        //包装流
        InputStreamReader isr = new InputStreamReader(is);
        //字符流
        BufferedReader bf = new BufferedReader(isr);
        //
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        //
        while ((line = bf.readLine()) != null) {
            stringBuilder.append(line);
        }
        
        return JSONArray.fromObject(stringBuilder.toString());
    }
    
    public static void main(String[] args) throws Exception {
    	JSONArray chinaArray = getAutoCfg();
    	for(int i = 0 ; i < chinaArray.size(); i++){
    		JSONObject provinceWrap = chinaArray.getJSONObject(i);
    		if(null != provinceWrap){
    			if(provinceWrap.has("t")){
    				String provinceName = provinceWrap.getString("t");
    				System.out.print(provinceName + "\t" );
    			}
    			
    			if(provinceWrap.has("s")){
    				JSONArray cityArray = provinceWrap.getJSONArray("s");
    				
    				for(int j = 0 ; j < cityArray.size(); j++){
    					JSONObject cityWrap = cityArray.getJSONObject(j);
    					
    					if(cityWrap.has("t")){
    	    				String cityName = cityWrap.getString("t");
    	    				if(!"其他地区".equals(cityName)){
    	    					System.out.print(cityName + "\t");
    	    				}
    	    			}
    				}
    			}
    		}
    		System.out.println();
    	}
    }

}
