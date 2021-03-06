package com.bikesystem.hp.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bikesystem.entity.SellAddress;
import com.bikesystem.entity.User;
import com.bikesystem.hp.dao.BikeSellDaoImpl;
import com.bikesystem.hp.service.BikeSellServiceImpl;
import com.bikesystem.hp.service.IBikeSellService;

@WebServlet("/hp/address")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		private  IBikeSellService ibss;
		private User user;
    public AddressServlet() {
        super();
        ibss= new BikeSellServiceImpl(new BikeSellDaoImpl());
        user = new User();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String params = request.getSession().getAttribute("params").toString();
		System.out.println("params----:"+params);
		user = (User) request.getSession().getAttribute("user");
		String name = user.getName();
		String username = request.getParameter("username");//收货人姓名
		String address = request.getParameter("city");
		String minuteaddress = request.getParameter("minuteaddress");
		String phone = request.getParameter("phone");
		boolean flag=false;
		System.out.println(name+username+":"+address+":"+minuteaddress+":"+phone);
		try{
			
			if(!name.equals("")&&!username.equals("")&&!address.equals("")&&!minuteaddress.equals("")&&!phone.equals("")){
				flag = ibss.insertBikeSellAddress(new SellAddress(name,username, address, minuteaddress, phone));
			}
			
		}
			catch(Exception e){
				response.sendRedirect("/bikesystem/buyaddress.jsp");
				 return;  
			}
		if(flag){
			response.sendRedirect("/bikesystem/user/hp/buynow?"+params+"");
					}
		else{
			//未传参数进来所以重定向回去填地址
			response.sendRedirect("/bikesystem/buyaddress.jsp");
		}

	}

}
