package ch7;
class Product{
    int price;
    int bonusPoint;

    Product(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Tv1 extends Product{
    Tv1(){
        super(100);
    }
    public String toString(){
        return "Tv";
    }
}


class radio1 extends Product{
    radio1(){
        super(200);
    }
    public String toString(){
        return "radio";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p){
        if (money < p.price){
            System.out.println("잔액부족");
            return;
        }
        money -=p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을 구입했습니다.");
    }
}

public class Ex_7_8 {
    public static void main(String [] args){
        Buyer b = new Buyer();
        b.buy(new Tv1());
        b.buy(new radio1());

        System.out.println("현재 남은돈은 "+ b.money);
        System.out.println("현재 보너스 점수는 "+ b.bonusPoint);
    }
}
