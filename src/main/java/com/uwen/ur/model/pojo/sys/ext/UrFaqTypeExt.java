package com.uwen.ur.model.pojo.sys.ext;


import com.uwen.ur.model.pojo.sys.UrFaqType;

public class UrFaqTypeExt  extends UrFaqType{
	
	

	@Override
	public String toString() {
		return "UrFaqTypeExt [text=" + text + ", getId()=" + getId()
				+ ", getParentId()=" + getParentId() + "]";
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
    
}