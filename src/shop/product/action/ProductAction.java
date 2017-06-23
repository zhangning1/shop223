package shop.product.action;

import shop.category.service.CategoryService;
import shop.product.entity.Product;
import shop.product.service.ProductService;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品的Action对象
 * 
 * @author zhangning
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
    //用于接受数据的模型驱动
	private Product product=new Product();
	public Product getModel() {
		return product;
	}
	
	//接收一级分类的ID
	private int cid; 
	
	//接收二级分类ID
	private int csid;
	
	//接收当前页数
	private int page;
	
	//注入ProductService
	private ProductService productService;
	
	//注入一级分类的Service
	private CategoryService categoryService;
	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getCid() {
		return cid;
	}


	public int getCsid() {
		return csid;
	}


	public void setCsid(int csid) {
		this.csid = csid;
	}

	
	
	public void setPage(int page) {
		this.page = page;
	}

	
	 
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//根据商品的ID查询商品，执行方法
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	//根据分类的ID查询商品
	public String findByCid(){
	//List<Category> cList = categoryService.findAll();
	  PageBean<Product> pageBean =	productService.findByPageCid(cid,page);//根据一级分类查询商品，带分页查询
	  
	  //将PageBean存入值栈中
	  ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	//根据二级分类ID查询到商品：
	public String findByCsid(){
	    PageBean<Product> pageBean = productService.findByPageCsid(csid,page);
	    
	    //将PageBean存入值栈中
		 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	    
		return "findByCsid";
	}
}
