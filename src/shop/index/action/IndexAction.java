package shop.index.action;

import java.util.List;

import shop.category.entity.Category;
import shop.category.service.CategoryService;
import shop.product.entity.Product;
import shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
/**
 * ��ҳ���ʵ�Action
 * @author zhangning
 *
 */
public class IndexAction extends ActionSupport{
	//ע��һ������Service:
	private CategoryService categoryService;
	//ע����ƷService
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	public String execute(){
		
		//��ѯһ������ļ��� 
		List<Category> cList = categoryService.findAll();
		//��һ��������뵽Session�ķ�Χ��
		ActionContext.getContext().getSession().put("cList", cList);
		
		//��ѯ������Ʒ
		List<Product> hList =productService.findHot();
		
		//��ѯ������Ʒ
		List<Product> nList = productService.findNew();
		
		//���浽ֵջ��
		ActionContext.getContext().getValueStack().set("hList", hList);
		
		//���浽ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index"; 
	}
	
}
