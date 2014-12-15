package com.community.app.module.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppPartyAddress;
import com.community.app.module.vo.AppPartyAddressQuery;

@Repository("AppPartyAddressDao")
@Transactional
public class AppPartyAddressDaoImpl implements AppPartyAddressDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppPartyAddress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppPartyAddress findById(final Integer id) throws DaoException {
		AppPartyAddress appPartyAddress = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppPartyAddressDao.findById",id);
		return appPartyAddress;
	}
	
	/**
	 * 无条件查询所有AppPartyAddress
	 * @return
	 * @throws DaoException
	 */
	public List<AppPartyAddress> findAll() throws DaoException {
		List<AppPartyAddress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPartyAddressDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppPartyAddress
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppPartyAddress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPartyAddressDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppPartyAddress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppPartyAddress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPartyAddressDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppPartyAddress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query) throws DaoException {
		List<AppPartyAddress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPartyAddressDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppPartyAddress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query, final Integer limit) throws DaoException {
		List<AppPartyAddress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPartyAddressDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppPartyAddress> findAllPage(final AppPartyAddressQuery query) throws DaoException {
		List<AppPartyAddress> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPartyAddressDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppPartyAddressQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppPartyAddressDao.selectCount",query);
		return count;
	}
	
	/**
	 * service
	 * 保存AppPartyAddress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppPartyAddressQuery entity) throws DaoException {
		AppPartyAddress AppPartyAddress = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppPartyAddressDao.getAddress",entity);
		entity.setAddress(AppPartyAddress.getAddress());
		entity.setAddress(AppPartyAddress.getAddress()+entity.getHouseCode());
		entity.setName(entity.getRealname());
		entity.setTel(entity.getTel());
		Timestamp  ts=new Timestamp(new Date().getTime());
		entity.setCreateTime(ts);
		entity.setEditTime(ts);
		entity.setUserId(entity.getUserId());
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppPartyAddressDao.save",entity);
	}

	/**
	 * 修改AppPartyAddress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppPartyAddressQuery entity) throws DaoException {
		AppPartyAddress AppPartyAddress = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppPartyAddressDao.getAddress",entity);
		entity.setAddress(AppPartyAddress.getAddress()+entity.getHouseCode());
		entity.setName(entity.getRealname());
		entity.setTel(entity.getTel());
		Timestamp  ts=new Timestamp(new Date().getTime());
		entity.setEditTime(ts);
		entity.setPartyAddressId(entity.getAddrId());
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppPartyAddressDao.update",entity);
	}

	/**
	 * 删除AppPartyAddress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppPartyAddressDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * service
	 * 设置默认收货地址
	 * @param entity
	 * @throws ServiceException
	 */
	public void setDefault(final AppPartyAddressQuery entity) throws DaoException{
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppPartyAddressDao.cancelDefault",entity);
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppPartyAddressDao.setDefault",entity);
	}
	
}
