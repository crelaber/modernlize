package com.uwen.ur.util;

import java.math.BigDecimal;

/**
 * 
 * 文件名称: DoubleUtilities.java 内容摘要: double工具类
 * 
 * @author:
 * @version: 1.0
 * @Date: 2011-12-29 上午09:38:38
 * 
 *        修改历史: 修改日期 修改人员 版本 修改内容 ----------------------------------------------
 *        2011-12-29 1.0 1.0 XXXX
 * 
 *        版权: 版权所有(C)2011 公司: 华诚信息科技股份有限公司
 */

public final class DoubleUtilities {
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化
	private DoubleUtilities() {
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */

	public static double add(Double v1, Double v2) {
		v1 = v1 == null ? Double.valueOf("0") : v1;
		v2 = v2 == null ? Double.valueOf("0") : v2;
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */

	public static double sub(Double v1, Double v2) {
		v1 = v1 == null ? Double.valueOf("0") : v1;
		v2 = v2 == null ? Double.valueOf("0") : v2;
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */

	public static double mul(Double v1, Double v2) {
		v1 = v1 == null ? Double.valueOf("0") : v1;
		v2 = v2 == null ? Double.valueOf("0") : v2;
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */

	public static double div(Double v1, Double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */

	public static double div(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The   scale   must   be   a   positive   integer   or   zero");
		}
		v1 = v1 == null ? Double.valueOf("0") : v1;
		v2 = v2 == null ? Double.valueOf("0") : v2;
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */

	public static double round(Double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The   scale   must   be   a   positive   integer   or   zero");
		}
		v = v == null ? Double.valueOf("0") : v;
		BigDecimal b = new BigDecimal(v.toString());
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 比较大小
	 * 
	 * @param v1
	 * @param v2
	 * @return 结果-1 小于 0 等于 1 大于
	 */
	public static int compare(Double v1, Double v2) {
		v1 = v1 == null ? Double.valueOf("0") : v1;
		v2 = v2 == null ? Double.valueOf("0") : v2;
		BigDecimal data1 = new BigDecimal(v1);
		BigDecimal data2 = new BigDecimal(v2);
		return data1.compareTo(data2);
	}

}
