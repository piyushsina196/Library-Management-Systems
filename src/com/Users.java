package com;

import java.util.HashMap;


public class Users {
Users(){
	
}
Users(String name){
	this.name=name;
}
private String name;
private long phoneNumber;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private HashMap<Long,String> user=new HashMap<Long,String>();
private HashMap<String,HashMap> users=new HashMap<String,HashMap>();
private HashMap<String,Integer> noOfBooksIssued=new HashMap<String,Integer>();

public void addUser(String name,long phoneNumber){
	boolean flag=false;
	if(this.users.containsKey(name)){
		HashMap<Long,String> temp=this.users.get(name);
		for(long phNo:temp.keySet()){
			if(phNo==phoneNumber){
				System.out.println("USER ALREADY EXIST");
				flag=true;
			}
			
		}if(flag==false){
			temp.put(phoneNumber,name);
			this.users.put(name, temp);
		}
	}else{
		this.user.put(phoneNumber,name);
		this.users.put(name, user);
	}
		
}
public String searchUser(String userNm){
	if(this.users.containsKey(userNm)){
		HashMap<Long,String> temp=this.users.get(userNm);
		for(long phNo:temp.keySet()){
			if(phNo==phoneNumber){
				return "Name: "+userNm+"  "+"PhoneNumber: "+phNo;
			}
		}
		return "USER DOES NOT EXIST";
	}else{
		return "USER DOES NOT EXIST";
	}
}

public boolean userExist(String userNm){
	if(this.users.containsKey(userNm)){
		HashMap<Long,String> temp=this.users.get(userNm);
		for(long phNo:temp.keySet()){
			if(phNo==phoneNumber){
				return true;
			}
		}
		return false;
	}else{
		return false;
	}
}
public boolean addBookForUser(String userName){
	if(this.noOfBooksIssued.containsKey(userName)){
		int i=this.noOfBooksIssued.get(userName);
		if(i>=2){
			return false;
		}
		else{
			this.noOfBooksIssued.put(userName, i+1);
		}
	}
	this.noOfBooksIssued.put(userName,1);
	return true;
}
public boolean returnBookForUser(String userName){
	if(this.noOfBooksIssued.containsKey(userName)){
		int i=this.noOfBooksIssued.get(userName);
		if(i>0){
			this.noOfBooksIssued.put(userName,i-1);
			}
		}
	this.noOfBooksIssued.remove(userName);
	return true;
}

}

