/**
 * RetOrderSerSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */
package com.community.ws.shop.ser;

import org.springframework.beans.BeansException;

import com.community.app.module.bean.BusinessShopFlow;
import com.community.app.module.bean.BusinessShopGoods;
import com.community.app.module.bean.BusinessShopOrder;
import com.community.app.module.service.BusinessShopFlowService;
import com.community.app.module.service.BusinessShopGoodsService;
import com.community.app.module.service.BusinessShopOrderService;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.DateUtil;
import com.community.ws.common.ApplicationSingleton;

/**
 * RetOrderSerSkeleton java skeleton for the axisService
 */
public class RetOrderSerSkeleton {

	/**
	 * Auto generated method signature
	 * 
	 * @param retOrder
	 */

	private BusinessShopOrderService businessShopOrderService;

	private BusinessShopGoodsService businessShopGoodsService;

	private BusinessShopFlowService businessShopFlowService;

	public com.community.ws.shop.ser.RetOrderResponse retOrder(
			com.community.ws.shop.ser.RetOrder retOrder) {
		// TODO : fill this with the necessary business logic

		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#retOrder");
		String code = "0000";
		String desc = "订单反馈成功!";
		com.community.ws.shop.ser.RetOrderResponse retOrderResponse = new com.community.ws.shop.ser.RetOrderResponse();
		com.community.ws.shop.rsp.xsd.RootE roote = new com.community.ws.shop.rsp.xsd.RootE();
		com.community.ws.shop.rsp.xsd.RetMsg retMsg = new com.community.ws.shop.rsp.xsd.RetMsg();
		com.community.ws.shop.rsp.xsd.RetCode_type1 rcType = new com.community.ws.shop.rsp.xsd.RetCode_type1();
		com.community.ws.shop.rsp.xsd.RetDesc_type1 rdType = new com.community.ws.shop.rsp.xsd.RetDesc_type1();
		rcType.setRetCode_type0(code);
		rdType.setRetDesc_type0(desc);

		retMsg.setRetCode(rcType);
		retMsg.setRetDesc(rdType);

		roote.setRetMsg(retMsg);
		retOrderResponse.set_return(roote);
		/*
		 * = (BusinessShopOrderService)
		 * this.ctx.getBean("businessShopOrderService");
		 */

		try {
			com.community.ws.shop.req.xsd.Root root = retOrder.getRoot();
			com.community.ws.shop.req.xsd.Header header = root.getHeader();
			com.community.ws.shop.req.xsd.FlowId_type1 flowId = header
					.getFlowId();
			com.community.ws.shop.req.xsd.Body body = root.getBody();
			com.community.ws.shop.req.xsd.Order order = body.getOrder();
			// ClassPathXmlApplicationContext context = new
			// ClassPathXmlApplicationContext("applicationContext.xml");
			businessShopOrderService = (BusinessShopOrderService) ApplicationSingleton
					.getInstance().getBean("BusinessShopOrderService");
			businessShopGoodsService = (BusinessShopGoodsService) ApplicationSingleton
					.getInstance().getBean("BusinessShopGoodsService");
			businessShopFlowService = (BusinessShopFlowService) ApplicationSingleton
					.getInstance().getBean("BusinessShopFlowService");
			BusinessShopFlow flow = businessShopFlowService.findById(Integer
					.valueOf(flowId.getFlowId_type0()));
			if (flow == null) {
				rcType.setRetCode_type0("1001");
				rdType.setRetDesc_type0("未查到用户进入商铺记录!");
				return retOrderResponse;
			}
			BusinessShopOrder businessShopOrder = new BusinessShopOrder();

			businessShopOrder.setEstateId(0);
			businessShopOrder.setNickName("test");
			businessShopOrder.setOrderNo(order.getOrderNo().getOrderNo_type0());
			businessShopOrder.setOrderTime(DateUtil.getTimeStampFromStr(order
					.getOrderTime().getOrderTime_type0()));
			businessShopOrder.setShopId(1000);
			businessShopOrder.setUserId(1000);
			businessShopOrder.setOrderAmount(1000.01);
			businessShopOrderService.save(businessShopOrder);

			System.out.println(businessShopOrderService == null);

			com.community.ws.shop.req.xsd.GoodsList goodList = order
					.getGoodsList();
			com.community.ws.shop.req.xsd.Goods[] goodsAry = goodList
					.getGoods();
			for (com.community.ws.shop.req.xsd.Goods goods : goodsAry) {
				BusinessShopGoods businessShopGoods = new BusinessShopGoods();
				businessShopGoods.setGoodsNO(goods.getGoodsNO()
						.getGoodsNO_type0());
				businessShopGoods.setGoodsName(goods.getGoodsName()
						.getGoodsName_type0());
				businessShopGoods.setGoodsPrice(Double.valueOf(goods
						.getGoodsPrice().getGoodsPrice_type0()));
				businessShopGoods.setGoodsAmount(Integer.valueOf(goods
						.getGoodsAmount().getGoodsAmount_type0()));
				businessShopGoods.setGoodsAgio(Double.valueOf(goods
						.getGoodsAgio().getGoodsAgio_type0()));
				businessShopGoods.setOrderId(11);
				businessShopGoodsService.save(businessShopGoods);
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			rcType.setRetCode_type0("1004");
			rdType.setRetDesc_type0("抱歉！未知错误，请反馈错误信息，谢谢！");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			rcType.setRetCode_type0("1003");
			rdType.setRetDesc_type0("订单报文解析失败,请遵循接口规范");
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			rcType.setRetCode_type0("1004");
			rdType.setRetDesc_type0("抱歉！未知错误。请联系管理员");
			e.printStackTrace();
		}

		// orderNo, userId, nickName, estateId, orderAmount, shopId, orderTime

		return retOrderResponse;
	}

}
