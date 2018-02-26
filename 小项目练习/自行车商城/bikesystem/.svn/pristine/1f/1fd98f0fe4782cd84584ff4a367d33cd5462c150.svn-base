package com.bikesystem.hs.service;

import com.bikesystem.entity.RentOrderInfo;

/**
 * 做具体的用户支付预约租金：
 * 	1.验证余额
 * 	2.用户金额计算
 * 		(1).付款时支付总的租金
 * 		(2).还车时商家计算总的租金和租时费用，作计算后归还给用户剩余的租金
 * 	3.数据库信息交互
 * 	4.安全验证（待开发）
 * @author bwfadmin
 *
 */
public interface IRentPayService {
	
	/**
	 * 付款时支付总的租金，并做减法
	 * @param allPayPrice
	 * @return
	 */
	public boolean caculatePayBalance(RentOrderInfo rentOrderInfo);
	/**
	 * 还车时归还扣费后的剩余租金
	 * @param allPayPrice
	 * @param totalTimePrice
	 * @return
	 */
	public boolean caculateReturnBalance(RentOrderInfo rentOrderInfo);
	
	
	
	
	
	
	
	
	
	
}
