package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //전체 파라미터 조회
        System.out.println("[전체 파라미터 조회] --- Start");

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName +   " = " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] --- End");
        System.out.println();

        System.out.println("[단일 파라미터 조회] --- Start");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] --- End");
        System.out.println();

        System.out.println("[이름(key)가 같은 복수 파라미터 조회]");
        //키가 중복이 된다는 게 신기하구만. -> 이름이 같으면 먼저 조회되는 값을 가져옴
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

        resp.getWriter().write("ok");
    }
}
