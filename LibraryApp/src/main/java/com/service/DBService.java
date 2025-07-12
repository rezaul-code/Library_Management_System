package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;

public class DBService {
	
	public int updateUser(UserDTO user) {
	    Connection con = DatabaseConnection.getConnection();
	    String update_user_query = QueryClass.user_update_query;
	    int rows = 0;

	    try {
	    	
	        PreparedStatement ps = con.prepareStatement(update_user_query);
	        ps.setString(1, user.getStatus());
	        ps.setInt(2, user.getId());
	        rows = ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rows;
	}

	
	
	
	
	
	public List<UserDTO> getAllUserDetails() {
		
		Connection con = DatabaseConnection.getConnection();
		String user_d_query = QueryClass.user_details_query;
		List<UserDTO> userlist = new ArrayList<UserDTO>();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(user_d_query);
			
			while(rs.next()) {
				
				String ids = rs.getString("id");
				int id = Integer.parseInt(ids);
				String userName = rs.getString("username");
				String fullName = rs.getString("name");
				String email = rs.getString("email");
				String phoneNo = rs.getString("phone_no");
				String password = rs.getString("password");
				String status = rs.getString("status");
				
				UserDTO user_dto = new UserDTO();
				user_dto.setId(id);
				user_dto.setUserName(userName);
				user_dto.setName(fullName);
				user_dto.setEmail(email);
				user_dto.setPhone_no(phoneNo);
				user_dto.setPassword(password);
				user_dto.setStatus(status);
				
				userlist.add(user_dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userlist;
	}
	
	
	




	public List<BookDTO> getAllbookDetails() {
	    Connection con = DatabaseConnection.getConnection();
	    String query = QueryClass.view_book_query;
	    List<BookDTO> bookslist = new ArrayList<>();

	    try {
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery(query);

	        while (rs.next()) {
	        	int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String author = rs.getString("author");
	            String category = rs.getString("category");
	            String availability = rs.getString("availability");

	            BookDTO b2 = new BookDTO();
	            b2.setId(id);
	            b2.setTitle(title);
	            b2.setAuthor(author);
	            b2.setCategory(category);
	            b2.setAvailability(availability);


	            bookslist.add(b2);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return bookslist;
	}

	
	public int adminAddBooks(BookDTO book1) {
		Connection con = DatabaseConnection.getConnection();
		String query_insert_book = QueryClass.insert_book_query;
		int rows = 0;
		
		
		try {
			PreparedStatement ps = con.prepareStatement(query_insert_book);
			ps.setInt(1, book1.getId());
			ps.setString(2, book1.getTitle());
			ps.setString(3, book1.getAuthor());
			ps.setString(4, book1.getCategory());

			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return rows;
		
	}
	
	
	public String userLoginService(String name, String pass) {
		String name2 = null;
		Connection con = DatabaseConnection.getConnection();
		String user_check = QueryClass.user_check_query;
		
		try {
			 PreparedStatement ps = con.prepareStatement(user_check);
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				name2 = rs.getString("username");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name2;
	}
		
	
	
	
public String adminlogInService(String name, String pass) {
		
		String name1 = null;
		Connection connection = DatabaseConnection.getConnection();
	    String admin_check = QueryClass.admin_check_query;
	    
		try {
			PreparedStatement ps = connection.prepareStatement(admin_check);
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
		String insertQuery = QueryClass.insert_user_query;
		int rows = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, sg1.getName());
			ps.setString(2, sg1.getFullName());
			ps.setString(3, sg1.getEmail());
			ps.setString(4, sg1.getPhoneNo());
			ps.setString(5, sg1.getPassword());
			
			
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return rows;
		
	}
}
