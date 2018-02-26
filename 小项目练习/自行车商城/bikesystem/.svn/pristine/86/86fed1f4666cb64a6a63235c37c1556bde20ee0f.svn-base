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
 * 处理用户姓名输入逻辑
 */
@WebServlet("/uname")
public class UserCreateUnameAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateUnameAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		PrintWriter out=response.getWriter();
		boolean flag=RegexUtil.getName(uname);
		if(uname==null||"".equals(uname))
			out.write("用户名不能为空");
		else if(!flag)
			out.write("用户姓名格式错误");
		else out.write("");
	}

}
