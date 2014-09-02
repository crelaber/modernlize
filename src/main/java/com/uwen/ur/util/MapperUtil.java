package com.uwen.ur.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.uwen.ur.exception.RuntimeMessageException;
import com.uwen.ur.util.sys.Betweener;
import com.uwen.ur.util.sys.Methoder;

public class MapperUtil {

	/**
	 * 构建查询条件
	 * 
	 * @param criteria
	 * @param record
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public static void builderCriteria(Object criteria, Object record)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		// 如果任一为空就返回
		if (null == criteria || null == record) {
			return;
		}
		// 顶层类
		Class<?> recordClazz = record.getClass(); //getSuperClass(record.getClass());
		builderCriteria2(criteria,record,recordClazz);
	}
	
	/**
	 * 构建查询条件
	 * 
	 * @param criteria
	 * @param record
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public static void builderCriteria2(Object criteria, Object record, Class<?> recordClazz)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		// 如果任一为空就返回
		if (null == criteria || null == record) {
			return;
		}
		
		//不关注Object类型
		if (recordClazz == Object.class) {
			return ;
		}
		
		// Criteria 类型
		Class<?> criteriaClazz = criteria.getClass();
		// 顶层类
		//Class<?> recordClazz = record.getClass(); //getSuperClass(record.getClass());
		// map键集合
		Field[] fields = recordClazz.getDeclaredFields();
		// 解析普通属性
		for (Field field : fields) {
			// 设置可操作
			field.setAccessible(true);
			//
			String fieldName = field.getName();
			//
			Object val = invokeGet(record, fieldName);
			// 值不为空
			if (null != val) {
				//
				Class<?> type = field.getType();
				Method m = getUnkownMethod(criteriaClazz, "and" + JUtil.upperFirstWord(fieldName) + "EqualTo", type);
				m.invoke(criteria, val);
			}
		}
		builderCriteria2(criteria, record,recordClazz.getSuperclass());
	}
	
	public static Method getUnkownMethod(Class<?> criteriaClazz,String methodName,Class<?> type) {
		if (criteriaClazz == Object.class) {
			return null;
		}
		
		try {
			return criteriaClazz.getDeclaredMethod(methodName,type);
		} catch (NoSuchMethodException e) {
			return getUnkownMethod(criteriaClazz.getSuperclass(), methodName,type);
		} catch (SecurityException e) {
			return getUnkownMethod(criteriaClazz.getSuperclass(), methodName,type);
		}
	}
	
	public static Method getUnkownMethod(Class<?> criteriaClazz,String methodName,Class[] classs) {
		if (criteriaClazz == Object.class) {
			return null;
		}
		
		try {
			return criteriaClazz.getDeclaredMethod(methodName,classs);
		} catch (NoSuchMethodException e) {
			return getUnkownMethod(criteriaClazz.getSuperclass(), methodName,classs);
		} catch (SecurityException e) {
			return getUnkownMethod(criteriaClazz.getSuperclass(), methodName,classs);
		}
	}

	/**
	 * 构建查询条件 URL http://localhost:8080/cplx/tpmAudit_list.action?beanProxy[
	 * 'auditTime_Between']=2012-12-25%2017:18:00,2012-12-25%2017:25:00&page=1&rows=
	 * 1 0
	 * 
	 * @param criteria
	 * @param record
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public static void builderCriteria(Object criteria, Class<?> clazz,
			Map<String, String> proxy) throws Exception {
		// 如果任一为空就返回
		if (null == criteria || null == proxy) {
			return;
		}
		// Criteria 类型
		Class<?> criteriaClazz = criteria.getClass();
		// 顶层类
		Class<?> recordClazz = clazz;// getSuperClass(clazz);
		// map键集合
		Set<String> keys = proxy.keySet();
		// 解析普通属性
		for (String key : keys) {
			// 按下划线分割
			String[] keySplits = key.split("_");
			// 名称
			String fieldName = keySplits[0];
			//
			Field field = getDeclaredField(recordClazz, fieldName);
			// 设置可操作
			field.setAccessible(true);
			//
			String val = proxy.get(key);
			// 值不为空
			if (null != val) {
				// 得到方法名称
				Methoder methoder = getCriteriaMethoder(keySplits, field, val,
						criteriaClazz);
				//
				Class<?> type = methoder.getType();
				if (JUtil.isNull(val) && type != String.class) {
					continue;
				}
				if (methoder.getDoType().endsWith("Between")) {
					Betweener bwt = (Betweener) methoder.getVal();
//					Method m = criteriaClazz.getDeclaredMethod(
//							methoder.getName(), type, type);
					Method m =getUnkownMethod(criteriaClazz, methoder.getName(), new Class[]{type,type}); 
					if (null != bwt.getFirst() && null != bwt.getSecond()) {
						m.invoke(criteria, bwt.getFirst(), bwt.getSecond());
					}
				} else if (methoder.getDoType().startsWith("Is")) {
//					Method m = criteriaClazz.getDeclaredMethod(methoder
//							.getName());
					Method m =getUnkownMethod(criteriaClazz, methoder.getName(), new Class[]{}); 
					m.invoke(criteria);
				} else {
//					Method m = criteriaClazz.getDeclaredMethod(
//							methoder.getName(), type);
					Method m =getUnkownMethod(criteriaClazz, methoder.getName(), new Class[]{type}); 
					Object invokeVal = methoder.getVal();
					m.invoke(criteria, invokeVal);
				}
			}
		}
	}

	private static Field getDeclaredField(Class<?> recordClazz, String fieldName) {
		try {
			return recordClazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			// e.printStackTrace();
			return getDeclaredField(recordClazz.getSuperclass(), fieldName);
		} catch (SecurityException e) {
			// e.printStackTrace();
			return getDeclaredField(recordClazz.getSuperclass(), fieldName);
		}
	}

	public static Methoder getCriteriaMethoder(String[] keySplits, Field field,
			String val, Class<?> criteriaClazz) throws Exception {
		if (null == keySplits || 0 == keySplits.length) {
			throw new RuntimeException("proxy 方法名定义有误!");
		}
		//
		Class<?> resType = field.getType();
		// 名称
		String fieldName = keySplits[0];
		// 单词首字母大写
		String ufwFieldName = JUtil.upperFirstWord(fieldName);
		//
		if (1 == keySplits.length) {
			Object invokeVal = getNormalVal(val, resType);
			return new Methoder("and" + ufwFieldName + "EqualTo", resType,
					invokeVal, "EqualTo");
		}
		// 查询条件类型
		String doType = keySplits[1];
		//
		Object invokeVal = null;
		// 如果是in
		if (doType.endsWith("In")) {
			resType = List.class;
			invokeVal = JUtil.splitToListString(val);
		} else if (doType.endsWith("Like")) {// 如果是like
			if (-1 == val.indexOf("%") && -1 == val.indexOf("_")
					&& -1 == val.indexOf("[") && -1 == val.indexOf("]")) {
				invokeVal = "%" + val.replaceAll("\\s", "%") + "%";
			} else {
				invokeVal = val;
			}
		} else if (doType.endsWith("Between")) {// 如果是like
			invokeVal = new Betweener(val, resType);
		} else {
			invokeVal = getNormalVal(val, resType);
		}

		return new Methoder("and" + ufwFieldName + doType, resType, invokeVal,
				doType);
	}

	public static Object getNormalVal(String val, Class<?> resType)
			throws Exception {
		if (resType == java.util.Date.class) {
			java.util.Date dateVal = null;
			try {
				dateVal = JUtil.parseDate(val);
			} catch (Exception e) {
				return null;
			}
			return dateVal;
		}
		return resType.getConstructor(String.class).newInstance(val);
	}
	
	@Deprecated
	public static Class<?> getSuperClass(Class<? extends Object> clazz) {
		Class<?> superClazz = clazz.getSuperclass();
		if (superClazz == Object.class) {
			return clazz;
		}
		return getSuperClass(superClazz);
	}

	/**
	 * 
	 * @param obj
	 * @param field
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object invokeGet(Object obj, Field field)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		return invokeGet(obj, field.getName());
	}

	/**
	 * 
	 * @param obj
	 * @param field
	 *            属性名称,不需要get
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Object invokeGet(Object obj, String field)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// 如果传入的属性为空,则返回空
		if (field == null) {
			return null;
		}
		//
		Method m = obj.getClass()
				.getMethod("get" + JUtil.upperFirstWord(field));
		//
		return m.invoke(obj);
	}

	/**
	 * 给对象设置值
	 * 
	 * @param obj
	 * @param fieldName
	 * @param val
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws NoSuchMethodException
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void invokeSet(Object obj, String fieldName, Object val)
			throws SecurityException, NoSuchFieldException,
			NoSuchMethodException, NumberFormatException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// 验证
		if (null == val || val.toString().trim().length() < 1)
			return;

		Class<?> clazz = obj.getClass();
		// 属性
		Field field = clazz.getDeclaredField(fieldName);
		//
		field.setAccessible(true);
		//
		Class<?> type = field.getType();
		//
		Method m = getMethod(clazz, fieldName, type);
		//
		m.invoke(obj, val);
	}

	/**
	 * 得到方法
	 * 
	 * @param clazz
	 * @param fieldName
	 * @param type
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	private static Method getMethod(Class<?> clazz, String fieldName,
			Class<?> type) throws SecurityException, NoSuchMethodException {
		return clazz.getDeclaredMethod("set" + JUtil.upperFirstWord(fieldName),
				type);
	}

	/**
	 * 属性类型
	 * 
	 * @param fieldName
	 * @param clazz
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public static Class<?> getFieldType(String fieldName, Class<?> clazz)
			throws SecurityException, NoSuchFieldException {
		// 属性
		Field field = clazz.getDeclaredField(fieldName);
		//
		field.setAccessible(true);
		//
		Class<?> type = field.getType();
		//
		return type;
	}

	public static List<String> getFiledVals(List<?> records, String fieldName)
			throws Exception {
		List<String> filedVals = new ArrayList<String>();
		for (Object object : records) {
			Object val = invokeGet(object, fieldName);
			if (null != val) {
				filedVals.add(val.toString());
			}
		}
		return filedVals;
	}

	public static List<String> getFiledVals(Object record, String fieldName)
			throws Exception {
		List<String> filedVals = new ArrayList<String>();
		Object val = invokeGet(record, fieldName);
		if (null != val) {
			filedVals.add(val.toString());
		}
		return filedVals;
	}
	
	public static final String KEY_ADD_DATETIME = "addDatetime";
	public static final String KEY_UPDATE_DATETIME = "updateDatetime";
	public static final String KEY_ORDER_DATETIME = "orderDatetime";
	public static final String GREATER_THAN_OR_EQUAL_TO = "_GreaterThanOrEqualTo";
	public static final String LESS_THAN_OR_EQUAL_TO = "_LessThanOrEqualTo";
	
	public static void builderBeanProxyQueryAddDatetime(
			Map<String, String> beanProxy) {
		builderBeanProxyQueryDatetime(beanProxy, KEY_ADD_DATETIME);
	}
	
	public static void builderBeanProxyQueryUpdateDatetime(
			Map<String, String> beanProxy) {
		builderBeanProxyQueryDatetime(beanProxy, KEY_UPDATE_DATETIME);
	}
	
	public static void builderBeanProxyQueryOrderDatetime(
			Map<String, String> beanProxy) {
		builderBeanProxyQueryDatetime(beanProxy, KEY_ORDER_DATETIME);
	}
	
	public static void builderBeanProxyQueryDatetime(
			Map<String, String> beanProxy,String key) {
		if (null == beanProxy) {
			return;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 如果不设置开始与结束时间
			if (!beanProxy.containsKey(key + GREATER_THAN_OR_EQUAL_TO)
					&& !beanProxy
							.containsKey(key + LESS_THAN_OR_EQUAL_TO)) {
				Date currentDate = new Date();
				// 当前减去一个月 至 当前
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(currentDate);
				gc.add(5, -30);

				beanProxy.put(key + LESS_THAN_OR_EQUAL_TO,
						sdf.format(currentDate));
				beanProxy.put(key + GREATER_THAN_OR_EQUAL_TO,
						sdf.format(gc.getTime()));

			} else if (!beanProxy
					.containsKey(key + LESS_THAN_OR_EQUAL_TO)) {
				String orderDatetimeStr = beanProxy
						.get(key + GREATER_THAN_OR_EQUAL_TO);
				Date newDate = JUtil.parseDate(orderDatetimeStr);

				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(newDate);
				gc.add(5, +30);

				beanProxy.put(key + LESS_THAN_OR_EQUAL_TO,sdf.format(gc.getTime()));

			} else if (!beanProxy
					.containsKey(key + GREATER_THAN_OR_EQUAL_TO)) {
				String orderDatetimeStr = beanProxy
						.get(key + LESS_THAN_OR_EQUAL_TO);
				Date newDate = JUtil.parseDate(orderDatetimeStr);
				
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(newDate);
				gc.add(5, -30);
				beanProxy.put(key + GREATER_THAN_OR_EQUAL_TO,
						sdf.format(gc.getTime()));
			}

		} catch (ParseException e) {
			throw new RuntimeMessageException("提交的日期格式不正确");
		}
	}
}
