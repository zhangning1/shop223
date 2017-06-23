package shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.product.entity.Product;
import shop.utils.PageHibernateCallback;

/**
 * 商品持久层代码
 * @author zhangning
 *
 */
public class ProductDao extends HibernateDaoSupport {

	//首页上热门商品查询
	public List<Product> findHot() {
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//查询是否为热门商品，条件为is_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 8);
		return list;
	}

	
	//首页上最新商品的查询
	public List<Product> findNew() {
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 7);
		return list;
	}

   //首页根据商品ID查询商品
	public Product findByPid(int pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}


	//根据一级分类ID查询商品个数
	public int findCountCid(int cid) {
		String hql ="select count(*) from Product p where p.categorySecond.category.cid = ?";
	    List<Long> list =	this.getHibernateTemplate().find(hql,cid);
	    if(list != null && list.size() > 0){
	    	
	    	return list.get(0).intValue();
	    }
		return 0;
	}

    //根据分类ID查询商品的集合 
	public List<Product> findByPageCid(int cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		
	   List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			
			 return list;
			
		}
	   
	   return null;
	}

	//根据二级分类ID查询商品个数
	public int findCountCsid(int csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
	    List<Long> list = this.getHibernateTemplate().find(hql,csid);
        if(list != null && list.size() > 0){
	    	
	    	return list.get(0).intValue();
	     }
		return 0;
	}

	 //根据二级分类ID查询商品的集合 
	public List<Product> findByPageCsid(int csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid =?";
 		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{csid},begin,limit));
       if(list != null && list.size() > 0){
	    	
	    	return list;
	     }
		return null;
	}

	
   //统计商品个数的方法
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {

			return list.get(0).intValue();
		}
		return 0;
	}

    //带有分页查询的方法
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list =this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,null,begin,limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}


	//添加商品
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

    //DAO层删除商品的方法
	public void delete(Product product) {
       this.getHibernateTemplate().delete(product);		
	}

    //DAO层修改商品的方法
	public void edit(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
