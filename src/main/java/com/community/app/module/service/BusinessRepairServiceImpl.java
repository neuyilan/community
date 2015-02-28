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
import com.community.app.module.bean.BusinessRepair;
import com.community.app.module.bean.BusinessRepairAudio;
import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.bean.BusinessRepairPic;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.dao.AppLatestNewsDao;
import com.community.app.module.dao.BusinessRepairAudioDao;
import com.community.app.module.dao.BusinessRepairCommentDao;
import com.community.app.module.dao.BusinessRepairDao;
import com.community.app.module.dao.BusinessRepairPicDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessRepairService")
@Transactional
public class BusinessRepairServiceImpl implements BusinessRepairService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRepairServiceImpl.class);
	@Autowired
	private BusinessRepairDao businessRepairDao;
	@Autowired
	private BusinessRepairPicDao businessRepairPicDao;
	@Autowired
	private BusinessRepairAudioDao businessRepairAudioDao;
	@Autowired
	private BusinessRepairCommentDao businessRepairCommentDao;
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;
	
	
	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRepair findById(final Integer id) throws ServiceException {
		BusinessRepair businessRepair = new BusinessRepair();
		try {
			businessRepair = businessRepairDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findById()：查询单个BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
		return businessRepair;
	}

    public MemberVO findAppUserById(Integer id) throws ServiceException {
        MemberVO  businessRepair = new MemberVO ();
        try {
            businessRepair = businessRepairDao.findAppUserById(id);
        } catch (DaoException e) {
            logger.debug("BusinessRepairServiceImpl findAppUserById()：BusinessRepair！", e);
            e.printStackTrace();
        }
        return businessRepair;
    }

    /**
	 * 无条件查询所有BusinessRepair
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRepair> findAll() throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		try {
			list=businessRepairDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findAll()：无条件查询所有BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepair
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepair> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		try {
			list=businessRepairDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findByMap()：按Map对象条件查询所有BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepair-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepair> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepair
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepair> findByExample(final BusinessRepairQuery query) throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		try {
			list=businessRepairDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findByExample()：按VO对象条件查询所有BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepair-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepair> findByExample(final BusinessRepairQuery query, final Integer limit) throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		try {
			list=businessRepairDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findByExample()：按VO对象条件查询所有BusinessRepair-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRepairQuery query) throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRepairDao.selectCount(query);
			query.setCount(count);
			list=businessRepairDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		baseBean.setRows(12);
		//计算分页数据
		//baseBean.getPager().doPage();
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessRepairQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRepairDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRepair数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRepair entity) throws ServiceException {
		try {
			businessRepairDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl save()：保存BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRepair数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRepair entity) throws ServiceException {
		try {
			businessRepairDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl update()：修改BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRepair
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRepairDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl delete()：删除BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessRepairQuery query) throws ServiceException {
		List<BusinessRepair> list = new ArrayList<BusinessRepair>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRepairDao.selectCount_app(query);
			list=businessRepairDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		//计算分页数据
		baseBean.getPager().doPage();
		return baseBean;
	}

	public BusinessRepair findById_app(Integer id) throws ServiceException {
		BusinessRepair businessRepair = new BusinessRepair();
		try {
			businessRepair = businessRepairDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl findById()：查询单个BusinessRepair发生错误！", e);
			e.printStackTrace();
		}
		return businessRepair;
	}
	/**
	 * 用户发布物业报修
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishPropertyRepair(final BusinessRepairQuery query) throws ServiceException {
		try {
			Map<String,String> param=query.getParam();
			Map<String,String> image=query.getImage();
			Map<String,String> audio=query.getAudio();
			int imagecount = 0;
			int audiocount = 0;
			BusinessRepair businessRepair = new BusinessRepair();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessRepair.setReporterId(new Integer(param.get("userId")));
			businessRepair.setEditTime(ts);
			businessRepair.setCreateTime(ts);
			businessRepair.setRepairContent(param.get("content"));
			businessRepair.setRepairTime(ts);
			businessRepair.setTypeId(new Integer(param.get("type")));
			businessRepair.setEstateId(new Integer(param.get("estateId")));
			businessRepair.setRepairState(0);
			BusinessRepair businessRepair1 = businessRepairDao.save(businessRepair);
			
			Collection<String> c = image.keySet();
			Iterator it = c.iterator();
	        for (; it.hasNext();) {
	        	it.next();
	        	imagecount++;
				BusinessRepairPic businessRepairPic = new BusinessRepairPic();
				businessRepairPic.setRepairId(businessRepair1.getRepairId());
				businessRepairPic.setCreateTime(ts);
				businessRepairPic.setEditTime(ts);
				businessRepairPic.setPicUrl((String)image.get(imagecount+""));
				businessRepairPicDao.save(businessRepairPic);
	        }
			
			
	        Collection<String> coll = audio.keySet();
			Iterator iter = coll.iterator();
	        for (; iter.hasNext();) {
	        	audiocount++;
	        	iter.next();
	        	String value = (String)audio.get(audiocount+"");
				String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
				BusinessRepairAudio  businessRepairAudio = new BusinessRepairAudio();
				businessRepairAudio.setRepairId(businessRepair1.getRepairId());
				businessRepairAudio.setCreateTime2(ts);
				businessRepairAudio.setEditTime(ts);
				businessRepairAudio.setPicUrl(value);
				businessRepairAudio.setTime(new Integer(str));
				businessRepairAudioDao.save(businessRepairAudio);
	        }
	        AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(param.get("userId")));
			appLatestNews.setTypeId(29);
			appLatestNews.setSourceId(businessRepair1.getRepairId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(31);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(32);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTo(1);
			appLatestNews.setTypeId(37);//报修
			appLatestNewsDao.save_app(appLatestNews);
			
			
		} catch (DaoException e) {
			logger.debug("BusinessRepairServiceImpl publishPropertyRepair()：用户发布物业报修发生错误！", e);
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
	public void evaluation(BusinessRepair entity,final BusinessRepairQuery query) throws ServiceException {
		try {
			businessRepairDao.update(entity);
			BusinessRepairComment businessRepairComment = new BusinessRepairComment();
			businessRepairComment.setRepairId(entity.getRepairId());
			businessRepairComment.setContentType(1);
			businessRepairCommentDao.update_app(businessRepairComment);
			if(query.getIfTheSolution()==2){
				businessRepairComment.setContentType(3);
			}else {
				businessRepairComment.setContentType(4);
			}
			businessRepairComment.setCommentorId(query.getUserId());
			businessRepairComment.setComment(""+entity.getRepairScore());
			businessRepairComment.setCommentTime(entity.getEditTime());
			businessRepairComment.setVideoSize(0);
			businessRepairCommentDao.save(businessRepairComment);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackServiceImpl save()：保存BusinessFeedback发生错误！", e);
			e.printStackTrace();
		}
	}

	
}
