package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototype1 = ac.getBean(PrototypeBean.class);
        System.out.println("prototype1 = " + prototype1);
        PrototypeBean prototype2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototype2 = " + prototype2);
        assertThat(prototype1).isNotSameAs(prototype2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean 빈 초기화");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean 빈 종료");
        }
    }
}
