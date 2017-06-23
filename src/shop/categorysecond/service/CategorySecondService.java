package shop.categorysecond.service;

import java.util.List;

import shop.categorysecond.dao.CategorySecondDao;
import shop.categorysecond.entity.CategorySecond;
import shop.utils.PageBean;

/**
 * 二级分类的业务层的类
 * @author zhangning
 *
 */
public class CategorySecondService {

	//注入二级分类dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	//业务层分页查询二级分类的方法
	public PageBean<CategorySecond> findByPage(int page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 6;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			
			totalPage = totalCount/limit;
		}else{
			
			totalPage = totalCount/limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的数据集合
		int begin = (page - 1)*limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层保存二级分类的方达
	public void add(CategorySecond categorySecond) {
		categorySecondDao.add(categorySecond);	
	}

	//业务层查询二级分类
	public CategorySecond findByCsid(int csid) {
		return categorySecondDao.findByCsid(csid);
	}

	//业务层删除二级分类
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);		
	}

	//业务层修改二级分类
	public void edit(CategorySecond categorySecond) {
		categorySecondDao.edit(categorySecond);
	}

	//业务层查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
