package com.uwen.ur.common.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.common.CommonConstants;
import com.uwen.ur.util.JUtil;

public class BusinessLoginIntercept extends MethodFilterInterceptor {

    private String enable;
    private String excludeMethods;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // log
    private final static Logger log = LoggerFactory .getLogger(BusinessLoginIntercept.class);

    
    public String intercept(ActionInvocation invocation) throws Exception {
        return doIntercept(invocation);
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    
    protected String doIntercept(ActionInvocation invocation) throws Exception {
    	HttpServletResponse response = JUtil.getResponse();
		response.setCharacterEncoding("utf-8");

		HttpServletRequest request = JUtil.getRequest();
		
		String servletPath = request.getServletPath();// /admin/log_list.action
		
		//如果不需要验证
		if(!JUtil.isNULL(excludeMethods)){
			String[] excludeActions = excludeMethods.split(",");
			for (String excludeAction : excludeActions) {
				if (servletPath.equals(excludeAction)){
					return invocation.invoke();
				}
			}
		}
		
		//如果不需要验证
		if (servletPath.contains("/client/userService/login")
				||servletPath.contains("/client/businessService/aroundBusiness")
				||servletPath.contains("/client/businessService/searchBusiness")
				||servletPath.contains("/client/businessService/home")
				||servletPath.contains("/client/businessService/newsList")
				||servletPath.contains("/client/businessService/login")) {
			return invocation.invoke();
		}
		
		//如果不需要验证
		if (!"true".equals(enable)) {
			return invocation.invoke();
		}
		
		// 如果不是根目录 或者 admin 目录访问的action 就返回异常

		return invocation.invoke();
    }
}
