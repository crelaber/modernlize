package com.uwen.ur.util.sys;

public class Methoder {
    public Methoder(String name, Class<?> type, Object val, String doType) {
        this.name = name;
        this.type = type;
        this.val = val;
        this.doType = doType;
    }

    public Methoder(String name, Class<?> type, Object val) {
        this.name = name;
        this.type = type;
        this.val = val;
    }

    public Methoder(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    private String name;
    private Class<?> type;
    private Object val;
    private String doType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public String getDoType() {
        return doType;
    }

    public void setDoType(String doType) {
        this.doType = doType;
    }
}
