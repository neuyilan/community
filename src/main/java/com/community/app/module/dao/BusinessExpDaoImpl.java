package com.community.app.module.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.BusinessExp;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BusinessExpQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.DateUtil;

@Repository("BusinessExpDao")
@Transactional
public class BusinessExpDaoImpl implements BusinessExpDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExp findById(final Integer id) throws DaoException {
		BusinessExp businessExp = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpDao.findById",id);
		return businessExp;
	}
	
	/**
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExp findById_app(final Integer id) throws DaoException {
		BusinessExp businessExp = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpDao.findById_app",id);
		return businessExp;
	}
	
	/**
	 * 无条件查询所有BusinessExp
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findAll() throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessExp
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExp> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExp-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessExp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessExp
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExp> findByExample(final BusinessExpQuery query) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExp-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessExp> findByExample(final BusinessExpQuery query, final Integer limit) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findAllPage(final BusinessExpQuery query) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索结果导出excel数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findExcelAllExp(final BusinessExpQuery query) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findExcelAllExp",query);
		return list;
	}

	/**
	 * 查询有快递单的快递公司
	 * 查询条件 和 查询快递单条件一致
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<Map> findHasExpCom(final BusinessExpQuery query) throws DaoException {
		List<Map> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findHasExpCom",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findAllPage_app(final BusinessExpQuery query) throws DaoException {
		List<BusinessExp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessExpQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessExp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExp entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpDao.save",entity);
	}

	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExp entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessExpDao.update",entity);
	}
	
	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessExp entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessExpDao.update_app",entity);
	}
	
	/**
	 * 取消预约
	 * @param entity
	 * @throws DaoException
	 */
	public void update_Schedule(final BusinessExp entity) throws DaoException {
		BusinessExpResolve businessExpResolve = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpResolveDao.findById_app_state",entity.getExpId());
		entity.setLastMessage(businessExpResolve.getResolveMemo());
		entity.setBriefMessage(DateUtil.nowTime1()+"\\r\\n"+businessExpResolve.getResolveMemo());
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessExpDao.update_Schedule",entity);
		this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpResolveDao.delete_app_state",entity.getExpId());
		this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpBackresolveDao.delete_app_state",entity.getExpId());
	}

	/**
	 * 删除BusinessExp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 用户使用发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpress(final BusinessExp entity) throws DaoException {
		int count=this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpDao.sendExpress",entity);
		if(count>0){
			BusinessExpResolve BusinessExpResolve = new BusinessExpResolve();
			BusinessExpResolve.setExpId(entity.getExpId());
			BusinessExpResolve.setResolveId(0);
			BusinessExpResolve.setResolverName("");
			BusinessExpResolve.setResolveTime(entity.getCreateTime());
			BusinessExpResolve.setState("0");
			BusinessExpResolve.setType(0);
			BusinessExpResolve.setResolveMemo(entity.getLastMessage());
			BusinessExpResolve.setVideoTime("");
			this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpResolveDao.save_app",BusinessExpResolve);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpBackresolveDao.save_app",BusinessExpResolve);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(entity.getSenderId());
			appLatestNews.setTypeId(21);
			appLatestNews.setSourceId(entity.getExpId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(22);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(26);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(38);//快递
			appLatestNews.setTo(1);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
		}
		
	}
	
	/**
	 * 用户使用语言发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpressSound(final BusinessExpQuery query) throws DaoException {
		Map<String,String> audioMap=query.getAudio();
		Map<String,String> paramMap=query.getParam();
		BusinessExp businessExp = new BusinessExp();
		Timestamp  ts=new Timestamp(new Date().getTime());
		businessExp.setCreateTime(ts);
		businessExp.setModifyTime(ts);
		businessExp.setSenderId(new Integer(paramMap.get("userId")));
		businessExp.setSenderName("");
		businessExp.setSenderTel("");
		businessExp.setSenderAddr("");
		businessExp.setExpState(0);
		businessExp.setExpType(1);
		businessExp.setStation(paramMap.get("station"));
		businessExp.setExpCompanyID(0);
		businessExp.setGetTime("");
		businessExp.setIsVideo(1);
		businessExp.setLastMessage("语音预约");
		businessExp.setBriefMessage(DateUtil.nowTime1()+"\\r\\n语音预约");
		int count=this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpDao.sendExpress",businessExp);
		if(count>0){
			BusinessExpResolve BusinessExpResolve = new BusinessExpResolve();
			BusinessExpResolve.setExpId(businessExp.getExpId());
			BusinessExpResolve.setResolveId(0);
			BusinessExpResolve.setResolverName("");
			BusinessExpResolve.setResolveTime(ts);
			BusinessExpResolve.setState("0");
			BusinessExpResolve.setType(1);
			BusinessExpResolve.setVideoTime("1");
			Collection<String> coll = audioMap.keySet();
			Iterator iter = coll.iterator();
			int audiocount = 0;
	        for (; iter.hasNext();) {
	        	audiocount++;
	        	iter.next();
	        	String value = (String)audioMap.get(audiocount+"");
				String str = value.substring(value.lastIndexOf("_")+1, value.lastIndexOf("."));
				BusinessExpResolve.setResolveMemo(value);
				BusinessExpResolve.setVideoTime(str);
	        }
			this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpResolveDao.save_app",BusinessExpResolve);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpBackresolveDao.save_app",BusinessExpResolve);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(businessExp.getSenderId());
			appLatestNews.setTypeId(21);
			appLatestNews.setSourceId(businessExp.getExpId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(22);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(26);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
			appLatestNews.setTypeId(38);//快递
			appLatestNews.setTo(1);
			this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",appLatestNews);
		}
		
	}
	
}
