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
 * Servlet implementation class AdminCreateAnameAjax
 */
@WebServlet("/aname")
public class AdminCreateAnameAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminCreateAnameAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String aname=request.getParameter("aname");
		boolean flag=RegexUtil.getName(aname);
		if(aname==null||"".equals(aname))
			out.write("登录名不能为空");
		else if(!flag)
			out.write("登录名格式错误");
		else out.write("");
	}
}
