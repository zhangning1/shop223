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
 * ���������Action
 * @author zhangning
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
    //ģ������ʹ�ö���
	private Order order = new Order();
	
	public Order getModel() {
		return order;
	}
    //ע��Service
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//ע��ProductService
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

	//���ɶ����ķ���
	public String save(){
		//1.�������ݵ����ݿ�
		order.setOrdertime(new Date());
		order.setState(1);  //1.δ����  2.�Ѿ����û�з��� 3.�Ѿ�����������û��ȷ���ջ�  4.�������
		//�ܼƵ������ǹ��ﳵ�е���Ϣ
		
		Cart cart  =(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		if(cart == null){
			this.addActionError("�ף���Ĺ��ﳵ�տ���Ҳ���Ͻ�ȥ�����");
			return "index";
			
		}
		order.setTotal(cart.getTotal());
		// ���ö������:
		for(CartItem cartItem:cart.getCartItems()){
			// ���������Ϣ�ӹ������õ�.
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
			
		}
		
		//���ö��������û�
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser == null){
			this.addActionError("�ף��㻹û�е�¼");
			return "login";
		}
		
		order.setUser(existUser);
		
		orderService.save(order);
		//2.������������ʾ�������ϣ�
		//����ͨ��ֵջ�ķ�ʽ��ʾ
		
		//�ύ��������չ��ﳵ
		cart.clearCart();
		return "saveSuccess";
	}
	
	//�ҵĶ����Ĳ�ѯ
	public String findByUid(){
		//�����û���ID��ѯ����
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//����service
		PageBean<Order> pageBean = orderService.findByPageUid(user.getUid(),page);
		
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidSuccess";
	}
	
	//����Oid���Ҷ���
	public String findByOid(){
		
		order = orderService.findByOid(order.getOid());
		return "findByOidSuccess";
	}
	
	public String buy(){
	
		// ��װһ��CartItem����
		CartItem cartItem = new CartItem();

		// ��������
		cartItem.setCount(Integer.parseInt(count));

		// ������Ʒ��Pid��ѯ��Ʒ
		Product product = productService.findByPid(pid);
		// ������Ʒ
		cartItem.setProduct(product);
		
		// 1.�������ݵ����ݿ�
		order.setOrdertime(new Date());
		order.setState(1); // 1.δ���� 2.�Ѿ����û�з��� 3.�Ѿ�����������û��ȷ���ջ� 4.�������
		// �ܼƵ������ǹ��ﳵ�е���Ϣ

		order.setTotal(cartItem.getSubtotal());
		// ���ö������:
	
		// ���������Ϣ�ӹ������õ�.
		OrderItem orderItem = new OrderItem();
		orderItem.setCount(cartItem.getCount());
		orderItem.setSubtotal(cartItem.getSubtotal());
		orderItem.setProduct(cartItem.getProduct());
		orderItem.setOrder(order);

		order.getOrderItems().add(orderItem);
		

		// ���ö��������û�
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (existUser == null) {
			this.addActionError("�ף��㻹û�е�¼");
			return "login";
		}

		order.setUser(existUser);

		orderService.save(order);
		
		return "buySuccess";
	}
	
	    //Ϊ��������ķ���
	    public String payOrder(){
	    	//�޸Ķ���
	      Order currOrder = orderService.findByOid(order.getOid());
	      currOrder.setAddr(order.getAddr());
	      currOrder.setName(order.getName());
	      currOrder.setPhone(order.getPhone());
	      currOrder.setState(2);
	      orderService.update(currOrder);
	      
	    	return "payOrderSuccess";
	    }
	    
	    //ȷ���ջ��ķ���
	    public String updateState(){
	    	//����id��ѯ����
	    	Order currOrder = orderService.findByOid(order.getOid());
	    	currOrder.setState(4);
	    	orderService.update(currOrder);
	    	return "updateStateSuccess";
	    }
}
