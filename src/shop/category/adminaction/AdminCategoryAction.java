package shop.category.adminaction;

import java.util.List;

import shop.category.entity.Category;
import shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台一级分类管理的Action
 * @author zhangning
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
 
	private Category category = new Category(); 
	
	public Category getModel() {
		return category;
	}
	
	//注入Service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//后台执行查询所有一级分类的方法：
	public String findAll(){
		
		//查询所有一级分类：
		List<Category> cList = categoryService.findAll();
		//将集合的数据显示在
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//后台添加一级分类的页面跳转
	public String addPage(){
		
		return "addPage";
	}
	
	//后台添加一级分类的方法
    public String add(){
    	//调用service进行保存
    	categoryService.add(category);
    	
    	return "addSuccess";
    }
    
    //后台删除一级分类的方法
    public String delete(){
    	//调用service
      category = categoryService.findByCid(category.getCid());
      
       categoryService.del(category);
    	
    	return "deleteSuccess";
    }
    
    
    
    //后台进入修改一级分类页面的方法
    public String editPage(){
    	//根据一级分类的管理查询一级分类
    	category =categoryService.findByCid(category.getCid());
    	//页面跳转
    	return "editPageSuccess";
    }

    //后台修改一级分类的方法
    public String edit(){
    	categoryService.edit(category);
    	return "editSuccess";
    }
}
