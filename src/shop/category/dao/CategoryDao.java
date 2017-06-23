package shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.category.entity.Category;
import shop.categorysecond.entity.CategorySecond;


/**
 * 一级分类持久层对象
 * @author zhangning
 *
 */
public class CategoryDao extends HibernateDaoSupport {


    //DAO层查询所有一级分类的方法
	public  List<Category> findAll() {
		
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//Dao层后台添加一级分类
	public void add(Category category) {
		this.getHibernateTemplate().save(category);
	}

	//Dao层后台删除一级分类
	public void del(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	//根据ID查询一级分类
	public Category findByCid(int cid) {

		String hql ="from Category where cid = ?"; 
		//return this.getHibernateTemplate().get(Category.class, cid);
	   List<Category> list = this.getHibernateTemplate().find(hql,cid);
	   if(list != null && list.size()>0){
		   
		   return list.get(0);
	   }
	   return null;
	}

	//修改一级分类
	public void edit(Category category) {
		this.getHibernateTemplate().update(category);
	}



	
}
