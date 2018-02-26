package com.bikesystem.hs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.BikeSell;
import com.bikesystem.entity.ShopImage;
import com.bikesystem.hs.dao.BikeKindDaoImpl;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.BikeSellDaoImpl;
import com.bikesystem.hs.dao.IBikeKindDao;
import com.bikesystem.hs.dao.ShopImageDaoImpl;
import com.bikesystem.hs.service.IShopBikesSearchService;
import com.bikesystem.hs.service.IShopImageService;
import com.bikesystem.hs.service.ShopBikesSearchServiceImpl;
import com.bikesystem.hs.service.ShopImageServiceImpl;

/**
 *
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月4日  上午10:26:05
 * tags
 */
@WebServlet("/hs/category")
public class ShopBikesSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IShopBikesSearchService shopBikesService;
	private IBikeKindDao bikeKindDao;
	private IShopImageService shopImageService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		shopBikesService = new ShopBikesSearchServiceImpl(new BikeRentDaoImpl(),
				new BikeSellDaoImpl());
		shopImageService = new ShopImageServiceImpl(new ShopImageDaoImpl());
		bikeKindDao = new BikeKindDaoImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String shopName = request.getParameter("shopname");
		String bikeType = request.getParameter("biketype");
		String orderType = request.getParameter("ordertype");
		String kindName = request.getParameter("kindname");
		
		System.out.println("shopName:"+shopName+" bikeType"+bikeType+" orderType"+orderType+" kindName"+kindName);
		
		request.setAttribute("shopname", shopName);
		
		if(orderType == null){
			//根据传递的bikeType参数来决定调用那个Dao方法来访问数据库
			if("sell".equals(bikeType)){
				List<BikeSell> shopBikes = shopBikesService.queryAllBikeSellByShopName(shopName);
				request.setAttribute("shopBikes",shopBikes);
				
				//保存一个返回的shopBikes的区分标志：sell的或者rent的
				request.setAttribute("listLogo","sell");
			}else if("rent".equals(bikeType)){
				List<BikeRent> shopBikes = shopBikesService.queryAllBikeRentByShopName(shopName);
				request.setAttribute("shopBikes",shopBikes);
				request.setAttribute("listLogo","rent");
			}else if("kind-rent".equals(bikeType)){
				List<BikeRent> shopBikes = shopBikesService.queryAllBikeRentByShopName(shopName, kindName);
				request.setAttribute("shopBikes",shopBikes);
				request.setAttribute("listLogo","rent");
			}else if("kind-sell".equals(bikeType)){
				List<BikeSell> shopBikes = shopBikesService.queryAllBikeSellByShopName(shopName, kindName);
				request.setAttribute("shopBikes",shopBikes);
				request.setAttribute("listLogo","sell");
			}else{}//如果都不对，则不进行查询
		}else{//说明选的是按序查看所有的rent车或sell车
			if("rent".equals(bikeType)){
				if("rentcount_desc".equals(orderType)){
					List<BikeRent> shopBikes = shopBikesService.queryAllBikeRentOrderByRentCount(shopName);
					request.setAttribute("shopBikes",shopBikes);
					request.setAttribute("listLogo","rent");
				}else if("dayprice_desc".equals(orderType)){
					List<BikeRent> shopBikes = shopBikesService.queryAllBikeRentOrderByDayPrice(shopName);
					request.setAttribute("shopBikes",shopBikes);
					request.setAttribute("listLogo","rent");
				}else{}//如果都不对，则不进行查询
			}else if("sell".equals(bikeType)){
				if("sellcount_desc".equals(orderType)){
					List<BikeSell> shopBikes = shopBikesService.queryAllBikeSellOrderBySellCount(shopName);
					request.setAttribute("shopBikes",shopBikes);
					request.setAttribute("listLogo","sell");
				}else if("bikeprice_desc".equals(orderType)){
					List<BikeSell> shopBikes = shopBikesService.queryAllBikeSellOrderByBikeprice(shopName);
					request.setAttribute("shopBikes",shopBikes);
					request.setAttribute("listLogo","sell");
				}else{}//如果都不对，则不进行查询
			}
		}
		System.out.println("shopBikes:"+request.getAttribute("shopBikes"));
		//查询商店的主页图片路径并保存到request请求
		List<ShopImage> headImages = shopImageService.queryShopImage(shopName,"headImage");
		request.setAttribute("headImages", headImages);
		
		//查询自行车种类
		List<BikeKind> bikeKinds = bikeKindDao.queryAllBikeKind();
		request.setAttribute("bikeKinds", bikeKinds);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/hs/shopbikes.jsp").forward(request, response);
		
		
		
		
		
	}
}