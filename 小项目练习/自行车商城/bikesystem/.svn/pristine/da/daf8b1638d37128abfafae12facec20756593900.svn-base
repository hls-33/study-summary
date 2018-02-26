package com.bikesystem.hs.service;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.RentOrderInfo;
import com.bikesystem.entity.User;
import com.bikesystem.entity.UserRent;
import com.bikesystem.hs.dao.IBikeRentDao;
import com.bikesystem.hs.dao.IUserRentDao;
import com.bikesystem.txz.interfaces.dao.IUserDao;
import com.bikesystem.utils.DateCaculateUtils;

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
public class RentPayServiceImpl implements IRentPayService {
	
	private IUserDao userDao;
	private IUserRentDao userRentDao;
	private IBikeRentDao bikeRentDao;
	
	//用一个全局变量保存从user表中获取的user对象信息
	private User user;
	
	public RentPayServiceImpl(IUserDao userDao, IUserRentDao userRentDao, IBikeRentDao bikeRentDao) {
		super();
		this.userDao = userDao;
		this.userRentDao = userRentDao;
		this.bikeRentDao = bikeRentDao;
	}

	/**
	 * 根据传入的所需支付的总租金来判断余额是否足够
	 * @param allPayPrice
	 * @return
	 */
	private boolean verifyBalance(RentOrderInfo rentOrderInfo) {
		/*
		 * 直接从数据库中查询到balance，看和 rentOrderInfo中的user（来自于session，所以登录之后保存在session中的
		 * user信息应该是不变的，此时就不能只从rentOrderInfo中的user的balance来判断了）
		 */
		this.user= userDao.queryUserInfo(rentOrderInfo.getUser().getUphone());
		System.out.println("RentPayServiceImpl中：用户余额balance:"+this.user.getBalance());
		if(rentOrderInfo.getAllPayPrice()<this.user.getBalance()){
			System.out.println("ddddsdfasd");
			return true;
		}
		return false;
	}

	@Override
	public boolean caculatePayBalance(RentOrderInfo rentOrderInfo) {
		boolean ok = verifyBalance(rentOrderInfo);
		System.out.println("ok:"+ok);
		if(ok){
			//修改用户账户余额，并更新数据库
			double newBalance = this.user.getBalance()-rentOrderInfo.getAllPayPrice();
			this.user.setBalance(newBalance);
			System.out.println("更新余额操作："+userDao.updateUserInfo(this.user));
			System.out.println("this.user:"+this.user);
			
			//保存用户租赁信息到user_rent表中
			String name = rentOrderInfo.getUser().getName();
			BikeRent bikeRent = bikeRentDao.queryBikeRentByBrid(rentOrderInfo.getBrid());
			String bikeNumber = bikeRent.getBikeNumber();
			String bikeName = bikeRent.getBikeName();
			String shopName = bikeRent.getShopName();
			String orderDate = rentOrderInfo.getOrderDate();	//提车日期即租用日期
			String rentType =  rentOrderInfo.getRentType();
			int rentTimes = rentOrderInfo.getRentTimes();
			String returnDate=DateCaculateUtils.dateAdd(orderDate, rentType, rentTimes);
			if(returnDate == null)return false;	//日期失效，则返回false
			double deposit = rentOrderInfo.getAllPayPrice();
			UserRent userRent = new UserRent(name, bikeNumber, bikeName, shopName,
					orderDate, returnDate, deposit, rentType);
			if(!userRentDao.insertUserRent(userRent))return false;
			
			//修改bikeRent表中的对应自行车为已出租和租用次数+1
			bikeRent.setIsRented("已出租");
			bikeRent.setRentCount(bikeRent.getRentCount()+1);
			bikeRentDao.updateBikeRent(bikeRent);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean caculateReturnBalance(RentOrderInfo rentOrderInfo) {
		
		return false;
	}

}
