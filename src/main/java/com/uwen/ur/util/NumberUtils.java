package com.uwen.ur.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: haobl
 * Date: 12-12-12
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
public class NumberUtils {

    /**
     * 字符串转整型
     * @param strIn
     * @return
     */
    public static int strToInt(String strIn) {
        int ret = 0;
        if (strIn != null && !StringUtils.isEmpty(strIn)) {
            try {
                ret = Integer.parseInt(strIn);
            } catch (NumberFormatException nfe) {
                ret = 0;
            }
        }
        return ret;
    }

    /**
     * 字符串转整数
     * @param strIn
     * @param defaultValue
     * @return
     */
    public static int strToInt(String strIn,int defaultValue) {
        int ret = defaultValue;
        if (strIn != null && !StringUtils.isEmpty(strIn)) {
            try {
                ret = Integer.parseInt(strIn);
            } catch (NumberFormatException nfe) {
                ret = defaultValue;
            }
        }
        return ret;
    }
}
