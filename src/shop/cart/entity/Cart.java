package shop.cart.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author zhangning
 *
 */
public class Cart implements Serializable{
	
	//购物车的属性
	//购物项集合：Map的Key就是商品pid,value:购物项
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//购物总计
	private double total;

	//car对象有个CartItems对象
	public Collection<CartItem> getCartItems(){
		return map.values();	
	}

	public double getTotal() {
		return total;
	}

	//购物车的功能
	//1.将购物项添加到购物车
	public void addCart(CartItem cartItem){
		//判断购买购物车中是否存在该购物项
		/*  存在
		 *     数量增加  ，总计 = 总计+购物项小计
		 *  不存在
		 *     向map中添加购物项，总计 = 总计 +购物项小计   
		 */
		 //获取商品ID
		   int pid = cartItem.getProduct().getPid();
		 //判断购物车中是否已经存在该购物项
		   if(map.containsKey(pid)){
			   //存在
			   CartItem _cartItem= map.get(pid);//获得购物中原来的购物项
			   _cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		   }else{
			   //不存在
			   map.put(pid,cartItem);
		   }
		   //设置总计的值
		   total += cartItem.getSubtotal();
		
	}
	//2.从购物物车移除购物车
	public void removeCart(int pid){
		//将购物项移除
		 CartItem carItem = map.remove(pid);
		//总计 = 总计 - 移除的购物小计
		total -= carItem.getSubtotal();
		
	}
	
	
	//3.清空购物车
	public void clearCart(){
		
		//将所有购物项清空
		map.clear();
		//将总计设置为0
		total = 0;
		
	}

}
