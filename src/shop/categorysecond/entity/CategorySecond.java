package shop.categorysecond.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import shop.category.entity.Category;
import shop.product.entity.Product;

/**
 * ���������ʵ����
 * @author zhangning
 *
 */

public class CategorySecond implements Serializable {

	private int csid;
	private String csname;
	//����һ�����࣬�����һ������Ķ���
	private Category category;
	
	//������Ʒ����
	private Set<Product> products =new HashSet<Product>();
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
