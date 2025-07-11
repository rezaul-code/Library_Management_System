package com.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.BookDTO;
import com.service.DBService;

@WebServlet("/addbooks")
public class AdminAddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/adminaddbooks.jsp");
			rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int bookId = Integer.parseInt(id);
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		
		BookDTO book1 = new BookDTO();
		book1.setTitle(title);
		book1.setAuthor(author);
		book1.setCategory(category);
		book1.setId(bookId);
		
		DBService ds = new DBService();
		int status = ds.adminAddBooks(book1);
		
		if (status > 0) {
			request.setAttribute("message", "Book Insert Successfully");
		}else {
			request.setAttribute("message", "Insert Failed!");
		}
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/adminaddbooks.jsp");
		rs.forward(request, response);	
		
	}

}
