package com.bikesystem.txz.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.txz.interfaces.service.IAdminService;
import com.bikesystem.txz.ipml.dao.AdminDaoIpml;
import com.bikesystem.txz.ipml.service.AdminServiceIpml;
import com.bikesystem.utils.RegexUtil;

/**
 * Servlet implementation class AdminCreateAphoneAjaxServlet
 */
@WebServlet("/aphone")
public class AdminCreateAphoneAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminService adminservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateAphoneAjaxServlet() {
        super();
        adminservice=new AdminServiceIpml(new AdminDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String aphone=request.getParameter("aphone");
		boolean flag=RegexUtil.getPhoneRegex(aphone);
		if(aphone==null||"".equals(aphone))
			out.write("手机号不能为空");
		else if(!flag)
			out.write("手机号格式错误");
		else if(!adminservice.queryByAphone(aphone))
			out.write("手机号已被注册");
		else out.write("");
	}

}
