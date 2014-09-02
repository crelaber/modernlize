package com.uwen.ur.util.sys;

import com.uwen.ur.util.MapperUtil;

public class Betweener {
    public Betweener(String val, Class<?> type) throws Exception {
        String[] valSplit = val.split(",");
        if(valSplit.length == 2){
        	this.first = MapperUtil.getNormalVal(valSplit[0], type);
        	this.second = MapperUtil.getNormalVal(valSplit[1], type);
        }
    }

    public Betweener(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    Object first;
    Object second;

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }
}
