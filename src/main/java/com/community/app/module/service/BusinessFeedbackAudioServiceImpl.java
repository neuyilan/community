package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFeedbackAudio;
import com.community.app.module.dao.BusinessFeedbackAudioDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackAudioQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessFeedbackAudioService")
@Transactional
public class BusinessFeedbackAudioServiceImpl implements BusinessFeedbackAudioService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFeedbackAudioServiceImpl.class);
	@Autowired
	private BusinessFeedbackAudioDao businessFeedbackAudioDao;

	/**
	 * 查询单个BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFeedbackAudio findById(final Integer id) throws ServiceException {
		BusinessFeedbackAudio businessFeedbackAudio = new BusinessFeedbackAudio();
		try {
			businessFeedbackAudio = businessFeedbackAudioDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findById()：查询单个BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
		return businessFeedbackAudio;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFeedbackAudio> findAll() throws ServiceException {
		List<BusinessFeedbackAudio> list = new ArrayList<BusinessFeedbackAudio>() ;
		try {
			list=businessFeedbackAudioDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findAll()：无条件查询所有BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackAudio> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFeedbackAudio> list = new ArrayList<BusinessFeedbackAudio>() ;
		try {
			list=businessFeedbackAudioDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackAudio> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFeedbackAudio> list = new ArrayList<BusinessFeedbackAudio>() ;
		try {
			list=businessFeedbackAudioDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackAudio-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query) throws ServiceException {
		List<BusinessFeedbackAudio> list = new ArrayList<BusinessFeedbackAudio>() ;
		try {
			list=businessFeedbackAudioDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query, final Integer limit) throws ServiceException {
		List<BusinessFeedbackAudio> list = new ArrayList<BusinessFeedbackAudio>() ;
		try {
			list=businessFeedbackAudioDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackAudio-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessFeedbackAudioQuery query) throws ServiceException {
		List<BusinessFeedbackAudio> list = new ArrayList<BusinessFeedbackAudio>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFeedbackAudioDao.findAllPage(query);
			count=businessFeedbackAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessFeedbackAudioQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFeedbackAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFeedbackAudio entity) throws ServiceException {
		try {
			businessFeedbackAudioDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl save()：保存BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFeedbackAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFeedbackAudio entity) throws ServiceException {
		try {
			businessFeedbackAudioDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl update()：修改BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFeedbackAudio
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFeedbackAudioDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackAudioServiceImpl delete()：删除BusinessFeedbackAudio发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
