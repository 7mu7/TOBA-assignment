package Servlets;

import JavaBean.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResetPasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/Index.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "home";
            url = "/Index.jsp";
        }
        if (action.equals("resetPassword")) {
            String username = request.getParameter("username");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            String message;
            if (newPassword.equals(confirmPassword)) {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                message = "";
                user.setPassword(newPassword);
                url = "/Account_activity.jsp";
                session.setAttribute("user", user);
            } else {
                message = "*The passwords did not match, please try again.";
                url = "/Password_reset.jsp";
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
