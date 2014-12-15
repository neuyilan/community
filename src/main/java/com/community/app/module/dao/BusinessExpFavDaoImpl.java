package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.vo.BusinessExpFavQuery;

@Repository("BusinessExpFavDao")
@Transactional
public class BusinessExpFavDaoImpl implements BusinessExpFavDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessExpFav
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExpFav findById(final Integer id) throws DaoException {
		BusinessExpFav businessExpFav = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpFavDao.findById",id);
		return businessExpFav;
	}
	
	/**
	 * 无条件查询所有BusinessExpFav
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpFav> findAll() throws DaoException {
		List<BusinessExpFav> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpFavDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessExpFav
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpFav> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessExpFav> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpFavDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpFav-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessExpFav> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessExpFav> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpFavDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessExpFav
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query) throws DaoException {
		List<BusinessExpFav> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpFavDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpFav-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query, final Integer limit) throws DaoException {
		List<BusinessExpFav> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpFavDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpFav> findAllPage(final BusinessExpFavQuery query) throws DaoException {
		List<BusinessExpFav> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpFavDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpFavQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpFavDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessExpFav数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExpFav entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpFavDao.save",entity);
	}

	/**
	 * 修改BusinessExpFav数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExpFav entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessExpFavDao.update",entity);
	}

	/**
	 * 删除BusinessExpFav
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpFavDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
