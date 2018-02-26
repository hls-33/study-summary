package com.bikesystem.txz.servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeSell;
import com.bikesystem.entity.BikeSellInfo;
import com.bikesystem.entity.User;
import com.bikesystem.hp.dao.BikeSellDaoImpl;
import com.bikesystem.hp.dao.BikeSellInfoDaoIpml;
import com.bikesystem.hp.service.BikeSellInfoServicImpl;
import com.bikesystem.hp.service.BikeSellServiceImpl;
import com.bikesystem.hp.service.IBikeSellInfoService;
import com.bikesystem.hp.service.IBikeSellService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryUserBuyBikeInfoServlt
 */
@WebServlet("/user/queryuserbikesell")
public class QueryUserBuyBikeInfoServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBikeSellInfoService bsi;
	private IBikeSellService bss;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserBuyBikeInfoServlt() {
        super();
        bsi=new BikeSellInfoServicImpl(new BikeSellInfoDaoIpml());
        bss=new BikeSellServiceImpl(new BikeSellDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		String name=user.getName();
		PrintWriter out=response.getWriter();
		ArrayList<BikeSellInfo> arr=(ArrayList<BikeSellInfo>) bsi.queryUserBikeRent(name);
		System.out.println(arr);
		ArrayList<BikeSellInfo> bslist=new ArrayList<BikeSellInfo>();
		boolean flag=false;
		if(arr!=null){
			Iterator<BikeSellInfo> it=arr.iterator();
			while(it.hasNext()){
				BikeSellInfo bsell=it.next();
				int bsid=bsell.getBsid();
				ArrayList<BikeSell> bs=(ArrayList<BikeSell>) bss.getBikeSellByBsid(bsid);
				if(bs!=null&&bs.size()>0){
					flag=true;
					BikeSellInfo newbsell=new BikeSellInfo(bsid, bsell.getShopName(),
							name, bsell.getBikePrice(),bsell.getSellDate(),
							bs.get(0).getBikeName(), bs.get(0).getKindName(), bs.get(0).getColor(), bs.get(0).getImgPath());
					bslist.add(newbsell);
					System.out.println(newbsell.toString());
				}
				
			}
		}
		if(flag){
			JSONArray jsarr=JSONArray.fromObject(bslist);
			System.out.println(jsarr.toString());
			out.write(jsarr.toString());
		}
		else request.getRequestDispatcher("/bikesystem//user/userpersonal").forward(request, response);
	}
}
