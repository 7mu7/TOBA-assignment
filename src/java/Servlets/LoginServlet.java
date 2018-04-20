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

public class LoginServlet extends HttpServlet {
	@Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Index.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            url = "/Index.jsp";
        } else if (action.equals("signin")) { 
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        if(Username.contains("jsmith@toba.com") && Password.contains("letmein")){    
		url = "/Account_activity.jsp";
        }
        else
        {
        url = "/Login_failure.jsp";
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

           
        
    

    



        