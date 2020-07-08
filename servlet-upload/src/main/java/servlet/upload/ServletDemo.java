package servlet.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @created nero
 * @date 2018/8/21 11:20
 */
//@WebServlet(urlPatterns = "/hehe")
public class ServletDemo extends HttpServlet {

    private String msg;

    @Override
    public void init() throws ServletException {
        msg = "Hello World";
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*设置响应的内容类型*/
        resp.setContentType("text/html");

        /*获取Session*/
        HttpSession session = req.getSession();
        /*设置Session的Atrribute*/
        session.setAttribute("key", "value");
        /*获取Session的Atrribute*/
        String sessionValue = (String) session.getAttribute("key");

        /*获取Get方式的参数*/
        String name = req.getParameter("name");
        Enumeration<String> nameEnum = req.getParameterNames();
        String[] names = req.getParameterValues("name");

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + msg + "</h1>");
    }

    @Override
    public void destroy() {

    }
}
