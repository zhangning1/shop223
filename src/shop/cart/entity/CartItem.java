package shop.cart.entity;

import java.io.Serializable;

import shop.product.entity.Product;

/**
 * 购物项对象
 * @author zhangning
 *
 */
public class CartItem implements Serializable {

	private Product product;  //购买项中商品信息
	private int count;        //购买商品的数量
	private double subtotal;  //购买商品的小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	//小计自动计算
	public double getSubtotal() {
		return count * product.getShop_price();
	}

	
	
}
