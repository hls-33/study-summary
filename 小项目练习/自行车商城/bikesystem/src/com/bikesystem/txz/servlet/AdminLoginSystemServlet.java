package com.bikesystem.txz.servlet;

import java.io.IOException;
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

import net.sf.json.JSONArray;

/**
 * 管理员登录验证
 */
@WebServlet("/adminlogin")
public class AdminLoginSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminService adminservice;
    public AdminLoginSystemServlet() {
        super();
        adminservice=new AdminServiceIpml(new AdminDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("adminname");
		String pass=request.getParameter("apassword");
		String chk=request.getParameter("check");
		boolean[] flags={false,false,false};
		String surechk=request.getSession().getAttribute("servletcheck").toString();
		flags[0]=RegexUtil.getPassword(phone);
		flags[1]=RegexUtil.getPassword(pass);
		flags[2]=RegexUtil.getCheck(chk);
		boolean flag=true;
		for(int i=0;i<3;i++){
			if(!flags[i]){
				flag=false;
				break;
			}
		}
		if(flag&&surechk.equals(chk)){
			Admin admin=adminservice.adminLogin(phone, pass);
			if(admin!=null){
				System.out.println(admin.toString());
				request.getSession().setAttribute("admin", admin);
				request.getRequestDispatcher("/hgg/queryuserrent").forward(request, response);
			}
			else response.sendRedirect("/bikesystem/aindex.jsp");
		}
		else response.sendRedirect("/bikesystem/aindex.jsp");
	}

}
