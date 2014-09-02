package com.uwen.ur.action.busi;


public class BasicAction {
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String EXCEPTION = "exception";
	public static final String LOGIN = "login";
	public static final String SELF = "self";
	public static final String FORWARD = "forward";
	public static final String FULL_UPLOAD_SIZE = "fullUploadSize";
	protected String jspName;
	
	public String getJspName() {
		return jspName;
	}

	public void setJspName(String jspName) {
		this.jspName = jspName;
	}
}
