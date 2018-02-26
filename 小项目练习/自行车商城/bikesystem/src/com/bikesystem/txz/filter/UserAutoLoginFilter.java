package com.bikesystem.txz.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.User;
import com.bikesystem.txz.interfaces.service.IUserService;
import com.bikesystem.txz.ipml.dao.UserDaoIpml;
import com.bikesystem.txz.ipml.service.UserServiceIpml;

/**
 * 用户自动登录逻辑处理
 */
@WebFilter(urlPatterns={"/user/*"})
public class UserAutoLoginFilter implements Filter {
	private IUserService userservice;
    /**
     * Default constructor. 
     */
    public UserAutoLoginFilter() {
       userservice=new UserServiceIpml(new UserDaoIpml());
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		
		//获取request请求的那个页面,并保存到session域中
		String reqUri = request.getRequestURI();
		String params = request.getQueryString();
		String totalUrl = reqUri+"?"+params;
		System.out.println("filter : totalUrl ="+totalUrl);
		request.getSession().setAttribute("totalUrl", totalUrl);
		
		
		Cookie[] cookies=request.getCookies();
		boolean flag=false;
		boolean cookieUserExsit =false;
		User user=null;
		if(cookies!=null&&cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				String str=cookies[i].getName();
				if("loginstatus".equals(str)){
					cookieUserExsit = true;
					String value=cookies[i].getValue();
					if(value!=null){
						String[] values=value.split(":");
						user=userservice.UserLogin(values[0], values[1]);
					}
					if(user!=null){
						request.getSession().setAttribute("user", user);
						System.out.println("cookie中的user保存："+user);
						flag=true;break;
					}
				}
			}
		}
		if(!cookieUserExsit){
			Object usersession = request.getSession().getAttribute("user");
			if(usersession!=null){
				flag=true;
				user =(User) usersession;
			}
		}
		
		System.out.println("User:"+user);
		if(!flag){
			response.sendRedirect("/bikesystem/jsp/userlogins.jsp");
		}

		else{
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
