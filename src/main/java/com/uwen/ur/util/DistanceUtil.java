package com.uwen.ur.util;

import java.util.HashMap;
import java.util.Map;

public class DistanceUtil {
	
	/**
	 * 地图半径
	 */
	public static long EARTH_RADIUS = 6378137;  
	/**
	 * 最大的距离
	 */
	public static long MAX_DISTANCE = 200000;
	/**
	 * 默认的中心纬度,定位到陆家嘴
	 */
	public static double DEFAULT_MY_LAT = 31.243319;
	/**
	 * 默认的中心纬度
	 */
	public static double DEFAULT_MY_LON = 121.509075;
	/**
     * 生成以中心点为中心的四方形经纬度
     * @param centralLat 中心点纬度 ,这里传手机所在的维度
     * @param centralLon 中心点精度 ,这里传手机所在的精度
     * @param distance 半径（以米为单位），由客户端传递进来的距离参数
     * @return map minLat最小维度  maxLat最大纬度  minLon最小精度   maxLon最大经度 earthRadius地球的半径
     */ 
    public static Map<String,Object> getAroundBaseInfoMap(double centralLat, double centralLon, double distance) { 
 
    	
        Map<String,Object> map = new HashMap<String,Object>();
        Double latitude = centralLat; 
        Double longitude = centralLon; 
 
        Double degree = (24901 * 1609) / 360.0; 
        double raidusMile = distance; 
 
        Double dpmLat = 1 / degree; 
        Double radiusLat = dpmLat * raidusMile; 
        Double minLat = latitude - radiusLat; 
        Double maxLat = latitude + radiusLat; 
 
        Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180)); 
        Double dpmLng = 1 / mpdLng;              
        Double radiusLng = dpmLng * raidusMile;  
        Double minLng = longitude - radiusLng;   
        Double maxLng = longitude + radiusLng;   
        map.put("earthRadius", EARTH_RADIUS);
        map.put("minLat", minLat);
        map.put("maxLat", maxLat);
        map.put("minLon", minLng);
        map.put("maxLon", maxLng);
       
        map.put("centralLat",centralLat);
        map.put("centralLon", centralLon);
        return map;
    }
}
