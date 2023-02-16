package quiz;

import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수 입력 : ");
        int temp = scanner.nextInt();
        System.out.println((temp%2==0? "짝수" : "홀수"));
        System.out.println((temp%3==0? "3의 배수" : "3의 배수가 아니다"));
        System.out.print("두 수 입력 : ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("data1 : "+a+"\tdata2 : "+b);
        System.out.println((a>b? "a가 큼" : "b가 큼"));



    }
}
