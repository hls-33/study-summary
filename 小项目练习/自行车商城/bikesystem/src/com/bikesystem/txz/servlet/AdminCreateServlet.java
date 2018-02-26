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

/**
 *管理员注册
 */
@WebServlet("/admincreate")
public class AdminCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminService adminservice;
    public AdminCreateServlet() {
        super();
        adminservice=new AdminServiceIpml(new AdminDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aphone=request.getParameter("aphone");
		String aname=request.getParameter("aname");
		String apassword=request.getParameter("apassword");
		String asurepass=request.getParameter("asurepass");
		String aidnumber=request.getParameter("aidnumber");
		boolean flag=true;
		boolean[]flags={false,false,false,false};
		flags[0]=RegexUtil.getPhoneRegex(aphone);
		flags[1]=RegexUtil.getName(aname);
		flags[2]=RegexUtil.getPassword(apassword);
		flags[3]=RegexUtil.getIdnumber(aidnumber);
		for(int i=0;i<4;i++){
			if(!flags[i]){
				flag=false;
				break;
			}
		}
		if(flag&&!"".equals(apassword)&&apassword.equals(asurepass)){
			flag=adminservice.adminRegist(new Admin(aphone, apassword, aname, aidnumber));
		}
		if(flag)request.getRequestDispatcher("/aindex.jsp").forward(request, response);
		else response.sendRedirect("/bikesystem/aindex.jsp");
	}

}
