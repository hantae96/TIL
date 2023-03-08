package mvc;


// DTO -> Data Transfer Object : 계층간 데이터 교환을 위해 사용되는 객체 통상 getter,setter 만가짐
public class MemberDTO {
    // 이메일, 이름, 휴대전화 필드가 있음
    private String email;
    private String name;
    private String mobile;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
