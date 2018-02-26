package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.BikeDestroy;
import com.bikesystem.entity.BikeRent;
import com.bikesystem.hgg.dao.BikeDestroyDaoImpl;
import com.bikesystem.hgg.dao.BikeRentDaoImpl;
import com.bikesystem.hgg.service.BikeDestroyServiceImpl;
import com.bikesystem.hgg.service.BikeRentServiceImpl;

/**
 * Servlet implementation class InsertBikeDestroyServlet
 */
@WebServlet("/hgg/insertbikedestroy")
public class InsertBikeDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BikeDestroyServiceImpl bikeDestroyServiceImpl;
	private BikeRentServiceImpl bikeRentServiceImpl;
	private List<BikeDestroy> bdlist;
	
    public InsertBikeDestroyServlet() {
        super();
        this.bikeDestroyServiceImpl=new BikeDestroyServiceImpl(new BikeDestroyDaoImpl());
        this.bikeRentServiceImpl=new BikeRentServiceImpl(new BikeRentDaoImpl());
        bdlist=new ArrayList<BikeDestroy>();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取系统当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String destroydate=sdf.format(new Date());
		
		PrintWriter out=response.getWriter();
		
		//获取js里面bikenumber的字符串
		String str=request.getParameter("bikenumber");
		
		
		//判断传进来的bikenumber是多个还是单个
		if(str.contains("-")&&str!=null){
			//拆分成数组
			String[] bikenumberarr=str.split("-");
			BikeRent bikeRent=new BikeRent();
			for(int i=0;i<bikenumberarr.length;i++){
				//创建BikeRent对象，用于在创建BikeDestroy对象的时候获取相应的属性
				bikeRent=bikeRentServiceImpl.queryBikeRentByBikeNumber(bikenumberarr[i]);
				System.out.println(bikeRent);
				//给bdlist集合中追加BikeDestroy对象
				bdlist.add(new BikeDestroy(bikeRent.getBikeNumber(),destroydate,bikeRent.getBikeName(),
						bikeRent.getKindName(),bikeRent.getShopName(),bikeRent.getImgPath()));
				//把选择报废的车子从bike_rent表中给删除掉
				bikeRentServiceImpl.deleteBikeRent(bikeRent);
			}
			boolean result=false;
			//循环添加车子报废信息
			for(BikeDestroy bd:bdlist){
				result=bikeDestroyServiceImpl.insertBikeDestory(bd);
			}
			if(result){
				out.write("true");
			}
		}
		if(!str.contains("-")&&str!=null){
			//接收单个bikenumber,删除单个BikeRent,添加单个BikeDestroy
			
			
			BikeRent br=bikeRentServiceImpl.queryBikeRentByBikeNumber(str);
			
			bikeRentServiceImpl.deleteBikeRent(br);
			boolean insertresult=bikeDestroyServiceImpl.insertBikeDestory(
					new BikeDestroy(br.getBikeNumber(),destroydate, 
					br.getBikeName(), br.getKindName(), br.getShopName(), 
					br.getImgPath()));
			if(insertresult)
				out.write("true");
		}
	}

}
