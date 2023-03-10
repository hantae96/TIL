package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);

        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("hello",20);
        Member member2 = new Member("hi",21);

        Member save1 = memberRepository.save(member1);
        Member save2 = memberRepository.save(member2);

        List<Member> result = memberRepository.findALl();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }

}
