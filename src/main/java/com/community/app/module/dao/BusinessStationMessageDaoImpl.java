package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStationMessage;
import com.community.app.module.vo.BusinessStationMessageQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessStationMessageDao")
@Transactional
public class BusinessStationMessageDaoImpl implements BusinessStationMessageDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 查询单个BusinessStationMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationMessage findById(final Integer id) throws DaoException {
		BusinessStationMessage businessStationMessage = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationMessageDao.findById",id);
		return businessStationMessage;
	}
	
	/**
	 * 无条件查询所有BusinessStationMessage
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationMessage> findAll() throws DaoException {
		List<BusinessStationMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationMessageDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessStationMessage
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationMessage> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessStationMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationMessageDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationMessage-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationMessage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessStationMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationMessageDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationMessage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query) throws DaoException {
		List<BusinessStationMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationMessageDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationMessage-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query, final Integer limit) throws DaoException {
		List<BusinessStationMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationMessageDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationMessage> findAllPage(final BusinessStationMessageQuery query) throws DaoException {
		List<BusinessStationMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationMessageDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationMessageQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationMessageDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessStationMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationMessage entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessStationMessageDao.save",entity);
	}

	/**
	 * 修改BusinessStationMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationMessage entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessStationMessageDao.update",entity);
	}

	/**
	 * 删除BusinessStationMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessStationMessageDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}