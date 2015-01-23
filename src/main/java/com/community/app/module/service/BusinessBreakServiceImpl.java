package com.community.app.module.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.framework.exception.DaoException;
import com.community.framework.utils.propertiesUtil;
import com.community.app.module.vo.BusinessBreakQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.dao.AppLatestNewsDao;
import com.community.app.module.dao.BusinessBreakAudioDao;
import com.community.app.module.dao.BusinessBreakDao;
import com.community.app.module.dao.BusinessBreakPicDao;

@Service("BusinessBreakService")
@Transactional
public class BusinessBreakServiceImpl implements BusinessBreakService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBreakServiceImpl.class);
	@Autowired
	private BusinessBreakDao businessBreakDao;
	@Autowired
	private BusinessBreakPicDao businessBreakPicDao;
	@Autowired
	private BusinessBreakAudioDao businessBreakAudioDao;
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;
	
	

	/**
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreak findById(final Integer id) throws ServiceException {
		BusinessBreak businessBreak = new BusinessBreak();
		try {
			businessBreak = businessBreakDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findById()：查询单个BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return businessBreak;
	}
	
	/**
	 * service
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreak findById_app(final Integer id) throws ServiceException {
		BusinessBreak businessBreak = new BusinessBreak();
		try {
			businessBreak = businessBreakDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findById_app()：查询单个BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return businessBreak;
	}
	
	/**
	 * 根据爆料ID获取爆料人基本信息及爆料内容
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreak checkBreakDetail(final Integer id) throws ServiceException {
		BusinessBreak businessBreak = new BusinessBreak();
		try {
			businessBreak = businessBreakDao.checkBreakDetail(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findById_app()：查询单个BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return businessBreak;
	}
	
	/**
	 * 无条件查询所有BusinessBreak
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreak> findAll() throws ServiceException {
		List<BusinessBreak> list = new ArrayList<BusinessBreak>() ;
		try {
			list=businessBreakDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findAll()：无条件查询所有BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreak
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreak> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBreak> list = new ArrayList<BusinessBreak>() ;
		try {
			list=businessBreakDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findByMap()：按Map对象条件查询所有BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreak-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreak> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBreak> list = new ArrayList<BusinessBreak>() ;
		try {
			list=businessBreakDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findByMap()：按Map对象条件查询所有BusinessBreak-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreak
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreak> findByExample(final BusinessBreakQuery query) throws ServiceException {
		List<BusinessBreak> list = new ArrayList<BusinessBreak>() ;
		try {
			list=businessBreakDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findByExample()：按VO对象条件查询所有BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreak-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreak> findByExample(final BusinessBreakQuery query, final Integer limit) throws ServiceException {
		List<BusinessBreak> list = new ArrayList<BusinessBreak>() ;
		try {
			list=businessBreakDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findByExample()：按VO对象条件查询所有BusinessBreak-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessBreakQuery query) throws ServiceException {
		List<BusinessBreak> list = new ArrayList<BusinessBreak>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessBreakDao.selectCount(query);
			query.setCount(count);
			list=businessBreakDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessBreakQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBreakDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBreak数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBreak entity) throws ServiceException {
		try {
			businessBreakDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl save()：保存BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改BusinessBreak数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBreak entity) throws ServiceException {
		try {
			businessBreakDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl update()：修改BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改BusinessBreak回复数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void updateComments(BusinessBreak entity) throws ServiceException {
		try {
			businessBreakDao.updateComments(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl updateComments()：修改BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBreak
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBreakDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl delete()：删除BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据用户id获取用户未被选中爆料的列表带分页
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public BaseBean getByUserId(final BusinessBreakQuery query) throws ServiceException{
		int count=0;
		List<BusinessBreakQuery> list = new ArrayList<BusinessBreakQuery>() ;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBreakDao.getByUserId(query);
			count=businessBreakDao.getByUserId_Count(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl BusinessBreakQuery()：根据用户id获取用户未被选中爆料的列表带分页！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
		
	}
	
	/**
	 * service
	 * 发布爆料
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishBroke(final BusinessBreak entity,Map imageMap,Map audioMap)  throws ServiceException {
		try {
			BusinessBreak businessBreak = businessBreakDao.save(entity);
			int imagecount = 0;
			int audiocount = 0;
			Collection<String> c = imageMap.keySet();
			Iterator it = c.iterator();
			
	        for (; it.hasNext();) {
	        	it.next();
	        	imagecount++;
	        	BusinessBreakPic businessBreakPic = new BusinessBreakPic();
				businessBreakPic.setBreakId(businessBreak.getBreakId());
				businessBreakPic.setCreateTime(entity.getCreateTime());
				businessBreakPic.setEditTime(entity.getCreateTime());
				businessBreakPic.setPicUrl((String)imageMap.get(imagecount+""));
				businessBreakPicDao.save(businessBreakPic);
	        }
			
	        Collection<String> coll = audioMap.keySet();
			Iterator iter = coll.iterator();
	        for (; iter.hasNext();) {
	        	audiocount++;
	        	iter.next();
	        	String value = (String)audioMap.get(audiocount+"");
	        	BusinessBreakAudio  businessBreakAudio = new BusinessBreakAudio();
				businessBreakAudio.setBreakId(businessBreak.getBreakId());
				businessBreakAudio.setCreateTime2(entity.getCreateTime());
				businessBreakAudio.setEditTime(entity.getCreateTime());
				businessBreakAudio.setPicUrl(value);
				String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
				businessBreakAudio.setTime(new Integer(str));
				businessBreakAudioDao.save(businessBreakAudio);
	        }
	        AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(entity.getBreakerId());
			appLatestNews.setTypeId(0);
			appLatestNews.setSourceId(businessBreak.getBreakId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(1);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(33);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(40);//爆料
			appLatestNews.setTo(1);
			appLatestNewsDao.save_app(appLatestNews);
			
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl save()：保存BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 发布爆料
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishBrokePHP(final BusinessBreak entity,String[] images)  throws ServiceException {
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			
			BusinessBreak businessBreak = businessBreakDao.save(entity);
			
			for (int i = 0; i < images.length; i++) {
				BusinessBreakPic businessBreakPic = new BusinessBreakPic();
				businessBreakPic.setBreakId(businessBreak.getBreakId());
				businessBreakPic.setCreateTime(entity.getCreateTime());
				businessBreakPic.setEditTime(entity.getCreateTime());
				businessBreakPic.setPicUrl(images[i].replace(ip, ""));
				businessBreakPicDao.save(businessBreakPic);
			}
			
	        AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(entity.getBreakerId());
			appLatestNews.setTypeId(0);
			appLatestNews.setSourceId(businessBreak.getBreakId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(1);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(33);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(40);//爆料
			appLatestNews.setTo(1);
			appLatestNewsDao.save_app(appLatestNews);
			
		} catch (DaoException e) {
			logger.debug("BusinessBreakServiceImpl save()：保存BusinessBreak发生错误！", e);
			e.printStackTrace();
		}
	}
}
