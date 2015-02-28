package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRepairAudio;
import com.community.app.module.dao.BusinessRepairAudioDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairAudioQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessRepairAudioService")
@Transactional
public class BusinessRepairAudioServiceImpl implements BusinessRepairAudioService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRepairAudioServiceImpl.class);
	@Autowired
	private BusinessRepairAudioDao businessRepairAudioDao;

	/**
	 * 查询单个BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRepairAudio findById(final Integer id) throws ServiceException {
		BusinessRepairAudio businessRepairAudio = new BusinessRepairAudio();
		try {
			businessRepairAudio = businessRepairAudioDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findById()：查询单个BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
		return businessRepairAudio;
	}
	
	/**
	 * 无条件查询所有BusinessRepairAudio
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRepairAudio> findAll() throws ServiceException {
		List<BusinessRepairAudio> list = new ArrayList<BusinessRepairAudio>() ;
		try {
			list=businessRepairAudioDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findAll()：无条件查询所有BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairAudio
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairAudio> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRepairAudio> list = new ArrayList<BusinessRepairAudio>() ;
		try {
			list=businessRepairAudioDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairAudio> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRepairAudio> list = new ArrayList<BusinessRepairAudio>() ;
		try {
			list=businessRepairAudioDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairAudio-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairAudio
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query) throws ServiceException {
		List<BusinessRepairAudio> list = new ArrayList<BusinessRepairAudio>() ;
		try {
			list=businessRepairAudioDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query, final Integer limit) throws ServiceException {
		List<BusinessRepairAudio> list = new ArrayList<BusinessRepairAudio>() ;
		try {
			list=businessRepairAudioDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairAudio-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRepairAudioQuery query) throws ServiceException {
		List<BusinessRepairAudio> list = new ArrayList<BusinessRepairAudio>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRepairAudioDao.findAllPage(query);
			count=businessRepairAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRepairAudioQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRepairAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRepairAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRepairAudio entity) throws ServiceException {
		try {
			businessRepairAudioDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl save()：保存BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRepairAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRepairAudio entity) throws ServiceException {
		try {
			businessRepairAudioDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl update()：修改BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRepairAudio
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRepairAudioDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairAudioServiceImpl delete()：删除BusinessRepairAudio发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
