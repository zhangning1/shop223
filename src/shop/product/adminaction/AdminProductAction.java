package shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import shop.categorysecond.entity.CategorySecond;
import shop.categorysecond.service.CategorySecondService;
import shop.product.entity.Product;
import shop.product.service.ProductService;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台管理的Action
 * @author zhangning
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product = new Product();
	public Product getModel() {
		return product;
	}

	//注入Service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//注入 二级分类的Service
	private CategorySecondService categorySecondService;
	
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//接受page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//文件上传需要的参数
	private File upload;  //上传的文件
	private String uploadFileName;  //接收文件的上传的文件名
	private String uploadContentType; //接收文件上传的文件的MIME类型

	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//带分页的查询商品的执行的方法
	public String findAll(){
		//调用Service完成查询操作
		PageBean<Product> pageBean = productService.findByPage(page);
		//将数据传递到页面上
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findAll";
	}
	
	//跳转到添加页面的方法
	public String addPage(){
		//查询所有二级分类的集合
		List<CategorySecond> csList = categorySecondService.findAll();
		//通过值栈来保存数据
		ActionContext.getContext().getValueStack().set("csList", csList);
		//页面跳转
		return "addPage";
	}
	
	//保存商品的方法
	public String save() throws IOException{
		product.setPdate(new Date());
		if(upload != null){
			//获取文件上传的磁盘路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/picture");
			//创建一个文件：
			File diskFile = new File(realPath+"//"+uploadFileName);
			//文件上传:
			FileUtils.copyFile(upload, diskFile);
			
			product.setImage("picture/"+uploadFileName);
		}           
		
		productService.save(product);
		return "saveSuccess"; 
	}
	
	//删除商品的方法
	public String delete(){
		//先查询在删除
	 product =	productService.findByPid(product.getPid());
	  //删除上传的图片
	 String path = product.getImage();
	 if(path != null){
		 String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
		 File file = new File(realPath);
		 file.delete();
	 }
	  //删除商品
	 productService.delete(product);
	 return "deleteSuccess";
	}
	
	//跳转到商品编辑页面
	public String editPage (){
		//查询所有二级分类的集合
		List<CategorySecond> csList = categorySecondService.findAll();
		//通过值栈来保存数据
		ActionContext.getContext().getValueStack().set("csList", csList);
		//根据商品ID查询商品
		product = productService.findByPid(product.getPid());
		
		return "editPage";
	} 
	
	//修改商品信息的方法
	public String edit() throws IOException{
		//修改商品的数据到数据库
		product.setPdate(new Date());
		if(upload != null){
			//将原来的图片删除掉
			String path = product.getImage();
			File file = new File(ServletActionContext.getServletContext().getRealPath("/ "+path));
			file.delete();
			
			//文件上传
			//获取文件上传的磁盘路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/picture");
			//创建一个文件：
			File diskFile = new File(realPath+"//"+uploadFileName);
			//文件上传:
			FileUtils.copyFile(upload, diskFile);
			
			product.setImage("picture/"+uploadFileName);
		}
		productService.edit(product);
		return "editSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
