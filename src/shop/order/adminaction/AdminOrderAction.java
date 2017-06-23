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
 * 后台订单管理的Action
 * @author zhangning
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
    //模型驱动使用的对象
   private Order order = new Order();
   
	public Order getModel() {
		return order;
	}

	//注入管理的Service
	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
	//接受Page 
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}
	
	//带分页查询的执行方法
	public String findAll(){
		//带分页的查询
		PageBean<Order> pageBean = orderService.findByPage(page);
		//通过值栈保存数据
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//根据订单ID查询订单项目
	 public String  findOrderItem(){
		 //根据订单ID查询订单项
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		//存入值栈中 
		ActionContext.getContext().getValueStack().set("list", list);
		 return "findOrderItem";
	 }
	 
	 //后台修改订单状态的方法：
	 public String updateState(){
		 //1.根据订单id查询订单
		Order currOrder = orderService.findByOid(order.getOid());
		 //2.修改订单的状态
		currOrder.setState(3);
		orderService.update(currOrder);
		 return "updateStateSuccess";
	 }
	 
	
}
