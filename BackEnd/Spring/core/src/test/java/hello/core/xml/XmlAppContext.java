package hello.core.xml;

import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext genericXmlApplicationContext=new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = genericXmlApplicationContext.getBean("memberService", MemberService.class);

    }
}
