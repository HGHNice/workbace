package com.hgh.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Administrator
 */
public class servlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream inputStream=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        String name=properties.getProperty("username");
        String pwd=properties.getProperty("password");
        resp.getWriter().print(name);
        resp.getWriter().print(pwd);

    }
}


