package ch7;

class Card {
    final int NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    Card(String kind,int num){
        KIND = kind;
        NUMBER = num;
    }
    Card(){
        this("HEART",1);
    }

    public String toString(){
        return KIND + "" + NUMBER;
    }
}

public class FinalCardTest {
   public static void main(String args[]){
       Card c = new Card("HEART",10);
       //c.NUMBER = 5;
       System.out.println(c.KIND);

   }
}

