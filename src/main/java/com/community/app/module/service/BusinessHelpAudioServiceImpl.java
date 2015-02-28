package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.dao.BusinessHelpAudioDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpAudioQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessHelpAudioService")
@Transactional
public class BusinessHelpAudioServiceImpl implements BusinessHelpAudioService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpAudioServiceImpl.class);
	@Autowired
	private BusinessHelpAudioDao businessHelpAudioDao;

	/**
	 * 查询单个BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpAudio findById(final Integer id) throws ServiceException {
		BusinessHelpAudio businessHelpAudio = new BusinessHelpAudio();
		try {
			businessHelpAudio = businessHelpAudioDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findById()：查询单个BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpAudio;
	}
	
	/**
	 * 无条件查询所有BusinessHelpAudio
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpAudio> findAll() throws ServiceException {
		List<BusinessHelpAudio> list = new ArrayList<BusinessHelpAudio>() ;
		try {
			list=businessHelpAudioDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findAll()：无条件查询所有BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpAudio
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpAudio> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpAudio> list = new ArrayList<BusinessHelpAudio>() ;
		try {
			list=businessHelpAudioDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpAudio> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpAudio> list = new ArrayList<BusinessHelpAudio>() ;
		try {
			list=businessHelpAudioDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpAudio-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpAudio
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query) throws ServiceException {
		List<BusinessHelpAudio> list = new ArrayList<BusinessHelpAudio>() ;
		try {
			list=businessHelpAudioDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpAudio> list = new ArrayList<BusinessHelpAudio>() ;
		try {
			list=businessHelpAudioDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpAudio-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpAudioQuery query) throws ServiceException {
		List<BusinessHelpAudio> list = new ArrayList<BusinessHelpAudio>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpAudioDao.findAllPage(query);
			count=businessHelpAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpAudioQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpAudio entity) throws ServiceException {
		try {
			businessHelpAudioDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl save()：保存BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelpAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpAudio entity) throws ServiceException {
		try {
			businessHelpAudioDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl update()：修改BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpAudio
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpAudioDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpAudioServiceImpl delete()：删除BusinessHelpAudio发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
