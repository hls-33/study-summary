package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.service.IShopService;
import com.bikesystem.hs.service.ShopServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryShowBikeRentServlet
 */
@WebServlet("/querybikerentinfo")
public class QueryShowBikeRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private IShopService imgservice;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryShowBikeRentServlet() {
        super();
        imgservice=new ShopServiceImpl(new BikeRentDaoImpl());
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str=request.getParameter("content");
		PrintWriter out=response.getWriter();
		JSONArray jsarr=null;
		List<BikeRent> arr=new ArrayList<BikeRent>();
		arr=imgservice.queryAllBikeRent();
		jsarr=JSONArray.fromObject(arr);
		out.write(jsarr.toString());
	}

}
