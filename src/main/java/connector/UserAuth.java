package connector;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class UserAuth implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String context = httpServletRequest.getContextPath();
        HttpSession session = httpServletRequest.getSession();
        String requestURL = httpServletRequest.getRequestURI();
        if ((session != null) && (session.getAttribute("login") != null)) {
            chain.doFilter(request,response);
        } else {
            httpServletResponse.sendRedirect(context + "/LoginForm.jsp");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
