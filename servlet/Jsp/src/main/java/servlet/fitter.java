package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class fitter implements Filter
{
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器启动");
    }

    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain filterChain) throws IOException, ServletException {
        Request.setCharacterEncoding("utf-8");
        Response.setCharacterEncoding("utf-8");
        HttpServletRequest request = (HttpServletRequest) Request;
        HttpServletResponse response = (HttpServletResponse) Response;
        if (request.getSession().getAttribute(contant.USER_SESSION)==null){
            response.sendRedirect("/login.jsp");
        }
        filterChain.doFilter(Request,Response);
    }

    public void destroy() {
        System.out.println("过滤器关闭");
    }
}
