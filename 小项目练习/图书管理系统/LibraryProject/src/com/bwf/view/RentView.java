package com.bwf.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.entry.Rent;
import com.bwf.entry.User;
import com.bwf.service.admin.AdminRentInfoManageServcieImpl;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.service.user.UserBookInfoManageServcieImpl;
import com.bwf.service.user.UserInfoManageServcieImpl;
import com.bwf.service.user.UserRentInfoManageServcieImpl;
import com.bwf.utils.CtrlUtils;
import com.bwf.utils.DateUtils;
import com.bwf.utils.DisplayUtils;
/**
 * 借阅信息管理界面
 * @author bwfadmin
 *
 */
public class RentView {
	private Scanner sc = CentreView.getSc();
	/**
	 * 借阅信息查看
	 * @return
	 */
	public boolean lookAll(){
		System.out.println("============借阅信息查询界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null)
			return false;
		if(user.getAuthority() == 0){	//管理员查看所有借阅信息
			AdminRentInfoManageServcieImpl rentInfo = new AdminRentInfoManageServcieImpl();
			ArrayList<Info> infoList = rentInfo.findAll();
			if(infoList == null)
				return false;
			DisplayUtils.displayCtl("借阅信息检索中", ".");
			if(infoList.size() == 0)
				System.out.println("暂无用户的借阅信息！！");
			else{
				for(Info info : infoList){
					System.out.println("<<"+info+">>");
				}
			}
			return true;
		}else{
			UserRentInfoManageServcieImpl rentInfo = new UserRentInfoManageServcieImpl();
			ArrayList<Info> infoList = rentInfo.findAll(user);
			if(infoList == null)
				return false;
			if(infoList.size() == 0)
				System.out.println("暂无用户您的借阅信息！！");
			else{
				for(Info info : infoList){
					System.out.println("<<"+info+">>");
				}
			}
			return true;
		}
	}
	/**
	 * 用户续借（仅针对普通用户账号）
	 */
	public boolean renew(){
		System.out.println("============图书续借界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null)
			return false;
		UserRentInfoManageServcieImpl rentInfo = new UserRentInfoManageServcieImpl();
		int bookId = CtrlUtils.ctrlInt(sc, "请输入你要续借的书籍编号：");
		//获取选择的需要续借的Rent_info对象
		Rent rent = rentInfo.getRentByBookId(user, bookId);
		if(rent == null){
			System.out.println("无此编号对应的书籍借阅信息！");
			return false;
		}
		//判定被续借的书是否已续借过或者逾期
		if(rent.getDayDiff() >0){
			System.out.println("该书已续借过，无法再续借");
			return false;
		}else if(DateUtils.getDayDiff(rent.getReturnDate()) <0){
			System.out.println("该书已逾期！无法再续借");
			return false;
		}
		System.out.print("你要续借的书籍信息如下：\n"+rent+"\n");
		int dayDiff =CtrlUtils.ctrlInt(sc, "请输入你要续借的天数：");
		String choose = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
		if(choose.equals("y")){
			DisplayUtils.displayCtl("书籍续借中", ".");
			Rent renew = new Rent(0, bookId, rent.getRentBook(), rent.getRentUser(), rent.getRentCredit(), null, null, dayDiff);
			System.out.println("续借书籍成功！");
			return rentInfo.updateInfo(renew);
		}else{
			System.out.println("续借书籍取消！");
			return false;
		}
	}
	
	/**
	 * 用户归还图书
	 */
	public boolean returnRent(){
		System.out.println("============图书归还界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null)
			return false;
		UserRentInfoManageServcieImpl rentInfo = new UserRentInfoManageServcieImpl();
		int rentId = CtrlUtils.ctrlInt(sc, "请输入你还书的对应归还编号ID：");
		Rent rent = rentInfo.getRentById(user, rentId);
		if(rent == null){
			System.out.println("无此编号对应的书籍借阅信息！");
			return false;
		}
		System.out.print("你要归还的书籍信息如下：\n"+rent+"\n");
		String choose = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
		if(choose.equals("y")){
			DisplayUtils.displayCtl("书籍归还中", ".");
			Rent returnRent = new Rent(rentId,rent.getBookId(), null, null,0,null, null,0);
			System.out.println("书籍归还成功！！");
			return rentInfo.removeInfo(returnRent);
		}else{
			System.out.println("归还取消！！");
			return false;
		}
	}
	
	/**
	 * 用户借书
	 */
	public boolean rentBook(){
		System.out.println("============图书借阅界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null )
			return false;
		if(user.getCredits() <20 && user.getCredits()>=2)
			System.out.println("您的积分已不足，请及时充值");
		if(user.getCredits() <=1){
			System.out.println("没积分还来借书？去氪金吧！");
			return false;
		}
		UserRentInfoManageServcieImpl rentInfo = new UserRentInfoManageServcieImpl();
		UserBookInfoManageServcieImpl bookInfo = new UserBookInfoManageServcieImpl();
		UserInfoManageServcieImpl userInfo = new UserInfoManageServcieImpl();
		int bookId = CtrlUtils.ctrlInt(sc, "请输入你要借阅的书籍编号：");
		Book book = bookInfo.getBook(bookId);
		if(book == null){
			System.out.println("无此编号对应的书籍信息！");
			return false;
		}
		System.out.print("你要借阅的书籍信息如下：\n"+book+"\n");
		String choose = CtrlUtils.ctrlString(sc, "确认y/其他键取消：");
		if(choose.equals("y")){
			Rent returnRent = new Rent(0, bookId, book.getBookName(), user.getUsername(),
					user.getCredits(),null, null,0);
			boolean flag = rentInfo.saveInfo(returnRent);
			DisplayUtils.displayCtl("图书借出中", ".");
			if(flag){
				//借书成功则扣积分-2
				userInfo.updateCredits(user, 2);
				System.out.println("借书成功！");
			}else{
				System.out.println("该书已经被借了，别逗！");
			}
			return flag;
		}else{
			System.out.println("借书取消！");
			return false;
		}
	}
	
	@Test
	public void test(){
		LoginView lv = new LoginView();
		lv.login();
		rentBook();
		returnRent();
		renew();
		lookAll();
	}
}
