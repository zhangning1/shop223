package shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.category.entity.Category;
import shop.categorysecond.entity.CategorySecond;


/**
 * һ������־ò����
 * @author zhangning
 *
 */
public class CategoryDao extends HibernateDaoSupport {


    //DAO���ѯ����һ������ķ���
	public  List<Category> findAll() {
		
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//Dao���̨���һ������
	public void add(Category category) {
		this.getHibernateTemplate().save(category);
	}

	//Dao���̨ɾ��һ������
	public void del(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	//����ID��ѯһ������
	public Category findByCid(int cid) {

		String hql ="from Category where cid = ?"; 
		//return this.getHibernateTemplate().get(Category.class, cid);
	   List<Category> list = this.getHibernateTemplate().find(hql,cid);
	   if(list != null && list.size()>0){
		   
		   return list.get(0);
	   }
	   return null;
	}

	//�޸�һ������
	public void edit(Category category) {
		this.getHibernateTemplate().update(category);
	}



	
}
