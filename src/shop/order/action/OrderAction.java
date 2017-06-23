 package shop.order.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import shop.cart.entity.Cart;
import shop.cart.entity.CartItem;
import shop.order.entity.Order;
import shop.order.entity.OrderItem;
import shop.order.service.OrderService;
import shop.product.entity.Product;
import shop.product.service.ProductService;
import shop.user.entity.User;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 订单管理的Action
 * @author zhangning
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
    //模型驱动使用对象
	private Order order = new Order();
	
	public Order getModel() {
		return order;
	}
    //注入Service
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//注入ProductService
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private int page;
	
	
	public void setPage(int page) {
		this.page = page;
	}

	private int pid;
	
	public void setPid(int pid) {
		this.pid = pid;
	}

	private String count;
	
	public void setCount(String count) {
		this.count = count;
	}

	//生成订单的方法
	public String save(){
		//1.保存数据到数据库
		order.setOrdertime(new Date());
		order.setState(1);  //1.未付款  2.已经付款，没有发货 3.已经发货，但是没有确认收货  4.交易完成
		//总计的数据是购物车中的信息
		
		Cart cart  =(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		if(cart == null){
			this.addActionError("亲，你的购物车空空如也，赶紧去购物吧");
			return "index";
			
		}
		order.setTotal(cart.getTotal());
		// 设置订单项集合:
		for(CartItem cartItem:cart.getCartItems()){
			// 订单项的信息从购物项获得的.
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
			
		}
		
		//设置订单所属用户
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser == null){
			this.addActionError("亲，你还没有登录");
			return "login";
		}
		
		order.setUser(existUser);
		
		orderService.save(order);
		//2.将订单对象显示到对象上：
		//可以通过值栈的方式显示
		
		//提交订单后清空购物车
		cart.clearCart();
		return "saveSuccess";
	}
	
	//我的订单的查询
	public String findByUid(){
		//根据用户的ID查询订单
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//调用service
		PageBean<Order> pageBean = orderService.findByPageUid(user.getUid(),page);
		
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidSuccess";
	}
	
	//根据Oid查找订单
	public String findByOid(){
		
		order = orderService.findByOid(order.getOid());
		return "findByOidSuccess";
	}
	
	public String buy(){
	
		// 封装一个CartItem对象
		CartItem cartItem = new CartItem();

		// 设置数量
		cartItem.setCount(Integer.parseInt(count));

		// 根据商品的Pid查询商品
		Product product = productService.findByPid(pid);
		// 设置商品
		cartItem.setProduct(product);
		
		// 1.保存数据到数据库
		order.setOrdertime(new Date());
		order.setState(1); // 1.未付款 2.已经付款，没有发货 3.已经发货，但是没有确认收货 4.交易完成
		// 总计的数据是购物车中的信息

		order.setTotal(cartItem.getSubtotal());
		// 设置订单项集合:
	
		// 订单项的信息从购物项获得的.
		OrderItem orderItem = new OrderItem();
		orderItem.setCount(cartItem.getCount());
		orderItem.setSubtotal(cartItem.getSubtotal());
		orderItem.setProduct(cartItem.getProduct());
		orderItem.setOrder(order);

		order.getOrderItems().add(orderItem);
		

		// 设置订单所属用户
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (existUser == null) {
			this.addActionError("亲，你还没有登录");
			return "login";
		}

		order.setUser(existUser);

		orderService.save(order);
		
		return "buySuccess";
	}
	
	    //为订单付款的方法
	    public String payOrder(){
	    	//修改订单
	      Order currOrder = orderService.findByOid(order.getOid());
	      currOrder.setAddr(order.getAddr());
	      currOrder.setName(order.getName());
	      currOrder.setPhone(order.getPhone());
	      currOrder.setState(2);
	      orderService.update(currOrder);
	      
	    	return "payOrderSuccess";
	    }
	    
	    //确认收货的方法
	    public String updateState(){
	    	//根据id查询订单
	    	Order currOrder = orderService.findByOid(order.getOid());
	    	currOrder.setState(4);
	    	orderService.update(currOrder);
	    	return "updateStateSuccess";
	    }
}
