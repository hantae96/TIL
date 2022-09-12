package ch7;

class Product2 {
    int price;
    int bonusPoint;

    Product2(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
    Product2(){}
}

class Tv3 extends Product2{
    Tv3(){super(100);}

    public String toString() {return "Tv";}
}

class Computer extends Product2{
    Computer() { super(200);}
    public String toString() {return "Computer";}
}

class Audio extends Product2 {
    Audio(){ super(50);}
    public String toString(){ return "Audio";}
}

class Buyer2{
    int money = 1000;
    int bonusPoint = 0;
    Product2 [] item = new Product2[10];
    int i = 0;

    void buy(Product2 p){
        if (money < p.price){
            System.out.println("잔액부족");
            return ;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item[i++] = p;
        System.out.println(p + "구입");
    }
    void summary(){
        int sum = 0;
        String itemList = "";

        for (int i = 0; i<item.length;i++){
            if(item[i] == null) break;
            sum += item[i].price;
            itemList += item[i] + ". ";
        }
        System.out.println("구입하신 물품 총 금액 : "+sum);
        System.out.println("구입하신 제품 : " + itemList);
    }
}



public class PolyArgumentTest2 {
    public static void main(String args[]){
        Buyer2 b =new Buyer2();

        b.buy(new Tv3());
        b.buy(new Computer());
        b.buy(new Audio());
        b.summary();
    }
}
