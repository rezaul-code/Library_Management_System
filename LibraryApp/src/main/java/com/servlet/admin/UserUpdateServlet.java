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


@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	String status = request.getParameter("status");
        String ids = request.getParameter("id");
        int id = Integer.parseInt(ids);

        UserDTO user = new UserDTO();
        user.setStatus(status);
        user.setId(id);

        DBService ds = new DBService();
        int result = ds.updateUser(user);

        if (result > 0) {
            request.setAttribute("message", "Details updated successfully");
        } else {
            request.setAttribute("message", "Update Failed!");
        }

        List<UserDTO> userList = ds.getAllUserDetails();
        request.setAttribute("userlist", userList);

        RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/admin/approve_delete_user.jsp");
        rs.forward(request, response);
    }
}

