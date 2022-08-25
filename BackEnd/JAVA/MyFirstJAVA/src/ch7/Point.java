package ch7;

class MyPoint {
    int x;
    int y;
}

// 상속
/*
class Circle extends MyPoint {
    int r;
}
*/

class Circle{
    MyPoint p = new MyPoint();
    int r;

}


public class Point {
    public static void main(String[] args){
        Circle c = new Circle();
        System.out.println(c.toString());
        Circle c2 = new Circle();
        System.out.println(c2.toString());
    }
}
