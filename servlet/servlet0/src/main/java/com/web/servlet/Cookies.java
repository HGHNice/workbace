package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Administrator
 */
public class Cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        Cookie[] cookies=req.getCookies();

        if (cookies!=null){
            out.write("No first");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie=cookies[i];
                if ("lastname".equals(cookie.getName())){
                    long lastname=Long.parseLong(cookie.getValue());
                    Date date = new Date(lastname);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.write("first");
        }
        Cookie cookie=new Cookie("lastname",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
