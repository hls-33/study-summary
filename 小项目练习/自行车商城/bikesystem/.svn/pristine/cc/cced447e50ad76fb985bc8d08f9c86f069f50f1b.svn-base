package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeKind;
import com.bikesystem.hgg.service.BikeKindServiceImpl;
import com.bikesystem.hs.dao.BikeKindDaoImpl;
@WebServlet("/hgg/showinsertbike")
public class ShowInsertBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BikeKindServiceImpl bikeKindServiceImpl;
       
    public ShowInsertBikeServlet() {
        super();
        this.bikeKindServiceImpl=new BikeKindServiceImpl(new BikeKindDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BikeKind> bklist=bikeKindServiceImpl.queryAllBikeKind();
		request.setAttribute("bikekind", bklist);
		request.getRequestDispatcher("/WEB-INF/jsp/hgg/insertBike.jsp").forward(request, response);
	}

}
