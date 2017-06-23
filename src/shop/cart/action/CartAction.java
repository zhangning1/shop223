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
 * 购物车的Action
 * @author zhangning
 *
 */
public class CartAction extends ActionSupport{
	 
	//接收pid
	private int pid;
	//接收数量count
	private int count;
	
     //注入productService
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

	//将购物项添加到购物车：执行方法 
	public String addCart(){
		
		//封装一个CartItem对象
		CartItem cartItem =new CartItem();
		
		//设置数量
		cartItem.setCount(count);
		
		//根据商品的Pid查询商品
		Product product = productService.findByPid(pid);
		//设置商品
		cartItem.setProduct(product);
		
		//将购物项添加到购物车， 购物车应该存在Session中
		 Cart cart = getCart();
		 cart.addCart(cartItem);
		
		return "addCart";
	}
	
	
	//执行清空购物车的方法
	public String clearCart(){
		//获取购物车对象
		Cart cart =getCart();
		
		//调用购物车的清空购物车的方法
		cart.clearCart()  ; 
		
		return "clearCart";
		
	}
	
	//执行移出购物项的方法
	public String removeCart(){
		//获取购物车对象
		Cart cart =getCart();
		
		//调用购物车的移除购物车的方法
		cart.removeCart(pid); 
		
		return "removeCart";
	}
	
	//进入购物车页面
	public String myCart(){
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null ){
			this.addActionError("亲，购物车空空的，不如先去商城购物吧");
		}
		return "myCart";
	}

	/**
	 *  从session中获取购物车的方法
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
 