package shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import shop.product.dao.ProductDao;
import shop.product.entity.Product;
import shop.utils.PageBean;

/**
 * ��Ʒҵ������
 * @author zhangning
 *
 */
@Transactional
public class ProductService {
    //ע��DAO
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	//��ҳ������Ʒ�Ĳ�ѯ
	public List<Product> findHot() {
		return productDao.findHot();
	}
	//��ҳ������Ʒ�Ĳ�ѯ
	public List<Product> findNew() {
		return productDao.findNew();
	}
     //������Ʒ��ID����ѯ
	public Product findByPid(int pid) {
		
		return productDao.findByPid(pid);
	}

	
	//����һ�������Cid���з�ҳ��ѯ��Ʒ
	public PageBean<Product> findByPageCid(int cid, int page) {
		
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 6;
		pageBean.setLimit(limit);
		
		//�����ܼ�¼����
		int totalCount = 0;
		totalCount	= productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			
			totalPage = totalCount / limit + 1;
			
		}
		pageBean.setTotalPage(totalPage);
		
		//ÿҳ��ʾ�����ݼ���
		int begin = (page - 1) * limit; //���Ŀ�ʼ
		List<Product> list = productDao.findByPageCid(cid,begin,limit);	
		pageBean.setList(list);
		return pageBean;
	}

	//���ݶ��������Csid���з�ҳ��ѯ��Ʒ
	public PageBean<Product> findByPageCsid(int csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 6;
		pageBean.setLimit(limit);
		
		//�����ܼ�¼����
		int totalCount = 0;
		totalCount	= productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			
			totalPage = totalCount / limit + 1;
			
		}
		pageBean.setTotalPage(totalPage);
		
		//ÿҳ��ʾ�����ݼ���
		int begin = (page - 1) * limit; //���Ŀ�ʼ
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);	
		pageBean.setList(list);
		return pageBean;
	}
	
	//ywy che  

	public PageBean<Product> findByPage(int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 6;
		pageBean.setLimit(limit);
		
		//�����ܼ�¼����
		int totalCount = 0;
		totalCount	= productDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			
			totalPage = totalCount / limit + 1;
			
		}
		pageBean.setTotalPage(totalPage);
		
		//ÿҳ��ʾ�����ݼ���
		int begin = (page - 1) * limit; //���Ŀ�ʼ
		List<Product> list = productDao.findByPage(begin,limit);	
		pageBean.setList(list);
		return pageBean;
	}

	//ҵ��������Ʒ
	public void save(Product product) {
		productDao.save(product);
	}

	//ҵ���ɾ����Ʒ�ķ���
	public void delete(Product product) {
		productDao.delete(product);
	}

	//ҵ����޸���Ʒ�ķ���
	public void edit(Product product) {
       productDao.edit(product);		
	}


}
