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
 * 后台二级分类管理的Action
 * @author zhangning
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
     //模型驱动使用驱动
	private CategorySecond categorySecond = new CategorySecond();
	
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//接收page
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}
	
	//注入一级分类的Service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
   //查询二级分类的方法
	public String findAll(){
		
	PageBean<CategorySecond> pageBean =	categorySecondService.findByPage(page);
	//将pageBean存入值栈中
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findSecondAll";
	}
	
	//跳转到添加的页面
	public String addPage(){
		//查询所有一级分类
		List<Category> cList = categoryService.findAll();
		//把数据显示页面的下拉列表中
		ActionContext.getContext().getValueStack().set("cList", cList);
		//页面跳转
		return "addPageSuccess";
	}
	
	//添加一个二级分类
	public String add(){
		
		categorySecondService.add(categorySecond); 
		return "addSuccess";
	}
	
	//删除一个二级分类
	public String delete(){
		//查询二级分类
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//跳转到二级分类编辑页面
    public String editPage(){
    	//根据CSID查询二级分类
    	categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		// 查询所有一级分类
		List<Category> cList = categoryService.findAll();
		// 把数据显示页面的下拉列表中
		ActionContext.getContext().getValueStack().set("cList", cList);
		
    	return "editPage";
    }
    
    //修改二级分类的方法
    public String edit(){
    	
    	//更新二级分类
    	categorySecondService.edit(categorySecond);
    	
    	return "editSuccess";
    }
    
}
