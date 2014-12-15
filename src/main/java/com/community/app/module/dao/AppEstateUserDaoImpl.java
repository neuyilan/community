package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.bean.AppUser;
import com.community.app.module.vo.AppEstateUserQuery;

@Repository("AppEstateUserDao")
@Transactional
public class AppEstateUserDaoImpl implements AppEstateUserDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppEstateUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppEstateUser findById(final Integer id) throws DaoException {
		AppEstateUser appEstateUser = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppEstateUserDao.findById",id);
		return appEstateUser;
	}
	
	/**
	 * 无条件查询所有AppEstateUser
	 * @return
	 * @throws DaoException
	 */
	public List<AppEstateUser> findAll() throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppEstateUser
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppEstateUser-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByExample_app(final AppEstateUserQuery query) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findByExample_app", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppEstateUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query, final Integer limit) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppEstateUser> findAllPage(final AppEstateUserQuery query) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppEstateUserQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppEstateUserDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppEstateUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppEstateUser entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppEstateUserDao.save",entity);
	}

	/**s
	 * 修改AppEstateUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public AppEstateUser update(final AppEstateUser entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppEstateUserDao.update",entity);
		AppEstateUser appEstateUser = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppEstateUserDao.findById",entity);
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppEstateUserDao.update",appEstateUser);
		AppUser appUser  = new AppUser();
		appUser.setUserId(entity.getUserId());
		if(appEstateUser.getUnitId()==0){
			appUser.setAddress(appEstateUser.getEstateName()+appEstateUser.getBuildingName()+"号楼"+entity.getHouseNo());
		}else {
			appUser.setAddress(appEstateUser.getEstateName()+appEstateUser.getBuildingName()+"号楼"+appEstateUser.getUnitName()+"单元"+entity.getHouseNo());
		}
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserDao.update",appUser);
		return appEstateUser;
	}

	/**
	 * 删除AppEstateUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppEstateUserDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据userId获取小区列表
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByUserId(final AppEstateUserQuery query) throws DaoException {
		List<AppEstateUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppEstateUserDao.findByUserId", query);
		return list;
	}
	
}
