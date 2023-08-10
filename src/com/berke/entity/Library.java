package com.berke.entity;

import java.util.Scanner;

import com.berke.repository.IView;

public class Library implements IView{
	
	Book book=new Book();
	
	Scanner sc=new Scanner(System.in);
	Book[] bookList;
	int size=0;
	
	public void application() {
		int picked;
		do {
			showAll();
			picked=choice();
			if(picked==0) {
				System.out.println("Çıkış yapıldı.");
			}else {
				menu(picked);
			}			
		}while(picked!=0);
				
		
	}
	
	public void menu(int choice) {
		switch(choice) {
		case 1:
			add(create());
			
			break;
		case 2:
			remove();
			
			break;
		case 3:
			search();
			book.view();
			break;
		case 4:
			list(bookList);
			view();
			break;
		default:
			System.err.println("Please enter a valid number.");
		}
		

	}
	
	public void showAll() {
		System.out.println();
		System.out.println("LIBRARY APP");
		System.out.println();
		System.out.println("1- Add a new book");
		System.out.println("2- Remove a book");
		System.out.println("3- Find a book");
		System.out.println("4- List all books");
		System.out.println("0- Exit");
		
	}
	
	public int choice() {
		System.out.println("Please choose an option: ");
		int choice=sc.nextInt();
		sc.nextLine();
		return choice;
		
	}	
	
	public Book create() {
		System.out.println("Please enter the book's title: ");
		String bookTitle=sc.nextLine();
		System.out.println("Please enter the name of the book's author:");
		String bookAuthor=sc.nextLine();
		System.out.println("Please enter the ISBN no for the book: ");
		int isbnNo=sc.nextInt();
		System.out.println("Please enter the year of the book's publication: ");
		int bookProductionDate=sc.nextInt();
		Book book=new Book(bookTitle,bookAuthor,isbnNo,bookProductionDate);
		System.err.println("The book has been added.");
		return book;
			
	}
	public void add(Book book) {
		Book[]tmp;
		if(bookList==null) {
			bookList=new Book[1];
			bookList[0]=book;
		}else {
			tmp=new Book[size+1];
			for(int i=0;i<size;i++) {
				tmp[i]=bookList[i];
			}tmp[size]=book;
			bookList=tmp;
		}
		size++;
	}
	
	public void remove() {
		if(bookList==null) {
			System.err.println("The library is empty.");
		}else {
		int j=0;
		System.out.println("Please enter the ISBN number of the book to be removed: ");
		int isbnNo=sc.nextInt();
		Book[]tmp=new Book[size-1];
		for(int i=0;i<size-1;i++) {
			if(bookList[i].getIsbn()!=isbnNo) {
				tmp[i]=bookList[i+j];
			}else {
				j=1;
				tmp[i]=bookList[i+j];
			}
		}
		bookList=tmp;
		size--;
		System.err.println("The book has been removed.");
	}
}	
	public void search() {
		boolean control=false;
		System.out.println("Please enter the name of the book you're searching for: ");
		String bookTitle=sc.nextLine();
		for(int i=0;i<size;i++) {
			if(bookList[i].getTitle().equalsIgnoreCase(bookTitle)) {
				System.err.println("The book you're looking for is in stock.");
				control=true;
				}				
			}
			if (control == false) {
				System.err.println("The book you're looking for is out of stock.");
		}
	}
	
	public void list(Book[] bookList) {
		if(size==0) {
			System.out.println("The library is empty.");
		}else {
		for(int i=0;i<bookList.length;i++) {
			System.out.print("Title: " + bookList[i].getTitle());
			System.out.print(" || Author: " + bookList[i].getAuthor());
			System.out.print(" || ISBN: " + bookList[i].getIsbn());
			System.out.print(" || Publication Date: " + bookList[i].getPublicationDate());
			System.out.println();
		}
	}
}
	@Override
	public void view() {
		System.out.println("You have viewed the library. ");
		
	}
}
