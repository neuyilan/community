package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.vo.BusinessBreakAudioQuery;

@Repository("BusinessBreakAudioDao")
@Transactional
public class BusinessBreakAudioDaoImpl implements BusinessBreakAudioDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakAudio findById(final Integer id) throws DaoException {
		BusinessBreakAudio businessBreakAudio = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakAudioDao.findById",id);
		return businessBreakAudio;
	}
	
	/**
	 * 无条件查询所有BusinessBreakAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakAudio> findAll() throws DaoException {
		List<BusinessBreakAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBreakAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakAudio> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBreakAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBreakAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 根据爆料ID查询所有爆料的语音BusinessBreakAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakAudio> findAudioListByBreakId(final BusinessBreakAudioQuery query) throws DaoException {
		List<BusinessBreakAudio> list  = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findAudioListByBreakId",query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query) throws DaoException {
		List<BusinessBreakAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query, final Integer limit) throws DaoException {
		List<BusinessBreakAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakAudio> findAllPage(final BusinessBreakAudioQuery query) throws DaoException {
		List<BusinessBreakAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakAudioDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakAudioQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakAudioDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessBreakAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakAudio entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBreakAudioDao.save",entity);
	}

	/**
	 * 修改BusinessBreakAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakAudio entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBreakAudioDao.update",entity);
	}

	/**
	 * 删除BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBreakAudioDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
