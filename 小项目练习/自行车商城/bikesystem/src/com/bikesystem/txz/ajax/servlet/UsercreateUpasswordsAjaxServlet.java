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
 * Servlet implementation class UsercreateUpasswordsAjaxServlet
 */
@WebServlet("/upassword")
public class UsercreateUpasswordsAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsercreateUpasswordsAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("upassword");
		PrintWriter out=response.getWriter();
		boolean flag=RegexUtil.getPassword(password);
		if(password==null||"".equals(password))
			out.write("密码不能为空");
		else if(!flag)
			out.write("密码长度为8~16位");
		else out.write("");
	}

}
