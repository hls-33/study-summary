package com.bikesystem.hs.dao;

import java.util.List;

import com.bikesystem.entity.ShopRentSale;

public interface IShopRentSaleDao {
	/**
	 * 商家添加租车折扣信息
	 * @param rentSale
	 * @return
	 */
	public boolean insertRentSale(ShopRentSale rentSale);
	
	/**
	 * 商家修改租车折扣信息
	 * @param rentSale
	 * @return
	 */
	public boolean updateRentSale(ShopRentSale rentSale);
	
	/**
	 * 商家查询自家店铺所有租车的折扣信息
	 * @return
	 */
	public List<ShopRentSale> queryAllRentSaleByShopname(String shopname);
	
	/**
	 * 商家查询某一辆租车的折扣
	 * @param brid
	 * @return
	 */
	public ShopRentSale queryRentSaleByBrid(int brid);
	
	/**
	 * 商家删除某一辆租车的折扣
	 * @param brid
	 * @return
	 */
	public boolean delteRentSaleByBrid(int brid);
}
