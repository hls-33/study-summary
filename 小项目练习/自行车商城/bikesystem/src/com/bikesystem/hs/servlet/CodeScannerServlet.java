package com.bikesystem.hs.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.RentOrderInfo;
import com.bikesystem.entity.User;
import com.bikesystem.entity.UserScanner;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.IUserScannerDao;
import com.bikesystem.hs.dao.UserRentDaoImpl;
import com.bikesystem.hs.dao.UserScannerDaoImpl;
import com.bikesystem.hs.service.IRentPayService;
import com.bikesystem.hs.service.RentPayServiceImpl;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;

/**
 * 检查用户是否已经扫描了二维码进行模拟付款的servlet
 * 并且在这个servlet中验证用户的余额是否足够支付，并且做相应的数据库信息交互
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月8日  上午10:47:04
 * tags
 */
@WebServlet("/user/hs/codescanner")
public class CodeScannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserScannerDao userScanDao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		userScanDao = new UserScannerDaoImpl();
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scanner = request.getParameter("scanner");
		if("true".equals(scanner)){
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("user: "+user);
			UserScanner userScanner = userScanDao.queryUserScannerStateByUid(user.getUid());
			//如果表中没有对应uid的UserScanner信息，说明还没有初始化,在将初始化的信息读取出来修改
			if(userScanner == null){
				userScanDao.insertInitUserScanner(user.getUid());
				userScanner = userScanDao.queryUserScannerStateByUid(user.getUid());
			}
			
			userScanner.setScannerstate("true");
			userScanDao.updateUserScannerState(userScanner);
			
		}else{
		}
	}
}