package com.uwen.ur.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uwen.ur.common.CommonConstants;

public class MD5Util {
	public static void main(String[] args) {
		System.out.println(getMD5str("wang"));
	}
	private static final Logger logger = LoggerFactory.getLogger(CommonConstants.class);
	/**
	 * MD5加密字符串
	 * 
	 * @param 要加密的字符串
	 *            type:String
	 * @return 加密后的字符串,返回为空为加密失败！ type:String
	 */
	public static String getMD5str(String str) {
		try {
			MessageDigest cmd = MessageDigest.getInstance("MD5");
			cmd.update(str.getBytes());
			byte b[] = cmd.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];

				if (i < 0) {
					i += 256;
				}

				if (i < 16) {
					buf.append("0");
				}

				buf.append(Integer.toHexString(i));
			}

			return buf.toString().toUpperCase();
		} catch (Exception ex) {
			logger.info(ex.getMessage());
			return "";
		}
	}

}
