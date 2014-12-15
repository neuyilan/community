package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessRepairAudio;
import com.community.app.module.vo.BusinessRepairAudioQuery;

@Repository("BusinessRepairAudioDao")
@Transactional
public class BusinessRepairAudioDaoImpl implements BusinessRepairAudioDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairAudio findById(final Integer id) throws DaoException {
		BusinessRepairAudio businessRepairAudio = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairAudioDao.findById",id);
		return businessRepairAudio;
	}
	
	/**
	 * 无条件查询所有BusinessRepairAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairAudio> findAll() throws DaoException {
		List<BusinessRepairAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairAudioDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRepairAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairAudio> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRepairAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairAudioDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRepairAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairAudioDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query) throws DaoException {
		List<BusinessRepairAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairAudioDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query, final Integer limit) throws DaoException {
		List<BusinessRepairAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairAudioDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairAudio> findAllPage(final BusinessRepairAudioQuery query) throws DaoException {
		List<BusinessRepairAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairAudioDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairAudioQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairAudioDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRepairAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairAudio entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairAudioDao.save",entity);
	}

	/**
	 * 修改BusinessRepairAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairAudio entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairAudioDao.update",entity);
	}

	/**
	 * 删除BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRepairAudioDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
