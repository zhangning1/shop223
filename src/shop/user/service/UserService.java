package shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import shop.user.dao.UserDao;
import shop.user.entity.User;
import shop.utils.Send;
import shop.utils.UUIDUtils;


/**
 * 用户模块业务层代码
 * @author zhangning
 *
 */
@Transactional
public class UserService {
    //注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//按用户名查询
	public User findByUserName(String username){
		
		return userDao.findByUserName(username); 
	}

	//业务层完成用户注册的代码
	public void save(User user) throws Exception {
		//将数据存入数据库
		user.setState(0);//0代表未激活，1代表已激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//String code = UUIDUtil.getUUID()+UUIDUtil.getUUID();//生成64位的激活码
		user.setCode(code);
		Send send = new Send();
		send.send(user,user.getEmail(), code);
		userDao.save(user);  
	}

	//用户登录的方法
	public User login(User user) {
		
		return userDao.login(user) ;
	}

	//业务层根据激活码查询用户
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	//业务层保存用户
	public void update(User existUser) {
		userDao.update(existUser);
	}
}
