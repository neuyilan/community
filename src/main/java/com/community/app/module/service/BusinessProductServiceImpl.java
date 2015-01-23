package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.propertiesUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BusinessProductQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.dao.AppLatestNewsDao;
import com.community.app.module.dao.BusinessProductDao;
import com.community.app.module.dao.BusinessProductPicDao;

@Service("BusinessProductService")
@Transactional
public class BusinessProductServiceImpl implements BusinessProductService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessProductServiceImpl.class);
	@Autowired
	private BusinessProductDao businessProductDao;
	@Autowired
	private BusinessProductPicDao businessProductPicDao;
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;

	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProduct findById(final Integer id) throws ServiceException {
		BusinessProduct businessProduct = new BusinessProduct();
		try {
			businessProduct = businessProductDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findById()：查询单个BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return businessProduct;
	}
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProduct findProductById(final Integer id) throws ServiceException {
		BusinessProduct businessProduct = new BusinessProduct();
		try {
			businessProduct = businessProductDao.findProductById(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findProductById()：查询单个BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return businessProduct;
	}
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public BusinessProduct findById_app(final Integer id) throws ServiceException {
		BusinessProduct businessProduct = new BusinessProduct();
		try {
			businessProduct = businessProductDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findById_app()：查询单个BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return businessProduct;
	}
	
	/**
	 * 无条件查询所有BusinessProduct
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProduct> findAll() throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		try {
			list=businessProductDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findAll()：无条件查询所有BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProduct
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProduct> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		try {
			list=businessProductDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findByMap()：按Map对象条件查询所有BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProduct-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProduct> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		try {
			list=businessProductDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findByMap()：按Map对象条件查询所有BusinessProduct-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProduct
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProduct> findByExample(final BusinessProductQuery query) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		try {
			list=businessProductDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findByExample()：按VO对象条件查询所有BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProduct-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProduct> findByExample(final BusinessProductQuery query, final Integer limit) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		try {
			list=businessProductDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findByExample()：按VO对象条件查询所有BusinessProduct-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessProductQuery query) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessProductDao.selectCount(query);
			query.setCount(count);
			list=businessProductDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_manage(final BusinessProductQuery query) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessProductDao.selectCount(query);
			query.setCount(count);
			list=businessProductDao.findAllPage_manage(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessProductQuery query) throws ServiceException {
		List<BusinessProduct> list = new ArrayList<BusinessProduct>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessProductDao.selectCount_app(query);
			query.setCount(count);
			list=businessProductDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessProductQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessProductDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProduct entity) throws ServiceException {
		try {
			businessProductDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl save()：保存BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProduct entity) throws ServiceException {
		try {
			businessProductDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl update()：修改BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save_app(BusinessProduct entity) throws ServiceException {
		try {
			businessProductDao.save_app(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl save()：保存BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update_app(BusinessProduct entity) throws ServiceException {
		try {
			businessProductDao.update_app(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl update()：修改BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessProduct
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessProductDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl delete()：删除BusinessProduct发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 新增商品
	 *
	 * @param entity
	 * @throws ServiceException
	 */
	public void addProduct(final BusinessProductQuery query) throws ServiceException {
		try {
			Map<String,String> param=query.getParam();
			Map<String,String> image=query.getImage();
			int imagecount = 0;
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessProduct businessProduct = new BusinessProduct();
			businessProduct.setDealType(new Integer(param.get("type")));
			businessProduct.setPublisherId(new Integer(param.get("userId")));
			businessProduct.setContent(param.get("desc"));
			businessProduct.setTitle("");
			businessProduct.setContactName(param.get("contact"));
			businessProduct.setContactTel(param.get("cellphone"));
			businessProduct.setContactQq("");
			businessProduct.setCreateTime(ts);
			businessProduct.setEditTime(ts);
			//businessProduct.setIsEstateAgent(new Integer(param.get("isAgent")));
			businessProduct.setIsEstateAgent(1);
			businessProduct.setDealState(0);
			businessProduct.setEstateId(new Integer(param.get("estateId")));
			businessProduct.setPrice(new Long(param.get("price")));
			if (param.get("typeId")!=null && param.get("typeId")!="0") {
				businessProduct.setTypeId(new Integer(param.get("typeId")));
				businessProduct.setTypeName(param.get("typeName"));
			}else {
				businessProduct.setTypeId(0);
				businessProduct.setTypeName("");
			}
			BusinessProduct BusinessProduct1 = businessProductDao.save_app(businessProduct);

			Collection<String> c = image.keySet();
			Iterator it = c.iterator();
	        for (; it.hasNext();) {
	        	it.next();
	        	imagecount++;
	        	BusinessProductPic businessProductPic = new BusinessProductPic();
				businessProductPic.setCreateTime(ts);
				businessProductPic.setProductId(BusinessProduct1.getProductId());
				businessProductPic.setPicPath((String)image.get(imagecount+""));
				businessProductPicDao.save_app(businessProductPic);
	        }
				
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(param.get("userId")));
			appLatestNews.setTypeId(2);
			appLatestNews.setSourceId(BusinessProduct1.getProductId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(6);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(39);//二手
			appLatestNews.setTo(1);
			appLatestNewsDao.save_app(appLatestNews);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl addProduct()：新增商品发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改商品
	 *
	 * @param entity
	 * @throws ServiceException
	 */
	public void editProduct(final BusinessProductQuery query) throws ServiceException {
		try {
			Map<String,String> param=query.getParam();
			Map<String,String> image=query.getImage();
			int imagecount = 0;
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessProduct businessProduct = new BusinessProduct();
			if("0".equals(param.get("submitType"))){
				businessProduct.setProductId(new Integer(param.get("productId")));
				businessProduct.setDealState(3);
				businessProduct.setEditTime(ts);
				businessProductDao.update_app(businessProduct);
			}else if ("2".equals(param.get("submitType"))) {
				businessProduct.setProductId(new Integer(param.get("productId")));
				businessProduct.setDealState(0);
				businessProduct.setEditTime(ts);
				businessProductDao.update_app(businessProduct);
			}else if ("3".equals(param.get("submitType"))) {
				businessProduct.setProductId(new Integer(param.get("productId")));
				businessProduct.setDealState(5);
				businessProduct.setEditTime(ts);
				businessProductDao.update_app(businessProduct);
			}else{
				businessProduct.setProductId(new Integer(param.get("productId")));
				businessProduct.setContent(param.get("desc"));
				businessProduct.setTitle("");
				businessProduct.setContactName(param.get("contact"));
				businessProduct.setContactTel(param.get("cellphone"));
				businessProduct.setContactQq("");
				businessProduct.setEditTime(ts);
				//businessProduct.setIsEstateAgent(new Integer(param.get("isAgent")));
				businessProduct.setIsEstateAgent(1);
				businessProduct.setDealState(0);
				businessProduct.setPrice(new Long(param.get("price")));
				if (param.get("typeId")!=null && param.get("typeId")!="0") {
					businessProduct.setTypeId(new Integer(param.get("typeId")));
					businessProduct.setTypeName(param.get("typeName"));
				}else {
					businessProduct.setTypeId(0);
					businessProduct.setTypeName("");
				}
				businessProductDao.update_app(businessProduct);
				businessProductPicDao.delete_app(new Integer(param.get("productId")));
				Collection<String> c = image.keySet();
				Iterator it = c.iterator();
		        for (; it.hasNext();) {
		        	it.next();
		        	imagecount++;
		        	
		        	BusinessProductPic businessProductPic = new BusinessProductPic();
					businessProductPic.setCreateTime(ts);
					businessProductPic.setProductId(new Integer(param.get("productId")));
					businessProductPic.setPicPath((String)image.get(imagecount+""));
					businessProductPicDao.save_app(businessProductPic);
		        }
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(new Integer(param.get("userId")));
				appLatestNews.setTypeId(2);
				appLatestNews.setSourceId(new Integer(param.get("productId")));
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsDao.save_app(appLatestNews);
				appLatestNews.setTypeId(6);
				appLatestNewsDao.save_app(appLatestNews);
				appLatestNews.setTypeId(39);//二手
				appLatestNews.setTo(1);
				appLatestNewsDao.save_app(appLatestNews);
			}
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl addProduct()：修改商品发生错误！", e);
			e.printStackTrace();
		}
	}


	/**
	 * 新增商品 for PHP
	 *
	 * @param entity
	 * @throws ServiceException
	 */
	public void addProductPHP(BusinessProductQuery query)
			throws ServiceException {
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   

			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessProduct businessProduct = new BusinessProduct();
			
			businessProduct.setDealType(query.getType());
			businessProduct.setPublisherId(query.getUserId());
			businessProduct.setContent(query.getDesc());
			businessProduct.setTitle("");
			businessProduct.setContactName(query.getContact());
			businessProduct.setContactTel(query.getCellphone());
			businessProduct.setContactQq("");
			businessProduct.setCreateTime(ts);
			businessProduct.setEditTime(ts);			
			
			businessProduct.setIsEstateAgent(1);
			businessProduct.setDealState(0);
			businessProduct.setEstateId(query.getEstateId());
			businessProduct.setPrice(query.getPrice());
			if (query.getTypeId()!=null && query.getTypeId().toString()!="0") {
				businessProduct.setTypeId(query.getTypeId());
				businessProduct.setTypeName(query.getTypeName());
			}else {
				businessProduct.setTypeId(0);
				businessProduct.setTypeName("");
			}
			BusinessProduct BusinessProduct1 = businessProductDao.save_app(businessProduct);

			String picPaths[] = query.getPicPaths();
			for(int i=0;i<picPaths.length;i++)
			{
	        	BusinessProductPic businessProductPic = new BusinessProductPic();
				businessProductPic.setCreateTime(ts);
				businessProductPic.setProductId(BusinessProduct1.getProductId());
				businessProductPic.setPicPath(picPaths[i].replace(ip, ""));
				businessProductPicDao.save_app(businessProductPic);
			}
			
			
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());//new Integer(param.get("userId")));
			appLatestNews.setTypeId(2);
			appLatestNews.setSourceId(BusinessProduct1.getProductId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(6);
			appLatestNewsDao.save_app(appLatestNews);
			appLatestNews.setTypeId(39);//二手
			appLatestNews.setTo(1);
			appLatestNewsDao.save_app(appLatestNews);
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl addProduct()：新增商品发生错误！", e);
			e.printStackTrace();
		}
	
		
	}



	public void editProductPHP(BusinessProductQuery query) {
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   

			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessProduct businessProduct = new BusinessProduct();
			if("0".equals(query.getSubmitType())){
				businessProduct.setProductId(query.getProductId());
				businessProduct.setDealState(3);
				businessProduct.setEditTime(ts);
				businessProductDao.update_app(businessProduct);
			}else if ("2".equals(query.getSubmitType())) {
				businessProduct.setProductId(query.getProductId());
				businessProduct.setDealState(0);
				businessProduct.setEditTime(ts);
				businessProductDao.update_app(businessProduct);
			}else if ("3".equals(query.getSubmitType())) {
				businessProduct.setProductId(query.getProductId());
				businessProduct.setDealState(5);
				businessProduct.setEditTime(ts);
				businessProductDao.update_app(businessProduct);
			}else{
				businessProduct.setProductId(query.getUserId());
				businessProduct.setContent(query.getDesc());
				businessProduct.setTitle("");
				businessProduct.setContactName(query.getContact());
				businessProduct.setContactTel(query.getCellphone());
				businessProduct.setContactQq("");
				businessProduct.setEditTime(ts);
				//businessProduct.setIsEstateAgent(new Integer(param.get("isAgent")));
				businessProduct.setIsEstateAgent(1);
				businessProduct.setDealState(0);
				businessProduct.setPrice(query.getPrice());
				if (query.getTypeId()!=null && query.getTypeId().toString()!="0") {
					businessProduct.setTypeId(query.getTypeId());
					businessProduct.setTypeName(query.getTypeName());
				}else {
					businessProduct.setTypeId(0);
					businessProduct.setTypeName("");
				}
				businessProductDao.update_app(businessProduct);
				businessProductPicDao.delete_app(query.getProductId());

				
				String picPaths[] = query.getPicPaths();
				for(int i=0;i<picPaths.length;i++)
				{
		        	BusinessProductPic businessProductPic = new BusinessProductPic();
					businessProductPic.setCreateTime(ts);
					businessProductPic.setProductId(query.getProductId());
					businessProductPic.setPicPath(picPaths[i].replace(ip, ""));
					businessProductPicDao.save_app(businessProductPic);
				}
				
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getUserId());
				appLatestNews.setTypeId(2);
				appLatestNews.setSourceId(query.getProductId());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsDao.save_app(appLatestNews);
				appLatestNews.setTypeId(6);
				appLatestNewsDao.save_app(appLatestNews);
				appLatestNews.setTypeId(39);//二手
				appLatestNews.setTo(1);
				appLatestNewsDao.save_app(appLatestNews);
			}
		} catch (DaoException e) {
			logger.debug("BusinessProductServiceImpl addProduct()：修改商品发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
