package shop.category.adminaction;

import java.util.List;

import shop.category.entity.Category;
import shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨һ����������Action
 * @author zhangning
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
 
	private Category category = new Category(); 
	
	public Category getModel() {
		return category;
	}
	
	//ע��Service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//��ִ̨�в�ѯ����һ������ķ�����
	public String findAll(){
		
		//��ѯ����һ�����ࣺ
		List<Category> cList = categoryService.findAll();
		//�����ϵ�������ʾ��
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//��̨���һ�������ҳ����ת
	public String addPage(){
		
		return "addPage";
	}
	
	//��̨���һ������ķ���
    public String add(){
    	//����service���б���
    	categoryService.add(category);
    	
    	return "addSuccess";
    }
    
    //��̨ɾ��һ������ķ���
    public String delete(){
    	//����service
      category = categoryService.findByCid(category.getCid());
      
       categoryService.del(category);
    	
    	return "deleteSuccess";
    }
    
    
    
    //��̨�����޸�һ������ҳ��ķ���
    public String editPage(){
    	//����һ������Ĺ����ѯһ������
    	category =categoryService.findByCid(category.getCid());
    	//ҳ����ת
    	return "editPageSuccess";
    }

    //��̨�޸�һ������ķ���
    public String edit(){
    	categoryService.edit(category);
    	return "editSuccess";
    }
}
