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

/**
 * Servlet implementation class UserPersonalInformationServlet
 */
@WebServlet("/user/userpersonal")
public class UserPersonalInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPersonalInformationServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null)request.getRequestDispatcher("/WEB-INF/jsp/txz/userpersoninfo.jsp").forward(request, response);
		else response.sendRedirect("/bikesystem/jsp/userlogins.jsp");
	}
}
