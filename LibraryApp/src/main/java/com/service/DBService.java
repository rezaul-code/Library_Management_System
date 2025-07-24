package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database_connection.DatabaseConnection;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class DBService {
	
	public int returnBookUpdate(int bookId) {
		int rows = 0;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.return_book_update_query;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookId);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	public int returnBook(int id) {
		
		int rows = 0;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.return_book_query;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<BookDTO> getSearchDetails(String text) {
		
		List<BookDTO> booklist = new ArrayList<BookDTO>();
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.search_book_details;
		String query2 = QueryClass.search_book_details2;
		
		PreparedStatement  ps = null;
		boolean isException = false;
		int textId =0;
		
		try {
			 textId = Integer.parseInt(text);
		}catch (NumberFormatException e) {
			isException = true;
		}
		
		try {
			
			if(isException) {
				 ps = con.prepareStatement(query);
					ps.setString(1,  text );
					
				
			}else {
				 ps = con.prepareStatement(query2);
				 ps.setString(1,  text );	
				 ps.setInt(2, textId);
					
			}
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String availability = rs.getString("availability");
				int id = rs.getInt("id");
				
				 BookDTO book = new BookDTO();
			    book.setId(id);
			    book.setTitle(title);
			    book.setAuthor(author);
			    book.setCategory(category);
			    book.setAvailability(availability);
			    booklist.add(book);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return booklist;
	}
	
	
	
	public List<UserBookDTO> viewIssueBook() {
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.view_pending_issue;
		List<UserBookDTO> bookIssue = new ArrayList<UserBookDTO>();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			 while (rs.next()) {
		        	int id = rs.getInt("id");
		        	String bookId = rs.getString("book_id");
		        	String user = rs.getString("user_name");
		        	String action = rs.getString("action");
		        	
		        	UserBookDTO issue = new UserBookDTO();
		        	issue.setId(id);
		        	issue.setBookId(bookId);
		        	issue.setUser(user);
		        	issue.setAction(action);
		        	
		        	bookIssue.add(issue);	
			 }	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookIssue;
	}
	
	
	
public List<UserBookDTO> getMyBookDetails(String username) {
		
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.view_my_book_query;
		List<UserBookDTO> myBookList = new ArrayList<UserBookDTO>();
		
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			 ps.setString(1, username);
			 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String bookId = rs.getString("book_id");
				String user = rs.getString("user_name");
				String action = rs.getString("action");
				
				UserBookDTO user1= new UserBookDTO();
				user1.setId(id);
				user1.setBookId(bookId);
				user1.setUser(user);
				user1.setAction(action);
				
				myBookList.add(user1);
			}	 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBookList;
	}
	
	
	
	public int update_book_user(int id) {
		
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.update_book_user;
		int rows = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			rows = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	public int insertBookReserve(int bookid, String username) {
		
		Connection  con = DatabaseConnection.getConnection();
		String query = QueryClass.insert_book_reserve_query;
		int rows = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookid);
			ps.setString(2, username);
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	public int updateBook(BookDTO book1) {
	    String update_book = QueryClass.update_book_query;
	    int rows = 0;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(update_book)) {

	        ps.setString(1, book1.getTitle());
	        ps.setString(2, book1.getAuthor());
	        ps.setString(3, book1.getCategory());
	        ps.setString(4, book1.getAvailability());
	        ps.setInt(5, book1.getId());

	        rows = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rows;
	}

	
	
	public BookDTO getBookById(int id) {
		Connection conn = DatabaseConnection.getConnection();
	    BookDTO book = null;
	    String query = QueryClass.get_book_by_id_query;

	    try (
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            book = new BookDTO();
	            book.setId(rs.getInt("id"));
	            book.setTitle(rs.getString("title"));
	            book.setAuthor(rs.getString("author"));
	            book.setCategory(rs.getString("category"));
	            book.setAvailability(rs.getString("availability"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return book;
	}

	
	public int deleteBook(int id) {
		
		Connection conn = DatabaseConnection.getConnection();
		String delete_book = QueryClass.delete_book_query;
		int rows = 0;
		
		try {
			PreparedStatement  ps = conn.prepareStatement(delete_book);
			ps.setInt(1, id);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	public int deleteUser(int id) {
		
		Connection  con = DatabaseConnection.getConnection();
		String delete_user = QueryClass.user_delete_query;
		int rows = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(delete_user);
			ps.setInt(1, id );
			rows = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	public int updateIssueBook(UserBookDTO book) {
		
		int rows=0;
		Connection con = DatabaseConnection.getConnection();
		String query = QueryClass.update_issue_book;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, book.getAction());
			ps.setInt(2, book.getId());
			
			rows= ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rows;
	}
	
	
	
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
