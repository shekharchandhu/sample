package com.lms.library;

import java.io.Serializable;

import java.util.Scanner;
import java.util.ArrayList;
@SuppressWarnings("serial")

public class Librarian extends Thread implements Serializable
{
	private Scanner scan=new Scanner(System.in);
	public void access()
	{
		BookDTO bookDTO=new BookDTO();
		BookDAO bookAccessObject=bookDTO.bookDAO();
		System.out.println("Press 1 to add a book..");
		System.out.println("Press 2 to search a book..");
		System.out.println("Press 3 to search a book using author");
		System.out.println("Press 4 to search book using book_name");
		System.out.println("Press 5 to update a book...");
		System.out.println("Press 6 to remove book....");
		System.out.println("Enter your choice");
		int choice =scan.nextInt();
		if(choice==1)
		{
			System.out.println("---Please enter Book details----");
			System.out.println("Enter book title...");
			String title=scan.next();
			System.out.println("Enter the author name...");
			String author=scan.next();
			System.out.println("Enter the genre...");
			String genre=scan.next();
			System.out.println("Enter the edition....");
			int edition=scan.nextInt();
			System.out.println("Enter the price.....");
			int price=scan.nextInt();
			Book book=new Book(title,author,genre,edition,price);
			bookAccessObject.addBook(book);
			
		}
		else if(choice==2)
		{
			System.out.println("---Please enter the following details------");
			System.out.println("Enter book title...");
			String bookTitle=scan.next();
			System.out.println("Enter the author name...");
			String bookAuthor=scan.next();
			
			System.out.println("Enter the edition...");
			int edition=scan.nextInt();
			
			Book detail=bookAccessObject.search(bookTitle,bookAuthor,edition);	
			System.out.println("The total book details is found,and its details are "+detail);
			
			
		}
		else if(choice==3)
		{
			System.out.println("Enter the name of the author");
			String bookAuthor=scan.next();
			ArrayList<Book> found=bookAccessObject.searchBookByAuthor(bookAuthor);
			System.out.println("The book is found,and its details is "+found);
			
		}
		else if(choice==4)
		{
			System.out.println("Enter the name of the book");
			String bookTitle=scan.next();
			ArrayList<Book> found=bookAccessObject.searchBookByTitle(bookTitle);
			System.out.println("The book is found,and its details is "+found);
			
			
		}
		else if(choice==5)
		{
			System.out.println("----Enter the details to old values------");
			System.out.println("---Please enter Book details----");
			System.out.println("Enter book title...");
			String title=scan.next();
			System.out.println("Enter the author name...");
			String author=scan.next();
			System.out.println("Enter the genre...");
			String genre=scan.next();
			System.out.println("Enter the edition....");
			int edition=scan.nextInt();
			System.out.println("Enetr the price.....");
			int price=scan.nextInt();
			Book book=new Book(title,author,genre,edition,price);
			Boolean update=bookAccessObject.updateBook(book);
			if(update==true)
			{
				System.out.println("The given details are successfuly updated");
			}
			else
			{
				System.out.println("Book is not updated,Please check your details");
			}
			
			
		}
		else if(choice==6)
		{
			System.out.println("Enter book title...");
			String title=scan.next();
			System.out.println("Enter the author name...");
			String author=scan.next();
			System.out.println("Enter the genre...");
			String genre=scan.next();
			System.out.println("Enter the edition....");
			int edition=scan.nextInt();
			System.out.println("Enetr the price.....");
			int price=scan.nextInt();
			Book book=new Book(title,author,genre,edition,price);
			
			Boolean value=bookAccessObject.removeBook(book);
			if(value==true)
			{
				System.out.println("Given details of book is removed");
			}
			else
			{
				System.out.println("Please enter corect Values");
			}
			
		}
		else
		{
			InvalidChoiceException e=new InvalidChoiceException();
			System.out.println(e);
		}
		
		
	}
	@Override
	public void run()
	{
		System.out.println("Welcome to libraary Management System");
		do
		{
			access();
			System.out.println("Press 'Y' to continue....");
			System.out.println("Press 'N' to stop");	
			
        }while(scan.next().charAt(0)=='Y' || scan.next().charAt(0)=='y');
		System.out.println("Thank you visit us again.....");
	}
	

}
