package com;

import java.util.HashMap;

public class Book {
	Book(){
		
	}
	Book(String bookName){
		this.BookName=bookName;
	}
private String Author;
private String BookName;
private HashMap<String,String> books=new HashMap<String,String>();
private HashMap<String,String> authors=new HashMap<String,String>();
private HashMap<String,Integer> noOfbooks=new HashMap<String,Integer>();
private HashMap<String,String> issuedBy=new HashMap<String,String>();

public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public String getBookName() {
	return BookName;
}
public void setBookName(String bookName) {
	BookName = bookName;
}
public void addBook(String authorName,String bookName){
	if(this.books.containsKey(authorName)){
		int i=this.noOfbooks.get(bookName);
		this.noOfbooks.put(bookName,i+1);
	}else{
		this.books.put(authorName, bookName);
		this.authors.put(bookName, authorName);
		this.noOfbooks.put(bookName,1);
	}	
		
}
public String findBookByName(String bookName){
	if(this.authors.containsKey(bookName)){
		return this.authors.get(bookName)+" book "+ bookName+" is there";
	}else{
		return "BOOK NOT FOUND";
	}
	
}
public String findBookAuthorName(String authorName){
	if(this.books.containsKey(authorName)){
		return this.books.get(authorName)+" by Author "+authorName+ " is there";
	}else{
		return "NO BOOK BY THIS AUTHOR";
	}
	
}
public boolean isBookThere(String bookName){
	if(this.authors.containsKey(bookName)){
		return true;
	}
	return false;
}
public boolean isAuthorThere(String authorName) {
	if(this.books.containsKey(authorName)){
		return true;
	}
	return false;
}

}
/*1. Ability to add books to the system.
2. Ability to add users to the system.
3. Ability to lend books to users.
4. Ability to return books to the library.
5. Ability to limit the number of books borrowed by user.
6. Ability to search a book by title, author.
7. Ability to search a user by name*/