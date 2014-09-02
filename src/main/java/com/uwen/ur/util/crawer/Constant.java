package com.uwen.ur.util.crawer;

import java.lang.reflect.Method;

import com.uwen.ur.model.pojo.sys.UrFaqTypeExample;
import com.uwen.ur.util.JUtil;
import com.uwen.ur.util.MapperUtil;

public class Constant {

	public static String dir_path = "/Users/xi/Downloads/";
	
	public static void main(String[] args) {
		try {
			Method m = UrFaqTypeExample.Criteria.class.getSuperclass().getDeclaredMethod(
					"and" + JUtil.upperFirstWord("Id") + "EqualTo",
					String.class);
			System.out.println(m);
			
			Method m2 = MapperUtil.getUnkownMethod(UrFaqTypeExample.Criteria.class,
					"and" + JUtil.upperFirstWord("Id") + "EqualTo",
					String.class);
			System.out.println(m2);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
