package ch6;

public class CardTest {
    //main도 메서드의 한종류이다. 프로그램 실행시 OS에 의해 자동호출된다.

    public static void main(String args[]){
        // static 변수(전역변수)는 클래스를 생성자를 통해 인스턴스화 하지 않아도 사용가능
        // 클래스가 컴파일되면서 메모리에 올라가기때문에
        System.out.println("ch6.Card-width : "+Card.width);
        System.out.println("ch6.Card-width : "+Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        c2.width = 50;
        c2.height = 100;
        System.out.println("ch6.Card-width : "+Card.width);
        System.out.println("ch6.Card-width : "+Card.height);

        }
    }



class Card {
    //static이 안 붙은건 인스턴스 변수 -> 해당 인스턴스가 생성자에 의해 생성될때 메모리에 올라가서 할당 가능
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}