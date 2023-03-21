package hello.servlet.web.springmvc.v1;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 여기로 http 요청이 들어오면
    @RequestMapping("/springmvc/v1/members")
    // 이 컨트롤러가 실행
    public ModelAndView process(){
        // 멤버 리포지 토리에서 전부 찾은다음에, List 자료로 반환
        List<Member> members = memberRepository.findAll();
        // 모델앤뷰 객체를 생성하여 논리적 주소를 넣어준다.
        ModelAndView mv = new ModelAndView("members");
        // 모델앤 뷰 객체에 사용할 데이터도 addObject를 통해 함께 넣어준다.
        mv.addObject("members", members);
        // 반환
        return mv;
    }
}
