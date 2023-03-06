package basic.core.discount;

import basic.core.member.Grade;
import basic.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("GOLD는 10% 할인이 적용되어야한다.")
    void gold_o(){
        Member member = new Member(1L,"memberGOLD", Grade.GOLD);
        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("SELVER는 5% 할인이 적용 되어야한다.")
    void sliver_o(){
        Member member = new Member(2L, "memberSliver", Grade.SLIVER);
        int discount = discountPolicy.discount(member,10000);
        System.out.println("discount = " + discount);
        assertThat(discount).isEqualTo(500);
    }
}
