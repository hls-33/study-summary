package com.bikesystem.txz.manner.servlet;

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

import net.sf.json.JSONArray;

/**
 * 管理员信息查询
 */
@WebServlet("/adminqueryinfo")
public class AdminQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminService adminservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQueryServlet() {
        super();
       adminservice=new AdminServiceIpml(new AdminDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		Admin adminsel=adminservice.queryAdminInfo(admin.getAphone());
		PrintWriter out=response.getWriter();
		if(adminsel!=null){
			JSONArray jsonarr=JSONArray.fromObject(adminsel);
			out.write(jsonarr.toString());
		}
		else out.write("没有此管理员的相关信息");
	}
}
