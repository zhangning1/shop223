package shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.product.entity.Product;
import shop.utils.PageHibernateCallback;

/**
 * ��Ʒ�־ò����
 * @author zhangning
 *
 */
public class ProductDao extends HibernateDaoSupport {

	//��ҳ��������Ʒ��ѯ
	public List<Product> findHot() {
		//ʹ�����߲�ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//��ѯ�Ƿ�Ϊ������Ʒ������Ϊis_hot=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//�������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 8);
		return list;
	}

	
	//��ҳ��������Ʒ�Ĳ�ѯ
	public List<Product> findNew() {
		//ʹ�����߲�ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//�������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 7);
		return list;
	}

   //��ҳ������ƷID��ѯ��Ʒ
	public Product findByPid(int pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}


	//����һ������ID��ѯ��Ʒ����
	public int findCountCid(int cid) {
		String hql ="select count(*) from Product p where p.categorySecond.category.cid = ?";
	    List<Long> list =	this.getHibernateTemplate().find(hql,cid);
	    if(list != null && list.size() > 0){
	    	
	    	return list.get(0).intValue();
	    }
		return 0;
	}

    //���ݷ���ID��ѯ��Ʒ�ļ��� 
	public List<Product> findByPageCid(int cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		
	   List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			
			 return list;
			
		}
	   
	   return null;
	}

	//���ݶ�������ID��ѯ��Ʒ����
	public int findCountCsid(int csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
	    List<Long> list = this.getHibernateTemplate().find(hql,csid);
        if(list != null && list.size() > 0){
	    	
	    	return list.get(0).intValue();
	     }
		return 0;
	}

	 //���ݶ�������ID��ѯ��Ʒ�ļ��� 
	public List<Product> findByPageCsid(int csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid =?";
 		List<Product> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{csid},begin,limit));
       if(list != null && list.size() > 0){
	    	
	    	return list;
	     }
		return null;
	}

	
   //ͳ����Ʒ�����ķ���
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {

			return list.get(0).intValue();
		}
		return 0;
	}

    //���з�ҳ��ѯ�ķ���
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list =this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,null,begin,limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}


	//�����Ʒ
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

    //DAO��ɾ����Ʒ�ķ���
	public void delete(Product product) {
       this.getHibernateTemplate().delete(product);		
	}

    //DAO���޸���Ʒ�ķ���
	public void edit(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
