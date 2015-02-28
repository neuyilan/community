package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.dao.BusinessBreakAudioDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakAudioQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessBreakAudioService")
@Transactional
public class BusinessBreakAudioServiceImpl implements BusinessBreakAudioService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBreakAudioServiceImpl.class);
	@Autowired
	private BusinessBreakAudioDao businessBreakAudioDao;

	/**
	 * 查询单个BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreakAudio findById(final Integer id) throws ServiceException {
		BusinessBreakAudio businessBreakAudio = new BusinessBreakAudio();
		try {
			businessBreakAudio = businessBreakAudioDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findById()：查询单个BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
		return businessBreakAudio;
	}
	
	/**
	 * 无条件查询所有BusinessBreakAudio
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakAudio> findAll() throws ServiceException {
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		try {
			list=businessBreakAudioDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findAll()：无条件查询所有BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakAudio
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakAudio> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		try {
			list=businessBreakAudioDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakAudio> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		try {
			list=businessBreakAudioDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakAudio-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreakAudio
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query) throws ServiceException {
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		try {
			list=businessBreakAudioDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query, final Integer limit) throws ServiceException {
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		try {
			list=businessBreakAudioDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakAudio-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据爆料ID查询所有爆料的语音BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakAudio> findAudioListByBreakId(final Integer id) throws ServiceException {
		BusinessBreakAudioQuery query = new BusinessBreakAudioQuery();
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		query.setBreakId(id);
		try {
			list = businessBreakAudioDao.findAudioListByBreakId(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findAudioListByBreakId()：根据爆料ID查询所有爆料的语音BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessBreakAudioQuery query) throws ServiceException {
		List<BusinessBreakAudio> list = new ArrayList<BusinessBreakAudio>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBreakAudioDao.findAllPage(query);
			count=businessBreakAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessBreakAudioQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBreakAudioDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBreakAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBreakAudio entity) throws ServiceException {
		try {
			businessBreakAudioDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl save()：保存BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessBreakAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBreakAudio entity) throws ServiceException {
		try {
			businessBreakAudioDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl update()：修改BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBreakAudio
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBreakAudioDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakAudioServiceImpl delete()：删除BusinessBreakAudio发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
