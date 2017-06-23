package shop.index.action;

import java.util.List;

import shop.category.entity.Category;
import shop.category.service.CategoryService;
import shop.product.entity.Product;
import shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
/**
 * 首页访问的Action
 * @author zhangning
 *
 */
public class IndexAction extends ActionSupport{
	//注入一级分类Service:
	private CategoryService categoryService;
	//注入商品Service
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	public String execute(){
		
		//查询一级分类的集合 
		List<Category> cList = categoryService.findAll();
		//将一级分类存入到Session的范围：
		ActionContext.getContext().getSession().put("cList", cList);
		
		//查询热门商品
		List<Product> hList =productService.findHot();
		
		//查询最新商品
		List<Product> nList = productService.findNew();
		
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("hList", hList);
		
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index"; 
	}
	
}
