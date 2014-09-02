/**   
 * 文件名：JUtil.java   
 *   
 * 版本信息：   
 * 日期：2012-5-11   
 * Copyright  Corporation 2012    
 * 版权所有   
 *   
 */

package com.uwen.ur.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.ServletActionContext;


import com.uwen.ur.common.CommonConstants;
import com.uwen.ur.exception.RuntimeMessageException;
import com.uwen.ur.model.interfaze.sys.FieldInAbstract;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExtTreeNode;

/** 
 * @author (Jiang wei)  邮件地址:jiangwei3788@talkweb.com.cn 
 * @version 创建时间：2012-5-11 上午09:57:03 
 * 类说明 
 */

/**
 * 文件名称: JUtil.java 内容摘要:
 * 
 * @author: 姜玮
 * @version: 1.0
 * @Date: 2012-5-11 上午09:57:03
 * 
 *        修改历史: 修改日期 修改人员 版本 修改内容 ----------------------------------------------
 *        2012-5-11 姜玮 1.0 1.0 无
 * 
 *        版权: 版权所有(C)2012 公司: 华诚信息科技股份有限公司
 */
public class JUtil {

	/**
	 * 默认值
	 * 
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public static Object substr(String str, int length, String end) {
		if (null == str) {
			return "";
		}

		if (str.length() <= length) {
			return str;
		}

		float charlenth = 0;
		char[] chars = str.toCharArray();
		int idx = 0;
		for (char c : chars) {
			int len = getLength(c);
			if (len > 1) {
				charlenth += 1;
			} else {
				charlenth += 0.5;
			}
			if (charlenth >= length) {
				int sub_len = charlenth == length ? idx + 1 : idx;
				return str.substring(0, sub_len) + end;
			}

			idx++;
			// 4 -1 -1
			// 啊是双调是xxxxx
			// if(length < str.length())break;
		}

		// 英文字母/数字/2位算1位
		return str;
	}

	public static void main(String[] args) {
		/*
		 * String result4 = autoSpace( 16 ,new
		 * AutoLine(12,"","预点号∶",AutoLine.LEFT,12f) ,new
		 * AutoLine(4,"","1245",AutoLine.LEFT,4f) ); System.out.println("-" +
		 * result4 + "-");
		 * 
		 * String result = autoSpace( 16 ,new
		 * AutoLine(5,"**","菜名",AutoLine.LEFT,5.5f) ,new
		 * AutoLine(4,"","数量",AutoLine.LEFT,4) ,new
		 * AutoLine(7,"","价格",AutoLine.LEFT,7.5f) ); System.out.println("-" +
		 * result + "-");
		 * 
		 * String result2 = autoSpace( 16 ,new
		 * AutoLine(5,"**","超级大卤肉饭",AutoLine.RIGHT,5.5f) ,new
		 * AutoLine(4,"","88",AutoLine.LEFT,4) ,new
		 * AutoLine(7,"","99.78",AutoLine.LEFT,7.5f) ); System.out.println("-" +
		 * result2 + "-");
		 * 
		 * 
		 * for (int i = 0; i < 4; i++) { String result3 = autoSpace( 16 ,new
		 * AutoLine(5,"*","白菜",AutoLine.RIGHT,5.5f) ,new
		 * AutoLine(4,"","88",AutoLine.LEFT,4) ,new
		 * AutoLine(7,"","9922.70",AutoLine.LEFT,7.5f) ); System.out.println("-"
		 * + result3 + "-"); }
		 */

