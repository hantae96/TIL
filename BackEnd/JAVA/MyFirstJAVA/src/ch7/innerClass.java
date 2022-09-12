package ch7;
class AAA {
    int i;
    BBB b = new BBB();

    class BBB{
        void method() {
            System.out.println(i);
        }
    }

}


//class CCC {
//    BBB b = new BBB();
//}

public class innerClass {
    public static void main(String[] args){
//        BBB b = new BBB();
//        b.method();
    }
}
