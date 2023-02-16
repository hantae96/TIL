package quiz;

import java.util.Scanner;

public class Quiz5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("세 가지 수를 입력하세요 : ");
//
//        int num1 = sc.nextInt();
//        int num2 = sc.nextInt();
//        int num3 = sc.nextInt();
//
//        if (num1 > num2){
//            if(num1 > num3){
//                System.out.println("제일 큰 수는 " + num1);
//            }else{
//                System.out.println("제일 큰 수는 " + num2);
//            }
//        }else{
//            if(num2 > num3){
//                System.out.println("제일 큰 수는 " + num2);
//            }else{
//                System.out.println("제일 큰 수는 " + num3);
//            }
//        }

        System.out.print("숫자를 입력하시오 : ");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.print("다시입력하세요 : ");
            num = sc.nextInt();
        } else {
            if (num % 3 == 0 || num % 4 == 0) {
                if (num % 3 == 0 && num % 4 == 0) {
                    System.out.println("3의 배수이면서 4의 배수입니다.");
                } else if (num % 3 == 0 && num % 4 != 0) {
                    System.out.println("3의 배수이지만 4의 배수는 아닙니다.");
                } else {
                    if (num % 4 == 0 && num % 3 != 0) {
                        System.out.println("4의 배수이지만 3의 배수는 아닙니다.");
                    } else if (num % 4 == 0 && num % 3 == 0) {
                        System.out.println("3의 배수이면서 4의 배수입니다.");
                    }
                }
            }else{
                System.out.println("3의 배수도 4의 배수도 아닙니다.");
            }
        }
    }
}
