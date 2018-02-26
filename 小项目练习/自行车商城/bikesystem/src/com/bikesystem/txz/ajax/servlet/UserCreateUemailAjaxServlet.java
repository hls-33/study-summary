package com.bikesystem.txz.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.txz.interfaces.service.IUserService;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;
import com.bikesystem.txz.ipml.service.UserServiceIpml;
import com.bikesystem.utils.RegexUtil;

/**
 * Servlet implementation class UserCreateUemailAjaxServlet
 */
@WebServlet("/uemail")
public class UserCreateUemailAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateUemailAjaxServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		PrintWriter out=response.getWriter();
		boolean flag=RegexUtil.getEmail(email);
		boolean f=userservice.queryUserByEmail(email);
		if(email==null||"".equals(email))
			out.write("邮箱不能为空");
		else if(flag&&f)
			out.write("");
		else if(flag&&!f)
			out.write("该邮箱已被注册");
		else out.write("邮箱格式错误(xxx@xxx.xxx)");
	}

}
