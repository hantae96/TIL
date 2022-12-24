package ch7;

public class SuperTEst {
    public static void main(String args[]){
        Child2 c = new Child2();
        c.method();
    }
}
class GrandParent2{
    int x = 1;
}
class Parent2 extends GrandParent2
{int x = 10;}
class Child2 extends Parent2 {
    int x = 20;
    void method(){
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x);
        System.out.println(super.x);

    }
}
