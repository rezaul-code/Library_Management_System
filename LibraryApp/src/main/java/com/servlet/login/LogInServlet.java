package com.servlet.login;

import java.io.IOException;

import com.service.DBService;

import jakarta.servlet.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/login.jsp");
    	rs.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String name = request.getParameter("username");
    	String pass = request.getParameter("password");
    	
    	DBService dbs = new DBService();
    	String admin = dbs.adminlogInService(name, pass);
    	
    	 if (admin != null) {
  		   HttpSession httpSession = request.getSession();
  		   httpSession.setAttribute("admin", admin);
  		   
  		   RequestDispatcher  rs = request.getRequestDispatcher("/WEB-INF/admin/admindashbord.jsp");
  		   rs.forward(request, response);
  	   } else {
  		   request.setAttribute("msg", "Invalid username or password!");
  		   RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/login.jsp");
  		   rs.forward(request, response);
  	   }
    	
    }
}
