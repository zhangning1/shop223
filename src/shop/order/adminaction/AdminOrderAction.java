package shop.order.adminaction;


import java.util.List;

import shop.order.entity.Order;
import shop.order.entity.OrderItem;
import shop.order.service.OrderService;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ��̨���������Action
 * @author zhangning
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
    //ģ������ʹ�õĶ���
   private Order order = new Order();
   
	public Order getModel() {
		return order;
	}

	//ע������Service
	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
	//����Page 
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}
	
	//����ҳ��ѯ��ִ�з���
	public String findAll(){
		//����ҳ�Ĳ�ѯ
		PageBean<Order> pageBean = orderService.findByPage(page);
		//ͨ��ֵջ��������
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//���ݶ���ID��ѯ������Ŀ
	 public String  findOrderItem(){
		 //���ݶ���ID��ѯ������
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		//����ֵջ�� 
		ActionContext.getContext().getValueStack().set("list", list);
		 return "findOrderItem";
	 }
	 
	 //��̨�޸Ķ���״̬�ķ�����
	 public String updateState(){
		 //1.���ݶ���id��ѯ����
		Order currOrder = orderService.findByOid(order.getOid());
		 //2.�޸Ķ�����״̬
		currOrder.setState(3);
		orderService.update(currOrder);
		 return "updateStateSuccess";
	 }
	 
	
}
