package com;

import java.util.HashMap;
import java.util.Scanner;

public class BookIssueDetails {

	static Users user;
	static Book book;
	static Scanner c;
	static HashMap<Users,Book> issuedBy =new HashMap<Users,Book>();
	public static void main(String[] args) {
		user=new Users();
		book=new Book();
		
		System.out.println("Welcome to Library Management System");
		System.out.println("Press 1 to add Book");
		System.out.println("Press 2 to add a User");
		System.out.println("Press 3 to issue a book");
		System.out.println("Press 4 to return a book");
		System.out.println("Press 5 to search a book by title");
		System.out.println("Press 6 to search a book by author");
		System.out.println("Press 7 to search a user");
		System.out.println("Press 8 to Exit");
		c = new Scanner(System.in);
		int choice = c.nextInt();
		do {
			switch (choice) {
			case 1:
				addBook(book);
				break;
			case 2:
				addUser(user);
				break;
			case 3:
				issueBook(book,user);
				break;
			case 4:
				returnBook(book,user);
				break;
			case 5:
				searhBookByTitle(book);
				break;
			case 6:
				searhBookByAuthor(book);
				break;
			case 7:
				searhUser(user);
				break;	
			case 8:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				break;
			}
			c = new Scanner(System.in);
			choice = c.nextInt();
		} while (choice > 0 && choice < 8);
	}

	private static void returnBook(Book book, Users user) {
		c=new Scanner(System.in);
		System.out.println("Enter book name");
		String bookName=c.nextLine();
		System.out.println("Enter User name");
		String userName=c.nextLine();
		if(book.isBookThere(bookName)){
			if(user.userExist(userName)){
				user.returnBookForUser(userName);
				for(Users users:issuedBy.keySet()){
					if(users.getName().equals(userName)){
						Book books=issuedBy.get(users);
						if(books.getBookName().equals(bookName)){
							issuedBy.remove(users);
							user.returnBookForUser(userName);
							System.out.println("BOOK RETURNED");
						}
					} 
				}
			}else{
				System.out.println("USER DOES NOT EXIST");
			}
		}else{
			System.out.println("BOOK NOT THERE");
		}
}
		
	

	private static void searhUser(Users user) {
		c=new Scanner(System.in);
		System.out.println("Enter User name");
		String userName=c.nextLine();
		user.searchUser(userName);
		
	}

	private static void searhBookByAuthor(Book book) {
		c=new Scanner(System.in);
		System.out.println("Enter author name");
		String authorName=c.nextLine();
		if(book.isAuthorThere(authorName)){
			System.out.println(book.findBookAuthorName(authorName));
		}else{
			System.out.println("BOOK NOT THERE");
		}
		
	}

	private static void searhBookByTitle(Book book) {
		c=new Scanner(System.in);
		System.out.println("Enter book name");
		String bookName=c.nextLine();
		if(book.isBookThere(bookName)){
			System.out.println(book.findBookByName(bookName));
		}else{
			System.out.println("BOOK NOT THERE");
		}
		
		
	}

	

	private static void issueBook(Book book, Users user) {
		c=new Scanner(System.in);
		System.out.println("Enter book name");
		String bookName=c.nextLine();
		System.out.println("Enter User name");
		String userName=c.nextLine();
		if(book.isBookThere(bookName)){
			if(user.userExist(userName)){
				if(user.addBookForUser(userName)){
					book=new Book(bookName);
					user=new Users(userName);
					issuedBy.put(user, book);
					System.out.println("BOOK ISSUED");
				}else{
					System.out.println("USER HAS ALREADY ISSUED MAX NUMBR OF BOOKS");
				}
				
				
			}else{
				System.out.println("USER DOES NOT EXIST");
			}
		}else{
			System.out.println("BOOK NOT THERE");
		}
		
	}

	private static void addUser(Users user) {
		c=new Scanner(System.in);
		System.out.println("Enter user name");
		String name=c.nextLine();
		System.out.println("Enter phone number");
		Long phoneNumber=c.nextLong();
		user.addUser(name, phoneNumber);
		System.out.println("USER ADDED SUCCESSFULLY");
				
	}

	private static void addBook(Book book) {
		c=new Scanner(System.in);
		System.out.println("Enter book name");
		String bookName=c.nextLine();
		System.out.println("Enter author name");
		String authorName=c.nextLine();
		
		book.addBook(authorName, bookName);
		System.out.println("BOOK ADDED SUCCESSFULLY");
		
	}
	

}
