package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源请求路径
        String uri = request.getRequestURI();
        //判断是否包含登录相关路径,还要排除css/js/images等文件
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")
                || uri.contains("/css/") || uri.contains("/js/")
                || uri.contains("/fonts/") || uri.contains("/images/")) {
            chain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
