package shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.adminuser.entity.Admin;

/**
 * ��̨��¼�־ò����
 * @author zhangning
 *
 */
public class AdminDao extends HibernateDaoSupport{

	
	//DAO�㣺����Ա��¼
	public Admin login(Admin admin) {
		String hql ="from Admin where username = ? and password = ?";
	   List<Admin> list= this.getHibernateTemplate().find(hql,admin.getUsername(),admin.getPassword());
	   if( list != null && list.size() > 0){
		   
		   return list.get(0);
	   }
		return null;
	} 

}
