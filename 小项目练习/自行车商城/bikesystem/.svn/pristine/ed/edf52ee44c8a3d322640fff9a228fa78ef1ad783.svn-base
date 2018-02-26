package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.Admin;
import com.bikesystem.txz.interfaces.service.IAdminService;
import com.bikesystem.txz.ipml.dao.AdminDaoIpml;
import com.bikesystem.txz.ipml.service.AdminServiceIpml;
import com.bikesystem.utils.RegexUtil;

/**
 * 管理员忘记密码
 */
@WebServlet("/searchpassword")
public class AdminSearchPasswordByphoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminService adminservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchPasswordByphoneServlet() {
        super();
       adminservice=new AdminServiceIpml(new AdminDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		PrintWriter out=response.getWriter();
		boolean flag=RegexUtil.getPhoneRegex(phone);
		if(!flag)
			out.write("输入的手机号格式错误");
		else{
			Admin admin=adminservice.queryAdminInfo(phone);
			if(admin!=null)
				out.write(admin.getPassword());
			else out.write("没有此管理员的相关信息");
		}
	}
}
