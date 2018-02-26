package com.bwf.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import com.bwf.entry.Book;
import com.bwf.entry.Info;
import com.bwf.entry.User;
import com.bwf.service.admin.AdminBookInfoManageServcieImpl;
import com.bwf.service.login.AdminLoginServiceImpl;
import com.bwf.utils.CtrlUtils;
import com.bwf.utils.DisplayUtils;
/**
 * 书籍管理界面
 * @author bwfadmin
 *
 */
public class BookView {
	private Scanner sc = CentreView.getSc();
	/**
	 * 图书库存查询（均可用）
	 */
	public boolean lookAllBook(){
		System.out.println("============图书信息查询界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null)
			return false;
		AdminBookInfoManageServcieImpl bookInfo = new AdminBookInfoManageServcieImpl();
		ArrayList<Info> bookList = bookInfo.findAll();
		if(bookList == null)
			return false;
		DisplayUtils.displayCtl("书籍信息检索中", ".");
		if(bookList.size() == 0)
			System.out.println("暂无图书信息！！");
		else{
			for(Info info : bookList){
				System.out.println("<<"+info+">>");
			}
		}
		return true;
	}
	
	/**
	 * 图书信息修改（仅管理员可用此功能！）
	 */
	public boolean updateBook(){
		System.out.println("============图书信息修改界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null || user.getAuthority() == 1)
			return false;
		AdminBookInfoManageServcieImpl bookInfo = new AdminBookInfoManageServcieImpl();
		int bookId = CtrlUtils.ctrlInt(sc, "请输入要修改的书籍ID：");
		String bookName = CtrlUtils.ctrlString(sc, "请输入修改后的书籍名称：");
		String bookAuthor = CtrlUtils.ctrlString(sc, "请输入修改后的作者名称：");
		Book newbook = new Book(bookId,bookName,bookAuthor,null);
		boolean flag = bookInfo.updateInfo(newbook);
		DisplayUtils.displayCtl("书籍信息更新中", ".");
		if(flag){
			System.out.println("图书更新成功！！");
		}else{
			System.out.println("图书不存在，还更新啥啊！");
		}
		return flag;
	}
	
	/**
	 * 图书信息增加（仅管理员可用此功能！）
	 */
	public boolean saveBook(){
		System.out.println("============图书信息添加界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null || user.getAuthority() == 1)
			return false;
		AdminBookInfoManageServcieImpl bookInfo = new AdminBookInfoManageServcieImpl();
		String bookName = CtrlUtils.ctrlString(sc, "请输入要添加的书籍名称：");
		String bookAuthor = CtrlUtils.ctrlString(sc, "请输入要添加的作者名称：");
		Book newbook = new Book(0,bookName,bookAuthor,null);
		boolean flag = bookInfo.saveInfo(newbook);
		DisplayUtils.displayCtl("书籍添加中", ".");
		if(flag){
			System.out.println("图书添加成功！！");
		}else{
			System.out.println("图书已存在，还添加啥啊！");
		}
		return flag;
	}
	
	/**
	 * 图书信息删除（仅管理员可用此功能！）
	 */
	public boolean removeBook(){
		System.out.println("============图书信息删除界面============");
		AdminLoginServiceImpl login = CentreView.getLogin();
		User user = login.getUser();	//获取登录账户
		if(user == null || user.getAuthority() == 1)
			return false;
		AdminBookInfoManageServcieImpl bookInfo = new AdminBookInfoManageServcieImpl();
		int bookId = CtrlUtils.ctrlInt(sc, "请输入要删除的书籍ID：");
		Book newbook = new Book(bookId,null,null,null);
		boolean flag = bookInfo.removeInfo(newbook);
		DisplayUtils.displayCtl("书籍删除中", ".");
		if(flag){
			System.out.println("图书删除成功！！");
		}else{
			System.out.println("图书都没有，你要删个啥？");
		}
		return flag;
	}
	
	@Test
	public void test(){
		LoginView lv = new LoginView();
		lv.login();
		System.out.println(saveBook());
		System.out.println(updateBook());
		System.out.println(removeBook());
		lookAllBook();
	}
}
