package com.lms.library;

public class Book {
	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private int bookEdition;
	private int bookPrice;
	public Book(String bookTitle, String bookAuthor, String bookGenre, int bookEdition, int bookPrice) 
	{
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookEdition = bookEdition;
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book [bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookGenre=" + bookGenre
				+ ", bookEdition=" + bookEdition + ", bookPrice=" + bookPrice + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		Book givenBook=(Book) o;
		return this.bookPrice==givenBook.bookPrice;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public int getBookEdition() {
		return bookEdition;
	}
	public void setBookEdition(int bookEdition) {
		this.bookEdition = bookEdition;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}
