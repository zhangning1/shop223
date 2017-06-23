package shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import shop.user.entity.User;
import shop.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 用户模块
 * @author zhangning
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动所调用的对象
	private User user = new User();
	//注入service
	private UserService userService;
	
	 
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 跳转到注册页面的方法
	 * @return
	 */
	public String registPage(){
		
		return "registPage";
	}
	/**
	 * 跳转到登录页面的方法
	 * @return
	 */
	public String loginPage(){
			
			return "loginPage";
		}

	/**
	 * AJAX进行异步校验
	 * @throws IOException 
	 */


	public String findByName() throws IOException{
		//调用Service
		User existUser = userService.findByUserName(user.getUsername());
		//获取response对象，用于页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置字符集
		response.setContentType("text/html;charset=UTF-8");
		if(existUser != null  ){
			//查询到该用户，用户已存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		}else{
			
			//没查到该用户，用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}return null;
	}

	/**
	 * 用户注册方法
	 * @throws Exception 
	 */
	public String regist() throws Exception{
		userService.save(user);
		return "index";
	}

	// 用户激活账号方法
	public String active() {
		User existUser = userService.findByCode(user.getCode());
		System.out.println("existUser:" + existUser);
		System.out.println("user.getUcode():" + user.getCode());
		if (existUser == null) {
			this.addActionError("激活失败：激活码错误");
		} else {
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "loginPage";
	}

	
	/**
	 * 用户登录方法
	 */
	public String login(){
	   User existUser = userService.login(user);
	   
	   if(existUser == null ){
		   //没有找到信息，登录失败
		   this.addActionError("你的用户名或密码错误或用户还没激活");
		   return LOGIN;
	   }else{
		   //找到匹配的信息，登录成功
		   //将用户信息存在session中
		   ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
		   //页面跳转
		   return "loginSuccess";
	   }
	}
	
	/**
	 * 用户退出方法
	 */
	public String quit(){
		
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
