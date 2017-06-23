package shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import shop.adminuser.entity.Admin;
import shop.adminuser.service.AdminService;
import shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台登录方法
 * @author zhangning
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	private Admin admin = new Admin();

	public Admin getModel() {
		return admin;
	}
	
	//注入AdminService
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * 后台后进入登录页面方法
	 */
	public String index(){
		
		return "index";
	}
	

	//后台登录的方法
    public String login(){
    	
    	Admin existadmin = adminService.login(admin);
        if(existadmin == null){
        	//登录失败
        	this.addActionError("亲，你的用户名或者密码错误"); 
        	return "loginFail";
        }
        else{
        	//登录成功
        	ServletActionContext.getRequest().getSession().setAttribute("existadmin",existadmin);
        	return "loginSuccess";
        
        }
    
    	
    }
    

}
