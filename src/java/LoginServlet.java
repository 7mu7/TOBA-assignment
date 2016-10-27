/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
 
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
         
        if(Username.contains("jsmith@toba.com") && Password.contains("letmein")){    
            RequestDispatcher rs = request.getRequestDispatcher("Account_activity.html");
            rs.forward(request, response);
        }
        else
        {
           RequestDispatcher rs = request.getRequestDispatcher("Login_failure.html");
           rs.include(request, response);
        }
    }
}

           
        
    

    



        