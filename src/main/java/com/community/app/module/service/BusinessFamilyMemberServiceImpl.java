package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessFamilyMember;
import com.community.app.module.dao.AppLatestNewsDao;
import com.community.app.module.dao.AppUserNewsDao;
import com.community.app.module.dao.BusinessFamilyMemberDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFamilyMemberQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessFamilyMemberService")
@Transactional
public class BusinessFamilyMemberServiceImpl implements BusinessFamilyMemberService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFamilyMemberServiceImpl.class);
	@Autowired
	private BusinessFamilyMemberDao businessFamilyMemberDao;
	@Autowired
	private AppUserNewsDao appUserNewsDao;
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;


	/**
	 * 查询单个BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFamilyMember findById(final Integer id) throws ServiceException {
		BusinessFamilyMember businessFamilyMember = new BusinessFamilyMember();
		try {
			businessFamilyMember = businessFamilyMemberDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findById()：查询单个BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
		return businessFamilyMember;
	}
	
	/**
	 * 无条件查询所有BusinessFamilyMember
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFamilyMember> findAll() throws ServiceException {
		List<BusinessFamilyMember> list = new ArrayList<BusinessFamilyMember>() ;
		try {
			list=businessFamilyMemberDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findAll()：无条件查询所有BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyMember
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyMember> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFamilyMember> list = new ArrayList<BusinessFamilyMember>() ;
		try {
			list=businessFamilyMemberDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findByMap()：按Map对象条件查询所有BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyMember> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFamilyMember> list = new ArrayList<BusinessFamilyMember>() ;
		try {
			list=businessFamilyMemberDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findByMap()：按Map对象条件查询所有BusinessFamilyMember-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyMember
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query) throws ServiceException {
		List<BusinessFamilyMember> list = new ArrayList<BusinessFamilyMember>() ;
		try {
			list=businessFamilyMemberDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findByExample()：按VO对象条件查询所有BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query, final Integer limit) throws ServiceException {
		List<BusinessFamilyMember> list = new ArrayList<BusinessFamilyMember>() ;
		try {
			list=businessFamilyMemberDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findByExample()：按VO对象条件查询所有BusinessFamilyMember-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFamilyMemberQuery query) throws ServiceException {
		List<BusinessFamilyMember> list = new ArrayList<BusinessFamilyMember>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFamilyMemberDao.findAllPage(query);
			count=businessFamilyMemberDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFamilyMemberQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFamilyMemberDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * service
	 * 保存BusinessFamilyMember数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFamilyMember entity) throws ServiceException {
		try {
			businessFamilyMemberDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl save()：保存BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 申请加入家庭
	 * @param entity
	 * @throws ServiceException
	 */
	public void ApplySave(final BusinessFamilyMember entity) throws ServiceException {
		try {
			businessFamilyMemberDao.ApplySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl ApplySave()：保存BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFamilyMember数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFamilyMember entity) throws ServiceException {
		try {
			businessFamilyMemberDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl update()：修改BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFamilyMember
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFamilyMemberDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl delete()：删除BusinessFamilyMember发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 验证用户是否有家庭
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherRepeat(final Integer id) throws ServiceException{
		try {
			return businessFamilyMemberDao.whetherRepeat(id);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl whetherRepeat()：！验证是否重复！！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * service
	 * 用户是否同意申请加入家庭
	 * @param entity
	 * @throws ServiceException
	 */
	public void informationAgreeAdd(final BusinessFamilyMemberQuery query) throws ServiceException {
		try {
			AppUserNews appUserNews = appUserNewsDao.findById_family_id(query.getApplyId());
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppUserNews aun = new AppUserNews();
			aun.setNewsId(appUserNews.getNewsId());
			aun.setCreateTime(appUserNews.getCreateTime());
			aun.setType(6);
			appUserNewsDao.update(aun);
			if(query.getType()==0){
				appUserNews.setCreateTime(ts);
				appUserNews.setContent("您已同意："+appUserNews.getContent().replace("申请",""));
				BusinessFamilyMember BusinessFamilyMember = new BusinessFamilyMember();
				BusinessFamilyMember.setMemberId(query.getApplyId());
				BusinessFamilyMember.setState(0);
				businessFamilyMemberDao.update(BusinessFamilyMember);
			}else{
				appUserNews.setCreateTime(ts);
				appUserNews.setContent("您已拒绝："+appUserNews.getContent().replace("申请",""));
				businessFamilyMemberDao.delete_app(query.getApplyId());
			}
			appUserNews.setType(6);
			AppUserNews appUserNews1 = appUserNewsDao.save(appUserNews);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(appUserNews.getUserId());
			appLatestNews.setTypeId(7);
			appLatestNews.setSourceId(appUserNews1.getNewsId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(8);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(10);
			appLatestNewsDao.save_app(appLatestNews);
			//businessFamilyMemberDao.informationAgreeAdd(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyMemberServiceImpl informationAgreeAdd()：保存用户是否同意申请加入家庭发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
