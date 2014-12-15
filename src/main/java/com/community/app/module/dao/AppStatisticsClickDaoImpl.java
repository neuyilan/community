package com.community.app.module.dao;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.vo.AppStatisticsClickQuery;
import com.community.framework.exception.DaoException;

@Repository("AppStatisticsClickDao")
@Transactional
public class AppStatisticsClickDaoImpl implements AppStatisticsClickDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppStatisticsClick
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppStatisticsClick findById(final Integer id) throws DaoException {
		AppStatisticsClick appStatisticsClick = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppStatisticsClickDao.findById",id);
		return appStatisticsClick;
	}
	
	/**
	 * 无条件查询所有AppStatisticsClick
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatisticsClick> findAll() throws DaoException {
		List<AppStatisticsClick> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsClickDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppStatisticsClick
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatisticsClick> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppStatisticsClick> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsClickDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppStatisticsClick-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppStatisticsClick> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppStatisticsClick> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsClickDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppStatisticsClick
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query) throws DaoException {
		List<AppStatisticsClick> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsClickDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppStatisticsClick-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query, final Integer limit) throws DaoException {
		List<AppStatisticsClick> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsClickDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatisticsClick> findAllPage(final AppStatisticsClickQuery query) throws DaoException {
		List<AppStatisticsClick> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsClickDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppStatisticsClickQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppStatisticsClickDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppStatisticsClick数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppStatisticsClick entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppStatisticsClickDao.save",entity);
	}

	/**
	 * 修改AppStatisticsClick数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppStatisticsClick entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppStatisticsClickDao.update",entity);
	}

	/**
	 * 删除AppStatisticsClick
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppStatisticsClickDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
