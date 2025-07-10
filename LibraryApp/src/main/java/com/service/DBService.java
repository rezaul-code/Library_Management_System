package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database_connection.DatabaseConnection;

public class DBService {
	
public String adminlogInService(String name, String pass) {
		
		String name1 = null;
		Connection connection = DatabaseConnection.getConnection();
	    String user_check = QueryClass.user_check_query;
	    
		try {
			PreparedStatement ps = connection.prepareStatement(user_check);
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name1 = rs.getString("username");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    return name1;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int addUser(SetterGetterService sg1) {
		Connection con = DatabaseConnection.getConnection();
		String insertQuery = QueryClass.insert_admin_query;
		int rows = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, sg1.username);
			ps.setString(2, sg1.email);
			ps.setString(3, sg1.password);
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return rows;
		
	}
}
