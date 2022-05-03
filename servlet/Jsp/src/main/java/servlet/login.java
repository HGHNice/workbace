package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        if ("admin".equals(name)){
            req.getSession().setAttribute(contant.USER_SESSION,req.getSession().getId());
            resp.sendRedirect("/success.jsp");
        }else {
            resp.sendRedirect("/index.jsp");
        }
    }
}
