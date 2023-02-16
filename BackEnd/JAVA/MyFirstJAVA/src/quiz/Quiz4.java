package quiz;

import java.util.Scanner;

public class Quiz4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("입력 : ");
        int num = sc.nextInt();
        System.out.println((num%5==0)? "5의 배수입니다.": "5의 배수가 아닙니다.");

        System.out.print("0 부터 100 이내의 수를 입력하세요 : ");
        num = sc.nextInt();
        if (num > 0 && num < 100) System.out.println("적중");
        else System.out.println("비적중");

        System.out.print("입력 : ");
        num = sc.nextInt();
        if (num % 2 == 0 && num%3 == 0) System.out.println("2의 배수이자 3의 배수입니다,");
        else System.out.println("2의 배수이자 3의 배수가 아닙니다.");

    }
}
