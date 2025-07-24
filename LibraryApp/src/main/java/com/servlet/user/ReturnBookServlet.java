package com.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.DBService;

@WebServlet("/return")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String idU = request.getParameter("id");
		int id = Integer.parseInt(idU);
		String bookIds = request.getParameter("bookId");
		int bookId = Integer.parseInt(bookIds);
		
		
		DBService dbs = new DBService();
		int result2 = dbs.returnBookUpdate(bookId);
		int result = dbs.returnBook(id);
		
		
		if(result >0 && result2>0) {
			request.setAttribute("mssg", "Book returned Successfuly");
		}else {
			request.setAttribute("mssg", "Book returned failed!");
		}
		
		response.sendRedirect(request.getContextPath() + "/mybooks");
	}

}
