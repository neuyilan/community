package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessUser;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessUserQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessUserService {

	/**
	 * 查询单个BusinessUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUser findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessUser
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessUser
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUser> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessUser-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessUser
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUser> findByExample(final BusinessUserQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessUser> findByExample(final BusinessUserQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessUserQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessUserQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessUser entity) throws ServiceException;
	
	/**
	 * 修改BusinessUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessUser entity) throws ServiceException;

	/**
	 * 删除BusinessUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

    /**
     * 获取员工信息
     * @param id
     * @return
     * @throws ServiceException
     */
    public MemberVO getWorkerInfo(final Integer id) throws ServiceException;

    /**
     * 查询用户所服务的用户数量
     * @param id
     * @return
     * @throws ServiceException
     */
    public Integer getManageUserCount(final Integer id) throws ServiceException;
    
    /**
     * service
	 * 根据驿站id获取驿站女孩
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationGril(final Integer id) throws ServiceException;

	/**
     * service
	 * 根据驿站id获取驿站工作人员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationAll(final Integer id) throws ServiceException;

	/**
     * service
	 * 根据楼栋id获取楼管理员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByPropertyBuildingAll(final Integer id) throws ServiceException;

	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countBySql(final String sql) throws ServiceException;
	
	/**
	 * 按参数统计部门下的用户数量
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countUserByParam(final Map paramMap) throws ServiceException;
	
	/**
	 * 检查输入员工的昵称是否重复
	 * @param BusinessUserQuery
	 * @return
	 * @throws ServiceException
	 */
	public int checkExistNickName(final String nickname) throws ServiceException;
}
