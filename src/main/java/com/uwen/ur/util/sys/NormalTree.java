package com.uwen.ur.util.sys;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认选择器
 * 
 * @author Administrator
 * 
 */
public class NormalTree {

    Object id;// 主键
    Object text;// 显示文本
    Object attributes;// 属性
    Object iconCls;// 图标
    Object state;// 状态,默认关闭  - open  and  closed
    Object checked;// 是否被选中
    List<NormalTree> children;// 子节点
    
    public static final String STATE_OPEN = "open";
    public static final String STATE_CLOSE = "closed";
    
    public NormalTree(Object id, Object text, Object attributes, Object iconCls) {
        super();
        this.id = id;
        this.text = text;
        this.attributes = attributes;
        this.iconCls = iconCls;
    }

    public NormalTree(Object id, Object text) {
        super();
        this.id = id;
        this.text = text;
    }

    public NormalTree(Object id, Object text, Object attributes,
            Object iconCls, Object state, Object checked) {
        super();
        this.id = id;
        this.text = text;
        this.attributes = attributes;
        this.iconCls = iconCls;
        this.state = state;
        this.checked = checked;
    }

    public NormalTree(Object id, Object text, Object attributes,
            Object iconCls, Object state, Object checked, List<NormalTree> children) {
        super();
        this.id = id;
        this.text = text;
        this.attributes = attributes;
        this.iconCls = iconCls;
        this.state = state;
        this.checked = checked;
        this.children = children;
    }
    
//----------------------------------- statics
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public Object getIconCls() {
        return iconCls;
    }

    public void setIconCls(Object iconCls) {
        this.iconCls = iconCls;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getChecked() {
        return checked;
    }

    public void setChecked(Object checked) {
        this.checked = checked;
    }

    public List<NormalTree> getChildren() {
        return children;
    }

    public void setChildren(List<NormalTree> children) {
        this.children = children;
    }

}
