package com.bikesystem.hs.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.RentOrderInfo;
import com.bikesystem.entity.Shop;
import com.bikesystem.entity.ShopRentSale;
import com.bikesystem.entity.User;
import com.bikesystem.entity.UserRent;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.ShopDaoImpl;
import com.bikesystem.hs.dao.ShopRentSellDaoImpl;
import com.bikesystem.hs.dao.UserRentDaoImpl;
import com.bikesystem.hs.service.IRentOrderService;
import com.bikesystem.hs.service.RentOrderServiceImpl;
import com.bikesystem.utils.ParseNumberUtils;

/**
 *
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月5日  上午10:45:08
 * tags
 */
@WebServlet("/user/hs/rentorder")
public class RentOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IRentOrderService orderService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		orderService = new RentOrderServiceImpl(new BikeRentDaoImpl(),
				new UserRentDaoImpl(),new ShopDaoImpl(),new ShopRentSellDaoImpl());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在session中保存rentOrderInfo的信息的对象
		RentOrderInfo rentOrderInfo = new RentOrderInfo();
		
		
		String brid = request.getParameter("brid");
		String shopName = request.getParameter("shopname");
		
		BikeRent bikeRent = orderService.queryRentByBrid(brid);
		
		//将没有做折扣计算的bikeRent先存到request中。
		BikeRent oldBikeRent = new BikeRent();
		oldBikeRent.setBrid(bikeRent.getBrid());
		oldBikeRent.setDayPrice(bikeRent.getDayPrice());
		oldBikeRent.setHourPrice(bikeRent.getHourPrice());
		oldBikeRent.setBikedeposit(bikeRent.getBikedeposit());
		request.setAttribute("oldBikeRent",oldBikeRent);
		System.out.println("oldBikeRent: "+oldBikeRent.getDayPrice());
		
		UserRent userRent=orderService.queryUserRentByBikeNumber(bikeRent.getBikeNumber());
		Shop shop = orderService.queryShopByShopname(shopName);
		if(bikeRent !=null){
			ShopRentSale rentSale = orderService.queryRentSaleByBrid(bikeRent.getBrid());
			//如果有折扣信息，则对bikeRent的hourPrice和dayPrice值进行修改。
			if(rentSale != null){
				double newHourPrice = bikeRent.getHourPrice()+rentSale.getHourSalePrice().doubleValue();
				double newDayPrice = bikeRent.getDayPrice()+rentSale.getDaySalePrice().doubleValue();
				bikeRent.setHourPrice(newHourPrice);
				bikeRent.setDayPrice(newDayPrice);
				request.setAttribute("rentSale",rentSale);
			}
		}
		
		double allPayPrice = bikeRent.getBikedeposit()+bikeRent.getDayPrice();
		request.setAttribute("allPayPrice",allPayPrice);
		
		/*
		 * 设置rentOrderInfo的初始获得的信息
		 * 将money保存到session中，便于后台之间直接获取，不能在其他servlet中从前台获取其值（安全考虑）
		 */
		rentOrderInfo.setBrid(ParseNumberUtils.parseIntId(brid));
		rentOrderInfo.setSid(shop.getSid());
		rentOrderInfo.setRentType("daymodel");
		rentOrderInfo.setRentTimes(1);
		rentOrderInfo.setTotalTimePrice(bikeRent.getDayPrice());
		rentOrderInfo.setAllPayPrice(allPayPrice);
		User user = (User)request.getSession().getAttribute("user");
		rentOrderInfo.setUser(user);
		request.getSession().setAttribute("rentOrderInfo", rentOrderInfo);
		
		
		System.out.println("newBikeRent: "+bikeRent.getDayPrice());
		request.setAttribute("newBikeRent",bikeRent);
		request.setAttribute("userRent", userRent);
		request.setAttribute("shop", shop);
		request.setAttribute("initAllPayPrice", allPayPrice);
		
		request.setAttribute("continaerPage","./confirmorder.jsp");
		request.getRequestDispatcher("/WEB-INF/jsp/hs/bikerentorder.jsp").forward(request, response);
	}
}