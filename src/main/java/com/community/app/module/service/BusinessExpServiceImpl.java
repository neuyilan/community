package com.community.app.module.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessExp;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.common.ExportUtil;
import com.community.app.module.dao.BusinessExpBackresolveDao;
import com.community.app.module.dao.BusinessExpDao;
import com.community.app.module.dao.BusinessExpResolveDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessExpQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.DateUtil;

@Service("BusinessExpService")
@Transactional
public class BusinessExpServiceImpl implements BusinessExpService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessExpServiceImpl.class);
	@Autowired
	private BusinessExpDao businessExpDao;
	@Autowired
	private BusinessExpResolveDao businessExpResolveDao;
	@Autowired
	private BusinessExpBackresolveDao businessExpBackresolveDao;

	

	/**
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessExp findById(final Integer id) throws ServiceException {
		BusinessExp businessExp = new BusinessExp();
		try {
			businessExp = businessExpDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findById()：查询单个BusinessExp发生错误！", e);
			e.printStackTrace();
		}
		return businessExp;
	}
	
	/**
	 * service
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessExp findById_app(final Integer id) throws ServiceException {
		BusinessExp businessExp = new BusinessExp();
		try {
			businessExp = businessExpDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findById_app()：查询单个BusinessExp发生错误！", e);
			e.printStackTrace();
		}
		return businessExp;
	}
	
	/**
	 * 无条件查询所有BusinessExp
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessExp> findAll() throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			list=businessExpDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findAll()：无条件查询所有BusinessExp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExp
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExp> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			list=businessExpDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findByMap()：按Map对象条件查询所有BusinessExp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExp-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessExp> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			list=businessExpDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findByMap()：按Map对象条件查询所有BusinessExp-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessExp
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExp> findByExample(final BusinessExpQuery query) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			list=businessExpDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findByExample()：按VO对象条件查询所有BusinessExp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExp-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessExp> findByExample(final BusinessExpQuery query, final Integer limit) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			list=businessExpDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findByExample()：按VO对象条件查询所有BusinessExp-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessExpQuery query) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessExpDao.selectCount(query);
			query.setCount(count);
			list=businessExpDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，导出excel数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessExp> findExcelAllExp(final BusinessExpQuery query) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			list=businessExpDao.findExcelAllExp(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findExcelAllExp()：根据搜索条件，导出excel数据发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessExpQuery query) throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessExpDao.selectCount_app(query);
			query.setCount(count);
			list=businessExpDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessExpQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessExpDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessExp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessExp entity) throws ServiceException {
		try {
			businessExpDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl save()：保存BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessExp entity) throws ServiceException {
		try {
			businessExpDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update_app(BusinessExp entity) throws ServiceException {
		try {
			businessExpDao.update_app(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 取消预定
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update_Schedule(BusinessExp entity) throws ServiceException {
		try {
			businessExpDao.update_Schedule(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 修改提取快件方式
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_state(final BusinessExp entity) throws ServiceException {
		try {
			businessExpDao.update_app(entity);
			BusinessExpResolve BusinessExpResolve = new BusinessExpResolve();
			BusinessExpResolve.setExpId(entity.getExpId());
			BusinessExpResolve.setResolveId(0);
			BusinessExpResolve.setResolverName("");
			BusinessExpResolve.setType(0);
			BusinessExpResolve.setResolveTime(entity.getModifyTime());
			BusinessExpResolve.setState(entity.getExpState()+"");
			BusinessExpResolve.setResolveMemo(entity.getLastMessage());
			BusinessExpResolve.setVideoTime("");
			businessExpResolveDao.save_app(BusinessExpResolve);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 修改提取语言快件方式
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_SpeechSound(final BusinessExpQuery query) throws ServiceException {
		try {
			Map<String,String> param=query.getParam();
			Map<String,String> audioMap=query.getAudio();
			BusinessExp BusinessExp = new BusinessExp();
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessExp.setExpId(new Integer(param.get("ID")));
			BusinessExp.setModifyTime(ts);
			BusinessExp.setIsVideo(1);
			BusinessExp.setStation(param.get("station"));
			BusinessExp.setReceiverAddr("");
			BusinessExp.setReceiverName("");
			BusinessExp.setReceiverTel("");
			BusinessExp.setExpState(5);
			BusinessExp.setLastMessage("您语言预约服务驿站送货上门");
			BusinessExp.setBriefMessage(DateUtil.nowTime1()+"\\r\\n运单号："+query.getOrderCode()+"\\r\\n您语言预约服务驿站送货上门");
			businessExpDao.update_app(BusinessExp);
			BusinessExpResolve BusinessExpResolve = new BusinessExpResolve();
			BusinessExpResolve.setExpId(new Integer(param.get("ID")));
			BusinessExpResolve.setResolveId(1);
			BusinessExpResolve.setResolverName("");
			BusinessExpResolve.setResolveTime(ts);
			BusinessExpResolve.setState("5");
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
	        BusinessExpResolve.setType(1);
			businessExpResolveDao.save_app(BusinessExpResolve);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessExp
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessExpDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl delete()：删除BusinessExp发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 用户使用发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpress(final BusinessExp entity) throws ServiceException {
		try {
			businessExpDao.sendExpress(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl sendExpress()：用户使用发件功能发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户使用语言发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpressSound(final BusinessExpQuery query) throws ServiceException {
		try {
			businessExpDao.sendExpressSound(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl sendExpressSound()：用户使用语言发件功能发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 定时修改状态
	 * @param entity
	 * @throws ServiceException
	 */
	public void taskUpdateState() throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			BusinessExpQuery businessExpQuery = new BusinessExpQuery();
			businessExpQuery.setTaskUpdateState(1);
			list=businessExpDao.findByExample(businessExpQuery);
			for (BusinessExp businessExp : list) {
				long time = new Date().getTime() + 2*60*60*1000;
				if(businessExp.getCheckInTime().getTime()<=time){
					BusinessExp businessExp1 = new BusinessExp();
					businessExp1.setExpId(businessExp.getExpId());
					businessExp1.setExpState(9);
					businessExpDao.update(businessExp1);
				}
			}
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 定时修改状态
	 * @param entity
	 * @throws ServiceException
	 */
	public void taskUpdateState1() throws ServiceException {
		List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try {
			BusinessExpQuery businessExpQuery = new BusinessExpQuery();
			businessExpQuery.setTaskUpdateState(1);
			list=businessExpDao.findByExample(businessExpQuery);
			for (BusinessExp businessExp : list) {
				BusinessExp businessExp1 = new BusinessExp();
				businessExp1.setExpId(businessExp.getExpId());
				businessExp1.setExpState(9);
				businessExpDao.update(businessExp1);
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessExpServiceImpl update()：修改BusinessExp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	public void exportExcel(BusinessExpQuery query, ServletOutputStream outputStream) {
		String[] title =   {"日期","运单状态","客户姓名","运单号","地址","电话","备注（取）","领取时间","客户签字","快递员签字","驿站签字"};
		/** test data */
		List<BusinessExp> list = null;
		List<Map> listCom = null;
		try {
			 list = businessExpDao.findExcelAllExp(query);
			 if (CollectionUtils.isEmpty(list))
				 return ;
			 listCom = businessExpDao.findHasExpCom(query);
		} catch (DaoException e1) {
			logger.debug("BusinessExpServiceImpl exportExcel()：导出运单Excel功能的查询快递单出错！",e1);
			e1.printStackTrace();
		}
		
		
		// 创建一个workbook 对应一个excel应用文件
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 在workbook中添加一个sheet,对应Excel文件中的sheet

		XSSFCell cell = null;
		XSSFSheet sheet = null;
		XSSFCellStyle headStyle = null;
		XSSFCellStyle bodyStyle = null;
		//根据有快递 的快递公司 循环创建sheet页
		for(int x=0;x<listCom.size();x++)
		{
			sheet = workBook.createSheet(listCom.get(x).get("expCompany").toString()); 
			ExportUtil exportUtil = new ExportUtil(workBook, sheet);
		    headStyle = exportUtil.getHeadStyle();
		    bodyStyle = exportUtil.getBodyStyle();
			// 构建表头
			XSSFRow headRow = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				cell = headRow.createCell(i);
				cell.setCellStyle(headStyle);
				cell.setCellValue(title[i]);
			}
		}
		
		// 构建表体数据
		if (CollectionUtils.isNotEmpty(list)) {
			java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");  
			for (int j = 0; j < list.size(); j++) {
				BusinessExp exp = list.get(j);
				String expComName = exp.getExpCompany();
				
				//根据sheet name找到sheet页
				if (StringUtils.isBlank(expComName))
					continue;
				sheet = workBook.getSheet(expComName);
				if (sheet == null)
					continue;
				//创建行数据
				XSSFRow bodyRow = sheet.createRow(sheet.getLastRowNum()+1);
				
				cell = bodyRow.createCell(3);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(exp.getExpCode());
				
				
				cell = bodyRow.createCell(1);
				cell.setCellStyle(bodyStyle);
				
				String stateName = "";
				int stat = exp.getExpState();
				if (stat == 0)
					stateName="上门取件";
				else if (stat == 1)
					stateName="已上门取件";
				else if (stat == 2)
					stateName="已发送";
				else if (stat == 3)
					stateName="已入库";
				else if (stat == 4)
					stateName="自提";
				else if (stat == 5)
					stateName="上门送件";
				else if (stat == 6)
					stateName="已签收";
				else if (stat == 7)
					stateName="已退件";
				else if (stat == 8)
					stateName="已取消";
				else if (stat == 9)
					stateName="问题件";
				else if (stat == 10)
					stateName="被投诉快递";				
				cell.setCellValue(stateName);
				
				cell = bodyRow.createCell(6);
				cell.setCellStyle(bodyStyle);
				cell = bodyRow.createCell(8);
				cell.setCellStyle(bodyStyle);
				cell = bodyRow.createCell(9);
				cell.setCellStyle(bodyStyle);
				cell = bodyRow.createCell(10);
				cell.setCellStyle(bodyStyle);
				cell = bodyRow.createCell(10);
				cell.setCellStyle(bodyStyle);
				
				
				cell = bodyRow.createCell(7);
				cell.setCellStyle(bodyStyle);
				if(exp.getSignTime() != null)
					cell.setCellValue(exp.getSignTime());
				else 
					cell.setCellValue("");
				
//				System.out.println(exp.getSignTime());
				if(exp.getExpState() != null)
				{
					if(exp.getExpState() == 0  || exp.getExpState() == 1  || exp.getExpState() == 2)
					{
						cell = bodyRow.createCell(0);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getSendTime() == null ? "" : format.format( new Date(exp.getSendTime().getTime())));

						cell = bodyRow.createCell(2);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getSenderName());
						
						cell = bodyRow.createCell(4);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getSenderAddr());
						
						cell = bodyRow.createCell(5);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getSenderTel());
						
					} else if ( exp.getExpState() == 3 )
					{
						cell = bodyRow.createCell(0);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getCheckInTime() == null ? "" : format.format( new Date(exp.getCheckInTime().getTime())) );
						
						cell = bodyRow.createCell(2);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiverName());
						
						cell = bodyRow.createCell(4);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiverAddr());
						
						cell = bodyRow.createCell(5);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiverTel());
						
					} else if ( exp.getExpState() == 4 || exp.getExpState() == 5 || exp.getExpState() == 6 || exp.getExpState() == 7 || exp.getExpState() == 8 || exp.getExpState() == 9)
					{
						cell = bodyRow.createCell(0);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiveTime() == null ? "" : format.format( new Date( exp.getReceiveTime().getTime())) );
						
						cell = bodyRow.createCell(2);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiverName());
						
						cell = bodyRow.createCell(4);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiverAddr());
						
						cell = bodyRow.createCell(5);
						cell.setCellStyle(bodyStyle);
						cell.setCellValue(exp.getReceiverTel());
					}
				}
				
			}
		}
		try {
			workBook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			logger.debug("BusinessExpServiceImpl exportExcel()：导出运单Excel功能发生错误！",e);
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				logger.debug("BusinessExpServiceImpl exportExcel()：关闭输出流发生错误！",e);
				e.printStackTrace();
			}
		}

	}

	
	
	
	
	public void exportExcelTool(BusinessExpQuery query, ServletOutputStream outputStream) {
		
		String[] titles = new String[]{"日期","运单状态","客户姓名","运单号","小区","楼号","电话","备注（取）","领取时间","客户签字","快递员签字","驿站签字"};
		
		/**  test data  */

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map1 ;
		for ( int i =0 ;i < 10 ; i++)
		{
			map1 = new HashMap<String, String>();
			map1.put("data1", i*100+1+"");
			map1.put("data2", i*100+2+"");
			map1.put("data3", i*100+3+"");
			list.add(map1);
		}
		/** TODO 取出来 所有的 快递公司 数据 和 所有的快递单数据*/
		// 创建一个workbook 对应一个excel应用文件
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 在workbook中 循环创建 sheet 页,对应不同的快递公司
		XSSFCell cell = null;
		XSSFSheet sheet ;
		XSSFCellStyle headStyle = null;
		XSSFCellStyle bodyStyle = null;
		for(int x=0;x<5;x++)
		{
			sheet = workBook.createSheet("sheet01"); 
			ExportUtil exportUtil = new ExportUtil(workBook, sheet);
		    headStyle = exportUtil.getHeadStyle();
		    bodyStyle = exportUtil.getBodyStyle();
			// 构建表头
			XSSFRow headRow = sheet.createRow(0);
			headRow.setRowStyle(headStyle);
			
			for (int i = 0; i < titles.length; i++) {
				cell = headRow.createCell(i);
				cell.setCellStyle(headStyle);
				cell.setCellValue(titles[i]);
			}
		}
		// 构建表体数据
		if (list != null && list.size() > 0) {
			
			for (int j = 0; j < list.size(); j++) {
				if (StringUtils.isBlank(list.get(j).get("ExpComName")))
						continue ;
				sheet = workBook.getSheet(list.get(j).get("ExpComName"));
				
				XSSFRow bodyRow = sheet.createRow(j + 1);
				
				Map<String, String> map = list.get(j);
				
				cell = bodyRow.createCell(0);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(map.get("data1"));

				cell = bodyRow.createCell(1);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(map.get("data2"));

				cell = bodyRow.createCell(2);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(map.get("data3"));
				
			}
		}
		try {
			workBook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			logger.debug("BusinessExpServiceImpl exportExcel()：导出运单Excel功能发生错误！",e);
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				logger.debug("BusinessExpServiceImpl exportExcel()：导出运单Excel功能 关闭输出流发生错误！",e);
				e.printStackTrace();
			}
		}

	}
	
	
}
