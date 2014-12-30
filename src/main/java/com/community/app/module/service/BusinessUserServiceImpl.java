package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.community.app.module.bean.MemberVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.framework.exception.DaoException;
import com.community.app.module.vo.BusinessUserQuery;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.dao.BusinessUserDao;

@Service("BusinessUserService")
@Transactional
public class BusinessUserServiceImpl implements BusinessUserService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserServiceImpl.class);
	@Autowired
	private BusinessUserDao businessUserDao;

	/**
	 * 查询单个BusinessUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessUser findById(final Integer id) throws ServiceException {
		BusinessUser businessUser = new BusinessUser();
		try {
			businessUser = businessUserDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findById()：查询单个BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return businessUser;
	}
	
	/**
	 * 无条件查询所有BusinessUser
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessUser> findAll() throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findAll()：无条件查询所有BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUser
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUser> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByMap()：按Map对象条件查询所有BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUser-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUser> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByMap()：按Map对象条件查询所有BusinessUser-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUser
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUser> findByExample(final BusinessUserQuery query) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByExample()：按VO对象条件查询所有BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUser-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUser> findByExample(final BusinessUserQuery query, final Integer limit) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByExample()：按VO对象条件查询所有BusinessUser-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessUserQuery query) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			if(ModuleConst.OPERATION_CODE.equals(query.getOrgType())) {//运营单走自己的搜索，因为运营人员没有负责范围，不通过资源查询员工
				count=businessUserDao.selectCountByOperation(query);
				query.setCount(count);
				list=businessUserDao.findAllPageByOperation(query);
			}else if(ModuleConst.COMMUNITY_CODE.equals(query.getOrgType())) {//社区报单走自己的搜索
				count=businessUserDao.selectCountByCommunity(query);
				query.setCount(count);
				list=businessUserDao.findAllPageByCommunity(query);
			}else{
				count=businessUserDao.selectCount(query);
				query.setCount(count);
				list=businessUserDao.findAllPage(query);
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessUserQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessUserDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessUser entity) throws ServiceException {
		try {
			businessUserDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl save()：保存BusinessUser发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessUser entity) throws ServiceException {
		try {
			businessUserDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl update()：修改BusinessUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessUser
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessUserDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl delete()：删除BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}

    /**
     * 获取员工信息
     * @param id
     * @return
     * @throws ServiceException
     */
    public MemberVO getWorkerInfo(Integer id) throws ServiceException {
        MemberVO memberVO = new MemberVO();
        try {
            memberVO = businessUserDao.getWorkerInfo(id);
        } catch (DaoException e) {
            logger.debug("BusinessUserServiceImpl getWorkerInfo()：获取员工信息发生错误！", e);
            e.printStackTrace();
        }
        return memberVO;
    }

    /**
     * 查询用户所服务的用户数量
     * @param id
     * @return
     * @throws ServiceException
     */
    public Integer getManageUserCount(final Integer id) throws ServiceException {
        Integer count = 0;
        try {
            count  = businessUserDao.getManageUserCount(id);
        } catch (DaoException e) {
            logger.debug("BusinessUserServiceImpl getManageUserCount()：查询用户所服务的用户数量发生错误！", e);
            e.printStackTrace();
        }
        return count;
    }
    
    /**
     * service
	 * 根据驿站id获取驿站女孩
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationGril(final Integer id) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByStationGril(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByStationGril() 发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
     * service
	 * 根据驿站id获取驿站工作人员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationAll(final Integer id) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByStationAll(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByStationAll() 发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
     * service
	 * 根据楼栋id获取楼管理员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByPropertyBuildingAll(final Integer id) throws ServiceException {
		List<BusinessUser> list = new ArrayList<BusinessUser>() ;
		try {
			list=businessUserDao.findByPropertyBuildingAll(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserServiceImpl findByPropertyBuildingAll() 发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 * @throws  
	 */
	public Integer countBySql(final String sql) throws ServiceException {
		Integer count = 0;
		try {
			return businessUserDao.countBySql(sql);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Integer countUserByParam(Map paramMap) throws ServiceException {
		Integer count = 0;
		try {
			return businessUserDao.countUserByParam(paramMap);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 检查输入员工的昵称是否重复
	 * @param BusinessUserQuery
	 * @return
	 * @throws ServiceException
	 */
	public int checkExistNickName(final String nickname) throws ServiceException {
		Integer count = 0;
		try {
			return businessUserDao.checkExistNickName(nickname);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return count;
	}
}
