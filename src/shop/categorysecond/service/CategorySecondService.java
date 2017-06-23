package shop.categorysecond.service;

import java.util.List;

import shop.categorysecond.dao.CategorySecondDao;
import shop.categorysecond.entity.CategorySecond;
import shop.utils.PageBean;

/**
 * ���������ҵ������
 * @author zhangning
 *
 */
public class CategorySecondService {

	//ע���������dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	//ҵ����ҳ��ѯ��������ķ���
	public PageBean<CategorySecond> findByPage(int page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 6;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			
			totalPage = totalCount/limit;
		}else{
			
			totalPage = totalCount/limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		int begin = (page - 1)*limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ��㱣���������ķ���
	public void add(CategorySecond categorySecond) {
		categorySecondDao.add(categorySecond);	
	}

	//ҵ����ѯ��������
	public CategorySecond findByCsid(int csid) {
		return categorySecondDao.findByCsid(csid);
	}

	//ҵ���ɾ����������
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);		
	}

	//ҵ����޸Ķ�������
	public void edit(CategorySecond categorySecond) {
		categorySecondDao.edit(categorySecond);
	}

	//ҵ����ѯ���ж�������ķ���
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
