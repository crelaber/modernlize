package com.uwen.ur.model.interfaze.sys;

import java.util.List;

public abstract class FieldInAbstract {
    protected String fieldName;
    protected String backFieldName;
    
    /**
     * 
     * @param oldVals 只适应于基础数据类型
     * @return
     * @throws Exception
     */
    public abstract List<String> getValues(List<String> oldVals) throws Exception;

    public abstract String getFieldName() throws Exception;

    public abstract String getBackFieldName() throws Exception;

}
