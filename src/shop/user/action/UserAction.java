package shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import shop.user.entity.User;
import shop.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * �û�ģ��
 * @author zhangning
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ģ�����������õĶ���
	private User user = new User();
	//ע��service
	private UserService userService;
	
	 
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * ��ת��ע��ҳ��ķ���
	 * @return
	 */
	public String registPage(){
		
		return "registPage";
	}
	/**
	 * ��ת����¼ҳ��ķ���
	 * @return
	 */
	public String loginPage(){
			
			return "loginPage";
		}

	/**
	 * AJAX�����첽У��
	 * @throws IOException 
	 */


	public String findByName() throws IOException{
		//����Service
		User existUser = userService.findByUserName(user.getUsername());
		//��ȡresponse��������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		//�����ַ���
		response.setContentType("text/html;charset=UTF-8");
		if(existUser != null  ){
			//��ѯ�����û����û��Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		}else{
			
			//û�鵽���û����û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}return null;
	}

	/**
	 * �û�ע�᷽��
	 * @throws Exception 
	 */
	public String regist() throws Exception{
		userService.save(user);
		return "index";
	}

	// �û������˺ŷ���
	public String active() {
		User existUser = userService.findByCode(user.getCode());
		System.out.println("existUser:" + existUser);
		System.out.println("user.getUcode():" + user.getCode());
		if (existUser == null) {
			this.addActionError("����ʧ�ܣ����������");
		} else {
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("����ɹ�:��ȥ��¼!");
		}
		return "loginPage";
	}

	
	/**
	 * �û���¼����
	 */
	public String login(){
	   User existUser = userService.login(user);
	   
	   if(existUser == null ){
		   //û���ҵ���Ϣ����¼ʧ��
		   this.addActionError("����û��������������û���û����");
		   return LOGIN;
	   }else{
		   //�ҵ�ƥ�����Ϣ����¼�ɹ�
		   //���û���Ϣ����session��
		   ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
		   //ҳ����ת
		   return "loginSuccess";
	   }
	}
	
	/**
	 * �û��˳�����
	 */
	public String quit(){
		
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
