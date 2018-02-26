package com.bikesystem.hs.servlet;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.RentOrderInfo;
import com.bikesystem.utils.QrcodeUtils;

/**
 *	处理用户提交支付押金的动作
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月5日  下午7:24:09
 * tags
 */
@WebServlet("/user/hs/paydeposite")
public class PayRentDepositServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session中的信息传递实体类
		RentOrderInfo rentOrderInfo = (RentOrderInfo) request.getSession().getAttribute("rentOrderInfo");
		//获取用户设置的提车日期
		String orderdate = request.getParameter("orderdate");
		rentOrderInfo.setOrderDate(orderdate);
		request.getSession().setAttribute("rentOrderInfo", rentOrderInfo);
		
		
		double price = rentOrderInfo.getAllPayPrice();
		if(price>0){
			request.setAttribute("continaerPage", "./payqrcode.jsp");
		}else{
			request.setAttribute("continaerPage", "./payerror.jsp");
		}
		
		//保存二维码到image中
		String realPath = request.getSession().getServletContext().getRealPath("image/hs/payqrcode.png");
		String logoPath = request.getSession().getServletContext().getRealPath("image/hgg/logo.jpg");
		System.out.println("realPath:"+realPath);
		System.out.println("logoPath:"+logoPath);
		QrcodeUtils qrcode = new QrcodeUtils();
		
		InetAddress address = InetAddress.getLocalHost();
		String ip =address.getHostAddress();
		String content = "http://"+ip+":8080/bikesystem/user/hs/codescanner?scanner=true";
		System.out.println("content:"+content);
		qrcode.encoderQRCode(content, realPath, "png", 18, logoPath);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/hs/bikerentorder.jsp").forward(request, response);
	}
}