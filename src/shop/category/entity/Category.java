package shop.category.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import shop.categorysecond.entity.CategorySecond;

/**
 * һ�������ʵ����
 * @author zhangning
 *
 */
public class Category implements Serializable { 
	
	private int cid;
	private String cname;
	//һ�������д�Ŷ�������ļ���
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	} 
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
}
