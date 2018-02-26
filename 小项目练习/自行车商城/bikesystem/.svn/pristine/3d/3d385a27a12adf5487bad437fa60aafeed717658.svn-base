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
 * Servlet implementation class UserCreateByAddressAjaxServlet
 */
@WebServlet("/uaddress")
public class UserCreateByAddressAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateByAddressAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address=request.getParameter("address");
		PrintWriter out=response.getWriter();
		boolean flag=RegexUtil.getAddress(address);
		if(address==null||"".equals(address))
			out.write("住址不能为空");
		else if(!flag)
			out.write("住址格式错误（xx省xx市xxx）");
		else out.write("");
	}

}
