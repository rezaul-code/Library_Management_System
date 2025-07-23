package com.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.service.BookDTO;
import com.service.DBService;

@WebServlet("/viewbook")
public class UserViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BookDTO> booklist2 = new ArrayList<BookDTO>();
		DBService dbs = new DBService();
		
		String text = request.getParameter("search_text");
		
		
		if (text == null || text.trim().isEmpty()) {
			
			booklist2 = dbs.getAllbookDetails();
			
		} else if(text != null && !text.trim().isEmpty() ) {
			
			 booklist2 = dbs.getSearchDetails(text.trim());
			
		}
		
		request.setAttribute("booklist", booklist2 );
		
		
		
		
		
		
				
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/userviewbook.jsp");
		rs.forward(request, response);
	}

}
