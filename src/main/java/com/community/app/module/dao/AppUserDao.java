package com.community.app.module.dao;

import java.util.List;
import java.util.Map;




import com.community.app.module.bean.MemberVO;

import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppUser;
import com.community.app.module.vo.AppUserQuery;

@Repository
public interface AppUserDao {
		
	/**
	 * 查询单个AppUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUser findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppUser
	 * @return
	 * @throws DaoException
	 */
	public List<AppUser> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppUser
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppUser-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByExample(final AppUserQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByExample(final AppUserQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUser> findAllPage(final AppUserQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserQuery query) throws DaoException;
	
	/**
	 * 保存AppUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppUser entity) throws DaoException;
	
	/**
	 * service
	 * 保存注册AppUser数据并添加小区
	 * @param entity
	 * @throws DaoException
	 */
	public void saveRegist(final AppUser entity) throws DaoException;
	
	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUser entity) throws DaoException;
	
	/**
	 * 清除关于该设备的百度id和设备号
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateBaiduId(final AppUser entity) throws DaoException;
	
	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void updatePassword(final AppUser entity) throws DaoException;

	/**
	 * 删除AppUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 验证tel是否重复
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean whetherRepeat(final String tel) throws DaoException;
	
	/**
	 * 验证用户tel、password是否正确
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean whetherCorrect(final AppUser entity) throws DaoException;

    /**
     * 查询APP用户信息
     * @param entity
     * @return
     * @throws DaoException
     */
	public MemberVO getAppUserInfo(final Integer id) throws DaoException;

	/**
     * 查询APP用户登录信息
     * @param id
     * @return
     * @throws ServiceException
     */
	public MemberVO getAppUserLoginInfo(final AppUser entity) throws DaoException;
	
	/**
     * 查询APP用户登录信息
     * @param id
     * @return
     * @throws ServiceException
     */
	public MemberVO getAppUserInfoByTel(final MemberVO obj) throws DaoException;
	
	  /**
     * 查询APP用户信息家庭信息
     * @param obj
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfoById(final Integer id) throws DaoException;

    /**
     * 按照电话查询关联APP用户
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List getAppUserByTel(final String cellPhone) throws DaoException;
    
    /**
	 * 根据搜索条件，搜索分页数据 针对物业
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUser> findAllPageByProperty(final AppUserQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数 针对物业
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByProperty(final AppUserQuery query) throws DaoException;
	
	/**
     * 查询该小区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIds(final Integer estateId) throws DaoException;
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIdsByCom(final Integer comId) throws DaoException;
    
}
