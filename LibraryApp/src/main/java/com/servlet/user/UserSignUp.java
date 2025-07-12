package com.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.DBService;
import com.service.SetterGetterService;

@WebServlet("/usersignup")
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/user_signup.jsp");
		rs.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_no");
		String password = request.getParameter("password");
    	
    	
    	
    	
    	SetterGetterService sg1 = new SetterGetterService();
    	sg1.setName(username);
    	sg1.setFullName(fullName);
    	sg1.setEmail(email);
    	sg1.setPhoneNo(phone);
    	sg1.setPassword(password);
    	
    	
    	
    	DBService ds = new DBService();
    	int status = ds.addUser(sg1);
    	
    	if (status > 0) {
			request.setAttribute("message", "Details insert successfully");
		}else {
			request.setAttribute("message", "Insert Failed!");
		}
    	RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/user/user_signup.jsp");
		rs.forward(request, response);
	}

}
