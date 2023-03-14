package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    //Json을 읽기 위한 objectMapper 생성
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type","application/json");
        response.setCharacterEncoding("utf-8");

        // json 폼 생성
        HelloData data = new HelloData();
        data.setUsername("choi");
        data.setAge(28);

        // json 객체 string으로 변환
        String result = objectMapper.writeValueAsString(data);
        response.getWriter().write(result);

    }
}
