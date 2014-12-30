package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageSendMsg;
import com.community.app.module.vo.ManageSendMsgQuery;
import com.community.framework.exception.DaoException;

@Repository("ManageSendMsgDao")
@Transactional
public class ManageSendMsgDaoImpl implements ManageSendMsgDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageSendMsg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageSendMsg findById(final Integer id) throws DaoException {
		ManageSendMsg manageSendMsg = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageSendMsgDao.findById",id);
		return manageSendMsg;
	}
	
	/**
	 * 无条件查询所有ManageSendMsg
	 * @return
	 * @throws DaoException
	 */
	public List<ManageSendMsg> findAll() throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageSendMsgDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageSendMsg
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageSendMsgDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageSendMsgDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageSendMsgDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query, final Integer limit) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageSendMsgDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageSendMsg> findAllPage(final ManageSendMsgQuery query) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageSendMsgDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageSendMsgQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageSendMsgDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageSendMsg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageSendMsg entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageSendMsgDao.save",entity);
	}

	/**
	 * 修改ManageSendMsg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageSendMsg entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageSendMsgDao.update",entity);
	}

	/**
	 * 删除ManageSendMsg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageSendMsgDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
