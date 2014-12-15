package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.ManageExpressFee;
import com.community.app.module.vo.ManageExpressFeeQuery;

@Repository("ManageExpressFeeDao")
@Transactional
public class ManageExpressFeeDaoImpl implements ManageExpressFeeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageExpressFee
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpressFee findById(final Integer id) throws DaoException {
		ManageExpressFee manageExpressFee = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressFeeDao.findById",id);
		return manageExpressFee;
	}
	
	/**
	 * 无条件查询所有ManageExpressFee
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressFee> findAll() throws DaoException {
		List<ManageExpressFee> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressFeeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageExpressFee
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressFee> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageExpressFee> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressFeeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpressFee-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressFee> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageExpressFee> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressFeeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpressFee
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query) throws DaoException {
		List<ManageExpressFee> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressFeeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpressFee-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressFee> findByExample(final ManageExpressFeeQuery query, final Integer limit) throws DaoException {
		List<ManageExpressFee> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressFeeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressFee> findAllPage(final ManageExpressFeeQuery query) throws DaoException {
		List<ManageExpressFee> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressFeeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressFeeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressFeeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageExpressFee数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpressFee entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageExpressFeeDao.save",entity);
	}

	/**
	 * 修改ManageExpressFee数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpressFee entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageExpressFeeDao.update",entity);
	}

	/**
	 * 删除ManageExpressFee
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageExpressFeeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
