package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet { //서블릿은 HttpServlet 을 상속받음


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        String username = req.getParameter("username");  //http 쿼리 파라미터 조회
        System.out.println("username = " + username);

        resp.setContentType("text/plain"); //header 정보
        resp.setCharacterEncoding("utf-8"); //header 정보
        resp.getWriter().write("hello " + username);


    }
}
