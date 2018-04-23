/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import Database.User;

@WebServlet(name="LoginServlet", urlPatterns={"/Login"})
public class LoginServlet extends HttpServlet {
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
				
				 HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                response.sendRedirect("account_activity.jsp");
            }
        } else if(username.equals("jsmith@toba.com") && password.equals("letmein")) {
            response.sendRedirect("account_activity.jsp");
            User user = new User(username, password);
            session.setAttribute("user", user);
        } else {
            response.sendRedirect("login_failure.jsp");
        }     
}

	getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
			}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
}
    public String getServletInfo() {
        return "Short description";
    }

}
           
        
    

    



        