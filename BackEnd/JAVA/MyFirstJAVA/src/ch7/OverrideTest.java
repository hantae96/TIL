package ch7;

class MyPoint3 {
    int x;
    int y;
    MyPoint3(){}
    MyPoint3(int x,int y){
        this.x = x;
        this.y = y;

    }
    public String toString(){
        return "x:"+x+",y:"+y;
    }
}
class MyPoint3D extends MyPoint3{
    int z;
    public String toString(){
        return "x:"+x+",y:"+y+"z:"+z;
    }
}

public class OverrideTest{
    public static void main(String [] args){
        MyPoint3D p = new MyPoint3D();
        p.x = 3;
        p.y = 5;
        p.z = 7;
        System.out.println(p);
    }
}