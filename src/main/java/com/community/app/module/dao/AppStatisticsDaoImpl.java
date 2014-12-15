package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppStatistics;
import com.community.app.module.vo.AppStatisticsQuery;

@Repository("AppStatisticsDao")
@Transactional
public class AppStatisticsDaoImpl implements AppStatisticsDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppStatistics
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppStatistics findById(final Integer id) throws DaoException {
		AppStatistics appStatistics = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppStatisticsDao.findById",id);
		return appStatistics;
	}
	
	/**
	 * 无条件查询所有AppStatistics
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatistics> findAll() throws DaoException {
		List<AppStatistics> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppStatistics
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatistics> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppStatistics> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppStatistics-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppStatistics> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppStatistics> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppStatistics
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatistics> findByExample(final AppStatisticsQuery query) throws DaoException {
		List<AppStatistics> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppStatistics-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppStatistics> findByExample(final AppStatisticsQuery query, final Integer limit) throws DaoException {
		List<AppStatistics> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatistics> findAllPage(final AppStatisticsQuery query) throws DaoException {
		List<AppStatistics> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppStatisticsDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppStatisticsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppStatisticsDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppStatistics数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppStatistics entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppStatisticsDao.save",entity);
	}

	/**
	 * 修改AppStatistics数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppStatistics entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppStatisticsDao.update",entity);
	}

	/**
	 * 删除AppStatistics
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppStatisticsDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
