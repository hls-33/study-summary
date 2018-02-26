package com.bikesystem.hs.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.UserRent;
import com.bikesystem.hs.dao.IUserRentDao;
import com.bikesystem.hs.dao.BikeRentDaoImpl;
import com.bikesystem.hs.dao.IBikeRentDao;
import com.bikesystem.hs.dao.UserRentDaoImpl;

/**
 *
 * @author bwfadmin  E-mail: 654835916@qq.com
 * @version v1.0 创建时间：2017年5月2日  下午5:13:43
 * tags
 */
@WebServlet("/hs/bikerent")
public class BikeRentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IBikeRentDao bikeRentDao;
	private IUserRentDao userRentDao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		bikeRentDao = new BikeRentDaoImpl();
		userRentDao = new UserRentDaoImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bikeName=request.getParameter("bikename");
		String shopName = request.getParameter("shopname");
		String brid = request.getParameter("brid");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bikename", bikeName);
		map.put("shopname", shopName);
		map.put("brid",brid);
		//查询数据库中中要租的那个车辆
		List<BikeRent> rents = bikeRentDao.queryAllBikeRentByParameter(map);
		if(rents!=null && rents.size()>0){
			BikeRent bikeRent = rents.get(0);
			request.setAttribute("bikeRent",bikeRent);
			
			//如果是已出租了，那就查询出出租的那个用户的信息记录
			if("已出租".equals(bikeRent.getIsRented())){
				UserRent userRent = userRentDao.queryUserBikeRentByBikeNumber(bikeRent.getBikeNumber());
				if(userRent!=null){
					request.setAttribute("userRent", userRent);
				}
			}
			//找到了对应的值才转发到目标页
			request.getRequestDispatcher("/WEB-INF/jsp/hs/marketrent.jsp").forward(request, response);
		}else{
			
			//没找到目标值，则跳转到提示页，提示没有找到对应车辆
			response.sendRedirect("/bikesystem/html/hs/notfound.html");
		}
		
		
		
		
	}
}