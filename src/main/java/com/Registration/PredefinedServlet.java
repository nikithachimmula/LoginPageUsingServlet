package com.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

  @WebServlet(
            description="Login Servlet Testing",
            urlPatterns={ "/PredefinedServlet" },
            initParams = {
          @WebInitParam(name = "user", value = "Nikitha"),
          @WebInitParam(name = "password", value = "Nicky@987")
  }
  )

    public class PredefinedServlet extends HttpServlet {

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String userIdInput = req.getParameter("user");
          String passwordInput = req.getParameter("password");

          if (userIdInput.matches("User") && passwordInput.matches("password")) {
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

