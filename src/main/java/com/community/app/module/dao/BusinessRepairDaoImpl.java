package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRepair;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.vo.BusinessRepairQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessRepairDao")
@Transactional
public class BusinessRepairDaoImpl implements BusinessRepairDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepair findById(final Integer id) throws DaoException {
		BusinessRepair businessRepair = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairDao.findById",id);
		return businessRepair;
	}
	
	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepair findById_app(final Integer id) throws DaoException {
		BusinessRepair businessRepair = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairDao.findById_app",id);
		return businessRepair;
	}

    /**
     * 获取手机用户信息
     * @param id
     * @return
     * @throws DaoException
     */
    public MemberVO findAppUserById(final Integer id) throws DaoException {
        MemberVO  businessRepair = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairDao.findAppUserById",id);
        return businessRepair;
    }
	
	/**
	 * 无条件查询所有BusinessRepair
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepair> findAll() throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRepair
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepair> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepair-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepair> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepair
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepair> findByExample(final BusinessRepairQuery query) throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepair-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepair> findByExample(final BusinessRepairQuery query, final Integer limit) throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepair> findAllPage(final BusinessRepairQuery query) throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepair> findAllPage_app(final BusinessRepairQuery query) throws DaoException {
		List<BusinessRepair> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessRepairQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessRepair数据
	 * @param entity
	 * @return 
	 * @throws DaoException
	 */
	public BusinessRepair save(final BusinessRepair entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairDao.save",entity);
		return entity;
	}

	/**
	 * 修改BusinessRepair数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepair entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairDao.update",entity);
	}
	
	/**
	 * 修改BusinessRepair数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessRepair entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairDao.update_app",entity);
	}

	/**
	 * 删除BusinessRepair
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRepairDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
