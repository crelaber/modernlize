package com.uwen.ur.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SbeanApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private final static Logger log = LoggerFactory.getLogger(SbeanApplicationContext.class);

    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        synchronized (SbeanApplicationContext.class) {
            log.info("锁定SbeanApplicationContext.class,设置ApplicationContext中");
            SbeanApplicationContext.applicationContext = applicationContext;
            SbeanApplicationContext.class.notifyAll();
            log.info("释放SbeanApplicationContext.class");
        }
    }

    public static ApplicationContext getApplicationContext() {
        synchronized (SbeanApplicationContext.class) {
            while (applicationContext == null) {
                try {
                    log.info("getApplicationContext, wait...");
                    SbeanApplicationContext.class.wait(60000);
                    if (applicationContext == null) {
                        log.warn("Have been waiting for ApplicationContext to be set for 1 minute", new Exception());
                    }
                } catch (InterruptedException ex) {
                    log.info("getApplicationContext, wait interrupted");
                }
            }
            return applicationContext;
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
    
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }
    
}
