package shop.interceptor;

import org.apache.struts2.ServletActionContext;

import shop.adminuser.entity.Admin;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 后台权限校验拦截器
 * @author zhangning
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//执行拦截的方法
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//判断Session中是否保存了后台用户的信息
		Admin adminUser = (Admin) ServletActionContext.getRequest()
				.getSession().getAttribute("existadmin");
		if(adminUser == null){
			//没有登录进行访问
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("亲！您还没有登录！没有权限访问");
			return "loginFail";
		}else{
			//已经登录过
			return actionInvocation.invoke();
		}
		
	
	}

}
