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
 * ��̨�����Action
 * @author zhangning
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product = new Product();
	public Product getModel() {
		return product;
	}

	//ע��Service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//ע�� ���������Service
	private CategorySecondService categorySecondService;
	
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//����page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//�ļ��ϴ���Ҫ�Ĳ���
	private File upload;  //�ϴ����ļ�
	private String uploadFileName;  //�����ļ����ϴ����ļ���
	private String uploadContentType; //�����ļ��ϴ����ļ���MIME����

	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//����ҳ�Ĳ�ѯ��Ʒ��ִ�еķ���
	public String findAll(){
		//����Service��ɲ�ѯ����
		PageBean<Product> pageBean = productService.findByPage(page);
		//�����ݴ��ݵ�ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findAll";
	}
	
	//��ת�����ҳ��ķ���
	public String addPage(){
		//��ѯ���ж�������ļ���
		List<CategorySecond> csList = categorySecondService.findAll();
		//ͨ��ֵջ����������
		ActionContext.getContext().getValueStack().set("csList", csList);
		//ҳ����ת
		return "addPage";
	}
	
	//������Ʒ�ķ���
	public String save() throws IOException{
		product.setPdate(new Date());
		if(upload != null){
			//��ȡ�ļ��ϴ��Ĵ���·��
			String realPath = ServletActionContext.getServletContext().getRealPath("/picture");
			//����һ���ļ���
			File diskFile = new File(realPath+"//"+uploadFileName);
			//�ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);
			
			product.setImage("picture/"+uploadFileName);
		}           
		
		productService.save(product);
		return "saveSuccess"; 
	}
	
	//ɾ����Ʒ�ķ���
	public String delete(){
		//�Ȳ�ѯ��ɾ��
	 product =	productService.findByPid(product.getPid());
	  //ɾ���ϴ���ͼƬ
	 String path = product.getImage();
	 if(path != null){
		 String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
		 File file = new File(realPath);
		 file.delete();
	 }
	  //ɾ����Ʒ
	 productService.delete(product);
	 return "deleteSuccess";
	}
	
	//��ת����Ʒ�༭ҳ��
	public String editPage (){
		//��ѯ���ж�������ļ���
		List<CategorySecond> csList = categorySecondService.findAll();
		//ͨ��ֵջ����������
		ActionContext.getContext().getValueStack().set("csList", csList);
		//������ƷID��ѯ��Ʒ
		product = productService.findByPid(product.getPid());
		
		return "editPage";
	} 
	
	//�޸���Ʒ��Ϣ�ķ���
	public String edit() throws IOException{
		//�޸���Ʒ�����ݵ����ݿ�
		product.setPdate(new Date());
		if(upload != null){
			//��ԭ����ͼƬɾ����
			String path = product.getImage();
			File file = new File(ServletActionContext.getServletContext().getRealPath("/ "+path));
			file.delete();
			
			//�ļ��ϴ�
			//��ȡ�ļ��ϴ��Ĵ���·��
			String realPath = ServletActionContext.getServletContext().getRealPath("/picture");
			//����һ���ļ���
			File diskFile = new File(realPath+"//"+uploadFileName);
			//�ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);
			
			product.setImage("picture/"+uploadFileName);
		}
		productService.edit(product);
		return "editSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
