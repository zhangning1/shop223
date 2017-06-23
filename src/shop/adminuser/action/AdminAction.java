package shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import shop.adminuser.entity.Admin;
import shop.adminuser.service.AdminService;
import shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��¼����
 * @author zhangning
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	private Admin admin = new Admin();

	public Admin getModel() {
		return admin;
	}
	
	//ע��AdminService
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * ��̨������¼ҳ�淽��
	 */
	public String index(){
		
		return "index";
	}
	

	//��̨��¼�ķ���
    public String login(){
    	
    	Admin existadmin = adminService.login(admin);
        if(existadmin == null){
        	//��¼ʧ��
        	this.addActionError("�ף�����û��������������"); 
        	return "loginFail";
        }
        else{
        	//��¼�ɹ�
        	ServletActionContext.getRequest().getSession().setAttribute("existadmin",existadmin);
        	return "loginSuccess";
        
        }
    
    	
    }
    

}
