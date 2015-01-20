package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.vo.BusinessActivityCouponQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessActivityCouponDao")
@Transactional
public class BusinessActivityCouponDaoImpl implements BusinessActivityCouponDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityCoupon findById(final Integer id) throws DaoException {
		BusinessActivityCoupon businessActivityCoupon = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityCouponDao.findById",id);
		return businessActivityCoupon;
	}
	
	/**
	 * 无条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityCoupon> findAll() throws DaoException {
		List<BusinessActivityCoupon> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCouponDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityCoupon> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityCoupon> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCouponDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityCoupon> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityCoupon> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCouponDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query) throws DaoException {
		List<BusinessActivityCoupon> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCouponDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityCoupon> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCouponDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityCoupon> findAllPage(final BusinessActivityCouponQuery query) throws DaoException {
		List<BusinessActivityCoupon> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCouponDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityCouponQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityCouponDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityCoupon数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityCoupon entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityCouponDao.save",entity);
	}

	/**
	 * 修改BusinessActivityCoupon数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityCoupon entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityCouponDao.update",entity);
	}

	/**
	 * 删除BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityCouponDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}