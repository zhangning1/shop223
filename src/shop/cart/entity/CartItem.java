package shop.cart.entity;

import java.io.Serializable;

import shop.product.entity.Product;

/**
 * ���������
 * @author zhangning
 *
 */
public class CartItem implements Serializable {

	private Product product;  //����������Ʒ��Ϣ
	private int count;        //������Ʒ������
	private double subtotal;  //������Ʒ��С��
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
	
	
	//С���Զ�����
	public double getSubtotal() {
		return count * product.getShop_price();
	}

	
	
}
