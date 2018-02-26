package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UserSearchPasswordByphoneServlet
 */
@WebServlet("/usersearchpass")
public class UserSearchPasswordByphoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchPasswordByphoneServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		boolean flag=RegexUtil.getPassword(phone);
		PrintWriter out=response.getWriter();
		if(!flag)
			out.write("输入手机号格式错误");
		User user=userservice.queryUserInfo(phone);
		if(user!=null)
			out.write(user.getPassword());
		else out.write("没有此用户的相关信息");
	}
}
