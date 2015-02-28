package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageExpress;
import com.community.app.module.vo.ManageExpressQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("ManageExpressDao")
@Transactional
public class ManageExpressDaoImpl implements ManageExpressDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpress findById(final Integer id) throws DaoException {
		ManageExpress manageExpress = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressDao.findById",id);
		return manageExpress;
	}
	
	/**
	 * 无条件查询所有ManageExpress
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAll() throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageExpress
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByExample(final ManageExpressQuery query) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByExample_app(final ManageExpressQuery query) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findByExample_app", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageExpress> findByExample(final ManageExpressQuery query, final Integer limit) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAllPage(final ManageExpressQuery query) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAllPage_app(final ManageExpressQuery query) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final ManageExpressQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存ManageExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpress entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageExpressDao.save",entity);
	}

	/**
	 * 修改ManageExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpress entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageExpressDao.update",entity);
	}

	/**
	 * 删除ManageExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageExpressDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 按驿站查找快递公司
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findExpressByStation(final Integer stationId) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressDao.findExpressByStation", stationId);
		return list;
	}
}
