package com.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.service.BookDTO;
import com.service.DBService;

@WebServlet("/update")
public class AdminUpdateBook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String idParam = request.getParameter("id");

        if (idParam != null && !idParam.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                DBService db = new DBService();
                BookDTO book = db.getBookById(id);

                if (book != null) {
                    request.setAttribute("book1", book);
                } else {
                    request.setAttribute("message", "Book not found.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid Book ID.");
            }
        } else {
            request.setAttribute("message", "Missing Book ID.");
        }

        RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/admin_update_book.jsp");
        rs.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String idStr = request.getParameter("id");

        if (idStr == null || idStr.trim().isEmpty()) {
            session.setAttribute("message", "Book ID is missing.");
            response.sendRedirect(request.getContextPath() + "/book_section");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String category = request.getParameter("category");
            String availability = request.getParameter("availability");

            BookDTO book1 = new BookDTO();
            book1.setId(id);
            book1.setTitle(title);
            book1.setAuthor(author);
            book1.setCategory(category);
            book1.setAvailability(availability);

            DBService dbs = new DBService();
            int status = dbs.updateBook(book1);

            if (status > 0) {
                session.setAttribute("message", "Book updated successfully.");
            } else {
                session.setAttribute("message", "Book update failed.");
            }

        } catch (NumberFormatException e) {
            session.setAttribute("message", "Invalid Book ID format.");
        }

        response.sendRedirect(request.getContextPath() + "/book_section");
    }
}
