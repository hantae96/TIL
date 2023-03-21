package hello.servlet.web.springmvc.v1;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberSaveControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
        // 더 편리하게 사용하기 위해, @RequestParam을 사용할 수 도 있다.
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 더 편리하게 사용하기 위해, @RequestBody..?
        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        // 모델앤 뷰 객체를 만들고, 파라미터에 논리적인 뷰의 주소를 넣는다.
        ModelAndView mv = new ModelAndView("save-result");
        // 모델에 식별키, 값을 넣어서 뷰와 한번에 전달할 수 있다. 뷰랑 모델이랑 같이 전달하는 이유는 클라이언트에 정보를 동적으로 보여주기 위해선 무조껀 같이 전달해야되낚!
        mv.addObject("member",member);

        return mv;
    }
}
