package com.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.service.DBService;
import com.service.UserBookDTO;

@WebServlet("/issuebooks")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DBService dbs = new DBService();
		List<UserBookDTO> issueBook = dbs.viewIssueBook();
		request.setAttribute("issue_pending", issueBook);
		
		RequestDispatcher ds = request.getRequestDispatcher("/WEB-INF/admin/issue_book.jsp");
		ds.forward(request, response);
	
	}

	
}
