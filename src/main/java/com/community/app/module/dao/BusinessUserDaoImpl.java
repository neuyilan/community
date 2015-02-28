package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessUser;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.vo.BusinessUserQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessUserDao")
@Transactional
public class BusinessUserDaoImpl implements BusinessUserDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUser findById(final Integer id) throws DaoException {
		BusinessUser businessUser = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.findById",id);
		return businessUser;
	}
	
	/**
	 * 无条件查询所有BusinessUser
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAll() throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessUser
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUser> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUser-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUser> findByExample(final BusinessUserQuery query) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUser> findByExample(final BusinessUserQuery query, final Integer limit) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAllPage(final BusinessUserQuery query) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUser entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessUserDao.save",entity);
	}

	/**
	 * 修改BusinessUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUser entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessUserDao.update",entity);
	}

	/**
	 * 删除BusinessUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessUserDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

    public MemberVO getWorkerInfo(Integer id) throws DaoException {
        return sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.getWorkerInfo", id);
    }

    /**
     * 查询用户所服务的用户数量
     * @param id
     * @return
     * @throws DaoException
     */
    public Integer getManageUserCount(final Integer id) throws DaoException {
        return sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.getManageUserCount", id);
    }
    
    /**
     * service
	 * 根据驿站id获取驿站女孩
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationGril(final Integer id) throws DaoException{
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByStationGril",id);
		return list;
	}
	
	/**
     * service
	 * 根据驿站id获取驿站工作人员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByStationAll(final Integer id) throws DaoException{
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByStationAll",id);
		return list;
	}
	
	/**
     * service
	 * 根据楼栋id获取楼管理员
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUser> findByPropertyBuildingAll(final Integer id)  throws DaoException{
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findByPropertyBuildingAll",id);
		return list;
	}
	
	/**
	 * 按sql统计数据
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countBySql(final String sql) throws DaoException {
		return this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.countBySql",sql);
	}
	
	/**
	 * 按参数统计部门下的用户数量
	 * @param sql
	 * @return
	 * @throws ServiceException
	 */
	public Integer countUserByParam(final Map paramMap) throws DaoException {
		return this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.countUserByParam",paramMap);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据 - 针对运营
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAllPageByOperation(final BusinessUserQuery query) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findAllPageByOperation",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数 - 针对运营
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByOperation(final BusinessUserQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.selectCountByOperation",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据 - 针对社区报
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUser> findAllPageByCommunity(final BusinessUserQuery query) throws DaoException {
		List<BusinessUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserDao.findAllPageByCommunity",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数 - 针对社区报
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByCommunity(final BusinessUserQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.selectCountByCommunity",query);
		return count;
	}
	
	/**
	 * 检查昵称是否也存在
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int checkExistNickName(final String nickname) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserDao.checkExistNickName",nickname);
		return count;
	}
}
