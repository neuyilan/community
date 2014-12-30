package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageSendMsg;
import com.community.app.module.dao.ManageSendMsgDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageSendMsgQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageSendMsgService")
@Transactional
public class ManageSendMsgServiceImpl implements ManageSendMsgService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageSendMsgServiceImpl.class);
	@Autowired
	private ManageSendMsgDao manageSendMsgDao;

	/**
	 * 查询单个ManageSendMsg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageSendMsg findById(final Integer id) throws ServiceException {
		ManageSendMsg manageSendMsg = new ManageSendMsg();
		try {
			manageSendMsg = manageSendMsgDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findById()：查询单个ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return manageSendMsg;
	}
	
	/**
	 * 无条件查询所有ManageSendMsg
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageSendMsg> findAll() throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findAll()：无条件查询所有ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageSendMsg> findByMap(final Map paramMap) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByMap()：按Map对象条件查询所有ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageSendMsg> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByMap()：按Map对象条件查询所有ManageSendMsg-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByExample()：按VO对象条件查询所有ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query, final Integer limit) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		try {
			list=manageSendMsgDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findByExample()：按VO对象条件查询所有ManageSendMsg-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageSendMsgQuery query) throws ServiceException {
		List<ManageSendMsg> list = new ArrayList<ManageSendMsg>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageSendMsgDao.findAllPage(query);
			count=manageSendMsgDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageSendMsgQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageSendMsgDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageSendMsg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageSendMsg entity) throws ServiceException {
		try {
			manageSendMsgDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl save()：保存ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageSendMsg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageSendMsg entity) throws ServiceException {
		try {
			manageSendMsgDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl update()：修改ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageSendMsg
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageSendMsgDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl delete()：删除ManageSendMsg发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}



	public void save(String cellphone,String result_mt, String content, int flag) {
		// TODO Auto-generated method stub
		ManageSendMsg msg = new ManageSendMsg();
		msg.setSendTel(cellphone);
		msg.setRecvCode(result_mt);
		msg.setSendContent(content);
		msg.setSendType(flag);
		msg.setSendTime(new Timestamp(System.currentTimeMillis()));
		
		try {
			manageSendMsgDao.save(msg);
		} catch (DaoException e) {
			logger.debug("ManageSendMsgServiceImpl save()：保存ManageSendMsg发生错误！", e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
