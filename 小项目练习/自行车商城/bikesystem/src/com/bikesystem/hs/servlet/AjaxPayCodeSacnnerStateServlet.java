package com.bikesystem.hs.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.User;
import com.bikesystem.entity.UserScanner;
import com.bikesystem.hs.dao.IUserScannerDao;
import com.bikesystem.hs.dao.UserScannerDaoImpl;

/**
 * 前端做异步轮询验证用户是否扫描了二维码进行付款
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月8日  上午9:45:22
 * tags
 */
@WebServlet("/hs/ajaxcodescanner")
public class AjaxPayCodeSacnnerStateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserScannerDao userScanDao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		userScanDao = new UserScannerDaoImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		UserScanner userScanner = userScanDao.queryUserScannerStateByUid(user.getUid());
		
		if(userScanner!=null){
			//查询结果不为空，则按照规则返回
			String scannerstate = userScanner.getScannerstate();
			//如果已经付款了，则应该将其scannerstate重新初始化为false，等待下一次的扫码付款状态
			if("true".equals(scannerstate)){
				userScanner.setScannerstate("false");
				userScanDao.updateUserScannerState(userScanner);
			}
			//响应给异步扫描付款状态
			response.getWriter().write(scannerstate);
		}else{
			response.getWriter().write("false");
		}
	}
}