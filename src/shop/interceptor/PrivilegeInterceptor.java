package shop.interceptor;

import org.apache.struts2.ServletActionContext;

import shop.adminuser.entity.Admin;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ��̨Ȩ��У��������
 * @author zhangning
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//ִ�����صķ���
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//�ж�Session���Ƿ񱣴��˺�̨�û�����Ϣ
		Admin adminUser = (Admin) ServletActionContext.getRequest()
				.getSession().getAttribute("existadmin");
		if(adminUser == null){
			//û�е�¼���з���
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("�ף�����û�е�¼��û��Ȩ�޷���");
			return "loginFail";
		}else{
			//�Ѿ���¼��
			return actionInvocation.invoke();
		}
		
	
	}

}
