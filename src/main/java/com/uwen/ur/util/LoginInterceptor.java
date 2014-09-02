package com.uwen.ur.util;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.uwen.ur.common.CommonConstants;
  
public class LoginInterceptor extends AbstractInterceptor {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 5917811118373513544L;

	  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Object user = JUtil.getSessionObj(CommonConstants.PROTOCOL_USER);  
  
        // 如果没有登陆，或者登陆所有的用户名不是yuewei，都返回重新登陆  
        if (user != null) {  
            return invocation.invoke();  
        }  
        ctx.put("tip", "你还没有登录");  
        return Action.LOGIN;  
  
    }  
  
}  