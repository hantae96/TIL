import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.awt.*;
import java.util.*;
import java.util.Scanner;

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 200;

    Card(String kind,int number){
        this.kind = kind;
        this.number = number;
    }

    Card(){
        this("test",1);
    }

    void printCard(){
        System.out.println("모양은"+kind+"숫자는"+number);
    }
}
public class Main {
    public static void main(String[] args) {

        Card c1 = new Card("ACE",1);
        Card c2 = new Card("DIA",10);
        Card c3 = new Card();


        c1.printCard();
        c2.printCard();
        c3.printCard();

        Card.width = 2000;
        System.out.println(c3.width);

    }
}