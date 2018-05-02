/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.AccountDB;
import Database.PasswordUtil;
import Database.UserDB;
import javabeans.Account;
import javabeans.User;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.servlet.*;
import javax.servlet.http.*;

public class NewCustomerServlet extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/New_customer.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
            url = "/New_customer.jsp";
        } else if (action.equals("register")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");
            String email = request.getParameter("email");
            String username = lastName + zipCode;
            String password = "welcome1";
            try {
                password = PasswordUtil.hashAndSaltPassword(password);
            } catch (NoSuchAlgorithmException e){
                e.getMessage();
            }
            String message;
            if (firstName == null || lastName == null || phone == null || address == null || city == null
                    || state == null || zipCode == null || email == null || firstName.isEmpty() || lastName.isEmpty()
                    || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty()
                    || email.isEmpty()) {
                message = "*Please fill out all fields";
                url = "/New_customer.jsp";
            } else {
                if (UserDB.emailExists(email)) {
                    message = "*This E-mail already exist.";
                    url = "/New_customer.jsp";
                } else if (UserDB.usernameExists(username)) {
                    message = "*This Username already exist.";
                    url = "/New_customer.jsp";
                } else {
                    User user = new User(firstName, lastName, phone, address, city, state, zipCode, email, username, password);
                    Account savingAccount = new Account(user, 0, Account.Type.SAVING);
                    Account checkingAccount = new Account(user, 0, Account.Type.CHECKING);
                    UserDB.insert(user);
                    AccountDB.insert(savingAccount);
                    AccountDB.insert(checkingAccount);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    message = "";
                    url = "/success.jsp";
                }
            }
            request.setAttribute("message", message);
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