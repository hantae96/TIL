package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.ControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    public FrontControllerServletV1(){
        controllerV1Map.put("/front-controller/v1/members/new-form",new MemberFormControllerV1());
        controllerV1Map.put("/front-controller/v1/members/save",new MemberSaveControllerV1());
        controllerV1Map.put("/front-controller/v1/members",new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerServletV1.service");
        // 요청한 url 을 가져와서
        String requestURl = request.getRequestURI();

        // 맵핑정보를 가져와서 해당 컨트롤러를 생성한다음
        ControllerV1 controller = controllerV1Map.get(requestURl);
        // 못찾으면 404 에러 발생
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // 찾으면 process <- 디스패처를 실
        controller.process(request,response);
    }
}
