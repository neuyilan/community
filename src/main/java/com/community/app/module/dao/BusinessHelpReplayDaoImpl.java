package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpReplay;
import com.community.app.module.vo.BusinessHelpReplayQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessHelpReplayDao")
@Transactional
public class BusinessHelpReplayDaoImpl implements BusinessHelpReplayDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpReplay findById(final Integer id) throws DaoException {
		BusinessHelpReplay businessHelpReplay = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpReplayDao.findById",id);
		return businessHelpReplay;
	}
	
	/**
	 * 无条件查询所有BusinessHelpReplay
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpReplay> findAll() throws DaoException {
		List<BusinessHelpReplay> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpReplayDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpReplay
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpReplay> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpReplay> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpReplayDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpReplay> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpReplay> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpReplayDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpReplay
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query) throws DaoException {
		List<BusinessHelpReplay> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpReplayDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpReplay> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpReplayDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpReplay> findAllPage(final BusinessHelpReplayQuery query) throws DaoException {
		List<BusinessHelpReplay> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpReplayDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpReplayQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpReplayDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpReplay数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpReplay entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpReplayDao.save",entity);
	}

	/**
	 * 修改BusinessHelpReplay数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpReplay entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpReplayDao.update",entity);
	}

	/**
	 * 删除BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpReplayDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
