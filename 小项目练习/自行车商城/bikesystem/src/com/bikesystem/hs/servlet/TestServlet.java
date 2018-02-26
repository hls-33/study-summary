package com.bikesystem.hs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月8日  上午11:27:58
 * tags
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object sc = request.getSession().getAttribute("scanner");
		System.out.println("test sc: "+sc);
		//如果通过二维码扫描了，则返回给异步一个信息
		if(sc != null){
			response.getWriter().write(sc.toString());
		}else{
			response.getWriter().write("test sc: null");
		}
	}
}