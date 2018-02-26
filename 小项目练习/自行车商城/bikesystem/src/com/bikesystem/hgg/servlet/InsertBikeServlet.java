package com.bikesystem.hgg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikesystem.entity.Admin;
import com.bikesystem.entity.BikeRent;
import com.bikesystem.entity.BikeSell;
import com.bikesystem.hgg.dao.BikeRentDaoImpl;
import com.bikesystem.hgg.dao.BikeSellDaoImpl;
import com.bikesystem.hgg.dao.ShopDaoImpl;
import com.bikesystem.hgg.service.BikeRentServiceImpl;
import com.bikesystem.hgg.service.BikeSellServiceImpl;
import com.bikesystem.hgg.service.ShopServiceImpl;

/**
 * Servlet implementation class InsertBikeServlet
 */
@WebServlet("/hgg/insertbike")
public class InsertBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random ran=new Random();
	private static final String bikeForSell="出售";
	private static final String bikeForRent="出租";
	private BikeSellServiceImpl bikeSellServiceImpl;
	private BikeRentServiceImpl bikeRentServiceImpl;
	private ShopServiceImpl shopServiceImpl;
	private BikeSell bikeSell;
	private BikeRent bikeRent;
	private String shopName;

    public InsertBikeServlet() {
        super();
        this.bikeRentServiceImpl=new BikeRentServiceImpl(new BikeRentDaoImpl());
        this.bikeSellServiceImpl=new BikeSellServiceImpl(new BikeSellDaoImpl());
        this.shopServiceImpl=new ShopServiceImpl(new ShopDaoImpl());
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		//根据aid查询商店名
		String shopname=shopServiceImpl.queryShopNameByAid(admin.getAid());
		shopName=shopname;
		//获取车型
		String kindName=request.getParameter("kindname");
		//获取车辆用途（出租、出售）
		String bikeForWhat=request.getParameter("bikeforwhat");
		PrintWriter out=response.getWriter();
		if(bikeForRent.equals(bikeForWhat)){
			//获取车名
			String bikeName=request.getParameter("bikename");
			List<BikeRent> list=bikeRentServiceImpl.queryBikeRentByShopName(shopname);
			//获取车牌号
			String bikeNumberStr=getBikeNumber();
			String bikeNumber="";
			boolean flag = true;
			while(true){
				flag = true;
				for(BikeRent br:list){
					if(!br.getBikeNumber().equals(bikeNumberStr)){
						bikeNumber=bikeNumberStr;
					}
					else{
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
				bikeNumberStr=getBikeNumber();
			}
			
			
			System.out.println(bikeNumber);
			
			//获取车身颜色
			String color=request.getParameter("color");
			
			//获取图片路径
			String imgPathStr=request.getParameter("imgpath");
			int index=imgPathStr.lastIndexOf("\\");
			String imgPath="/bikesystem/image/hs/"+imgPathStr.substring(index+1);
			
			System.out.println(imgPath);
			
			//获取时租金
			String hourPriceStr=request.getParameter("hourprice");
			double hourPrice=Double.parseDouble(hourPriceStr);
			//获取日租金
			String dayPriceStr=request.getParameter("dayprice");
			double dayPrice=Double.parseDouble(dayPriceStr);
			//获取押金
			String bikedepositStr=request.getParameter("bikedeposit");
			double bikedeposit=Double.parseDouble(bikedepositStr);
			
			bikeRent=new BikeRent(bikeNumber, bikeName, color, kindName, shopname, hourPrice, dayPrice, "未出租", imgPath, bikedeposit, 0);
			System.out.println(bikeRent);
			//插入租赁自行车
			bikeRentServiceImpl.insertBikeRent(bikeRent);
			out.write("true");
		}
		if(bikeForSell.equals(bikeForWhat)){
			//获取车名
			String bikeName=request.getParameter("bikesellname");
			//获取车型
			String kindname=request.getParameter("kindsellname");
			//获取车身颜色
			String color=request.getParameter("bikesellcolor");
			//获取图片路径
			String imgPathStr=request.getParameter("bikesellimgpath");
			System.out.println(imgPathStr);
			int index=imgPathStr.lastIndexOf("\\");
			String imgPath="/bikesystem/image/hs/"+imgPathStr.substring(index+1);
			//获取车辆数量
			String bikeCountStr=request.getParameter("bikecount");
			int bikeCount=Integer.parseInt(bikeCountStr);
			//获取车辆售价
			String bikePriceStr=request.getParameter("bikeprice");
			double bikePrice=Double.parseDouble(bikePriceStr);
			//获取商品标题
			String bikeheadinfo=request.getParameter("bikeheadinfo");
			//获取商品描述
			String bikesubheadinfo=request.getParameter("bikesubheadinfo");
			bikeSell=new BikeSell(bikeName, bikeCount, color, kindname, shopname, bikePrice, imgPath, 0,bikeheadinfo,bikesubheadinfo);
			System.out.println(bikeSell);
			//插入出售自行车
			bikeSellServiceImpl.insertBikeSell(bikeSell);
			out.write("true");
		}
	}
	public String getBikeNumber(){
		String number="";
		//循环生成5个随机数 组成字符串
		for(int i=0;i<5;i++){
			number+=String.valueOf(ran.nextInt(9));
		}
		System.out.println(number);
		//生成车牌号
		String bikeNumberStr="bk"+shopName+"rent"+number;
		return bikeNumberStr;
		
	}

}
