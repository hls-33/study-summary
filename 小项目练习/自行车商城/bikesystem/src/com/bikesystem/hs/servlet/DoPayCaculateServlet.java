package com.bikesystem.hs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.RentOrderInfo;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.UserRentDaoImpl;
import com.bikesystem.hs.service.IRentPayService;
import com.bikesystem.hs.service.RentPayServiceImpl;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;

/**
 *
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月10日  上午8:51:30
 * tags
 */
@WebServlet("/hs/dopaycaculate")
public class DoPayCaculateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IRentPayService rentPayService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		rentPayService = new RentPayServiceImpl(new UserDaoIpml(),
				new UserRentDaoImpl(), new BikeRentDaoImpl());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对数据做数据验证和数据库交互
		RentOrderInfo rentOrderInfo = (RentOrderInfo) request.getSession().getAttribute("rentOrderInfo");
		System.out.println("CodeScannerServlet----rentOrderInfo:"+rentOrderInfo);
		boolean payResult = rentPayService.caculatePayBalance(rentOrderInfo);
		System.out.println("payResult:"+payResult);
		if(payResult){
			response.getWriter().write("success");
		}else{
			response.getWriter().write("fail");
		}
	}
}