package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.community.app.module.vo.BusinessHelpQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.dao.AppLatestNewsDao;
import com.community.app.module.dao.BusinessHelpAudioDao;
import com.community.app.module.dao.BusinessHelpDao;
import com.community.app.module.dao.BusinessHelpPicDao;

@Service("BusinessHelpService")
@Transactional
public class BusinessHelpServiceImpl implements BusinessHelpService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpServiceImpl.class);
	@Autowired
	private BusinessHelpDao businessHelpDao;
	@Autowired
	private BusinessHelpPicDao businessHelpPicDao;
	@Autowired
	private BusinessHelpAudioDao businessHelpAudioDao;
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;
	
	

	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelp findById(final Integer id) throws ServiceException {
		BusinessHelp businessHelp = new BusinessHelp();
		try {
			businessHelp = businessHelpDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findById()：查询单个BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
		return businessHelp;
	}
	
	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public BusinessHelp findById_app(final Integer id) throws ServiceException {
		BusinessHelp businessHelp = new BusinessHelp();
		try {
			businessHelp = businessHelpDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findById()：查询单个BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
		return businessHelp;
	}
	
	/**
	 * 无条件查询所有BusinessHelp
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelp> findAll() throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		try {
			list=businessHelpDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findAll()：无条件查询所有BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelp
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelp> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		try {
			list=businessHelpDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findByMap()：按Map对象条件查询所有BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelp-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelp> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		try {
			list=businessHelpDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findByMap()：按Map对象条件查询所有BusinessHelp-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelp
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelp> findByExample(final BusinessHelpQuery query) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		try {
			list=businessHelpDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findByExample()：按VO对象条件查询所有BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelp-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelp> findByExample(final BusinessHelpQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		try {
			list=businessHelpDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findByExample()：按VO对象条件查询所有BusinessHelp-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpQuery query) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessHelpDao.selectCount(query);
			query.setCount(count);
			list=businessHelpDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessHelpQuery query) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpDao.findAllPage_app(query);
			count=businessHelpDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage1(final BusinessHelpQuery query) throws ServiceException {
		List<BusinessHelp> list = new ArrayList<BusinessHelp>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpDao.findAllPage1(query);
			count=businessHelpDao.selectCount1(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelp entity) throws ServiceException {
		try {
			businessHelpDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl save()：保存BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelp entity) throws ServiceException {
		try {
			businessHelpDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl update()：修改BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelp
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpServiceImpl delete()：删除BusinessHelp发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 新增求助
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishSeekHelpRepair(final BusinessHelpQuery query) throws ServiceException {
		try {
			Map<String,String> param=query.getParam();
			Map<String,String> image=query.getImage();
			Map<String,String> audio=query.getAudio();
			int imagecount = 0;
			int audiocount = 0;
			BusinessHelp businessHelp = new BusinessHelp();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessHelp.setHelperId(new Integer(param.get("userId")));
			businessHelp.setEditTime(ts);
			businessHelp.setCreateTime(ts);
			businessHelp.setHelpContent(SensitivewordFilter.replaceSensitiveWord(param.get("content"),1,"*"));
			businessHelp.setHelpTime(ts);
			businessHelp.setIsExpend(new Integer(param.get("isExpend")));
			businessHelp.setEstateId(new Integer(param.get("estateId")));
			businessHelp.setIsNickname(new Integer(param.get("isNickname")));
			BusinessHelp businessHelp1 = businessHelpDao.save(businessHelp);
			
			Collection<String> c = image.keySet();
			Iterator it = c.iterator();
	        for (; it.hasNext();) {
	        	it.next();
	        	imagecount++;
	        	BusinessHelpPic BusinessHelpPic = new BusinessHelpPic();
	        	BusinessHelpPic.setHelpId(businessHelp1.getHelpId());
	        	BusinessHelpPic.setCreateTime(ts);
	        	BusinessHelpPic.setEditTime(ts);
	        	BusinessHelpPic.setPicUrl((String)image.get(imagecount+""));
	        	businessHelpPicDao.save(BusinessHelpPic);
	        }
	        Collection<String> coll = audio.keySet();
			Iterator iter = coll.iterator();
	        for (; iter.hasNext();) {
	        	audiocount++;
	        	iter.next();
	        	String value = (String)audio.get(audiocount+"");
				String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
				BusinessHelpAudio  businessHelpAudio = new BusinessHelpAudio();
				businessHelpAudio.setHelpId(businessHelp1.getHelpId());
				businessHelpAudio.setCreateTime2(ts);
				businessHelpAudio.setEditTime(ts);
				businessHelpAudio.setPicUrl(value);
				businessHelpAudio.setTime(new Integer(str));
				businessHelpAudioDao.save(businessHelpAudio);
	        }
	        AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(param.get("userId")));
			appLatestNews.setTypeId(27);//我的邻里求助
			appLatestNews.setSourceId(businessHelp1.getHelpId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(28);//我的邻里求助列表
			appLatestNewsDao.save_app(appLatestNews);
			
			
			
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl save()：保存BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
