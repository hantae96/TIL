package basic.core.discount;

import basic.core.member.Grade;
import basic.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.GOLD) {
            return price * discountPercent / 100;
        } else if(member.getGrade() == Grade.SLIVER) {
            return price * (discountPercent-5) / 100;
        } else if(member.getGrade() == Grade.BRONZE) {
            return price * (discountPercent-10) / 100;
        }
        return 0;
    }
}