		System.out.println(genOrderId());
	}

	/**
	 * 
	 * @param lineMax
	 *            每行最多的字符个数
	 * @param lines
	 * @return
	 */
	public static String autoSpace(int lineMax, AutoLine... lines) {
		StringBuilder strb = new StringBuilder();
		for (AutoLine line : lines) {
			Object strResult = substr(line.getStr(), line.getMaxsize(),
					line.getCha());
			if (strResult instanceof String) {
				line.setConvertStr((String) strResult);
			} else {
				line.setConvertStr("");
			}
			float convertLenth = getLength(line.getConvertStr());
			float expectLength = line.getExpectLength();
			// 计算长度
			line.setConvertLength(convertLenth);
			// 如果实际长度小于预期长度
			if (convertLenth < expectLength) {
				String nbsps = genNbsp((float) expectLength - convertLenth);
				if (line.getDirection() == AutoLine.LEFT) {
					strb.append(nbsps);
					strb.append(line.getConvertStr());
				} else if (line.getDirection() == AutoLine.RIGHT) {
					strb.append(line.getConvertStr());
					strb.append(nbsps);
				}
			} else if (convertLenth > expectLength) {
				strb.append(line.getConvertStr());
			} else {
				strb.append(line.getConvertStr());
			}
		}

		/*
		 * for (AutoLine line : lines) { //开始拼装字符串
		 * strb.append(line.getConvertStr()); }
		 */

		return strb.toString();
	};

	/**
	 * 
	 * @param sum
	 * @return
	 */
	public static String genNbsp(float sum) {
		StringBuilder nbsps = new StringBuilder();
		int intval = new Float(sum).intValue();
		int loopSum = intval;
		if (sum > intval) {
			loopSum += 1;
		}

		for (int i = 0; i < loopSum; i++) {
			nbsps.append("　");
		}
		return nbsps.toString();
	};

	public static class AutoLine {
		public static final int LEFT = 0;
		public static final int RIGHT = 1;

		/**
		 * 
		 * @param maxsize
		 *            超过多少长度加省略字符
		 * @param cha
		 *            省略字符
		 * @param str
		 *            字符串
		 * @param direction
		 *            方向
		 * @param expectLength
		 *            预期最长长度(必须要给每个区块设置好预期长度)
		 */
		public AutoLine(int maxsize, String cha, String str, int direction,
				float expectLength) {
			super();
			this.maxsize = maxsize;
			this.cha = cha;
			this.str = str;
			this.direction = direction;
			this.expectLength = expectLength;
		}

		// 补充空格的方位
		int direction;
		// 最大长度
		private int maxsize;
		// 补充字符
		private String cha;
		// 字符串
		private String str;
		// 转换后的字符串
		private String convertStr;
		// 转换后的字符串
		private float convertLength;
		// 预期最长长度(必须要给每个区块设置好预期长度)
		private float expectLength;

		public int getMaxsize() {
			return maxsize;
		}

		public void setMaxsize(int maxsize) {
			this.maxsize = maxsize;
		}

		public String getCha() {
			return cha;
		}

		public void setCha(String cha) {
			this.cha = cha;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public String getConvertStr() {
			return convertStr;
		}

		public void setConvertStr(String convertStr) {
			this.convertStr = convertStr;
		}

		public float getConvertLength() {
			return convertLength;
		}

		public void setConvertLength(float convertLength) {
			this.convertLength = convertLength;
		}

		public float getExpectLength() {
			return expectLength;
		}

		public void setExpectLength(float expectLength) {
			this.expectLength = expectLength;
		}

		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}
	}

	/**
	 * 得到字符串的长度
	 * 
	 * @param str
	 * @return
	 */
	public static float getLength(String str) {
		float charlenth = 0;
		char[] chars = str.toCharArray();
		for (char c : chars) {
			int len = getLength(c);
			if (len > 1) {
				charlenth += 1;
			} else {
				charlenth += 0.5;
			}
		}
		return charlenth;
	}

	/**
	 * 得到字符的长度
	 * 
	 * @param c
	 * @return
	 */
	public static int getLength(char c) {
		Pattern patt = Pattern.compile("^[\u4e00-\u9fa5]{1}$");
		Matcher matcher = patt.matcher(new String(new char[] { c }));
		if (matcher.find()) {
			return 2;
		}
		return 1;
	}

	/**
	 * 默认值
	 * 
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public static Object roundDouble(Double obj) {
		if (null == obj)
			return 0;
		return Math.round(obj);
	}

	/**
	 * 默认值
	 * 
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public static Object def(Object obj, Object defVal) {
		if (null == obj)
			return defVal;
		return obj;
	}

	/**
	 * 
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public static String star(Float val) {
		if (null == val)
			return "2_5";
		String res = "";
		if (val > 4.5d) {
			res = "5";
		} else if (val > 4d) {
			res = "4_5";
		} else if (val > 3.5d) {
			res = "4";
		} else if (val > 3d) {
			res = "3_5";
		} else if (val > 2.5d) {
			res = "3";
		} else if (val > 2d) {
			res = "2_5";
		} else if (val > 1.5d) {
			res = "2";
		} else if (val > 1d) {
			res = "1_5";
		} else if (val > 0.5d) {
			res = "1";
		} else if (val > 0d) {
			res = "0_5";
		} else {
			res = "0_5";
		}
		return res;
	}

	/**
	 * 构建Select
	 * 
	 * @param array
	 * @param text
	 * @param value
	 * @return
	 */
	public static List<Map<String, Object>> builderSelect(JSONArray array,
			String textField, String valueField) {
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		if (null == array) {
			return res;
		}
		int size = array.size();
		for (int i = 0; i < size; i++) {
			JSONObject jsonObj = array.getJSONObject(i);
			if (null == jsonObj) {
				continue;
			}
			Map<String, Object> option = new HashMap<String, Object>();
			option.put("text", jsonObj.get(textField));
			option.put("value", jsonObj.get(valueField));
			res.add(option);
		}

		return res;
	}

	/**
	 * 封装快框的formatDatagirdData方法
	 * 
	 * @param array
	 * @param page
	 * @return
	 */
	public static HashMap<String, Object> formatDatagirdData(Object array,
			Page page) {
		HashMap<String, Object> cacheData = new HashMap<String, Object>();
		cacheData.put("data", array);
		HashMap<String, Object> info = new HashMap<String, Object>();
		if (null != page) {
			info.put("total", page.getCount());// 总条数
			info.put("page", page.getCurrent());// 当前页面
			info.put("records", page.getTotal());// 总页数
			info.put("rows", page.getLength());// 每页显示多少条
		} else {
			info.put("total", 0);// 总条数
			info.put("page", 0);// 当前页面
			info.put("records", 0);// 总页数
			info.put("rows", 0);// 每页显示多少条
		}
		cacheData.put("info", info);
		return cacheData;
	}

	/**
	 * 添加前缀，map
	 * 
	 * @Title: addPrefix
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param map
	 * @param prefix
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map addPrefix(Map map, String prefix) {
		Map res = new HashMap();
		if (null == map)
			return res;
		Set<String> keys = map.keySet();
		for (String key : keys) {
			Object val = map.get(key);
			res.put(prefix + key, val);
			// map.remove(key);
		}
		return res;
	}

	public static List<String> splitToListString(String fieldIdStr) {
		return splitToListString(fieldIdStr, ",");
	}

	/**
	 * 
	 * @param fieldIdStr
	 * @param character
	 * @return
	 */
	public static List<String> splitToListString(String fieldIdStr,
			String character) {
		String[] chars = fieldIdStr.split(character);
		List<String> listChars = new ArrayList<String>();
		for (String cha : chars) {
			listChars.add(cha);
		}
		return listChars;
	}

	public static String splitListToString(List<String> strs) {
		return splitListToString(strs, ",");
	}

	/**
	 * 
	 * @param fieldIdStr
	 * @param character
	 * @return
	 */
	public static String splitListToString(List<String> strs, String character) {
		StringBuilder sbui = new StringBuilder();
		int size = strs.size();
		int index = 0;
		for (String str : strs) {
			sbui.append(str);
			if ((++index) < size) {
				sbui.append(",");
			}
		}
		return sbui.toString();
	}

	public static boolean isMorethanNhours(Date startDate, Date endDate,
			double nhours) {
		// 计算时间差long
		long diff = endDate.getTime() - startDate.getTime();
		double hours = diff / (double) (1000 * 60 * 60);
		// System.out.println(hours);
		return hours > nhours;
	}

	/**
	 * 得到出差天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static double getTravelDays(Date startDate, Date endDate, double days)
			throws ParseException {
		// 出发时间(上午或下午)
		int startAmOrPm = JUtil.getAmOrPm(startDate);
		// 到达时间(上午或下午)
		int endAmOrPm = JUtil.getAmOrPm(endDate);

		// 当天出发当天到
		if (days == 0) {
			double[][] dayflag = new double[2][2];
			dayflag[JUtil.AM][JUtil.PM] = 1;
			dayflag[JUtil.AM][JUtil.AM] = 0.5;
			dayflag[JUtil.PM][JUtil.PM] = 0.5;
			days += dayflag[startAmOrPm][endAmOrPm];
		} else {// 当天出发隔n天到
			double[][] dayflag = new double[2][2];
			dayflag[JUtil.AM][JUtil.PM] = 2;
			dayflag[JUtil.AM][JUtil.AM] = 1.5;
			dayflag[JUtil.PM][JUtil.AM] = 1;
			dayflag[JUtil.PM][JUtil.PM] = 1.5;
			days += dayflag[startAmOrPm][endAmOrPm];
			days -= 1;
		}
		return days;
	}

	/**
	 * 得到天数差
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static double getDaysDifference(Date startDate, Date endDate)
			throws ParseException {
		// 时间只取到天
		startDate = getDate(startDate);
		endDate = getDate(endDate);
		// 计算时间差long
		long diff = endDate.getTime() - startDate.getTime();
		// long转换为天数
		// double days = diff / (1000 * 60 * 60 * 24);
		long res = diff / 86400000;
		return new Long(res).doubleValue();
	}

	public static boolean isNull(String filed) {
		return null == filed || "undefined".equals(filed.trim())
				|| "".equals(filed);
	}

	public static void checkNull(String filed, String msg) {
		if (isNull(filed))
			throw new RuntimeException(msg);
	}

	public static void checkNull(String filed, RuntimeException e) {
		if (isNull(filed))
			throw e;
	}

	public static void checkNULL(Object filed, String msg) {
		if (null == filed)
			throw new RuntimeException(msg);
	}

	public static void checkNULL(Object filed, RuntimeException e) {
		if (null == filed)
			throw e;
	}

	public static void checkNull2(String filed, String msg) {
		checkNULL(filed, new RuntimeMessageException(msg));
	}

	public static void checkNULL2(Object filed, String msg) {
		checkNULL(filed, new RuntimeMessageException(msg));
	}

	public static void checkNullArray(List array, String msg) {
		checkNULL(array, msg);
		if (array.isEmpty())
			throw new RuntimeException(msg);
	}

	public static boolean isNULL(Object filed) {
		return null == filed || "undefined".equals(filed.toString().trim())
				|| "".equals(filed.toString().trim());
	}

	/**
	 * @Title: getDate
	 * @Description: TODO
	 * @return
	 * @throws ParseException
	 */
	public static String getCurrentYearMonth() throws ParseException {
		return getCurrentDate("yyyy-MM");
	}

	/**
	 * @Title: getDate
	 * @Description: TODO
	 * @return
	 * @throws ParseException
	 */
	public static String getCurrentDate() throws ParseException {
		return getCurrentDate("yyyy-MM-dd");
	}

	/**
	 * @Title: getDate
	 * @Description: TODO
	 * @return
	 * @throws ParseException
	 */
	public static String getCurrentDateHHmmss() throws ParseException {
		return getCurrentDate("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentDate(String format) throws ParseException {
		return getDateStr(new Date(), format);
	}

	public static String getDateStr(Date date, String format)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date getDate(String date, String format)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}

	public static Date getDate(Date date) throws ParseException {
		return getDate(date, "yyyy-MM-dd");
	}

	public static Date getDate(Date date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(sdf.format(date));
	}

	public static final int AM = 0;// 上午
	public static final int PM = 1;// 下午
	public static final double SEMI_DAY = 0.5;// 半天
	public static final double ALL_DAY = 1;// 全天

	/**
	 * 得到上午或者下午
	 * 
	 * @param date
	 * @return AM/PM
	 * @throws ParseException
	 */
	public static int getAmOrPm(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 电子报账系统特殊需求
		return calendar.get(Calendar.HOUR_OF_DAY) > 11 ? PM : AM;
	}

	/**
	 * 是上午吗
	 * 
	 * @param date
	 * @return yes/no
	 * @throws ParseException
	 */
	public static boolean isAM(Date date) throws ParseException {
		return AM == getAmOrPm(date) ? true : false;
	}

	/**
	 * 是下午吗
	 * 
	 * @param date
	 * @return yes/no
	 * @throws ParseException
	 */
	public static boolean isPM(Date date) throws ParseException {
		return PM == getAmOrPm(date) ? true : false;
	}

	public static final boolean NO_WEEKEND = false;
	public static final boolean WEEKEND = true;

	/**
	 * 是否为周末
	 * 
	 * @param date
	 * @return AM/PM
	 * @throws ParseException
	 */
	public static boolean isWeekend(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// System.out.println(calendar.getTime());
		// calendar.add(Calendar.DAY_OF_WEEK, -2);
		// System.out.println(calendar.getTime());
		// 电子报账系统特殊需求
		// return calendar.get(Calendar.DAY_OF_WEEK) > 11 ? NO_WEEKEND :
		// WEEKEND;
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek == 1 || dayOfWeek == 7 ? WEEKEND : NO_WEEKEND;
	}

	/**
	 * 得到时间断的周末时间
	 * 
	 * @param date
	 * @return number
	 * @throws ParseException
	 */
	public static int getWeekendNum(Date startDate, Date endDate)
			throws ParseException {
		// 时间只取到天
		startDate = getDate(startDate);
		endDate = getDate(endDate);
		// 周木和
		int num = 0;
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		// System.out.println(start.getTime());
		do {
			if (isWeekend(start.getTime())) {
				// System.out.println("周末:" + start.getTime());
				num++;
			}
			start.add(Calendar.DAY_OF_YEAR, 1);
		} while (start.before(end) || start.equals(end));
		return num;
	}

	public static double getFinalWeekendNum(Date startDate, Date endDate,
			double days) throws ParseException {
		double finalNum = getWeekendNum(startDate, endDate);
		// 如果开始时间是周末 并且 下午出发 扣半天
		if (isWeekend(startDate) && isPM(startDate)) {
			finalNum -= 0.5;
		}

		// 如果开始时间是周末 并且 上午出发 并且 出差时间为半天 扣半天
		if (isWeekend(startDate) && isAM(startDate) && SEMI_DAY == days) {
			finalNum -= 0.5;
		}

		// 如果结束时间是周末 并且 上午回 并且跨天 扣半天
		if (isWeekend(endDate) && isAM(endDate)
				&& getDaysDifference(startDate, endDate) >= 1) {
			finalNum -= 0.5;
		}
		return finalNum;
	}

	/**
	 * @Title: defaultVal
	 * @Description: TODO
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static <T> T defaultVal(T o1, T o2) {
		// TODO Auto-generated method stub
		return null == o1 ? o2 : o1;
	}

	/**
	 * 增删改 结果验证
	 * 
	 * @param flag
	 * @param msg
	 */
	public static void validCUD(int flag, String msg) {
		if (flag < 1) {
			throw new RuntimeException("数据库操作(" + msg + ")失败!");
		}
	}

	/**
	 * 首单词大写
	 * 
	 * @param str
	 * @return
	 */
	public static String upperFirstWord(String str) {
		// if(null == str || str.trim().length() < 1) return str;
		StringBuilder strb = new StringBuilder(str);
		strb.replace(0, 1, strb.substring(0, 1).toUpperCase());
		return strb.toString();
	}

	/**
	 * 首单词小写
	 * 
	 * @param str
	 * @return
	 */
	public static String lowerFirstWord(String str) {
		// if(null == str || str.trim().length() < 1) return str;
		StringBuilder strb = new StringBuilder(str);
		strb.replace(0, 1, strb.substring(0, 1).toLowerCase());
		return strb.toString();
	}

	// public static void main(String[] args) {
	/*
	 * try { Calendar s = Calendar.getInstance(); s.set(2012, 5, 17, 8,0,0);
	 * Calendar e = Calendar.getInstance(); e.set(2012, 5, 17, 12,0,0);
	 * //System.out.println(getWeekendNum(s.getTime(), e.getTime()));
	 * //System.out.println(getFinalWeekendNum(s.getTime(), e.getTime(),1.5));
	 * System.out.println(isMorethanNhours(s.getTime(), e.getTime(),4));
	 * System.out.println(getDaysDifference(s.getTime(), e.getTime()));
	 * //System.out.println(getDate(getCurrentDate(), "yyyy-MM-dd")); } catch
	 * (ParseException e) { e.printStackTrace(); }
	 */
	// long res = 28;
	// System.out.println((int) res);
	// System.out.println(UUNUM(12));
	// }

	public static String getSuffix(String fileName, String c) {
		if (null != fileName) {
			int lastindex = fileName.lastIndexOf(c);
			if (lastindex > -1) {
				return fileName.substring(fileName.lastIndexOf(c) + 1,
						fileName.length());
			}
		}
		return fileName;
	}

	public static <T> T valiObject(T t, String msg) {
		if (null == t) {
			throw new RuntimeException(msg);
		}
		return t;
	}

	public static String getBeanProxyInNewVal(FieldInAbstract fia, String val)
			throws Exception {
		List<String> oldVals = JUtil.splitToListString(val);
		List<String> ids = fia.getValues(oldVals);
		return JUtil.splitListToString(ids);
	}

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String uuid12() {
		return uuid().substring(0, 12);
	}

	public static String getWebRoot() {
		return ServletActionContext.getServletContext().getRealPath("/");
	}

	public static JSONObject getUser() {
		Object user = getSession().getAttribute("user");
		if (user instanceof JSONObject)
			return (JSONObject) user;
		return null;
	}

	public static JSONObject getAdminUser() {
		return (JSONObject) getSession().getAttribute(
				CommonConstants.ADMIN_USER);
	}

	public static void setSessionObj(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeSessionObj(String key) {
		getSession().setAttribute(key, null);
	}

	public static Object getSessionObj(String key) {
		// TODO Auto-generated method stub
		return getSession().getAttribute(key);
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public static String getDateSeq() {
		String dateSeq = "";
		try {
			dateSeq = getCurrentDate().replace("-", "");
		} catch (ParseException e) {
			dateSeq = "";
		}
		return dateSeq;
	}

	public static String getIp() {
		HttpServletRequest request = getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		if (null != ip && ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	public static String getAreaId() {
		Object city = getSessionObj("city");
		if (!(city instanceof String)) {
			throw new CityNotFoundException();
		}
		return (String) city;
	}

	public static void setHisurl() {
		setSessionObj(CommonConstants.HISTORY_URL, JUtil.getRequest()
				.getServletPath().substring(1)
				+ "?" + JUtil.getRequest().getQueryString());
	}

	public static String UUNUM(int num) {
		StringBuilder strb = new StringBuilder();
		Random random = new Random();
		for (int j = 0; j < num; j++) {
			strb.append(Integer.toString(random.nextInt(10)));
		}
		return strb.toString();
	}

	public static boolean thanTime(Date endAddDatetime, Date date) {
		// TODO Auto-generated method stub
		if (null == endAddDatetime)
			return false;
		if (null == date)
			return false;
		return endAddDatetime.getTime() > date.getTime();
	}

	public static String getRootPath() {
		return "images/default/upload/prdimgs/" + JUtil.getDateSeq() + "/";
	}

	public static String getRootAudioPath(String id) {
		return "upload/audio/" + id + "/" + JUtil.getDateSeq() + "/";
	}

	public static String getAdvPath() {
		return "images/default/upload/adv/";
	}

	public static String getContextPath() {
		return getRequest().getContextPath();
	}

	public static String replaceNoECN(String s) {
		if (null == s)
			return null;
		return s.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5]", "");
	}

	public static class CityNotFoundException extends RuntimeException {

		public CityNotFoundException() {
			super();
		}

		public CityNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}

		public CityNotFoundException(String message) {
			super(message);
		}

		public CityNotFoundException(Throwable cause) {
			super(cause);
		}

	}

	public static String getCurrentYear() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}

	public static String getPinYin(String src) {
		char[] t1 = null;
		t1 = src.toCharArray();
		// System.out.println(t1.length);
		String[] t2 = new String[t1.length];
		// System.out.println(t2.length);
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				// System.out.println(t1[i]);
				if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中
					t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
				} else {
					// 如果不是汉字字符，直接取出字符并连接到字符串t4后
					t4 += Character.toString(t1[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t4;
	}

	public static String getPinyinFirst(String cnchar) {
		String pinyin = getPinYin(cnchar);
		return pinyin.substring(0, 1);
	}

	public static Integer getLevel(Integer exp) {
		if (exp > 10000) {
			return 7;
		} else if (exp > 5000) {
			return 6;
		} else if (exp > 2500) {
			return 5;
		} else if (exp > 1250) {
			return 4;
		} else if (exp > 625) {
			return 3;
		} else if (exp > 300) {
			return 2;
		} else if (exp > 75) {
			return 2;
		} else if (exp > 0) {
			return 1;
		}
		return 0;
	}

	public static void checkJSONObjectKey(JSONObject orderJSONObj, String key,
			String message) {
		if (!orderJSONObj.has(key)) {
			throw new RuntimeMessageException(message);
		}
	}

	public static void checkMapKey(Map<String, String> beanProxy, String key,
			String msg) {
		checkNULL2(beanProxy, msg);
		if (!beanProxy.containsKey(key)) {
			throw new RuntimeMessageException(msg);
		}
	}

	public static String genOrderId() {
		StringBuffer strBuff = new StringBuffer("86");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		strBuff.append(sdf.format(new Date()));
		strBuff.append(100000 + new Random().nextInt(888888));
		return strBuff.toString();
	}

	/**
	 * 解析各种时间格式
	 * 
	 * @param orderDatetimeStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String orderDatetimeStr) throws ParseException {
		return DateUtils.parseDate(orderDatetimeStr, new String[] { "yyyy-MM",
				"yyyyMM", "yyyy/MM", "yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd",
				"yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss",
				"yyyy-MM-dd HH:mm", "yyyy-MM-dd HH" });
	}
	
	/**
	 * 分类节点
	 */
	private static UrFaqTypeExtTreeNode castTo (UrFaqTypeExt e,String reqeusttype){
		UrFaqTypeExtTreeNode tree = new UrFaqTypeExtTreeNode();
		// String parentIcon = "";
		// String childIcon="";
		//if(reqeusttype!=null&&"1".compareTo(reqeusttype)==0){//1表示前台来的请求 0表示后台来的请求
			//前台
		 // parentIcon = "icon-tip";
		 // childIcon="icon-edit";
		//}
		//if(e.getParentId().compareTo("-1")==0){
			//tree.setIconCls(parentIcon);
		//}else{
			//tree.setIconCls(childIcon);
		//}
		tree.setId(e.getId());
		tree.setFaqTypeCode(e.getFaqTypeCode());
		tree.setFaqTypeName(e.getFaqTypeName());
		tree.setText(e.getText());
		tree.setParentId(e.getParentId());
		return tree;
	}
	
	public static JSONArray getNodeSelectTree(List<UrFaqTypeExt> list,String reqeusttype){
		return JSONArray.fromObject(getNode(list,reqeusttype),CommonConstants.JSON_CFG);
	}
	
	private static List<UrFaqTypeExtTreeNode> getNode(List<UrFaqTypeExt> list,String reqeusttype){
		UrFaqTypeExtTreeNode tree = new UrFaqTypeExtTreeNode();
		List<UrFaqTypeExtTreeNode> list1 = new ArrayList<UrFaqTypeExtTreeNode>();
		for(UrFaqTypeExt e2:list){
			if(e2.getParentId().equals("-1")){//找到所有的根节点
				tree=castTo(e2,reqeusttype);
				tree=getChild(list,tree,reqeusttype);
				list1.add(tree);
			}
		}
		if(reqeusttype!=null&&"0".compareTo(reqeusttype)==0){//后台
			UrFaqTypeExtTreeNode root = new UrFaqTypeExtTreeNode();
			root.setIconCls("");
			root.setId("-1");
			root.setChildren(list1);
			root.setParentId("-2");
			root.setText("根目录");
			root.setFaqTypeCode("-1");
			root.setFaqTypeName("根目录");
			list1 =  new ArrayList<UrFaqTypeExtTreeNode>();
			list1.add(root);
		}
		
		return list1;
	}
	private static UrFaqTypeExtTreeNode getChild(List<UrFaqTypeExt> list,UrFaqTypeExtTreeNode tree,String reqeusttype){
		boolean isParent = false;
		for(UrFaqTypeExt e2:list){
			if(e2.getParentId().equals(tree.getId())){//找到子节点
				isParent=true;
				if(tree.getChildren()==null){
					tree.setChildren(new Vector<UrFaqTypeExtTreeNode>());
				}
				UrFaqTypeExtTreeNode node = castTo(e2,reqeusttype);
				node =getChild(list,node,reqeusttype); 
				tree.getChildren().add(node);
			}
		}
		if(reqeusttype!=null&&"1".compareTo(reqeusttype)==0){//前台
		if(isParent){
				tree.setIconCls("icon-tip");
			}else{
				tree.setIconCls("icon-edit");
			}
		}else{
			tree.setIconCls("");
		}
		return tree;
	}

}
