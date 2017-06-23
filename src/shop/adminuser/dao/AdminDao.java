package shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.adminuser.entity.Admin;

/**
 * 后台登录持久层代码
 * @author zhangning
 *
 */
public class AdminDao extends HibernateDaoSupport{

	
	//DAO层：管理员登录
	public Admin login(Admin admin) {
		String hql ="from Admin where username = ? and password = ?";
	   List<Admin> list= this.getHibernateTemplate().find(hql,admin.getUsername(),admin.getPassword());
	   if( list != null && list.size() > 0){
		   
		   return list.get(0);
	   }
		return null;
	} 

}
