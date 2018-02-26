package com.bikesystem.txz.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.utils.RegexUtil;

/**
 * Servlet implementation class AdminCreateAidnumberAjaxServlet
 */
@WebServlet("/aidnumberp")
public class AdminCreateAidnumberAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateAidnumberAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String idnumber=request.getParameter("aidnumber");
		boolean flag=RegexUtil.getIdnumber(idnumber);
		if(idnumber==null||"".equals(idnumber))
			out.write("身份号码不能为空");
		else if(!flag)
			out.write("身份证号格式错误");
		else out.write("");
	}

}
