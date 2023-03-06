package basic.core;

import basic.core.discount.DiscountPolicy;
import basic.core.discount.FixDiscountPolicy;
import basic.core.discount.RateDiscountPolicy;
import basic.core.member.MemberRepository;
import basic.core.member.MemberService;
import basic.core.member.MemberServiceImpl;
import basic.core.member.MemoryMemberRepository;
import basic.core.order.OrderService;
import basic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
