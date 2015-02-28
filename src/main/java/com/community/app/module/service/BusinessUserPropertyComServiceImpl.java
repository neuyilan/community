package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessUserPropertyCom;
import com.community.app.module.dao.BusinessUserPropertyComDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessUserPropertyComQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessUserPropertyComService")
@Transactional
public class BusinessUserPropertyComServiceImpl implements BusinessUserPropertyComService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserPropertyComServiceImpl.class);
	@Autowired
	private BusinessUserPropertyComDao businessUserPropertyComDao;

	/**
	 * 查询单个BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessUserPropertyCom findById(final Integer id) throws ServiceException {
		BusinessUserPropertyCom businessUserPropertyCom = new BusinessUserPropertyCom();
		try {
			businessUserPropertyCom = businessUserPropertyComDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findById()：查询单个BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
		return businessUserPropertyCom;
	}
	
	/**
	 * 无条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessUserPropertyCom> findAll() throws ServiceException {
		List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
		try {
			list=businessUserPropertyComDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findAll()：无条件查询所有BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserPropertyCom> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
		try {
			list=businessUserPropertyComDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findByMap()：按Map对象条件查询所有BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUserPropertyCom> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
		try {
			list=businessUserPropertyComDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findByMap()：按Map对象条件查询所有BusinessUserPropertyCom-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query) throws ServiceException {
		List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
		try {
			list=businessUserPropertyComDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findByExample()：按VO对象条件查询所有BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query, final Integer limit) throws ServiceException {
		List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
		try {
			list=businessUserPropertyComDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findByExample()：按VO对象条件查询所有BusinessUserPropertyCom-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessUserPropertyComQuery query) throws ServiceException {
		List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessUserPropertyComDao.findAllPage(query);
			count=businessUserPropertyComDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessUserPropertyComQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessUserPropertyComDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessUserPropertyCom数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessUserPropertyCom entity) throws ServiceException {
		try {
			businessUserPropertyComDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl save()：保存BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessUserPropertyCom数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessUserPropertyCom entity) throws ServiceException {
		try {
			businessUserPropertyComDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl update()：修改BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessUserPropertyComDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserPropertyComServiceImpl delete()：删除BusinessUserPropertyCom发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
    /**
     * 查询互动记录
     * @param query
     * @return
     * @throws ServiceException
     */
    public List<BusinessUserPropertyCom> getChatInfo(final BusinessUserPropertyComQuery query) throws ServiceException {
        List<BusinessUserPropertyCom> list = new ArrayList<BusinessUserPropertyCom>() ;
        try {
            list = businessUserPropertyComDao.findByExample(query);
        } catch (DaoException e) {
            logger.debug("BusinessUserPropertyComServiceImpl getChatInfo()：查询互动记录发生错误！", e);
            e.printStackTrace();
        }

        return list;
    }
}
