package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityMessage;
import com.community.app.module.vo.BusinessActivityMessageQuery;

@Repository("BusinessActivityMessageDao")
@Transactional
public class BusinessActivityMessageDaoImpl implements BusinessActivityMessageDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityMessage findById(final Integer id) throws DaoException {
		BusinessActivityMessage businessActivityMessage = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityMessageDao.findById",id);
		return businessActivityMessage;
	}
	
	/**
	 * 无条件查询所有BusinessActivityMessage
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessage> findAll() throws DaoException {
		List<BusinessActivityMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessageDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityMessage
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessage> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessageDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityMessage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessageDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query) throws DaoException {
		List<BusinessActivityMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessageDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessageDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessage> findAllPage(final BusinessActivityMessageQuery query) throws DaoException {
		List<BusinessActivityMessage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessageDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityMessageQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityMessageDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityMessage entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityMessageDao.save",entity);
	}

	/**
	 * 修改BusinessActivityMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityMessage entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityMessageDao.update",entity);
	}

	/**
	 * 删除BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityMessageDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
