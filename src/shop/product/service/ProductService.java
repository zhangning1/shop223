package shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import shop.product.dao.ProductDao;
import shop.product.entity.Product;
import shop.utils.PageBean;

/**
 * 商品业务层代码
 * @author zhangning
 *
 */
@Transactional
public class ProductService {
    //注入DAO
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	//首页最热商品的查询
	public List<Product> findHot() {
		return productDao.findHot();
	}
	//首页最新商品的查询
	public List<Product> findNew() {
		return productDao.findNew();
	}
     //根据商品的ID来查询
	public Product findByPid(int pid) {
		
		return productDao.findByPid(pid);
	}

	
	//根据一级分类的Cid带有分页查询商品
	public PageBean<Product> findByPageCid(int cid, int page) {
		
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		
		//设置每页显示的记录数
		int limit = 6;
		pageBean.setLimit(limit);
		
		//设置总记录数：
		int totalCount = 0;
		totalCount	= productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		//Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			
			totalPage = totalCount / limit + 1;
			
		}
		pageBean.setTotalPage(totalPage);
		
		//每页显示的数据集合
		int begin = (page - 1) * limit; //从哪开始
		List<Product> list = productDao.findByPageCid(cid,begin,limit);	
		pageBean.setList(list);
		return pageBean;
	}

	//根据二级分类的Csid带有分页查询商品
	public PageBean<Product> findByPageCsid(int csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		
		//设置每页显示的记录数
		int limit = 6;
		pageBean.setLimit(limit);
		
		//设置总记录数：
		int totalCount = 0;
		totalCount	= productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		//Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			
			totalPage = totalCount / limit + 1;
			
		}
		pageBean.setTotalPage(totalPage);
		
		//每页显示的数据集合
		int begin = (page - 1) * limit; //从哪开始
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);	
		pageBean.setList(list);
		return pageBean;
	}
	
	//ywy che  

	public PageBean<Product> findByPage(int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		
		//设置每页显示的记录数
		int limit = 6;
		pageBean.setLimit(limit);
		
		//设置总记录数：
		int totalCount = 0;
		totalCount	= productDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage = 0;
		//Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			
			totalPage = totalCount / limit + 1;
			
		}
		pageBean.setTotalPage(totalPage);
		
		//每页显示的数据集合
		int begin = (page - 1) * limit; //从哪开始
		List<Product> list = productDao.findByPage(begin,limit);	
		pageBean.setList(list);
		return pageBean;
	}

	//业务层添加商品
	public void save(Product product) {
		productDao.save(product);
	}

	//业务层删除商品的方法
	public void delete(Product product) {
		productDao.delete(product);
	}

	//业务层修改商品的方法
	public void edit(Product product) {
       productDao.edit(product);		
	}


}
