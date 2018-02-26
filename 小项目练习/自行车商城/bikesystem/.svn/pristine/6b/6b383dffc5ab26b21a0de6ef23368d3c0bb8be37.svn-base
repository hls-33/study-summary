package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.Admin;
import com.bikesystem.entity.BikeRent;
import com.bikesystem.hgg.dao.BikeRentDaoImpl;
import com.bikesystem.hgg.dao.ShopDaoImpl;
import com.bikesystem.hgg.service.BikeRentServiceImpl;
import com.bikesystem.hgg.service.ShopServiceImpl;

@WebServlet("/hgg/showbikedestroy")
public class ShowBikeDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BikeRentServiceImpl bikeRentServiceImpl;
	private ShopServiceImpl shopServiceImpl;
	private List<BikeRent> brlist;
       
    public ShowBikeDestroyServlet() {
        super();
        this.bikeRentServiceImpl=new BikeRentServiceImpl(new BikeRentDaoImpl());
        this.shopServiceImpl=new ShopServiceImpl(new ShopDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		//根据aid查询商店名
		String shopname=shopServiceImpl.queryShopNameByAid(admin.getAid());
		brlist=bikeRentServiceImpl.queryAllBikeRentNoRented(shopname);
		request.setAttribute("allbikerent", brlist);
		request.getRequestDispatcher("/WEB-INF/jsp/hgg/insertBikeDestroy.jsp").forward(request,response);
	}

}
