package com.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.DBService;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher  rs = request.getRequestDispatcher("/WEB-INF/admin/login.jsp");
		rs.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String admin = request.getParameter("username");
		String pass = request.getParameter("password");
		
		DBService ds = new DBService();
		String adminName = ds.adminlogInService(admin, pass);
		
		if (adminName != null) {
			
			request.getSession().setAttribute("admin", adminName);
			
			
			RequestDispatcher	rs = request.getRequestDispatcher("/WEB-INF/admin/admindashbord.jsp");
			rs.forward(request, response);
		}else {
			 RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/login.jsp");
			 rs.forward(request, response);
		}
		
		
	}

}
