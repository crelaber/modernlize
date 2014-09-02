package com.uwen.ur.model.interfaze.sys;

public interface MapperCallBack {
    /**
     * 
     * @param obj
     */
    void doRecord(Object obj) throws Exception;
    
    /**
     * 
     * @param example
     */
    void doExample(Object example) throws Exception;
    
    /**
     * 
     * @param obj
     */
    void doCriteria(Object obj) throws Exception;
    
}
