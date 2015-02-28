package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.vo.BusinessBreakQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessBreakDao")
@Transactional
public class BusinessBreakDaoImpl implements BusinessBreakDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreak findById(final Integer id) throws DaoException {
		BusinessBreak businessBreak = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakDao.findById",id);
		return businessBreak;
	}
	
	/**
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreak findById_app(final Integer id) throws DaoException {
		BusinessBreak businessBreak = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakDao.findById_app",id);
		return businessBreak;
	}
	
	/**
	 * 根据爆料ID获取爆料人基本信息及爆料内容
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreak checkBreakDetail(final Integer id) throws DaoException {
		BusinessBreak businessBreak = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakDao.checkBreakDetail",id);
		return businessBreak;
	}
	
	/**
	 * 无条件查询所有BusinessBreak
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreak> findAll() throws DaoException {
		List<BusinessBreak> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBreak
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreak> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBreak> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreak-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreak> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBreak> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreak
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreak> findByExample(final BusinessBreakQuery query) throws DaoException {
		List<BusinessBreak> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreak-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreak> findByExample(final BusinessBreakQuery query, final Integer limit) throws DaoException {
		List<BusinessBreak> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreak> findAllPage(final BusinessBreakQuery query) throws DaoException {
		List<BusinessBreak> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessBreak数据
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessBreak save(final BusinessBreak entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBreakDao.save",entity);
		return entity;
	}

	/**
	 * 修改BusinessBreak数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreak entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBreakDao.update",entity);
	}

	/**
	 * 修改BusinessBreak回复数据
	 * @param entity
	 * @throws DaoException
	 */
	public void updateComments(final BusinessBreak entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBreakDao.updateComments",entity);
	}
	
	/**
	 * 删除BusinessBreak
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBreakDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据用户id获取用户未被选中爆料的列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakQuery> getByUserId(final BusinessBreakQuery query) throws DaoException{
		List<BusinessBreakQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakDao.getByUserId",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int getByUserId_Count(final BusinessBreakQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakDao.getByUserId_Count",query);
		return count;
	}
	
}
