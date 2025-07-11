package com.servlet.admin;

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

@WebServlet("/book_section")
public class BooksSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBService dbs = new DBService();
		List<BookDTO> booklist2 = dbs.getAllbookDetails();
		request.setAttribute("booklist", booklist2 );
		
		 RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/book_operation.jsp");
		 rs.forward(request, response);
	}


}
