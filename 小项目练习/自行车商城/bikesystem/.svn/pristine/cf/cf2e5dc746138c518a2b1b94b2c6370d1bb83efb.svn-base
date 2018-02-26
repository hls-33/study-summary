package com.bikesystem.hp.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bikesystem.hp.dao.BikeSellDaoImpl;
import com.bikesystem.hp.service.BikeSellServiceImpl;
import com.bikesystem.hp.service.IBikeSellService;

@WebServlet("/user/hp/priceajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private IBikeSellService ibss;
    public AjaxServlet() {
        super();
        ibss= new BikeSellServiceImpl(new BikeSellDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除已过期的地址，当用户点击删除项时，异步传入一个对应的id
		String id = request.getParameter("said");
		boolean jsonid = false;
		if(id!=null && !id.equals("")){
			String aid = id.replaceAll("\\s*", "");
			System.out.println(aid);
			int said = Integer.parseInt(aid);
			
			jsonid = ibss.deleteBikeSellAddressById(said);
		}
		if(jsonid){
			
			response.getWriter().write("true");;
		}
		else{
			response.getWriter().write("false");;
		}
		System.out.println("ajax :id--"+id);
	}
	
}
