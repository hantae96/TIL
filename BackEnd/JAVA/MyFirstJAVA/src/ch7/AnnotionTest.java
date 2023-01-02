package ch7;

class Parent1{
    void parentMethod(){}
    @Deprecated
    void notUsed(){}
}

public class AnnotionTest extends Parent1{
    public static void main(String[] args){
        Parent1 p = new Parent1();
        p.notUsed();
    }


}
