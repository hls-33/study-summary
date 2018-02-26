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
 * 身份证号码
 */
@WebServlet("/uidnumber")
public class UserCreateUidnumberAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateUidnumberAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uidnumber=request.getParameter("uid");
		PrintWriter out=response.getWriter();
		boolean flag=RegexUtil.getIdnumber(uidnumber);
		if(uidnumber==null||"".equals(uidnumber))
			out.write("身份证号码不能为空");
		else if(!flag)
			out.write("身份证号码格式不正确");
		else out.write("");
	}

}
