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
 * Servlet implementation class UpdateUserPhoneServ
 */
@WebServlet("/user/updateuserphone")
public class UpdateUserPhoneServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPhoneServ() {
        super();
       userservice=new UserServiceIpml(new UserDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("uphone");
		User user=(User) request.getSession().getAttribute("user");
		boolean flagp=RegexUtil.getPhoneRegex(phone);
		if(flagp){
			boolean flag=userservice.updateUserInfoByPhone(user.getUphone(), phone);
			if(flag){
				user.setUphone(phone);
				request.getSession().setAttribute("user", user);
			}
		}
		response.sendRedirect("/bikesystem/user/userpersonal");
	}
}
