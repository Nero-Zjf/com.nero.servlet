package servlet.upload;

import javax.servlet.*;
import java.io.IOException;

/**
 * @created nero
 * @date 2018/8/21 14:46
 */
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String title = filterConfig.getInitParameter("title");
        System.out.println(title);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 把请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
