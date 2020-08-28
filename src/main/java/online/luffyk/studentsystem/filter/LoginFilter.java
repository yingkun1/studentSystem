package online.luffyk.studentsystem.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("过滤器初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("login")||requestURI.contains("api")||requestURI.contains("css")||requestURI.contains("images")||requestURI.contains("js")||requestURI.contains("lib")||requestURI.contains("page")||requestURI.contains("getCapture")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                response.sendRedirect("login");
            }
        }


    }

    @Override
    public void destroy() {
        logger.debug("过滤器被销毁了");
    }
}
