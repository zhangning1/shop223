package shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import shop.category.dao.CategoryDao;
import shop.category.entity.Category;
import shop.categorysecond.entity.CategorySecond;


/**
 * һ�������ҵ������
 * @author zhangning
 *
 */
@Transactional
public class CategoryService {
	
	//ע��categoryDAO
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	//��̨���һ������
	public void add(Category category) {
		
		categoryDao.add(category);
	}

	//��̨ɾ��һ������
	public void del(Category category) {
         
		categoryDao.del(category);
	}

	//����ID��ѯһ������
	public Category findByCid(int cid) {
		return categoryDao.findByCid(cid);
	}

	//ҵ�����޸�һ������ķ���
	public  void edit(Category category) {
		categoryDao.edit(category);
	}



}
