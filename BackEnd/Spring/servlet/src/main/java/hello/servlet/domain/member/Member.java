package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
//        id는 회원 저장소에서 할당한다.
//        this.id = id;
        this.username = username;
        this.age = age;
    }
}
