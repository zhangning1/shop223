package shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import shop.categorysecond.entity.CategorySecond;
import shop.utils.PageHibernateCallback;


/**
 * 二级分类管理的Dao层的类
 * @author zhangning
 *
 */
public class CategorySecondDao extends HibernateDaoSupport{

	//Dao层的统计二级分类的个数的方法
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//Dao层分页查询二级分类的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list =this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//DAO层的添加二级分类的方法
	public void add(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	//DAO层查询二级分类
	public CategorySecond findByCsid(int csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	//DAO删除二级分类
	public void delete(CategorySecond categorySecond) {
          this.getHibernateTemplate().delete(categorySecond);		
	}

	//DAO层修改二级分类
	public void edit(CategorySecond categorySecond) {
        this.getHibernateTemplate().update(categorySecond);		
	}

	//DAO层查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		String hql="from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}


}
