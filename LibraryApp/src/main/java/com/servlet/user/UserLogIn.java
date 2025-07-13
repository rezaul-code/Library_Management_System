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


@WebServlet("/userlogin")
public class UserLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/userlogin.jsp");
		rs.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		
		DBService dbs = new DBService();
		String user = dbs.userLoginService(name , pass );
		System.out.println("User returned from DBService: " + user);

		
		if (user != null) {
			 HttpSession hts = request.getSession();
		    hts.setAttribute("username", name);
		    
		    System.out.println("Login successful");
		    RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/user_dashbord.jsp");
		    rs.forward(request, response);
		}

		else {
			 RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/userlogin.jsp");
			 rs.forward(request, response);
			    System.out.println("Login failed");

			 
		}
		
	}

}




