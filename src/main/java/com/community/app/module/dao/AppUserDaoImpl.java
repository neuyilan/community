package com.community.app.module.dao;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.bean.MemberVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.ZXingUtil;
import com.community.app.module.bean.AppUser;
import com.community.app.module.vo.AppUserQuery;

@Repository("AppUserDao")
@Transactional
public class AppUserDaoImpl implements AppUserDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUser findById(final Integer id) throws DaoException {
		AppUser appUser = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.findById",id);
		return appUser;
	}
	
	/**
	 * 无条件查询所有AppUser
	 * @return
	 * @throws DaoException
	 */
	public List<AppUser> findAll() throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppUser
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUser-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUser
	 * @param
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByExample(final AppUserQuery query) throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUser-限制返回条数
	 * @param
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUser> findByExample(final AppUserQuery query, final Integer limit) throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public List<AppUser> findAllPage(final AppUserQuery query) throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppUser entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserDao.save",entity);
	}
	
	/**
	 * service
	 * 保存注册AppUser数据并添加小区
	 * @param entity
	 * @throws DaoException
	 */
	public void saveRegist(final AppUser entity) throws DaoException {
		entity.setDimensionCode("/"+entity.getFiledir());
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserDao.saveRegist",entity);
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserDao.saveCellphone",entity);
		AppEstateUser AppEstateUser = new AppEstateUser();
		AppEstateUser.setEstateId(entity.getEstateId());
		AppEstateUser.setUserId(entity.getUserId());
		AppEstateUser.setCreateTime(entity.getCreateTime());
		AppEstateUser.setEditTime(entity.getCreateTime());
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppEstateUserDao.save",AppEstateUser);
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserConfigDao.save",AppEstateUser);
		String url = entity.getPath()+entity.getFiledir();
		File folder = new File(url);
		String json = "{\"uuid\":\"88023f8d-e710-487c-9c78-38dd90ceda68\",\"type\":\"0\",\"userId \":\""+AppEstateUser.getUserId()+"\"}";
		folder.mkdirs();
		ZXingUtil.encodeQRCodeImage(json, null,url, 300, 300, null); 
	}

	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUser entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserDao.update",entity);
	}
	
	/**
	 * 清除关于该设备的百度id和设备号
	 * @param entity
	 * @throws DaoException
	 */
	public void updateBaiduId(final AppUser entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserDao.updateBaiduId",entity);
	}
	
	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void updatePassword(final AppUser entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserDao.updatePassword",entity);
	}
	
	/**
	 * 修改AppUser数据remarks
	 * @param entity
	 * @throws DaoException
	 */
	public void updateRemarks(final AppUser entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserDao.updateRemarks",entity);
	}

	/**
	 * 删除AppUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppUserDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 验证tel是否重复
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public boolean whetherRepeat(final String tel) throws DaoException{
		int count=this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.whetherRepeat",tel);
		if(count>0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 验证用户tel、password是否正确
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public boolean whetherCorrect(final AppUser entity) throws DaoException{
		int count=this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.whetherCorrect",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

    /**
     * 查询APP用户信息
     * @param
     * @return
     * @throws DaoException
     */
    public MemberVO getAppUserInfo(final Integer id) throws DaoException {
        return sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.getAppUserInfo", id);
    }
    
    /**
     * 查询APP用户登录信息
     * @param id
     * @return
     * @throws ServiceException
     */
	public MemberVO getAppUserLoginInfo(final AppUser entity) throws DaoException {
        return sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.getAppUserLoginInfo", entity);
    }
	
	/**
     * 查询APP用户信息
     * @param obj
     * @return
     * @throws DaoException
     */
    public MemberVO getAppUserInfoByTel(final MemberVO obj) throws DaoException {
        return sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.getAppUserInfoByTel", obj);
    }
    
    /**
     * 查询APP用户信息家庭信息
     * @param obj
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfoById(final Integer id) throws DaoException {
        return sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.getAppUserInfoById", id);
    }
    
    /**
     * 按照电话查询关联APP用户
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List getAppUserByTel(final String tellPhone) throws DaoException {
    	return sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.getAppUserByTel", tellPhone);
    }
    
    /**
	 * 根据搜索条件，搜索分页数据 针对物业
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUser> findAllPageByProperty(final AppUserQuery query) throws DaoException {
		List<AppUser> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findAllPageByProperty",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数 针对物业
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByProperty(final AppUserQuery query) throws DaoException{
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.selectCountByProperty",query);
		return count;
	}
	
	/**
     * 查询该小区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIds(final String estateId) throws DaoException {
    	AppUserQuery appUserQuery = new AppUserQuery();
    	appUserQuery.setIds(estateId);
    	List list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findUserPushIds",appUserQuery);
		return list;
    }
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIdsByCom(final Integer comId) throws DaoException {
    	List list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findUserPushIdsByCom",comId);
		return list;
    }
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findPushIdsByCom(final AppUserQuery query) throws DaoException {
    	List list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserDao.findPushIdsByCom",query);
		return list;
    }
    
	public MemberVO findByCon(Map<String, Object> con) throws DaoException {
		return this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserDao.findByCon", con);
	}
}