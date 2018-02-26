package com.bikesystem.txz.servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 */
@WebServlet("/showchk")
public class ShowCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int width=135;
    private static final int height=40;
    private static final String content="ABCd58efghiD67GHIqrstJKLMNYZ"+
    		"abQRcjnPSTpuvEFwxyVWz2km34UX9";
    public ShowCheckServlet() {
        super();
    }
    private Color getColor(int begin,int end){
    	if(begin<0)begin=0;
    	if(begin>255)begin=255;
    	if(end<0)end=0;
    	if(end>255)end=255;
    	int r=begin+(int)(Math.random()*(end-begin));
    	int g=begin+(int)(Math.random()*(end-begin));
    	int b=begin+(int)(Math.random()*(end-begin));
    	return new Color(r, g, b);
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics graphics=image.getGraphics();
	
		graphics.setColor(getColor(200,250));
		
		graphics.fillRect(0, 0, width, height);
		
		int x=0;
		String contentstr="";
		for(int i=0;i<5;i++){
			int index=(int)(Math.random()*content.length());
			String ch=content.substring(index, index+1);
			contentstr+=ch;
		
			graphics.setColor(getColor(15,150));
		
			graphics.setFont(new Font("Cooper Std Black",Font.BOLD,35));
			
			graphics.drawString(ch, x, 30);
			x+=26;
		}
		request.getSession().setAttribute("servletcheck", contentstr);
		
		for(int i=0;i<90;i++){
			int x1=(int)(Math.random()*width);
			int y1=(int)(Math.random()*height);
			graphics.setColor(getColor(151,199));
			graphics.drawLine(x1, y1, x1+4, y1+4);
		}
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
}
































