package com.bikesystem.utils;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;
/**
 * 二维码绘画类，用在二维码工具类当中
 * @author bwfadmin
 *
 */
public class QrcodeImage implements QRCodeImage {
	BufferedImage bufImg;  
    
    public QrcodeImage(BufferedImage bufImg) {  
        this.bufImg = bufImg;  
    }  
      
    @Override  
    public int getHeight() {  
        return bufImg.getHeight();  
    }  
  
    @Override  
    public int getPixel(int x, int y) {  
        return bufImg.getRGB(x, y);  
    }  
  
    @Override  
    public int getWidth() {  
        return bufImg.getWidth();  
    }  
}
