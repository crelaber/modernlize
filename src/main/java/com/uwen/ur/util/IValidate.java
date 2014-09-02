package com.uwen.ur.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IValidate extends Validate{
    
    
    /**
     * 验证不能相等
     * @param obj
     * @param equalsTo
     */
    public static void notEquals(Object obj , String equalsTo){
        notEquals(obj, equalsTo, null);
    }
    
    /**
     * 验证不能相等
     * @param obj
     * @param equalsTo
     */
    public static void notEquals(Object obj , String equalsTo , String msg){
        if(equalsTo.equals(obj)){
            if(null == msg){
                throw new RuntimeException();
            }else{
                throw new RuntimeException(msg);
            }
        }
    }

    /**
     * 邮件格式验证
     * @param email
     * @return
     */
    public static boolean isEmail(String email)
    {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        Matcher mat = pattern.matcher(email);
        if (!mat.find())
        {
            tag = false;
        }
        return tag;

    }
    
    /** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }
    
    /** 
     *  长度不足
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean lengthEnough(String str, int minLen) {   
        boolean b = false;   
        if(str.length()<minLen){
        	b = true;
        }
        return b;  
    }
    
    public static String setDefaultValue(String key ,String defaultValue){
    	if(StringUtils.isEmpty(key)){
    		key = defaultValue;
    	}
    	return key;
    }
}
