package shop.adminuser.service;

import shop.adminuser.dao.AdminDao;
import shop.adminuser.entity.Admin;


/**
 * 后台登录业务层代码
 * @author zhangning
 *
 */
public class AdminService {
    //注入AdminDao
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	//业务层，管理员登录
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}
	
}
