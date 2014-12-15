package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFeedbackAudio;
import com.community.app.module.vo.BusinessFeedbackAudioQuery;

@Repository("BusinessFeedbackAudioDao")
@Transactional
public class BusinessFeedbackAudioDaoImpl implements BusinessFeedbackAudioDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackAudio findById(final Integer id) throws DaoException {
		BusinessFeedbackAudio businessFeedbackAudio = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackAudioDao.findById",id);
		return businessFeedbackAudio;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackAudio> findAll() throws DaoException {
		List<BusinessFeedbackAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackAudioDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackAudio> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFeedbackAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackAudioDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFeedbackAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackAudioDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query) throws DaoException {
		List<BusinessFeedbackAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackAudioDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query, final Integer limit) throws DaoException {
		List<BusinessFeedbackAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackAudioDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackAudio> findAllPage(final BusinessFeedbackAudioQuery query) throws DaoException {
		List<BusinessFeedbackAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackAudioDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackAudioQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackAudioDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackAudio entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFeedbackAudioDao.save",entity);
	}

	/**
	 * 修改BusinessFeedbackAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackAudio entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFeedbackAudioDao.update",entity);
	}

	/**
	 * 删除BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFeedbackAudioDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
