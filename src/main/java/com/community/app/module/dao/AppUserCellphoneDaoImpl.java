package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppUserCellphone;
import com.community.app.module.vo.AppUserCellphoneQuery;

@Repository("AppUserCellphoneDao")
@Transactional
public class AppUserCellphoneDaoImpl implements AppUserCellphoneDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppUserCellphone
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserCellphone findById(final Integer id) throws DaoException {
		AppUserCellphone appUserCellphone = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserCellphoneDao.findById",id);
		return appUserCellphone;
	}
	
	/**
	 * 无条件查询所有AppUserCellphone
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserCellphone> findAll() throws DaoException {
		List<AppUserCellphone> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserCellphoneDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppUserCellphone
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppUserCellphone> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserCellphoneDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserCellphone-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppUserCellphone> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserCellphoneDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserCellphone
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query) throws DaoException {
		List<AppUserCellphone> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserCellphoneDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserCellphone-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query, final Integer limit) throws DaoException {
		List<AppUserCellphone> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserCellphoneDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserCellphone> findAllPage(final AppUserCellphoneQuery query) throws DaoException {
		List<AppUserCellphone> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserCellphoneDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserCellphoneQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserCellphoneDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppUserCellphone数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppUserCellphone entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserCellphoneDao.save",entity);
	}

	/**
	 * 修改AppUserCellphone数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUserCellphone entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserCellphoneDao.update",entity);
	}

	/**
	 * 删除AppUserCellphone
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppUserCellphoneDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
