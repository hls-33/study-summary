package com.bikesystem.hp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeSell;
import com.bikesystem.entity.SellAddress;
import com.bikesystem.entity.User;
import com.bikesystem.hp.dao.BikeSellDaoImpl;
import com.bikesystem.hp.dao.IBikeSellDao;
import com.bikesystem.hp.service.BikeSellServiceImpl;
import com.bikesystem.hp.service.IBikeSellService;

@WebServlet("/user/hp/buynow")
public class BuyNowBikeSellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private	IBikeSellDao sellDao;
	 private IBikeSellService ibss;
	 private User user;
    public BuyNowBikeSellServlet() {
        super();
        sellDao = new BikeSellDaoImpl();
        ibss= new BikeSellServiceImpl(new BikeSellDaoImpl());
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String params = request.getQueryString();
		System.out.println("params:"+params);
		request.getSession().setAttribute("params", params);
		String bikeName=request.getParameter("bikename");
		String shopName = request.getParameter("shopname");
		String bikeColor = request.getParameter("bikecolor");
		String count = request.getParameter("count");
		request.setAttribute("bikecolor", bikeColor);//选择车的颜色
		request.setAttribute("count", count);//选择车的数量
		//过滤器 过滤登录，如果登陆了，则获取用户的姓名，没有则在过滤器中设置name，从数据库中读取
		 user = (User) request.getSession().getAttribute("user");
		String name = user.getName();
		request.setAttribute(name, "name");
		//动态添加传入的参数
		try{
				List<BikeSell> bikeSellList = sellDao.querySpecialBikeSell(bikeName, shopName);
				if(bikeSellList!=null&&!bikeSellList.equals("")){
					request.setAttribute("bikeSellList", bikeSellList);
					//查询该用户的所有地址
					List<SellAddress>SellAddressList = ibss.queryAllBikeSellAddress(name);
					if(SellAddressList!=null){
						request.setAttribute("SellAddressList", SellAddressList);
						//根据帐号名 和收货人姓名 》》》选择收货的地址，默认选择第一个
						request.setAttribute("username", SellAddressList.get(0).getUsername());//收货人姓名
						request.setAttribute("address", SellAddressList.get(0).getAddress());
						request.setAttribute("minuteaddress", SellAddressList.get(0).getMinuteaddress());
						request.setAttribute("phone", SellAddressList.get(0).getPhone());
						System.out.println("name："+name);
						System.out.println("SellAddressList:"+SellAddressList.size());
					}
					
				}
				request.setAttribute("bikename",bikeName);
				request.setAttribute("shopname",shopName);
				request.setAttribute("bikecount", bikeSellList.get(0).getBikeCount());
				request.setAttribute("sellcount", bikeSellList.get(0).getSellCount());
				request.setAttribute("bikeprice", bikeSellList.get(0).getBikePrice());
				request.setAttribute("imgpath", bikeSellList.get(0).getImgPath());
				request.setAttribute("color", bikeSellList.get(0).getColor());
				request.setAttribute("kindname", bikeSellList.get(0).getKindName());
				
				//计算购买车的总的价格
				String inputnumber = request.getParameter("inputnumber");
				if(inputnumber!=null && !inputnumber.equals("")){
						int inputnum = Integer.parseInt(inputnumber);
						if(inputnum<=1){
								inputnum=1;
						}
						request.setAttribute("allbikeprice", inputnum);
					}
				}
				catch(Exception e){
						e.printStackTrace();
						return;  
				}

		request.getRequestDispatcher("/WEB-INF/jsp/hp/buyNow.jsp").forward(request, response);
		
		
		
		
	}

}
