package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.User;
import com.bikesystem.txz.interfaces.service.IUserService;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;
import com.bikesystem.txz.ipml.service.UserServiceIpml;

import net.sf.json.JSONArray;

/**
 * 查询用户个人信息逻辑
 */
@WebServlet("/queryuserinfo")
public class QueryUserPersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userservice;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserPersonalInfoServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		PrintWriter out=response.getWriter();
		String uphone=user.getUphone();
		User u=userservice.queryUserInfo(uphone);
		JSONArray jsarr=JSONArray.fromObject(u);
		out.write(jsarr.toString());
	}
}
