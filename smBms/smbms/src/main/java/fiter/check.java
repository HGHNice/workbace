package fiter;

import javax.servlet.*;
import java.io.IOException;

public class check implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain filterChain) throws IOException, ServletException {
        rq.setCharacterEncoding("utf-8");
        rp.setCharacterEncoding("utf-8");
        filterChain.doFilter(rq, rp);
    }

    public void destroy() {

    }
}
