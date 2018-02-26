package com.bwf.entry;

public class Book extends Info{
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookState;
	
	public Book() {
	}
	public Book(int bookId, String bookName, String bookAuthor, String bookState) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookState = bookState;
	}
	
	@Override
	public String toString() {
		return "书籍编号："+bookId+"  书名："+bookName+"  作者："+bookAuthor+"  状态："+bookState;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}
	
	public String getBookState() {
		return bookState;
	}
	public void setBookState(String bookState) {
		this.bookState = bookState;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
}
