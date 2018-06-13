package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.LoginTraderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginTraderServlet extends HttpServlet {

    private LoginTraderService loginTraderService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        loginTraderService = LoginTraderService.getService();
        String operazione = request.getParameter("pulsante");
        if(operazione.equals("Register")){
            String reg_username = request.getParameter("reg_username");
            String reg_password = request.getParameter("reg_password");
            if (this.loginTraderService.doRegister(reg_username, reg_password)) {
                response.sendRedirect("index.jsp");
            } else
                response.sendRedirect("register.jsp");
        }
        else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (this.loginTraderService.login(username, password)) {
                response.sendRedirect("home.jsp");
            } else
                response.sendRedirect("index.jsp");
        }

    }
}
