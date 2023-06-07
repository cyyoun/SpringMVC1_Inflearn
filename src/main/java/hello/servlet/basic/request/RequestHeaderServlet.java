package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaderUtils(req);
        printEtc(req);
    }

    private static void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("req.getMethod() = " + req.getMethod()); //GET
        System.out.println("req.getProtocol() = " + req.getProtocol()); //HTTP/1.1

        System.out.println("req.getScheme() = " + req.getScheme()); //http

        System.out.println("req.getRequestURL() = " + req.getRequestURL()); // http://localhost:8080/request-header

        System.out.println("req.getRequestURI() = " + req.getRequestURI()); // /req-header

        System.out.println("req.getQueryString() = " + req.getQueryString()); //username=hi

        System.out.println("req.isSecure() = " + req.isSecure()); //https 사용 유무

        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }



    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("req.getServerName() = " +
                req.getServerName()); //Host 헤더
        System.out.println("req.getServerPort() = " +
                req.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("req.getLocale() = " + req.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("req.getContentType() = " +
                req.getContentType());
        System.out.println("req.getContentLength() = " +
                req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " +
                req.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }


    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}