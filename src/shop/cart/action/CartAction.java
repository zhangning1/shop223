package shop.cart.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import shop.cart.entity.Cart;
import shop.cart.entity.CartItem;
import shop.order.entity.OrderItem;
import shop.product.entity.Product;
import shop.product.service.ProductService;
import shop.user.entity.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ﳵ��Action
 * @author zhangning
 *
 */
public class CartAction extends ActionSupport{
	 
	//����pid
	private int pid;
	//��������count
	private int count;
	
     //ע��productService
	private ProductService productService;
	
	public void setPid(int pid) {
		this.pid = pid;
	} 

	public void setCount(int count) {
		this.count = count;
	}
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//����������ӵ����ﳵ��ִ�з��� 
	public String addCart(){
		
		//��װһ��CartItem����
		CartItem cartItem =new CartItem();
		
		//��������
		cartItem.setCount(count);
		
		//������Ʒ��Pid��ѯ��Ʒ
		Product product = productService.findByPid(pid);
		//������Ʒ
		cartItem.setProduct(product);
		
		//����������ӵ����ﳵ�� ���ﳵӦ�ô���Session��
		 Cart cart = getCart();
		 cart.addCart(cartItem);
		
		return "addCart";
	}
	
	
	//ִ����չ��ﳵ�ķ���
	public String clearCart(){
		//��ȡ���ﳵ����
		Cart cart =getCart();
		
		//���ù��ﳵ����չ��ﳵ�ķ���
		cart.clearCart()  ; 
		
		return "clearCart";
		
	}
	
	//ִ���Ƴ�������ķ���
	public String removeCart(){
		//��ȡ���ﳵ����
		Cart cart =getCart();
		
		//���ù��ﳵ���Ƴ����ﳵ�ķ���
		cart.removeCart(pid); 
		
		return "removeCart";
	}
	
	//���빺�ﳵҳ��
	public String myCart(){
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null ){
			this.addActionError("�ף����ﳵ�տյģ�������ȥ�̳ǹ����");
		}
		return "myCart";
	}

	/**
	 *  ��session�л�ȡ���ﳵ�ķ���
	 * @return
	 */
	private Cart getCart() {
		
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart",cart);
			
		}
		 
		return cart;
	}

}
 