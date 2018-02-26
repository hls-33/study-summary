package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.UserRent;
import com.bikesystem.hgg.dao.AdminUserRentDaoImpl;
import com.bikesystem.hgg.service.AdminUserRentServiceImpl;

@WebServlet("/hgg/queryadminuserrent")
public class QueryAdminUserRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminUserRentServiceImpl adminUserRentServiceImpl;
	private List<UserRent> urlist;
       
    public QueryAdminUserRentServlet() {
        super();
        this.adminUserRentServiceImpl=new AdminUserRentServiceImpl(new AdminUserRentDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopName=request.getParameter("shopname");
		urlist=adminUserRentServiceImpl.queryUserRentByShopName(shopName);
		request.setAttribute("userRentList", urlist);
		request.getRequestDispatcher("/WEB-INF/jsp/hgg/queryadminuserrent.jsp").forward(request, response);
	}

}
