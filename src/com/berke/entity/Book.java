package com.berke.entity;

import com.berke.repository.IView;

public class Book implements IView{
	
	
	private String title;
	private String author;
	private int isbn;
	private int publicationDate;
	
	public Book() {
		
	}
	
	public Book(String title, String author, int isbn, int publicationDate) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(int publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public void view() {
		System.out.println("You have viewed a book.");
		
	}
	
}
