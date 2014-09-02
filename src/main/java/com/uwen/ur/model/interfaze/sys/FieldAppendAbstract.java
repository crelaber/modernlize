package com.uwen.ur.model.interfaze.sys;

import java.util.List;

public abstract class FieldAppendAbstract {
    //
    protected String fieldName;
    //
    protected String fieldSuffix = "_append";
    //对应实体
    protected String mappingPojoName;
    //对应属性
    protected String mappingFieldName;
    //显示值字段
    protected String mappingFieldText;
    
    public abstract Object listValues(List<String> oldFieldVals) throws Exception;
    
    public abstract Object getValue(Object listVal,Object oldVal) throws Exception;
    
    public abstract String getFieldName();

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public abstract  String getFieldSuffix();

    public void setFieldSuffix(String fieldSuffix) {
        this.fieldSuffix = fieldSuffix;
    }

    public String getMappingPojoName() {
        return mappingPojoName;
    }

    public void setMappingPojoName(String mappingPojoName) {
        this.mappingPojoName = mappingPojoName;
    }

    public String getMappingFieldName() {
        return mappingFieldName;
    }

    public void setMappingFieldName(String mappingFieldName) {
        this.mappingFieldName = mappingFieldName;
    }

    public String getMappingFieldText() {
        return mappingFieldText;
    }

    public void setMappingFieldText(String mappingFieldText) {
        this.mappingFieldText = mappingFieldText;
    }
}
