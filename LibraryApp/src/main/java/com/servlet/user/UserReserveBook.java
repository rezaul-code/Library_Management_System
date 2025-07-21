package com.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.service.DBService;


@WebServlet("/reservebook")
public class UserReserveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookId1 = request.getParameter("id");
		int bookId = Integer.parseInt(bookId1); 
		
		HttpSession  http = request.getSession();
		String name = (String) http.getAttribute("username");
		
		DBService dbs = new DBService();
		dbs.update_book_user(bookId);
		int result = dbs.insertBookReserve(bookId, name);
		
		
		if (result >0 ) {
			request.setAttribute("status", "Book Reserve successfully");
		}else {
			request.setAttribute("status", "Book Reserve Failed!");
		}
		
		 response.sendRedirect(request.getContextPath() + "/viewbook");
		

	}

}
