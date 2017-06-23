package shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.order.dao.OrderDao;
import shop.order.entity.Order;
import shop.order.entity.OrderItem;
import shop.utils.PageBean;

/**
 *  ����ģ��ҵ���
 * @author zhangning
 *
 */
@Transactional
public class OrderService {
	//ע��OrderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	//���涩����ҵ������
	public void save(Order order) {
		orderDao.save(order);
	}


	//�ҵĶ�����ҵ������
	public PageBean<Order> findByPageUid(int uid, int page) {
		 PageBean<Order> pageBean = new PageBean<Order>();
		 //���õ�ǰҳ��
		 pageBean.setPage(page);
		 
		 //����ÿҳ����ʾ�ļ�¼��
		 int limit = 5;
		 pageBean.setLimit(limit);
		 
		 //�����ܼ�¼�� 
		 int totalCount = 0;
		 totalCount = orderDao.findByCountUid(uid);
		 pageBean.setTotalCount(totalCount); 
		 
		 //������ҳ��
		 int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);		
		
		//����ÿҳ��ʾ���ݵļ���
		int begin = (page - 1) *limit;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		
		return pageBean;
	}

    //ҵ��㣺����oid��ѯ����
	public Order findByOid(int oid) {
		
		return orderDao.findByOid(oid);
	}

     
	//ҵ��㣺�޸Ķ����Ĳ���
	public void update(Order currOrder) {
        orderDao.update(currOrder);		
	}

    //ҵ��㣺��̨����ҳ��ѯ�Ķ����ķ���
	public PageBean<Order> findByPage(int page) {

		PageBean<Order> pageBean = new PageBean<Order>();
		
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼��
		int limit = 8;
		pageBean.setLimit(limit);		
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = orderDao.findByCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
		}else{
			
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//����ÿҳ��ʾ�����ݵļ���
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

   //ҵ�����ݶ���id��ѯ������ķ���
	public List<OrderItem> findOrderItem(int oid) {
		return orderDao.findOrderItem(oid);
	}




}
