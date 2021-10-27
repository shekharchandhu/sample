package com.lms.library;
import java.util.ArrayList;
import java.util.Scanner;
public class BookDTO {
	private static ArrayList<Book> bookList=new ArrayList<Book>();
	public BookDAO bookDAO()
	{
		return new BookDAOImp();
	}
	private class BookDAOImp implements BookDAO
	{
		
		@Override
		public void addBook(Book book)
		{
			bookList.add(book);
		}
		@Override
		public ArrayList<Book> searchBookByTitle(String bookTitle)
		{
			ArrayList<Book> bookobj=new ArrayList<Book>();
			 
			for(int i=0;i<bookList.size();i++)
			{
			    	if(bookList.get(i).getBookTitle().equals(bookTitle))
			    	{
			    		bookobj.add(bookList.get(i));
			    	}
			    	
			}
			System.out.println(bookobj);
			return bookobj;
		}
		@Override
		public ArrayList<Book> searchBookByAuthor(String bookAuthor)
		{ArrayList<Book> bookobj=new ArrayList<Book>();
		 
			for(int i=0;i<bookList.size();i++)
			{
			    	if(bookList.get(i).getBookAuthor().equals(bookAuthor))
			    	{
			    		bookobj.add(bookList.get(i));
			    	}
			    	
			}
			System.out.println(bookobj);
			
			return bookobj;
		}
		@Override
		public Book search(String bookTitle,String bookAuthor,int edition)
		{
			
			Book book = null;
			for(int i=0;i<bookList.size();i++)
			{
				if(bookList.get(i).getBookTitle().equals(bookTitle) && bookList.get(i).getBookAuthor().equals(bookAuthor) && bookList.get(i).getBookEdition()==edition)
				{
					book=bookList.get(i);
				}
			}
			
			return book;
		}
		@Override
		public boolean updateBook(Book book)
		{
			Book booktobeUpdated=null;
			Book values=null;
			for(int i=0;i<bookList.size();i++)
			{
				booktobeUpdated=bookList.get(i);
				if(booktobeUpdated.getBookTitle().equals(book.getBookTitle()) &&booktobeUpdated.getBookAuthor().equals(book.getBookAuthor())&&booktobeUpdated.getBookGenre().equals(book.getBookGenre()) && booktobeUpdated.getBookEdition()==book.getBookEdition()&&booktobeUpdated.getBookPrice()==(book.getBookPrice()))
               {
				values=booktobeUpdated;	
				break;
               }
				
			}
			if(values==null)
			{
				return false;
			}
			else
			{
			System.out.println("please enter your choice");
			System.out.println("Enter 1 to update Title");
			System.out.println("Enter 2 to update Author");
			System.out.println("Enter 3 to update Genre");
			System.out.println("Enter 4 to update Edition");
			System.out.println("Enter 5 to update Price");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			
			if(choice==1)
			{
				System.out.println("Please enter the new Title");
				String s1=sc.next();
				for(int i=0;i<bookList.size();i++)
				{
					if(values==bookList.get(i))
					{
						bookList.get(i).setBookTitle(s1);
					}
						      
							
				}
				System.out.println(bookList);
				return true;
			}
			if(choice==2)
			{
				System.out.println("Please enter the new Author");
				String s1=sc.next();
				for(int i=0;i<bookList.size();i++)
				{
					if(values==bookList.get(i))
					{
						bookList.get(i).setBookAuthor(s1);
					}
						      
							
				}
				System.out.println(bookList);
				return true;
			}
			if(choice==3)
			{
				System.out.println("Please enter the new Genre");
				String s1=sc.next();
				for(int i=0;i<bookList.size();i++)
				{
					if(values==bookList.get(i))
					{
						bookList.get(i).setBookGenre(s1);
					}
						      
							
				}
				System.out.println(bookList);
				return true;
			}
			if(choice==4)
			{
				System.out.println("Please enter the new Edition");
			int val=sc.nextInt();
				for(int i=0;i<bookList.size();i++)
				{
					if(values==bookList.get(i))
					{
						bookList.get(i).setBookEdition(val);
					}
						      
							
				}
				System.out.println(bookList);
				return true;
			}
			if(choice==5)
			{System.out.println("Please enter the new Price");
				int val=sc.nextInt();
				
				for(int i=0;i<bookList.size();i++)
				{
					if(values==bookList.get(i))
					{
						bookList.get(i).setBookPrice(val);
					}
						      
							
				}
				System.out.println(bookList);
				return true;
				
			}
			if(choice>5)
			{
				InvalidChoiceException e=new InvalidChoiceException();
				System.out.println(e);
			}
			
			
			
			
			
			}
			return false;
		}
		@Override
		public boolean removeBook(Book book)
		{
			Book booktobeRemoved=null;
			for(int i=0;i<bookList.size();i++)
			{
				booktobeRemoved=bookList.get(i);
				if(booktobeRemoved.getBookTitle().equals(book.getBookTitle()) &&booktobeRemoved.getBookAuthor().equals(book.getBookAuthor()) &&booktobeRemoved.getBookGenre().equals(book.getBookGenre())&& booktobeRemoved.getBookEdition()==book.getBookEdition()&&booktobeRemoved.getBookPrice()==(book.getBookPrice()))
               {
            	   bookList.remove(i);
            	   return true;
               }
			}
			return false;
		}
		
	}

}
