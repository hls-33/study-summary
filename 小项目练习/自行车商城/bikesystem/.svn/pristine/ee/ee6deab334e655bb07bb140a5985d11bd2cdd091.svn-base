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
 * Servlet implementation class AdminLoginNameAjaxServlet
 */
@WebServlet("/aloginajax")
public class AdminLoginNameAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginNameAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("adminname");
		boolean flag=RegexUtil.getPhoneRegex(name);
		if(name==null||"".equals(name)){
			out.write("登录手机号不能为空");
		}
		else if(!flag)
			out.write("登录手机号格式错误");
		else out.write("");
	}

}
