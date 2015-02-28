package com.community.app.module.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.vo.BusinessActivityParticipateQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessActivityParticipateDao")
@Transactional
public class BusinessActivityParticipateDaoImpl implements BusinessActivityParticipateDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityParticipate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityParticipate findById(final Integer id) throws DaoException {
		BusinessActivityParticipate businessActivityParticipate = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityParticipateDao.findById",id);
		return businessActivityParticipate;
	}
	
	/**
	 * 无条件查询所有BusinessActivityParticipate
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityParticipate> findAll() throws DaoException {
		List<BusinessActivityParticipate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityParticipate
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityParticipate> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityParticipate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityParticipate-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityParticipate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityParticipate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityParticipate
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityParticipate> findByExample(final BusinessActivityParticipateQuery query) throws DaoException {
		List<BusinessActivityParticipate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.findByExample", query);
		return list;
	}
	
	/**
	 * service
	 * 获取排名
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public Map<String,Object> ranking(final BusinessActivityParticipateQuery query) throws DaoException {
		BusinessActivityParticipate businessActivityParticipate = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityParticipateDao.findById_app",query);
		String sql ="SELECT p.actId,p.userId,p.joinTime,p.rank,u.nickname AS userName FROM business_activity_participate p LEFT JOIN app_user u ON u.userId=p.userId where  actId="+query.getActId()+" and rank in (";
		int ranks = query.getRanks()+5;
		if(businessActivityParticipate==null){
			for (int i = 1; i <= ranks; i++) {
				sql += "'"+i+"',";
			}
		}else {
			int rank = businessActivityParticipate.getRank();
			
			if(rank<=ranks){
				for (int i = 1; i <= ranks; i++) {
					sql += "'"+i+"',";
				}
			}else {
				for (int i = 1; i <= ranks; i++) {
					sql += "'"+i+"',";
				}
				sql += "'"+(rank+3)+"',";
				sql += "'"+(rank+2)+"',";
				sql += "'"+(rank+1)+"',";
				sql += "'"+(rank)+"',";
				sql += "'"+(rank-1)+"',";
				sql += "'"+(rank-2)+"',";
				sql += "'"+(rank-3)+"',";
			}
		}
		
		sql = sql.substring(0, sql.length()-1);
		sql += ")";
		
		List<BusinessActivityParticipateQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.rankingBySql", sql);
		Map<String,Object> Map = new HashMap<String,Object>();
		Map.put("list",list);
		Map.put("businessActivityParticipate",businessActivityParticipate);
		return Map;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityParticipate-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityParticipate> findByExample(final BusinessActivityParticipateQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityParticipate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityParticipate> findAllPage(final BusinessActivityParticipateQuery query) throws DaoException {
		List<BusinessActivityParticipate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityParticipateDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityParticipateQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityParticipateDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityParticipate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityParticipate entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityParticipateDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.updateParticpates",entity);
		}
	}

	/**
	 * 修改BusinessActivityParticipate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityParticipate entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityParticipateDao.update",entity);
	}

	/**
	 * 删除BusinessActivityParticipate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityParticipateDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
