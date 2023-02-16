package javaExample;


class Parent{
    String data = "난 부모 데이터야";
    Parent(String temp){
        System.out.println("부모 생성자가 오버로딩 되어있다!");
        System.out.println(this.data + temp);
    }
}

class Child extends Parent{
    String data = "난 자식 데이터야";

    Child(String temp){
        super(temp);
    }

    void print(){
        System.out.println(data);
        System.out.println(this.data);
        System.out.println(super.data);
    }
}


public class Super {
    public static void main(String[] args) {
        Child child = new Child("zz");
        // 자식 데이터에 접근
        child.print();
    }
}


