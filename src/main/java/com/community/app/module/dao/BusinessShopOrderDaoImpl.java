package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessShopOrder;
import com.community.app.module.vo.BusinessShopOrderQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessShopOrderDao")
@Transactional
public class BusinessShopOrderDaoImpl implements BusinessShopOrderDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessShopOrder
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopOrder findById(final Integer id) throws DaoException {
		BusinessShopOrder businessShopOrder = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessShopOrderDao.findById",id);
		return businessShopOrder;
	}
	
	/**
	 * 无条件查询所有BusinessShopOrder
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopOrder> findAll() throws DaoException {
		List<BusinessShopOrder> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopOrderDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessShopOrder
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopOrder> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessShopOrder> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopOrderDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopOrder-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopOrder> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessShopOrder> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopOrderDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopOrder
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query) throws DaoException {
		List<BusinessShopOrder> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopOrderDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopOrder-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query, final Integer limit) throws DaoException {
		List<BusinessShopOrder> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopOrderDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopOrder> findAllPage(final BusinessShopOrderQuery query) throws DaoException {
		List<BusinessShopOrder> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopOrderDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopOrderQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessShopOrderDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessShopOrder数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopOrder entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessShopOrderDao.save",entity);
	}

	/**
	 * 修改BusinessShopOrder数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopOrder entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessShopOrderDao.update",entity);
	}

	/**
	 * 删除BusinessShopOrder
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessShopOrderDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
