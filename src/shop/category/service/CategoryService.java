package shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.category.dao.CategoryDao;
import shop.category.entity.Category;
import shop.categorysecond.entity.CategorySecond;


/**
 * 一级分类的业务层对象
 * @author zhangning
 *
 */
@Transactional
public class CategoryService {
	
	//注入categoryDAO
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	//后台添加一级分类
	public void add(Category category) {
		
		categoryDao.add(category);
	}

	//后台删除一级分类
	public void del(Category category) {
         
		categoryDao.del(category);
	}

	//根据ID查询一级分类
	public Category findByCid(int cid) {
		return categoryDao.findByCid(cid);
	}

	//业务层的修改一级分类的方法
	public  void edit(Category category) {
		categoryDao.edit(category);
	}



}
