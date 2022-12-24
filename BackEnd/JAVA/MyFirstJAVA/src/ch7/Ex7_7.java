package ch7;


class Car1{
    String color;
    int door;

    void drive(){
        System.out.println("부르릉");
    }
    void stop(){
        System.out.println("멈춰");
    }
}

class FireEngine extends Car1{
    void water(){
        System.out.println("물뿌리기");
    }
}


public class Ex7_7 {
    public static void main(String args[]){
        Car1 car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = (FireEngine)car;
        Car1 car2 = (Car1)fe2;
        car2.drive();

        fe.water();
        car = (Car1)fe;
//        car.water();
        fe2 = (FireEngine)car;
        fe2.water();

    }
}
