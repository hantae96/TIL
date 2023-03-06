package basic.core.discount;


import basic.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
