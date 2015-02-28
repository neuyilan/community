package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.dao.ManageUserFunctionDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageUserFunctionQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageUserFunctionService")
@Transactional
public class ManageUserFunctionServiceImpl implements ManageUserFunctionService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageUserFunctionServiceImpl.class);
	@Autowired
	private ManageUserFunctionDao manageUserFunctionDao;

	/**
	 * 查询单个ManageUserFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageUserFunction findById(final Integer id) throws ServiceException {
		ManageUserFunction manageUserFunction = new ManageUserFunction();
		try {
			manageUserFunction = manageUserFunctionDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findById()：查询单个ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
		return manageUserFunction;
	}
	
	/**
	 * 无条件查询所有ManageUserFunction
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageUserFunction> findAll() throws ServiceException {
		List<ManageUserFunction> list = new ArrayList<ManageUserFunction>() ;
		try {
			list=manageUserFunctionDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findAll()：无条件查询所有ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageUserFunction
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageUserFunction> findByMap(final Map paramMap) throws ServiceException {
		List<ManageUserFunction> list = new ArrayList<ManageUserFunction>() ;
		try {
			list=manageUserFunctionDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findByMap()：按Map对象条件查询所有ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageUserFunction-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageUserFunction> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageUserFunction> list = new ArrayList<ManageUserFunction>() ;
		try {
			list=manageUserFunctionDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findByMap()：按Map对象条件查询所有ManageUserFunction-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query) throws ServiceException {
		List<ManageUserFunction> list = new ArrayList<ManageUserFunction>() ;
		try {
			list=manageUserFunctionDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findByExample()：按VO对象条件查询所有ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query, final Integer limit) throws ServiceException {
		List<ManageUserFunction> list = new ArrayList<ManageUserFunction>() ;
		try {
			list=manageUserFunctionDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findByExample()：按VO对象条件查询所有ManageUserFunction-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageUserFunctionQuery query) throws ServiceException {
		List<ManageUserFunction> list = new ArrayList<ManageUserFunction>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageUserFunctionDao.findAllPage(query);
			count=manageUserFunctionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageUserFunctionQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageUserFunctionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageUserFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageUserFunction entity) throws ServiceException {
		try {
			manageUserFunctionDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl save()：保存ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageUserFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageUserFunction entity) throws ServiceException {
		try {
			manageUserFunctionDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl update()：修改ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageUserFunction
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageUserFunctionDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageUserFunctionServiceImpl delete()：删除ManageUserFunction发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
    /**
     * 删除ManageUserFunction
     * @param id
     * @return
     * @throws ServiceException
     */
    public boolean deleteByUserId(final Integer id) throws ServiceException {
        try {
            return manageUserFunctionDao.deleteByUserId(id);
        } catch (DaoException e) {
            logger.debug("ManageUserFunctionServiceImpl deleteByUserId()：删除ManageUserFunction发生错误！", e);
            e.printStackTrace();
        }
        return false;
    }
}
