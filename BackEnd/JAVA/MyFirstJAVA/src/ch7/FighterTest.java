//package ch7;
//
//abstract class Unit {
//    int x,y ;
//
//    public Unit(int hp) {
//    }
//
//    abstract void move(int x, int y);
//    void stop(){System.out.println("멈춥니다.");}
//}
//
//// 인터페이스의 모든 메서드는 public abstract
//interface Fighttable {
//    void move(int x, int y);
//    void attack (Fighttable f);
//}
//
//class Fighter extends Unit implements Fighttable{
//    // public을 안붙이면 default 접근 제어자로 붙는다.
//    // public은 제한 없음
//    // default는 같은 패키지 내에서만 작동하기 떄문에 더 좁은 범위 이다.
//    // 오버라이딩 규칙 : 조상보다 접근 제어자의 범위가 좁으면 안된다.
//    public void move(int x, int y){
//        System.out.println("이동");
//    };
//    public void attack (Fighttable f){
//        System.out.println("공격");
//    };
//
//    Fighttable getFightable(){
//        Fighter f = new Fighter();
//        return f;
//    }
//}
//
//public class FighterTest {
//    public static void main(String[] args){
//        Fighter f = new Fighter();
//        Fighttable f2 =f.getFightable();
//        f.move(100,200);
//        f.attack(new Fighter());
//    }
//}
