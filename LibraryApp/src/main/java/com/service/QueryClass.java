package com.service;

public class QueryClass {
	
	public static String insert_user_query = "INSERT INTO users (username, passwords, email, phone_no, full_name ) VALUES ( ? , ? , ? ,?, ? )";
	public static String admin_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?";
	public static String user_check_query = "SELECT username FROM users WHERE username = ? AND passwords = ?";
	
	
	/////////////////////////////////////////////////////////
	
	public static String view_book_query = "select* from book";
	
	
	/////////////////////////////////////////////////////////
	
	public static String insert_book_query = " INSERT INTO book (id, title, author, category) VALUES (? , ?, ?, ?)";
//	public static String edit_book_query = "";
	
	
	
}
