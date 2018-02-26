package com.bwf.entry;

public class Rent extends Info{
	private int rentId;
	private int bookId;
	private String rentBook;
	private String rentUser;
	private int rentCredit;
	private String rentDate;
	private String returnDate;
	private int dayDiff;
	public Rent() {
	}
	public Rent(int rentId, int bookId, String rentBook, String rentUser, int rentCredit, String rentDate,
			String returnDate,int dayDiff) {
		this.rentId = rentId;
		this.bookId = bookId;
		this.rentBook = rentBook;
		this.rentUser = rentUser;
		this.rentCredit = rentCredit;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.dayDiff = dayDiff;
	}
	@Override
	public String toString() {
		return "租用信息编号："+rentId+"  租用书籍编号："+bookId+"  租借书名："+rentBook+"  租借用户："+
					rentUser+"  用户积分："+rentCredit+"  租借日期："+rentDate+"  应还日期："+returnDate+
					"  已续借天数："+dayDiff+"天";
	}
	
	public int getDayDiff() {
		return dayDiff;
	}
	public void setDayDiff(int dayDiff) {
		this.dayDiff = dayDiff;
	}
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getRentBook() {
		return rentBook;
	}
	public void setRentBook(String rentBook) {
		this.rentBook = rentBook;
	}
	public String getRentUser() {
		return rentUser;
	}
	public void setRentUser(String rentUser) {
		this.rentUser = rentUser;
	}
	public int getRentCredit() {
		return rentCredit;
	}
	public void setRentCredit(int rentCredit) {
		this.rentCredit = rentCredit;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
}
