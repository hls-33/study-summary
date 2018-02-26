package com.bikesystem.hp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeSellInfo;
import com.bikesystem.hp.dao.BikeSellInfoDaoIpml;
import com.bikesystem.hp.dao.IBikeSellInfoDao;
import com.bikesystem.hp.service.BikeSellInfoServicImpl;
import com.bikesystem.hp.service.IBikeSellInfoService;

@WebServlet("/hp/referto")
public class RefertoSellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBikeSellInfoService ibs;
    public RefertoSellServlet() {
        super();
        ibs = new BikeSellInfoServicImpl(new BikeSellInfoDaoIpml());
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String bikeprice = request.getParameter("bikeprice");
			String shopname = request.getParameter("shopname");
			String name = request.getParameter("name");
			Date currentTime =  new Date();
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
			boolean flag = false;
		if(!bikeprice.equals(null) && !name.equals(null)){
			double price = Double.parseDouble(bikeprice);
			flag = ibs.insertBikeSellInfo(new BikeSellInfo(shopname,name,price,time));
		}
		System.out.println(time+name+bikeprice);
		PrintWriter out = response.getWriter();
		if(flag){
			out.write(">>>>>购买成功！！！！");
		}
		else{
			out.write(">>>>>余额不足！！！！");
		}
	}

}
