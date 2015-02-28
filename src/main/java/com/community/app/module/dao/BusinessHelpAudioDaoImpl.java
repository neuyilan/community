package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.vo.BusinessHelpAudioQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessHelpAudioDao")
@Transactional
public class BusinessHelpAudioDaoImpl implements BusinessHelpAudioDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpAudio findById(final Integer id) throws DaoException {
		BusinessHelpAudio businessHelpAudio = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpAudioDao.findById",id);
		return businessHelpAudio;
	}
	
	/**
	 * 无条件查询所有BusinessHelpAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpAudio> findAll() throws DaoException {
		List<BusinessHelpAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpAudioDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpAudio> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpAudioDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpAudioDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query) throws DaoException {
		List<BusinessHelpAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpAudioDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpAudioDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpAudio> findAllPage(final BusinessHelpAudioQuery query) throws DaoException {
		List<BusinessHelpAudio> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpAudioDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpAudioQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpAudioDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpAudio entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpAudioDao.save",entity);
	}

	/**
	 * 修改BusinessHelpAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpAudio entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpAudioDao.update",entity);
	}

	/**
	 * 删除BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpAudioDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
