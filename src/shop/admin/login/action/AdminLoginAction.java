package shop.admin.login.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 后台首页显示
 * @author zhangning
 *
 */
public class AdminLoginAction extends ActionSupport {
	
	public String execute(){
		return "login";
	}

}
