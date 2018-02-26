package com.bikesystem.txz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bikesystem.entity.User;
import com.bikesystem.txz.interfaces.service.IUserService;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;
import com.bikesystem.txz.ipml.service.UserServiceIpml;
import com.bikesystem.utils.RegexUtil;

import net.sf.json.JSONArray;

@WebServlet("/userlogin")
public class UserLoginSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private IUserService userservice; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginSystemServlet() {
        super();
        userservice=new UserServiceIpml(new UserDaoIpml());
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean f1=false,f2=false;
		String status=request.getParameter("loginstatus");
		if(username!=null&&(username.contains("@")||username.contains("."))){
			f1=RegexUtil.getEmail(username);
		}
		else f1=RegexUtil.getPhoneRegex(username);
		f2=RegexUtil.getPassword(password);
		if(f1&&f2){
			User user=userservice.UserLogin(username, password);
			HttpSession session=request.getSession();
			if(user!=null){
				if(status!=null&& !"".equals(status)){
					javax.servlet.http.Cookie cookie=new javax.servlet.http.Cookie("loginstatus", user.toString());
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				session.setAttribute("user", user);
				
				//判断是过滤器转过来的还是本来就是直接访问提交的登录处理
				Object url = request.getSession().getAttribute("totalUrl");
				if(url == null){
					//说明不是过滤器转到登录页面登录后再来的
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else{
					String dispatcherUrl = url.toString().substring("/bikesystem".length());
					request.getRequestDispatcher(dispatcherUrl).forward(request, response);
				}
			}
			else{
				request.setAttribute("usererror", "用户名或密码错误");
				request.getRequestDispatcher("/jsp/userlogins.jsp").forward(request, response);
			}
		}
		else{ 
			request.setAttribute("usererror", "用户名或密码错误");
			request.getRequestDispatcher("/jsp/userlogins.jsp").forward(request, response);
			}
	}
}
