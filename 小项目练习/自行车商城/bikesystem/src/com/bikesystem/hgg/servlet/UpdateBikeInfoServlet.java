package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.hgg.dao.BikeRentDaoImpl;
import com.bikesystem.hgg.service.BikeRentServiceImpl;

@WebServlet("/hgg/updatebikeinfo")
public class UpdateBikeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BikeRentServiceImpl bikeRentServiceImpl;
       
    public UpdateBikeInfoServlet() {
        super();
        this.bikeRentServiceImpl=new BikeRentServiceImpl(new BikeRentDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bikeNumber=request.getParameter("bikenumber");
		String hourPriceStr=request.getParameter("hourprice");
		double hourPrice=Double.parseDouble(hourPriceStr);
		
		String dayPriceStr=request.getParameter("dayprice");
		double dayPrice=Double.parseDouble(dayPriceStr);
		
		String depositStr=request.getParameter("deposit");
		double deposit=Double.parseDouble(depositStr);
		
		boolean result=bikeRentServiceImpl.updateBikeRent(bikeNumber, hourPrice, dayPrice, deposit);
		System.out.println(bikeNumber+" "+hourPrice+" "+dayPrice+" "+deposit);
		PrintWriter out=response.getWriter();
		if(result){
			out.write("true");
		}
	}

}
