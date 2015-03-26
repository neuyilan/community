package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.vo.BusinessActRegQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessActRegDao")
@Transactional
public class BusinessActRegDaoImpl implements BusinessActRegDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActReg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActReg findById(final Integer id) throws DaoException {
		BusinessActReg businessActReg = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActRegDao.findById",id);
		return businessActReg;
	}
	
	/**
	 * 无条件查询所有BusinessActReg
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActReg> findAll() throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActReg
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActReg> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActReg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActReg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActReg> findByExample(final BusinessActRegQuery query) throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActReg> findById_app(final BusinessActRegQuery query) throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findById_app", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActReg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActReg> findByExample(final BusinessActRegQuery query, final Integer limit) throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActReg> findAllPage(final BusinessActRegQuery query) throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActRegQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActRegDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActReg数据
	 * @param entity
	 * @throws DaoException
	 */
	public int save(final BusinessActReg entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActRegDao.save",entity);
		return count;
	}

	/**
	 * 修改BusinessActReg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActReg entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActRegDao.update",entity);
	}

	/**
	 * 删除BusinessActReg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActRegDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	public int cntFront(Map<String, Object> map) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActRegDao.cntFront",map);
		return count;
	}

	public void updateCode(Map<String, Object> map) throws DaoException {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActRegDao.updateCode",map);

	}

	/**
	 * 查询报名排名
	 * @param map
	 * @return
	 */
	public List<BusinessActReg> findRankPage(BusinessActRegQuery query)
			throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findRankPage",query);
		return list;
	}
	/**
	 * 获取最新报名
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActReg> findLatestRegPage(BusinessActRegQuery query)
			throws DaoException {
		List<BusinessActReg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActRegDao.findLatestRegPage",query);
		return list;
	}
}
