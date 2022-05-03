package com.hgh.servlet;

import com.sun.net.httpserver.HttpsServer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.util.Scanner;

public class read extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
        String name= (String) context.getAttribute("name");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(name);

    }
}
