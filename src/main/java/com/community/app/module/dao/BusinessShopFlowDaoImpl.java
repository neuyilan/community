package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessShopFlow;
import com.community.app.module.vo.BusinessShopFlowQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessShopFlowDao")
@Transactional
public class BusinessShopFlowDaoImpl implements BusinessShopFlowDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessShopFlow
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopFlow findById(final Integer id) throws DaoException {
		BusinessShopFlow businessShopFlow = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessShopFlowDao.findById",id);
		return businessShopFlow;
	}
	
	/**
	 * 无条件查询所有BusinessShopFlow
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopFlow> findAll() throws DaoException {
		List<BusinessShopFlow> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopFlowDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessShopFlow
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopFlow> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessShopFlow> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopFlowDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopFlow-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopFlow> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessShopFlow> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopFlowDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopFlow
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopFlow> findByExample(final BusinessShopFlowQuery query) throws DaoException {
		List<BusinessShopFlow> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopFlowDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopFlow-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopFlow> findByExample(final BusinessShopFlowQuery query, final Integer limit) throws DaoException {
		List<BusinessShopFlow> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopFlowDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopFlow> findAllPage(final BusinessShopFlowQuery query) throws DaoException {
		List<BusinessShopFlow> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopFlowDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopFlowQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessShopFlowDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessShopFlow数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopFlow entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessShopFlowDao.save",entity);
	}

	/**
	 * 修改BusinessShopFlow数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopFlow entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessShopFlowDao.update",entity);
	}

	/**
	 * 删除BusinessShopFlow
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessShopFlowDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
