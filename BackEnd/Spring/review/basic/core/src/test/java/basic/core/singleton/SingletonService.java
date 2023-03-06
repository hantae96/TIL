package basic.core.singleton;

import org.springframework.boot.test.json.GsonTester;

public class SingletonService {

    // static 영역에 객체를 딱 하나만 생성하기 위해 final을 붙인다.
    private static final SingletonService instance = new SingletonService();

    // 접근제어자를 Public으로 설정하여 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private로 선언하여 외부에서 new 키워드를 통해 객체를 생성하는 것을 막는다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
