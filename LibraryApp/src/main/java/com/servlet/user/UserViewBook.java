package com.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.service.BookDTO;
import com.service.DBService;

@WebServlet("/viewbook")
public class UserViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBService dbs1 = new DBService();
		List<BookDTO> bd1 = dbs1.getAllbookDetails();
		request.setAttribute("booklist", bd1);
				
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/userviewbook.jsp");
		rs.forward(request, response);
	}

}
