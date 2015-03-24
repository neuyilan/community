package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessPrize;
import com.community.app.module.vo.BusinessPrizeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessPrizeDao")
@Transactional
public class BusinessPrizeDaoImpl implements BusinessPrizeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessPrize
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPrize findById(final Integer id) throws DaoException {
		BusinessPrize businessPrize = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPrizeDao.findById",id);
		return businessPrize;
	}
	
	/**
	 * 无条件查询所有BusinessPrize
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPrize> findAll() throws DaoException {
		List<BusinessPrize> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPrizeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessPrize
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPrize> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessPrize> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPrizeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPrize-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessPrize> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessPrize> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPrizeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessPrize
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPrize> findByExample(final BusinessPrizeQuery query) throws DaoException {
		List<BusinessPrize> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPrizeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPrize-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessPrize> findByExample(final BusinessPrizeQuery query, final Integer limit) throws DaoException {
		List<BusinessPrize> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPrizeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPrize> findAllPage(final BusinessPrizeQuery query) throws DaoException {
		List<BusinessPrize> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPrizeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPrizeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPrizeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessPrize数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPrize entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessPrizeDao.save",entity);
	}

	/**
	 * 修改BusinessPrize数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPrize entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessPrizeDao.update",entity);
	}

	/**
	 * 删除BusinessPrize
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessPrizeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
