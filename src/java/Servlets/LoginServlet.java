/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Servlets;

import javabeans.User;
import javabeans.Account;
import Database.AccountDB;
import Database.UserDB;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
        
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            url = "/index.jsp";
        } else if (action.equals("signin")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (!UserDB.emailExists("jsmith@toba.com")) {
                User jSmith = new User("J", "Smith", "7277777777", "11 Drew St", "Clearwater", "FL", "33761", "jsmith@toba.com", "jsmith@toba.com", "letmein");
                Account savingAccount = new Account(jSmith, 25.00, Account.Type.SAVING);
                Account checkingAccount = new Account(jSmith, 0, Account.Type.CHECKING);
                UserDB.insert(jSmith);
                AccountDB.insert(savingAccount);
                AccountDB.insert(checkingAccount);
            }
            User user = UserDB.login(username, password);
            if (user != null) {
                url = "/account_activity.jsp";
            } else {
                url = "/login_failure.jsp";
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
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