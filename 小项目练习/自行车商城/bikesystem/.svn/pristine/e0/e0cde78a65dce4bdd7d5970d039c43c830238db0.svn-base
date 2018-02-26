package com.bikesystem.txz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeSell;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.BikeSellDaoImpl;
import com.bikesystem.hs.service.IShopService;
import com.bikesystem.hs.service.ShopServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryShowAllInformation
 */
@WebServlet("/querybikesellinfo")
public class QueryShowAllInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private IShopService imgservice;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryShowAllInformation() {
        super();
        imgservice=new ShopServiceImpl(new BikeSellDaoImpl());
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String str=request.getParameter("content");
		PrintWriter out=response.getWriter();
		ArrayList<BikeSell> arr=new ArrayList<BikeSell>();
		JSONArray jsarr=null;
		arr=(ArrayList<BikeSell>) imgservice.queryAllBikeSell();
		System.out.println(arr);
		if(arr!=null){
			jsarr=JSONArray.fromObject(arr);
			out.write(jsarr.toString());
		}
		else out.write("没有相关信息");
	}

}
