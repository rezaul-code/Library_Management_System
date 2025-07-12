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
import com.service.UserDTO;

@WebServlet("/approve_delete_user")
public class ApproveDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBService dbs1 = new DBService();
		List<UserDTO> userlist = dbs1.getAllUserDetails();
		request.setAttribute("userlist", userlist);
		
		
		 RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/approve_delete_user.jsp");
		 rs.forward(request, response);
		 
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
