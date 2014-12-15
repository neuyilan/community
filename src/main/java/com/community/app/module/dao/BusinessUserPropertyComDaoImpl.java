package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessUserPropertyCom;
import com.community.app.module.vo.BusinessUserPropertyComQuery;

@Repository("BusinessUserPropertyComDao")
@Transactional
public class BusinessUserPropertyComDaoImpl implements BusinessUserPropertyComDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserPropertyCom findById(final Integer id) throws DaoException {
		BusinessUserPropertyCom businessUserPropertyCom = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserPropertyComDao.findById",id);
		return businessUserPropertyCom;
	}
	
	/**
	 * 无条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserPropertyCom> findAll() throws DaoException {
		List<BusinessUserPropertyCom> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserPropertyComDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserPropertyCom> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessUserPropertyCom> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserPropertyComDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserPropertyCom> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessUserPropertyCom> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserPropertyComDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query) throws DaoException {
		List<BusinessUserPropertyCom> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserPropertyComDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query, final Integer limit) throws DaoException {
		List<BusinessUserPropertyCom> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserPropertyComDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserPropertyCom> findAllPage(final BusinessUserPropertyComQuery query) throws DaoException {
		List<BusinessUserPropertyCom> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserPropertyComDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserPropertyComQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserPropertyComDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessUserPropertyCom数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserPropertyCom entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessUserPropertyComDao.save",entity);
	}

	/**
	 * 修改BusinessUserPropertyCom数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserPropertyCom entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessUserPropertyComDao.update",entity);
	}

	/**
	 * 删除BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessUserPropertyComDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

    /**
     * 查询互动记录
     * @param query
     * @return
     * @throws DaoException
     */
    public List<BusinessUserPropertyCom> getChatInfo(final BusinessUserPropertyComQuery query) throws DaoException {
        return sqlSessionTemplate.selectList("getChatInfo", query);
    }
}
