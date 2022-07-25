package com.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description="Login Servlet Testing",
        urlPatterns={"/LoginServlet"}
)

public class LoginServlet extends HttpServlet {

    private static final String FullName = "^[A-Z]{1}[a-z]{7}[A-Z]{1}[a-z]{6}";

    private static final String Password = "^[A-Z]{1}[a-z]{4}+@[1-5]{3}";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdInput = req.getParameter("user");
        String passwordInput = req.getParameter("password");

        if (userIdInput.matches(FullName) && passwordInput.matches(Password)) {
            req.setAttribute("user", userIdInput);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color = red> Either username or password is wrong</font>");
            rd.include(req, resp);
        }
    }
}
