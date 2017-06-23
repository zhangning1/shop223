package shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import shop.user.dao.UserDao;
import shop.user.entity.User;
import shop.utils.Send;
import shop.utils.UUIDUtils;


/**
 * �û�ģ��ҵ������
 * @author zhangning
 *
 */
@Transactional
public class UserService {
    //ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//���û�����ѯ
	public User findByUserName(String username){
		
		return userDao.findByUserName(username); 
	}

	//ҵ�������û�ע��Ĵ���
	public void save(User user) throws Exception {
		//�����ݴ������ݿ�
		user.setState(0);//0����δ���1�����Ѽ���
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//String code = UUIDUtil.getUUID()+UUIDUtil.getUUID();//����64λ�ļ�����
		user.setCode(code);
		Send send = new Send();
		send.send(user,user.getEmail(), code);
		userDao.save(user);  
	}

	//�û���¼�ķ���
	public User login(User user) {
		
		return userDao.login(user) ;
	}

	//ҵ�����ݼ������ѯ�û�
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	//ҵ��㱣���û�
	public void update(User existUser) {
		userDao.update(existUser);
	}
}
