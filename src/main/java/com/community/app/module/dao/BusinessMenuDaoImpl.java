package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.vo.BusinessMenuQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessMenuDao")
@Transactional
public class BusinessMenuDaoImpl implements BusinessMenuDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessMenu findById(final Integer id) throws DaoException {
		BusinessMenu businessMenu = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessMenuDao.findById",id);
		return businessMenu;
	}
	
	/**
	 * 无条件查询所有BusinessMenu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessMenu> findAll() throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessMenu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessMenu> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessMenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessMenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessMenu> findByExample(final BusinessMenuQuery query) throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessMenu> findByExample(final BusinessMenuQuery query, final Integer limit) throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessMenu> findAllPage(final BusinessMenuQuery query) throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessMenuQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessMenuDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessMenu entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessMenuDao.save",entity);
	}

	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessMenu entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessMenuDao.update",entity);
	}

	/**
	 * 删除BusinessMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessMenuDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查找模块下的所有菜单
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessMenu> findMenuByModuleId(final Integer moduleId) throws DaoException {
		List<BusinessMenu> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessMenuDao.findMenuByModuleId",moduleId);
		return list;
	}
	
}
