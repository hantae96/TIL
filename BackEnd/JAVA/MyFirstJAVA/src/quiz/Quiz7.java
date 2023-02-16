package quiz;

import java.util.Scanner;

public class Quiz7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = 1000;
        int count = 0;
        double answer = 0;

        System.out.print("몇 개를 구매하시겠습니까? : ");
        count = sc.nextInt();

        if (count >= 100){
            answer = (count*price)*0.88;
        }else if (count >= 10){
            answer = (count*price)*0.9;
        }else{
            answer = (count*price);
        }
        System.out.println("총 가격은 "+answer);


        int coffee = 0;
        System.out.print("몇 개를 구매하시겠습니까? : ");
        count = sc.nextInt();

        if (count > 10) coffee += (2000*10) + (1500*(count-10));
        else coffee += (count*2000);
        System.out.println("커피 가격은 " + coffee);

        int basicPrice = 30000;
        int addPrice = 5000;

        System.out.println("비행기 타는데 까지 얼마나 걸림?");
        int time = sc.nextInt();

        if (time >= 30){
            basicPrice+=((time-30)/10)*addPrice;
        }

        System.out.println(basicPrice);
    }
}
