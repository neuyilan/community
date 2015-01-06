package com.community.app.module.service;

import java.util.List;
import java.util.Map;




import com.community.app.module.bean.MemberVO;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppUser;
import com.community.app.module.vo.AppUserQuery;


public interface AppUserService {

	/**
	 * 查询单个AppUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppUser findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppUser
	 * @return
	 * @throws ServiceException
	 */
	public List<AppUser> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppUser
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUser> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppUser-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有AppUser
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUser> findByExample(final AppUserQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUser> findByExample(final AppUserQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppUserQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppUserQuery query) throws ServiceException;
	
	/**
	 * 保存AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppUser entity) throws ServiceException;
	
	/**
	 * service
	 * 保存注册AppUser数据并添加小区
	 * @param entity
	 * @throws ServiceException
	 */
	public void saveRegist(final AppUser entity) throws ServiceException;
	
	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppUser entity) throws ServiceException;
	
	/**
	 * 清除关于该设备的百度id和设备号
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateBaiduId(final AppUser entity) throws ServiceException;
	
	/**
	 * service
	 * 修改AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void updatePassword(final AppUser entity) throws ServiceException;

	/**
	 * service
	 * 修改AppUser数据remarks
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateRemarks(final AppUser entity) throws ServiceException;
	
	/**
	 * 删除AppUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 验证tel是否重复
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherRepeat(final String tel) throws ServiceException;
	
	/**
	 * 验证用户tel、password是否正确
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherCorrect(final AppUser entity) throws ServiceException;

    /**
     * 查询APP用户信息
     * @param id
     * @return
     * @throws ServiceException
     */
	public MemberVO getAppUserInfo(final Integer id) throws ServiceException;

	 /**
     * 查询APP用户登录信息
     * @param id
     * @return
     * @throws ServiceException
     */
	public MemberVO getAppUserLoginInfo(final AppUser entity) throws ServiceException;
	 /**
     * 查询APP用户信息
     * @param obj
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfoByTel(MemberVO obj) throws ServiceException;

    /**
     * 查询APP用户信息家庭信息
     * @param obj
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfoById(final Integer id) throws ServiceException;
    
    /**
     * 按照电话查询关联APP用户
     * @param obj
     * @return
     * @throws ServiceException
     */
    public AppUser getAppUserByTel(final String tellPhone) throws ServiceException;
    
    /**
     * 查询该小区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIds(final String estateId) throws ServiceException;
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIdsByCom(final Integer comId) throws ServiceException;
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findPushIdsByCom(final AppUserQuery query) throws ServiceException;
    
    /**
   	 * 推送天气
   	 * @param 
   	 * @return
   	 * @throws 
   	 */	
   	public   void pushWeather() throws ServiceException;

   	/**
   	 * 按条件查询 用户信息
   	 * @param con
   	 * @throws ServiceException
   	 */
	public MemberVO findByCon(Map<String, Object> con) throws ServiceException;
    
    

}
