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

import net.sf.json.JSON;

@WebServlet("/userregist")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uphone=request.getParameter("uphone");
		String name=request.getParameter("uname");
		String password=request.getParameter("upass");
		String surepass=request.getParameter("usurepass");
		String sex=request.getParameter("personsex");
		String idnumber=request.getParameter("idnumber");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		boolean[] flags=new boolean[7];
		flags[0]=RegexUtil.getPhoneRegex(uphone);
		flags[1]=RegexUtil.getName(name);
		flags[2]=RegexUtil.getPassword(password);
		flags[3]=RegexUtil.getSex(sex);
		flags[4]=RegexUtil.getIdnumber(idnumber);
		flags[5]=RegexUtil.getAddress(address);
		flags[6]=RegexUtil.getEmail(email);
		boolean f=true;
		for(int i=0;i<7;i++){
			if(!flags[i]){
				f=false;
				break;
			}
		}
		boolean flag=false;
		if(f&&password.equals(surepass))
			flag=userservice.userRegist(new User(uphone, password, name, idnumber, sex, address, email, 0.0));
		if(flag){
			request.getRequestDispatcher("/jsp/userlogins.jsp").forward(request, response);
		}
		else response.sendRedirect("/bikesystem/jsp/usercreate.jsp");
	}
}
