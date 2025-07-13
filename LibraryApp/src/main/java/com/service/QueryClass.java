package com.service;

public class QueryClass {
	
	public static String insert_user_query = "INSERT INTO users (username, name, email, phone_no, password ) VALUES ( ? , ? , ? ,?, ? )";
	public static String admin_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?";
	public static String user_check_query = "SELECT username FROM users WHERE username = ? AND password = ? AND status = 'approved'";
	public static String user_details_query = "SELECT * FROM users";
	public static String user_update_query = "UPDATE Users SET status = ? WHERE id = ?";
	public static String user_delete_query = "delete from users where id = ?";
	
	
	public static String view_book_query = "select* from book";
	public static String delete_book_query = "delete from book where id = ?";
	public static String update_book_query = "UPDATE Book SET title = ?, author = ?, category = ?, availability = ? WHERE id = ?";

	
	public static String insert_book_query = " INSERT INTO book (id, title, author, category) VALUES (? , ?, ?, ?)";
	
	
	
}
