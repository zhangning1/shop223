package shop.categorysecond.adminaction;

import java.util.List;

import shop.category.entity.Category;
import shop.category.service.CategoryService;
import shop.categorysecond.entity.CategorySecond;
import shop.categorysecond.service.CategorySecondService;
import shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ��̨������������Action
 * @author zhangning
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
     //ģ������ʹ������
	private CategorySecond categorySecond = new CategorySecond();
	
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//����page
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}
	
	//ע��һ�������Service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
   //��ѯ��������ķ���
	public String findAll(){
		
	PageBean<CategorySecond> pageBean =	categorySecondService.findByPage(page);
	//��pageBean����ֵջ��
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findSecondAll";
	}
	
	//��ת����ӵ�ҳ��
	public String addPage(){
		//��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		//��������ʾҳ��������б���
		ActionContext.getContext().getValueStack().set("cList", cList);
		//ҳ����ת
		return "addPageSuccess";
	}
	
	//���һ����������
	public String add(){
		
		categorySecondService.add(categorySecond); 
		return "addSuccess";
	}
	
	//ɾ��һ����������
	public String delete(){
		//��ѯ��������
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//��ת����������༭ҳ��
    public String editPage(){
    	//����CSID��ѯ��������
    	categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		// ��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		// ��������ʾҳ��������б���
		ActionContext.getContext().getValueStack().set("cList", cList);
		
    	return "editPage";
    }
    
    //�޸Ķ�������ķ���
    public String edit(){
    	
    	//���¶�������
    	categorySecondService.edit(categorySecond);
    	
    	return "editSuccess";
    }
    
}
