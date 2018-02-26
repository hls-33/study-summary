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
 * Servlet implementation class UserLoginNameAjaxServlet
 */
@WebServlet("/loginajax")
public class UserLoginNameAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginNameAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		boolean flag=false;
		if(username.contains("@")||username.contains(".")){
			flag=RegexUtil.getEmail(username);
			if(!flag)
				out.write("输入邮箱格式错误");
			else out.write("");
		}
		else{
			flag=RegexUtil.getPhoneRegex(username);
			if(!flag)
				out.write("输入手机号格式错误");
			else out.write("");
		}
	}

}
