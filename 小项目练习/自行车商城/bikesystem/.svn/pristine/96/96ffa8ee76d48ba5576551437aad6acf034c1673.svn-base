package com.bikesystem.txz.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminCreateAsurepassAjaxServlet
 */
@WebServlet("/asurepass")
public class AdminCreateAsurepassAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateAsurepassAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("asure");
		PrintWriter out=response.getWriter();
		if(str==null||"".equals(str))
			out.write("确认密码不能为空");
		else{
			if(str.length()>1&&str.contains(":")){
				String[] values=str.split(":");
				if(values[0]==null||values[1]==null||values[0].length()<=0||values[1].length()<=0)
					out.write("确认密码格式错误");
				else if(values[0].equals(values[1]))
					out.write("");
				else out.write("确认密码与设置密码不同");
			}
			else out.write("确认密码格式错误");
		}
	}

}
