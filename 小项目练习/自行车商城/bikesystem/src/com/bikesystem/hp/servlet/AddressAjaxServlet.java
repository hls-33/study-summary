package com.bikesystem.hp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hp/addressajax")
public class AddressAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddressAjaxServlet() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Address = request.getParameter("address");
		String NamePhone = request.getParameter("namephone");
		NamePhone = NamePhone.substring(0, NamePhone.length()-1).trim();
		String JsonStr =Address+"&"+NamePhone ;
		response.getWriter().write(JsonStr);
		System.out.println(">>>>>>>>>>>>>>>JsonStr:"+JsonStr);
		
	}

}
