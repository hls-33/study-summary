package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.Admin;
import com.bikesystem.entity.UserRent;
import com.bikesystem.hgg.dao.ShopDaoImpl;
import com.bikesystem.hgg.dao.UserRentDaoImpl;
import com.bikesystem.hgg.service.ShopServiceImpl;
import com.bikesystem.hgg.service.UserRentServiceImpl;

@WebServlet("/hgg/queryuserrent")
public class QueryUserBikeRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRentServiceImpl userRentServiceImpl;
	private ShopServiceImpl shopServiceImpl;
	private List<UserRent> list;

    public QueryUserBikeRentServlet() {
        super();
        this.userRentServiceImpl=new UserRentServiceImpl(new UserRentDaoImpl());
        this.shopServiceImpl=new ShopServiceImpl(new ShopDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		//根据aid查询商店名
		String shopname=shopServiceImpl.queryShopNameByAid(admin.getAid());
		//根据传入的商店名查看商店内用户租借信息
		list=userRentServiceImpl.queryBikeRentByShopName(shopname);
		request.setAttribute("allUserRent", list);
		
		request.getRequestDispatcher("/WEB-INF/jsp/hgg/queryuserrent.jsp").forward(request,response);
	}

}
