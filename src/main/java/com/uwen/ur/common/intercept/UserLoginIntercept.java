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

public class UserLoginIntercept extends MethodFilterInterceptor {

    private String enable;
    private String excludeMethods;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // log
    private final static Logger log = LoggerFactory .getLogger(UserLoginIntercept.class);

    
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
    	
    	//HttpServletRequest request = ServletActionContext.getRequest();
    	/*
        String getScheme = request.getScheme();//http
        String serverName = request.getServerName();//localhost
        int port = request.getServerPort();//8080
    	String protocol = request.getProtocol();//HTTP1.0
        */
    	
        //String contextPath = request.getContextPath();// /gsoo
        //String servletPath = request.getServletPath();// /admin/log_list.action
        
        //JUtil.log(servletPath, "");
        
        /*if(servletPath.matches("^/admin/[a-zA-Z_0-9\\.]*$")){
        	try {
        		if(!"/admin/userExt_adminLogin".equals(servletPath) && !"/admin/userExt_valiAdminLogin".equals(servletPath)){
					JSONObject userJO = JUtil.getAdminUser();
					if(null == userJO) throw new RuntimeException();
					if(userJO.getInt("utype") != 1) throw new RuntimeException();
        		}
			} catch (Exception e) {
				HttpServletResponse response = JUtil.getResponse();
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(JSONObject.fromObject(new BasicJSON(198, "未登陆", null)).toString());
	            log.debug("用户未登陆!");
	            return null;
			}
        	//admin模块
        }else if(servletPath.matches("^/enterprise/[a-zA-Z_0-9\\.]*$")){
        	try {
        		if(!"/admin/userExt_adminLogin".equals(servletPath) && !"/admin/userExt_valiAdminLogin".equals(servletPath)){
					JSONObject userJO = JUtil.getAdminUser();
					if(null == userJO) throw new RuntimeException();
					if(userJO.getInt("utype") != 1) throw new RuntimeException();
        		}
			} catch (Exception e) {
				HttpServletResponse response = JUtil.getResponse();
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(JSONObject.fromObject(new BasicJSON(198, "未登陆", null)).toString());
	            log.debug("用户未登陆!");
	            return null;
			}
        	//企业级用户模块
        }else if(servletPath.matches("^/[a-zA-Z_0-9\\.]*$")){
        	//正常模块
        }else if(servletPath.matches("^/s$")){
        	//正常模块
        }else{
        	//异常模块
        	return "fail";
        }
        //如果不是根目录 或者 admin 目录访问的action 就返回异常
        
        ServletActionContext.getResponse().setCharacterEncoding("utf-8");
        if (!"true".equals(enable)) {
            return invocation.invoke();
        }

        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        
        if (null == session.getAttribute("user")) {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            Map<String,String> result = new HashMap<String, String>();
            result.put("state", "198");
            result.put("message", "用户未登陆!");
            result.put("path", request.getContextPath());
            response.getWriter().print(JSONObject.fromObject(result).toString());
            log.debug("用户未登陆!");
            return null;
        }*/
        //return invocation.invoke();
        
        HttpServletResponse response = JUtil.getResponse();
		response.setCharacterEncoding("utf-8");

		HttpServletRequest request = JUtil.getRequest();
		/*
		 * String getScheme = request.getScheme();//http String serverName =
		 * request.getServerName();//localhost int port =
		 * request.getServerPort();//8080 String protocol =
		 * request.getProtocol();//HTTP1.0
		 */
		String contextPath = request.getContextPath();// /gsoo
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
		if (servletPath.contains("/client/userService")||servletPath.contains("/client/businessService")) {
			return invocation.invoke();
		}
		
		if (servletPath.endsWith("adminExt_adminLogin")
				|| servletPath.endsWith("adminExt_valiAdminLogin")) {
			return invocation.invoke();
		}
		
		//如果不需要验证
		if (!"true".equals(enable)) {
			return invocation.invoke();
		}
	

		return invocation.invoke();
    }
}
