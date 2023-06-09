package hello.servlet.basic.request;


import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream(); //메시지 바디 값을 byte로 바로 받아올 수 있음
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//byte 값 String 변환
        System.out.println("messageBody = " + messageBody);
        resp.getWriter().write("okok >-<");
    }
}
