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
 * Servlet implementation class UpdateUserSomeInfoServlet
 */
@WebServlet("/user/updatesomeinfo")
public class UpdateUserSomeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserSomeInfoServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String sex=request.getParameter("usex");
		String address=request.getParameter("uaddress");
		boolean[]flags={false,false,false};
		flags[0]=RegexUtil.getName(name);
		flags[1]=RegexUtil.getSex(sex);
		flags[2]=RegexUtil.getAddress(address);
		if(flags[0]&&flags[1]&&flags[2]){
			User user=(User) request.getSession().getAttribute("user");
			String uphone=user.getUphone();
			userservice.updateUserInfo(new User(uphone, name, sex, address),user.getName());
			user.setName(name);
			request.getSession().setAttribute("user", user);
		}
		response.sendRedirect("/bikesystem/user/userpersonal");
	}
}
