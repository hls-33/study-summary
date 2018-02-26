package com.bikesystem.txz.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.utils.RegexUtil;

/**
 * Servlet implementation class UserLoginUpasswordAjaxServlet
 */
@WebServlet("/loginpassajax")
public class UserLoginUpasswordAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginUpasswordAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String password=request.getParameter("password");
		boolean flag=RegexUtil.getPassword(password);
		if(password==null||"".equals(password)){
			out.write("输入密码不能为空");
		}
		else if(!flag)
			out.write("输入密码格式错误");
		else out.write("");
	}

}
