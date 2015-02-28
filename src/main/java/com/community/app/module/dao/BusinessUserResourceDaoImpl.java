package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.vo.BusinessUserResourceQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessUserResourceDao")
@Transactional
public class BusinessUserResourceDaoImpl implements BusinessUserResourceDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessUserResource
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserResource findById(final Integer id) throws DaoException {
		BusinessUserResource businessUserResource = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserResourceDao.findById",id);
		return businessUserResource;
	}
	
	/**
	 * 无条件查询所有BusinessUserResource
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserResource> findAll() throws DaoException {
		List<BusinessUserResource> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserResourceDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessUserResource
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserResource> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessUserResource> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserResourceDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserResource-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserResource> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessUserResource> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserResourceDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserResource
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query) throws DaoException {
		List<BusinessUserResource> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserResourceDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserResource-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query, final Integer limit) throws DaoException {
		List<BusinessUserResource> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserResourceDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserResource> findAllPage(final BusinessUserResourceQuery query) throws DaoException {
		List<BusinessUserResource> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserResourceDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserResourceQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserResourceDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessUserResource数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserResource entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessUserResourceDao.save",entity);
	}

	/**
	 * 修改BusinessUserResource数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserResource entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessUserResourceDao.update",entity);
	}

	/**
	 * 删除BusinessUserResource
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessUserResourceDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
    /**
     * 删除BusinessUserResource
     * @param id
     * @return
     * @throws DaoException
     */
    public boolean deleteByUserId(final Integer id) throws DaoException {
        int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessUserResourceDao.deleteByUserId",id);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
}
