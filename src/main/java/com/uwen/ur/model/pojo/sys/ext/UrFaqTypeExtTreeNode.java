package com.uwen.ur.model.pojo.sys.ext;

import java.util.List;
import java.util.Vector;

public class UrFaqTypeExtTreeNode extends UrFaqTypeExt{

	private List<UrFaqTypeExtTreeNode> children;
    
	private String iconCls;
	
	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public List<UrFaqTypeExtTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<UrFaqTypeExtTreeNode> children) {
		this.children = children;
	}

	
	
	
}
