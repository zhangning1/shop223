package shop.adminuser.service;

import shop.adminuser.dao.AdminDao;
import shop.adminuser.entity.Admin;


/**
 * ��̨��¼ҵ������
 * @author zhangning
 *
 */
public class AdminService {
    //ע��AdminDao
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	//ҵ��㣬����Ա��¼
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}
	
}
