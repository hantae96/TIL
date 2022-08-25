package ch7;

class MyPoint3 extends Object {
    MyPoint3(int x,int y){
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
    public  String toString(){
        return "x : "+x+", y : "+y;
    }
}

public class OverrideTest {
    public static void main(String[] args){
        MyPoint3 p = new MyPoint3(3,5);
        System.out.println(p);
    }
}
