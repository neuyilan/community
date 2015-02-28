package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsRecommend;
import com.community.app.module.vo.BusinessNewsRecommendQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessNewsRecommendDao")
@Transactional
public class BusinessNewsRecommendDaoImpl implements BusinessNewsRecommendDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsRecommend findById(final Integer id) throws DaoException {
		BusinessNewsRecommend businessNewsRecommend = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsRecommendDao.findById",id);
		return businessNewsRecommend;
	}
	
	/**
	 * 无条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsRecommend> findAll() throws DaoException {
		List<BusinessNewsRecommend> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsRecommendDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsRecommend> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewsRecommend> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsRecommendDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsRecommend> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNewsRecommend> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsRecommendDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query) throws DaoException {
		List<BusinessNewsRecommend> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsRecommendDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query, final Integer limit) throws DaoException {
		List<BusinessNewsRecommend> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsRecommendDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsRecommend> findAllPage(final BusinessNewsRecommendQuery query) throws DaoException {
		List<BusinessNewsRecommend> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsRecommendDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsRecommendQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsRecommendDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessNewsRecommend数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsRecommend entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsRecommendDao.save",entity);
	}

	/**
	 * 修改BusinessNewsRecommend数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsRecommend entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsRecommendDao.update",entity);
	}

	/**
	 * 删除BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsRecommendDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
