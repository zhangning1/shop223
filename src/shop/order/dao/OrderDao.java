package shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import shop.order.entity.Order;
import shop.order.entity.OrderItem;
import shop.utils.PageHibernateCallback;

/**
 * ����ģ��Dao�����
 * @author zhangning
 *
 */
public class OrderDao extends HibernateDaoSupport{

	//Dao ���涩���Ĵ���
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	//DAO����ҵĶ����ĸ���ͳ��
	public  int findByCountUid(int uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
			
		}
		return 0;
	}

	//DAO����ҵĶ����Ĳ�ѯ
	public List<Order> findByPageUid(int uid, int begin, int limit) {
		String hql = "from Order o where o.user.uid = ? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,new Object[]{uid},begin,limit));
		return list;
	}

	//DAO�����ID��ѯ����
	public Order findByOid(int oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//DAO���޸Ķ���
	public void update(Order currOrder) {
		 this.getHibernateTemplate().update(currOrder);
	}

	//DAO��ͳ�ƶ��������ķ���
	public int findByCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//DAO�����ҳ��ѯ�ķ���
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list =this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,null,begin,limit));
		if(list != null && list.size()>0){
			return list;
		}
		
		return null;
	}

	//DAO���ݶ���ID��ѯ������ķ���
	public List<OrderItem> findOrderItem(int oid) {
        String hql = "from OrderItem oi where oi.order.oid = ?";
        List<OrderItem> list = this.getHibernateTemplate().find(hql,oid);
    	if(list != null && list.size()>0){
			return list;
		}
		return null;
	}


}
