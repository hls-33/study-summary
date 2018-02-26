package com.bikesystem.txz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.User;
import com.bikesystem.txz.interfaces.service.IUserService;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;
import com.bikesystem.txz.ipml.service.UserServiceIpml;
import com.bikesystem.utils.RegexUtil;

/**
 * Servlet implementation class UpdateUserEmailServlet
 */
@WebServlet("/user/updateuseremail")
public class UpdateUserEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserEmailServlet() {
        super();
       userservice=new UserServiceIpml(new UserDaoIpml());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		User user=(User) request.getSession().getAttribute("user");
		boolean flag=RegexUtil.getEmail(email);
		if(flag)userservice.updateUserInfoByEmail(user.getUphone(), email);
		//重定向到用户个人信息管理页面
		response.sendRedirect("/bikesystem/user/userpersonal");
	}
}
