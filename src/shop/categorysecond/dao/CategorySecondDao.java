package shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import shop.categorysecond.entity.CategorySecond;
import shop.utils.PageHibernateCallback;


/**
 * ������������Dao�����
 * @author zhangning
 *
 */
public class CategorySecondDao extends HibernateDaoSupport{

	//Dao���ͳ�ƶ�������ĸ����ķ���
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//Dao���ҳ��ѯ��������ķ���
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list =this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	//DAO�����Ӷ�������ķ���
	public void add(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	//DAO���ѯ��������
	public CategorySecond findByCsid(int csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	//DAOɾ����������
	public void delete(CategorySecond categorySecond) {
          this.getHibernateTemplate().delete(categorySecond);		
	}

	//DAO���޸Ķ�������
	public void edit(CategorySecond categorySecond) {
        this.getHibernateTemplate().update(categorySecond);		
	}

	//DAO���ѯ���ж�������ķ���
	public List<CategorySecond> findAll() {
		String hql="from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}


}
