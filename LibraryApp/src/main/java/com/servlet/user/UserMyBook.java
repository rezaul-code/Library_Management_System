package com.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.service.DBService;
import com.service.UserBookDTO;

@WebServlet("/mybooks")
public class UserMyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession hts = request.getSession(false);
		 String name = (String) hts.getAttribute("username");
		
		
		DBService dbs1 = new DBService();
		List<UserBookDTO> list = dbs1.getMyBookDetails(name);
		request.setAttribute("booklist", list);
		
		RequestDispatcher rs= request.getRequestDispatcher("WEB-INF/user/usermybook.jsp");
		rs.forward(request, response);
	}

	}
