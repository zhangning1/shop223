package shop.product.action;

import shop.category.service.CategoryService;
import shop.product.entity.Product;
import shop.product.service.ProductService;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒ��Action����
 * 
 * @author zhangning
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
    //���ڽ������ݵ�ģ������
	private Product product=new Product();
	public Product getModel() {
		return product;
	}
	
	//����һ�������ID
	private int cid; 
	
	//���ն�������ID
	private int csid;
	
	//���յ�ǰҳ��
	private int page;
	
	//ע��ProductService
	private ProductService productService;
	
	//ע��һ�������Service
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

	//������Ʒ��ID��ѯ��Ʒ��ִ�з���
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	//���ݷ����ID��ѯ��Ʒ
	public String findByCid(){
	//List<Category> cList = categoryService.findAll();
	  PageBean<Product> pageBean =	productService.findByPageCid(cid,page);//����һ�������ѯ��Ʒ������ҳ��ѯ
	  
	  //��PageBean����ֵջ��
	  ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	//���ݶ�������ID��ѯ����Ʒ��
	public String findByCsid(){
	    PageBean<Product> pageBean = productService.findByPageCsid(csid,page);
	    
	    //��PageBean����ֵջ��
		 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	    
		return "findByCsid";
	}
}
