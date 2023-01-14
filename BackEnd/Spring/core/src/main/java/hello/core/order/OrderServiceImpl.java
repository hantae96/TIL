package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRespository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final MemberRepository memberRepository = new MemoryMemberRespository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId,String itemName, int itemPrice){
        // 회원정보 조회 MVP,일반
        Member member = memberRepository.findById(memberId);
        // 해당하는 정책으로 가격을 정함
        int discountPrice = discountPolicy.discount(member,itemPrice);
        // 새로운 오더 객체(할인 먹인)를 반환함
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
