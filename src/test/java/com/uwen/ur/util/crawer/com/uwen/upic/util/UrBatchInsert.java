package com.uwen.ur.util.crawer.com.uwen.upic.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.uwen.ur.action.sys.ext.UrFaqTypeExtAction;


public class UrBatchInsert {
	
public static void main(String[] args) {
	//获取spring配置
	
	ApplicationContext act =   new   ClassPathXmlApplicationContext("applicationContext.xml");
	//System.out.println(act);
	UrFaqTypeExtAction a =(UrFaqTypeExtAction)act.getBean("urFaqTypeExtAction");
	System.out.println(a);
	
}


}
