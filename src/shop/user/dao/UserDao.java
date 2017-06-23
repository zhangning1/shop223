package shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.user.entity.User;

/**
 * 用户模块持久层代码 
 * @author zhangning
 *
 */
public class UserDao extends HibernateDaoSupport {
    //按名称查询用户
    public User findByUserName(String username){
    	String hql = "from User where username = ?";
    	List<User> list = this.getHibernateTemplate().find(hql,username);
    	if(list != null && list.size()>0){
    		
    		return list.get(0); 
    	}else{
    		return null;
    	}
    }

	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	//用户登录的方法
	public User login(User user) {
		String hql="from User where username=? and password=? and state=?";
		List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(), 1);
		if(list != null && list.size() > 0){
			
			return list.get(0);
		}
		return null;
	}

	//DAO根据code查询用户
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql,code);
		if (list != null && list.size() > 0) {

			return list.get(0);
		}
		return null;
	}

	//DAO保存用户
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}
}
