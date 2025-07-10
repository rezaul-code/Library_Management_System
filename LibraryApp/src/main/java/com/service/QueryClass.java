package com.service;

public class QueryClass {
	public static String insert_admin_query = "INSERT INTO admin (username, email, password) VALUES ( ? , ? , ? )";
	public static String user_check_query = "SELECT * FROM admin WHERE username = ? AND password = ?";

	
}
