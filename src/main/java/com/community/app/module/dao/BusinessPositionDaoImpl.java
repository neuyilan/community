package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.vo.BusinessPositionQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessPositionDao")
@Transactional
public class BusinessPositionDaoImpl implements BusinessPositionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessPosition
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPosition findById(final Integer id) throws DaoException {
		BusinessPosition businessPosition = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPositionDao.findById",id);
		return businessPosition;
	}
	
	/**
	 * 无条件查询所有BusinessPosition
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPosition> findAll() throws DaoException {
		List<BusinessPosition> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPositionDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessPosition
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPosition> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessPosition> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPositionDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPosition-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessPosition> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessPosition> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPositionDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessPosition
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPosition> findByExample(final BusinessPositionQuery query) throws DaoException {
		List<BusinessPosition> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPositionDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPosition-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessPosition> findByExample(final BusinessPositionQuery query, final Integer limit) throws DaoException {
		List<BusinessPosition> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPositionDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPosition> findAllPage(final BusinessPositionQuery query) throws DaoException {
		List<BusinessPosition> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPositionDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPositionQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPositionDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessPosition数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPosition entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessPositionDao.save",entity);
	}

	/**
	 * 修改BusinessPosition数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPosition entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessPositionDao.update",entity);
	}

	/**
	 * 删除BusinessPosition
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessPositionDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
