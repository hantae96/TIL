package quiz;

import java.util.Scanner;

public class Quiz15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("==동전 앞/뒤 맞추기");
            System.out.println("1.앞면 /2.뒷면/3.종료");
            System.out.print("선택 > ");

            int myNum = sc.nextInt();
            if(myNum == 3) break;
            int com = (int)Math.round(Math.random());

            if (myNum == com) System.out.println("맞췄습니다!!");
            else System.out.println("틀렸습니다!!");
            System.out.println(com);
        }
    }
}
