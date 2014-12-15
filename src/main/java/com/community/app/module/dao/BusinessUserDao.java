package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import com.community.app.module.bean.MemberVO;

import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.vo.BusinessUserQuery;

@Repository
public interface BusinessUserDao {
		
	/**
	 * 查询单个BusinessUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUser findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessUser
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessUser
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUser> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessUser-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUser> findByExample(final BusinessUserQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUser> findByExample(final BusinessUserQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAllPage(final BusinessUserQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserQuery query) throws DaoException;
	
	/**
	 * 保存BusinessUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUser entity) throws DaoException;
	
	/**
	 * 修改BusinessUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUser entity) throws DaoException;

	/**
	 * 删除BusinessUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

    /**
     * 获取员工信息
     * @param id
     * @return
     * @throws DaoException
     */
    public MemberVO getWorkerInfo(final Integer id) throws DaoException;

    /**
     * 查询用户所服务的用户数量
     * @param id
     * @return
     * @throws DaoException
     */
    public Integer getManageUserCount(final Integer id) throws DaoException;
    
    /**
     * service
	 * 根据驿站id获取驿站女孩
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationGril(final Integer id) throws DaoException;

	/**
     * service
	 * 根据驿站id获取驿站工作人员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationAll(final Integer id) throws DaoException;

	/**
     * service
	 * 根据楼栋id获取楼管理员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByPropertyBuildingAll(final Integer id) throws DaoException;
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countBySql(final String sql) throws DaoException;
	
	/**
	 * 按参数统计部门下的用户数量
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countUserByParam(final Map paramMap) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据 - 针对运营
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAllPageByOperation(final BusinessUserQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数 - 针对运营
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByOperation(final BusinessUserQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据 - 针对社区报
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAllPageByCommunity(final BusinessUserQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数 - 针对社区报
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByCommunity(final BusinessUserQuery query) throws DaoException;

	/**
	 * 检查昵称是否也存在
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int checkExistNickName(final String nickname) throws DaoException;
}
