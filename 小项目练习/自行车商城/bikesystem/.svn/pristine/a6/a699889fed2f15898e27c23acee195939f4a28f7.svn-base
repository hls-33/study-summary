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
 * Servlet implementation class UserLoginCheckAjaxServlet
 */
@WebServlet("/loginchkajax")
public class UserLoginCheckAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCheckAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String chk=request.getParameter("chk");
		String checkstr=request.getSession().getAttribute("servletcheck").toString();
		boolean flag=RegexUtil.getCheck(chk);
		if(chk==null||"".equals(chk)){
			out.write("验证码不能为空");
		}
		else if(!flag)
			out.write("验证码格式错误");
		else if(checkstr!=null&&!"".equals(checkstr)&&checkstr.equals(chk))
			out.write("");
		else out.write("验证码输入错误");
	}

}
