package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessFamilyMember;
import com.community.app.module.vo.BusinessFamilyMemberQuery;

@Repository("BusinessFamilyMemberDao")
@Transactional
public class BusinessFamilyMemberDaoImpl implements BusinessFamilyMemberDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFamilyMember findById(final Integer id) throws DaoException {
		BusinessFamilyMember businessFamilyMember = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyMemberDao.findById",id);
		return businessFamilyMember;
	}
	
	/**
	 * 无条件查询所有BusinessFamilyMember
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyMember> findAll() throws DaoException {
		List<BusinessFamilyMember> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyMemberDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFamilyMember
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFamilyMember> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyMemberDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFamilyMember> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyMemberDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyMember
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query) throws DaoException {
		List<BusinessFamilyMember> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyMemberDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query, final Integer limit) throws DaoException {
		List<BusinessFamilyMember> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyMemberDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyMember> findAllPage(final BusinessFamilyMemberQuery query) throws DaoException {
		List<BusinessFamilyMember> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyMemberDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFamilyMemberQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyMemberDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFamilyMember数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFamilyMember entity) throws DaoException {
		int count=this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFamilyMemberDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFamilyDao.updateMount",entity);
		}
	}
	
	/**
	 * service
	 * 申请加入家庭
	 * @param entity
	 * @throws ServiceException
	 */
	public void ApplySave(final BusinessFamilyMember entity) throws DaoException {
		int count=this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFamilyMemberDao.save",entity);
		if(count>0){
			AppUserNews appUserNews = new AppUserNews();
			appUserNews.setUserId(entity.getFounderId());
			appUserNews.setCreateTime(entity.getCreateTime());
			appUserNews.setNewTitle("加入家庭");
			appUserNews.setType(5);
			appUserNews.setId(entity.getMemberId());
			appUserNews.setContent("手机号为"+entity.getTel()+" 的"+entity.getName()+" 申请加入您的家庭");
			appUserNews.setLastMessage("");
			appUserNews.setLastMessageName("");
			this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserNewsDao.save",appUserNews);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(entity.getFounderId());
			appLatestNews.setTypeId(7);
			appLatestNews.setSourceId(appUserNews.getNewsId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(8);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(10);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
		}
	}

	/**
	 * 修改BusinessFamilyMember数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFamilyMember entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFamilyMemberDao.update",entity);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFamilyDao.updateMount",entity);
	}

	/**
	 * 删除BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int familyId=this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyDao.whetherFounderId",id);
		if(familyId>0){
			this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFamilyDao.deleteFamily",id);
			this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFamilyMemberDao.deleteAll",familyId);
		}else{
			this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFamilyMemberDao.delete",id);
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFamilyDao.updateMount--",familyId);
		}
		return false;
	}
	
	/**
	 * 删除BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final Integer id) throws DaoException {
		this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFamilyMemberDao.delete_app",id);
		return false;
	}
	
	
	/**
	 * 验证用户是否有家庭
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherRepeat(final Integer id) throws DaoException{
		int count=this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyMemberDao.whetherRepeat",id);
		if(count>0){
			return false;
		}else{
			return true;
		}
	}
	
	
}
