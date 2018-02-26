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
import com.bikesystem.entity.ShopRentSale;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.ShopDaoImpl;
import com.bikesystem.hs.dao.ShopRentSellDaoImpl;
import com.bikesystem.hs.dao.UserRentDaoImpl;
import com.bikesystem.hs.service.IRentOrderService;
import com.bikesystem.hs.service.RentOrderServiceImpl;
import com.bikesystem.utils.MoneyFormatUtil;
import com.bikesystem.utils.ParseNumberUtils;

/**
 *
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月6日  下午2:23:40
 * tags
 */
@WebServlet("/hs/caculate")
public class AjaxCaculateRentPriceServlet extends HttpServlet {

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
		RentOrderInfo rentOrderInfo = (RentOrderInfo) request.getSession().getAttribute("rentOrderInfo");
		
		String brid = request.getParameter("brid");
		BikeRent bikeRent = orderService.queryRentByBrid(brid);
		String rentType = request.getParameter("renttype");
		String rentTimes = request.getParameter("renttimes");
		//更新rentOrderInfo信息类的中的type和times
		rentOrderInfo.setRentType(rentType);
		rentOrderInfo.setRentTimes(ParseNumberUtils.parseIntId(rentTimes));
		
		
		if(bikeRent !=null){
			//初始化价格
			double totalTimePrice = bikeRent.getDayPrice();//默认值按一天的价格来算。。
			ShopRentSale rentSale = orderService.queryRentSaleByBrid(bikeRent.getBrid());
			//如果有折扣信息，则对bikeRent的hourPrice和dayPrice值进行修改。
			if(rentSale != null){
				double newHourPrice = bikeRent.getHourPrice()+rentSale.getHourSalePrice().doubleValue();
				double newDayPrice = bikeRent.getDayPrice()+rentSale.getDaySalePrice().doubleValue();
				
				if("hourmodel".equals(rentType)){
					totalTimePrice= Integer.parseInt(rentTimes)*newHourPrice;
				}else if("daymodel".equals(rentType)){
					totalTimePrice= Integer.parseInt(rentTimes)*newDayPrice;
				}else{
					totalTimePrice = newDayPrice*365;//如果是乱来的参数，则按照一年的价格计算
				}
			}else{//没有折扣，按原价计算
				if("hourmodel".equals(rentType)){
					totalTimePrice= Integer.parseInt(rentTimes)*bikeRent.getHourPrice();
				}else if("daymodel".equals(rentType)){
					totalTimePrice= Integer.parseInt(rentTimes)*bikeRent.getDayPrice();
				}else{
					totalTimePrice = bikeRent.getDayPrice()*365;//如果是乱来的参数，则按照一年的价格计算
				}
			}
			double allPayPrice = bikeRent.getBikedeposit()+totalTimePrice;//计算加上租金的总价格
			
			//更新rentOrderInfo信息类的中的totaltimeprice和总价格
			rentOrderInfo.setTotalTimePrice(totalTimePrice);
			rentOrderInfo.setAllPayPrice(allPayPrice);
			
			
			//转换为#.00格式
			String totalTimePriceStr=MoneyFormatUtil.parseMoney(totalTimePrice);
			String allPayPriceStr = MoneyFormatUtil.parseMoney(allPayPrice);
			
			//将money保存到session中，便于后台之间直接获取，不能在其他servlet中从前台获取其值（安全考虑）
			request.getSession().setAttribute("allPayPrice", allPayPriceStr);
			//组成json字符串返回异步请求
			String priceJsonStr ="{\"totalTimePrice\":"+totalTimePriceStr+",\"allPayPrice\":"+allPayPriceStr+"}" ;
			System.out.println("priceJsonStr: "+priceJsonStr);
			response.getWriter().write(priceJsonStr);
		}
	}
}