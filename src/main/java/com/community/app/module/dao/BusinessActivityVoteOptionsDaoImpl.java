package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;

@Repository("BusinessActivityVoteOptionsDao")
@Transactional
public class BusinessActivityVoteOptionsDaoImpl implements BusinessActivityVoteOptionsDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityVoteOptions findById(final Integer id) throws DaoException {
		BusinessActivityVoteOptions businessActivityVoteOptions = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findById",id);
		return businessActivityVoteOptions;
	}
	
	/**
	 * 无条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteOptions> findAll() throws DaoException {
		List<BusinessActivityVoteOptions> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteOptions> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityVoteOptions> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityVoteOptions> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityVoteOptions> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query) throws DaoException {
		List<BusinessActivityVoteOptions> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityVoteOptions> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteOptions> findAllPage(final BusinessActivityVoteOptionsQuery query) throws DaoException {
		List<BusinessActivityVoteOptions> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteOptionsDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityVoteOptionsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityVoteOptionsDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityVoteOptions entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityVoteOptionsDao.save",entity);
	}

	/**
	 * 修改BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityVoteOptions entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityVoteOptionsDao.update",entity);
	}

	/**
	 * 删除BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityVoteOptionsDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
