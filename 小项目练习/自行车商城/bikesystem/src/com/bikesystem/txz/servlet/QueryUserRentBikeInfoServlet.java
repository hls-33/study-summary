package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.User;
import com.bikesystem.entity.UserRent;
import com.bikesystem.hs.dao.UserRentDaoImpl;
import com.bikesystem.txz.interfaces.service.IUserRentQueryService;
import com.bikesystem.txz.ipml.service.UserRentQueryServletIpml;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryUserRentBikeInfoServlet
 */
@WebServlet("/user/queryuserbikerent")
public class QueryUserRentBikeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserRentQueryService userquery;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserRentBikeInfoServlet() {
        super();
       userquery=new UserRentQueryServletIpml(new UserRentDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		String name=user.getName();
		ArrayList<UserRent> arr=(ArrayList<UserRent>) userquery.getUserRentByName(name);
		PrintWriter out=response.getWriter();
			JSONArray jsarr=JSONArray.fromObject(arr);
			System.out.println(jsarr.toString());
			out.write(jsarr.toString());
	}

}
