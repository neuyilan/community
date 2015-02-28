package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessFeedbackAudio;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.dao.AppLatestNewsDao;
import com.community.app.module.dao.BusinessFeedbackAudioDao;
import com.community.app.module.dao.BusinessFeedbackCommentDao;
import com.community.app.module.dao.BusinessFeedbackDao;
import com.community.app.module.dao.BusinessFeedbackPicDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessFeedbackService")
@Transactional
public class BusinessFeedbackServiceImpl implements BusinessFeedbackService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFeedbackServiceImpl.class);
	@Autowired
	private BusinessFeedbackDao businessFeedbackDao;
	@Autowired
	private BusinessFeedbackPicDao businessFeedbackPicDao;
	@Autowired
	private BusinessFeedbackAudioDao businessFeedbackAudioDao;
	@Autowired
	private BusinessFeedbackCommentDao businessFeedbackCommentDao;
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;

	
	/**
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFeedback findById(final Integer id) throws ServiceException {
		BusinessFeedback businessFeedback = new BusinessFeedback();
		try {
			businessFeedback = businessFeedbackDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findById()：查询单个BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
		return businessFeedback;
	}
	
	/**
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFeedback findById_app(final Integer id) throws ServiceException {
		BusinessFeedback businessFeedback = new BusinessFeedback();
		try {
			businessFeedback = businessFeedbackDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findById_app()：查询单个BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
		return businessFeedback;
	}
	
	/**
	 * 无条件查询所有BusinessFeedback
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFeedback> findAll() throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		try {
			list=businessFeedbackDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findAll()：无条件查询所有BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedback
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedback> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		try {
			list=businessFeedbackDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedback-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedback> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		try {
			list=businessFeedbackDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedback-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedback
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query) throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		try {
			list=businessFeedbackDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedback-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query, final Integer limit) throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		try {
			list=businessFeedbackDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedback-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFeedbackQuery query) throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			if(query.getOrgType() != null 
					&& !"".equals(query.getOrgType())
					&& query.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {
				count=businessFeedbackDao.selectCountByProperty(query);
				query.setCount(count);
				list=businessFeedbackDao.findAllPageByProperty(query);
			}else{
				count=businessFeedbackDao.selectCount(query);
				query.setCount(count);
				list=businessFeedbackDao.findAllPage(query);
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		baseBean.setRows(12);
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
	public BaseBean findAllPage_app(final BusinessFeedbackQuery query) throws ServiceException {
		List<BusinessFeedback> list = new ArrayList<BusinessFeedback>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFeedbackDao.findAllPage_app(query);
			count=businessFeedbackDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFeedbackQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFeedbackDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFeedback entity) throws ServiceException {
		try {
			businessFeedbackDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl save()：保存BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 评价
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void evaluation(BusinessFeedback entity,final BusinessFeedbackQuery query) throws ServiceException {
		try {
			businessFeedbackDao.update(entity);
			BusinessFeedbackComment businessFeedbackComment = new BusinessFeedbackComment();
			businessFeedbackComment.setFeedbackId(entity.getFeedbackId());
			businessFeedbackComment.setContentType(1);
			businessFeedbackCommentDao.update_app(businessFeedbackComment);
			if(query.getIfTheSolution()==2){
				businessFeedbackComment.setContentType(3);
			}else {
				businessFeedbackComment.setContentType(4);
			}
			businessFeedbackComment.setCommentorId(query.getUserId());
			businessFeedbackComment.setComment(""+entity.getFbScore());
			businessFeedbackComment.setCommentTime(entity.getEditTime());
			businessFeedbackComment.setVideoSize(0);
			businessFeedbackCommentDao.save(businessFeedbackComment);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl save()：保存BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFeedback entity) throws ServiceException {
		try {
			businessFeedbackDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl update()：修改BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFeedback
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFeedbackDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl delete()：删除BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 用户发布反馈
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishPropertyComplaint(final BusinessFeedbackQuery query) throws ServiceException {
		try {
			Map<String,String> param=query.getParam();
			Map<String,String> image=query.getImage();
			Map<String,String> audio=query.getAudio();
			int imagecount = 0;
			int audiocount = 0;
			BusinessFeedback businessFeedback = new BusinessFeedback();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFeedback.setFberId(new Integer(param.get("userId")));
			businessFeedback.setEditTime(ts);
			businessFeedback.setCreateTime(ts);
			businessFeedback.setFbContent(param.get("content"));
			businessFeedback.setFbTime(ts);
			businessFeedback.setFbType(new Integer(param.get("fbType")));
			businessFeedback.setEstateId(new Integer(param.get("estateId")));
			businessFeedback.setFbState(0);
			if("".equals(param.get("ID")) || null==param.get("ID"))
			{
				businessFeedback.setExpId(0);
			}else{
				businessFeedback.setExpId(new Integer(param.get("ID")));
			}
			BusinessFeedback businessFeedback1 = businessFeedbackDao.save(businessFeedback);
			
			Collection<String> c = image.keySet();
			Iterator it = c.iterator();
	        for (; it.hasNext();) {
	        	it.next();
	        	imagecount++;
				BusinessFeedbackPic BusinessFeedbackPic = new BusinessFeedbackPic();
				BusinessFeedbackPic.setFeedbackId(businessFeedback1.getFeedbackId());
				BusinessFeedbackPic.setCreateTime(ts);
				BusinessFeedbackPic.setEditTime(ts);
				BusinessFeedbackPic.setPicUrl((String)image.get(imagecount+""));
				businessFeedbackPicDao.save(BusinessFeedbackPic);
	        }
			

	        Collection<String> coll = audio.keySet();
			Iterator iter = coll.iterator();
	        for (; iter.hasNext();) {
	        	audiocount++;
	        	iter.next();
	        	String value = (String)audio.get(audiocount+"");
				String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
				BusinessFeedbackAudio  businessFeedbackAudio = new BusinessFeedbackAudio();
				businessFeedbackAudio.setFeedbackId(businessFeedback1.getFeedbackId());
				businessFeedbackAudio.setCreateTime2(ts);
				businessFeedbackAudio.setEditTime(ts);
				businessFeedbackAudio.setPicUrl(value);
				businessFeedbackAudio.setTime(new Integer(str));
				businessFeedbackAudioDao.save(businessFeedbackAudio);
	        }
	        AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(param.get("userId")));
			appLatestNews.setSourceId(businessFeedback1.getFeedbackId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNews.setTypeId(20);//我的服务管家列表
			appLatestNewsDao.save_app(appLatestNews);
			if("0".equals(param.get("fbType"))){
				appLatestNews.setTypeId(15);//物业投诉
				appLatestNewsDao.save_app(appLatestNews);
				appLatestNews.setTypeId(18);//物业投诉处理中
				appLatestNewsDao.save_app(appLatestNews);
			}else if ("1".equals(param.get("fbType"))) {
				appLatestNews.setTypeId(14);//物业建议
				appLatestNewsDao.save_app(appLatestNews);
			}else if ("2".equals(param.get("fbType"))) {
				appLatestNews.setTypeId(11);//使用反馈
				appLatestNewsDao.save_app(appLatestNews);
			}else if ("3".equals(param.get("fbType"))) {
				appLatestNews.setTypeId(12);//驿站建议
				appLatestNewsDao.save_app(appLatestNews);
			}else {
				appLatestNews.setTypeId(13);//快递投诉
				appLatestNewsDao.save_app(appLatestNews);
				appLatestNews.setTypeId(16);//快递投诉处理中
				appLatestNewsDao.save_app(appLatestNews);
			}
			appLatestNews.setTo(1);
			appLatestNews.setTypeId(36);//反馈
			appLatestNewsDao.save_app(appLatestNews);
			
			
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl save()：保存BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
