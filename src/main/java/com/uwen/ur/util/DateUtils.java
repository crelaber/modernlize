package com.uwen.ur.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间类
 * User: haobl
 * Date: 12-12-27
 * Time: 上午9:28
 * To change this template use File | Settings | File Templates.
 */
public class DateUtils {

    protected static final String DATE_FORMAT = "yyyy-MM-dd";
    protected static final String DATE_FORMAT_2 = "yyyy-MM-dd hh:mm:ss";

    public static Date getDateInstance(int field, int amount)
    {
        Date date = new Date();//当前日期
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static Date   getInstance()
    {
        return   new Date();//当前日期
    }

    public static Date getBeforeMonthDate()
    {
        return getDateInstance(Calendar.MONTH, -1);
    }
    public static Date getBeforeDayDate()
    {
        return getDateInstance(Calendar.DAY_OF_MONTH, -1);
    }

    public static String format(Date dateIn)
    {
        final DateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT);
        String dateStr = "";
        if(dateIn!=null)
        {
            dateStr = dateFormat.format(dateIn);
        }
        return dateStr;
    }
    
    public static String format2(Date dateIn)
    {
        final DateFormat dateFormat = new SimpleDateFormat(DateUtils.DATE_FORMAT_2);
        String dateStr = "";
        if(dateIn!=null)
        {
            dateStr = dateFormat.format(dateIn);
        }
        return dateStr;
    }
    
    public static Date StringToDate(String dateStr,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
