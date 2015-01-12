package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessShopGoods;
import com.community.app.module.vo.BusinessShopGoodsQuery;

@Repository("BusinessShopGoodsDao")
@Transactional
public class BusinessShopGoodsDaoImpl implements BusinessShopGoodsDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessShopGoods
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopGoods findById(final Integer id) throws DaoException {
		BusinessShopGoods businessShopGoods = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessShopGoodsDao.findById",id);
		return businessShopGoods;
	}
	
	/**
	 * 无条件查询所有BusinessShopGoods
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopGoods> findAll() throws DaoException {
		List<BusinessShopGoods> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopGoodsDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessShopGoods
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopGoods> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessShopGoods> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopGoodsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopGoods-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopGoods> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessShopGoods> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopGoodsDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopGoods
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopGoods> findByExample(final BusinessShopGoodsQuery query) throws DaoException {
		List<BusinessShopGoods> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopGoodsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopGoods-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessShopGoods> findByExample(final BusinessShopGoodsQuery query, final Integer limit) throws DaoException {
		List<BusinessShopGoods> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopGoodsDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopGoods> findAllPage(final BusinessShopGoodsQuery query) throws DaoException {
		List<BusinessShopGoods> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessShopGoodsDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopGoodsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessShopGoodsDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessShopGoods数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopGoods entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessShopGoodsDao.save",entity);
	}

	/**
	 * 修改BusinessShopGoods数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopGoods entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessShopGoodsDao.update",entity);
	}

	/**
	 * 删除BusinessShopGoods
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessShopGoodsDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
