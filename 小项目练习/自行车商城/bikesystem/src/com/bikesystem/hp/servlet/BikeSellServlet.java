package com.bikesystem.hp.servlet;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.entity.BikeSell;
import com.bikesystem.hp.dao.BikeSellDaoImpl;
import com.bikesystem.hp.dao.IBikeSellDao;
import com.bikesystem.hs.dao.BikeKindDaoImpl;
import com.bikesystem.hs.dao.IBikeKindDao;


@WebServlet("/hp/bikesell")
public class BikeSellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private	IBikeSellDao sellDao;
	 private IBikeKindDao kindDao;
    public BikeSellServlet() {
        super();
    	sellDao = new BikeSellDaoImpl();
    	kindDao = new BikeKindDaoImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bikeName=request.getParameter("bikename");
		String shopName = request.getParameter("shopname");
		//动态添加传入的参数
			try{
				List<BikeSell> bikeSellList = sellDao.querySpecialBikeSell(bikeName, shopName);
				if(bikeSellList!=null){
						request.setAttribute("bikeSellList", bikeSellList);
					}
				request.setAttribute("bikename",bikeName);
				request.setAttribute("shopname",shopName);
				request.setAttribute("color", bikeSellList.get(0).getColor());
				request.setAttribute("bikecount", bikeSellList.get(0).getBikeCount());
				request.setAttribute("sellcount", bikeSellList.get(0).getSellCount());
				request.setAttribute("imgpath", bikeSellList.get(0).getImgPath());
				request.setAttribute("kindname", bikeSellList.get(0).getKindName());
				request.setAttribute("bikeprice", bikeSellList.get(0).getBikePrice());
				request.setAttribute("bikeheadinfo", bikeSellList.get(0).getBikeheadinfo());
				request.setAttribute("bikesubheadinfo", bikeSellList.get(0).getBikesubheadinfo());
				
			}
			catch(Exception e){
				response.sendRedirect("/bikesystem/hp/search");
				 return;  
			}
		//种类
		List<BikeKind> bikeKindsList = kindDao.queryAllBikeKind();
		if(bikeKindsList != null){
			request.setAttribute("bikeKindsList", bikeKindsList);
		}
					
				
		request.getRequestDispatcher("/WEB-INF/jsp/hp/marketSell.jsp").forward(request, response);
		
	}


}
