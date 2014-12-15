package com.community.app.module.dao;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;








import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.StringUtil;
import com.community.framework.utils.ZXingUtil;
import com.community.app.module.bean.BusinessFamily;
import com.community.app.module.bean.BusinessFamilyMember;
import com.community.app.module.vo.BusinessFamilyMemberQuery;
import com.community.app.module.vo.BusinessFamilyQuery;

@Repository("BusinessFamilyDao")
@Transactional
public class BusinessFamilyDaoImpl implements BusinessFamilyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFamily
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFamily findById(final Integer id) throws DaoException {
		BusinessFamily businessFamily = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyDao.findById",id);
		return businessFamily;
	}
	
	/**
	 * 无条件查询所有BusinessFamily
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamily> findAll() throws DaoException {
		List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFamily
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamily-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamily
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query) throws DaoException {
		List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamily-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query, final Integer limit) throws DaoException {
		List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamily> findAllPage(final BusinessFamilyQuery query) throws DaoException {
		List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFamilyQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存家庭并新增家庭成员并返回家庭信息
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessFamily save(final BusinessFamilyQuery entity) throws DaoException {
		Timestamp ts = new Timestamp(new Date().getTime());
		BusinessFamily BusinessFamily = new BusinessFamily();
		BusinessFamilyMember businessFamilyMember = new BusinessFamilyMember();
		BusinessFamily.setFamilyName(entity.getFamilyName());
		BusinessFamily.setFounderId(entity.getUserId());
		BusinessFamily.setCreateTime(ts);
		BusinessFamily.setEditTime(ts);
		
		BusinessFamily.setDimensionCode("/"+entity.getFiledir());
		String str="";
		for(;1==1;){
			str=StringUtil.createRandom(true, 6);
			BusinessFamilyQuery BusinessFamilyQuery = new BusinessFamilyQuery();
			BusinessFamilyQuery.setVerifyCode(str);
			BusinessFamilyQuery.setFamilyState(0);
			List<BusinessFamily> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.findByExample", BusinessFamilyQuery);
			if(list.size()==0){
				break;
			}
		}
		BusinessFamily.setVerifyCode(str);
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFamilyDao.save",BusinessFamily);
		businessFamilyMember.setCreateTime(ts);
		businessFamilyMember.setEditTime(ts);
		businessFamilyMember.setFamilyId(BusinessFamily.getFamilyId());
		businessFamilyMember.setUserId(entity.getUserId());
		businessFamilyMember.setState(0);
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFamilyMemberDao.save",businessFamilyMember);
		Integer id=BusinessFamily.getFamilyId();
		
		BusinessFamily businessFamily = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyDao.findById",id);
		String url = entity.getPath()+entity.getFiledir();
		File folder = new File(url);
		String json = "{\"uuid\":\"88023f8d-e710-487c-9c78-38dd90ceda68\",\"type\":\"1\",\"familyId \":\""+id+"\"}";
		folder.mkdirs();
		ZXingUtil.encodeQRCodeImage(json, null,url, 300, 300, null); 
		return businessFamily;
	}

	/**
	 * 修改BusinessFamily数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFamily entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFamilyDao.update",entity);
	}

	/**
	 * 删除BusinessFamily
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFamilyDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 获取家庭信息和成员信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFamilyQuery> getFamilyInfo(final Integer id) throws DaoException {
		List<BusinessFamilyQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyDao.getFamilyInfo",id);
		return list;
	}
	
	/**
	 * service
	 * 获取家庭信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamily getFamilyInfoById(final Integer id) throws DaoException {
		BusinessFamily BusinessFamily = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyDao.getFamilyInfoById",id);
		return BusinessFamily;
	}
	
}
