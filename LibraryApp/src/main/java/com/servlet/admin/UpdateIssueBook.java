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

@WebServlet("/updateissuebooks")
public class UpdateIssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
        String ids = request.getParameter("id");
        int id = Integer.parseInt(ids);
        
        UserBookDTO book = new UserBookDTO();
        book.setId(id);
        book.setAction(action);
        
        DBService dbs = new DBService();
        int result = dbs.updateIssueBook(book);
        
        if (result > 0) {
            request.setAttribute("message", "Details updated successfully");
        } else {
            request.setAttribute("message", "Update Failed!");
        }
        
        
        List<UserBookDTO> issuedBook = dbs.viewIssueBook();
        request.setAttribute("booklist", issuedBook);
        
        response.sendRedirect(request.getContextPath() + "/issuebooks");
        
        
        
	}

}
