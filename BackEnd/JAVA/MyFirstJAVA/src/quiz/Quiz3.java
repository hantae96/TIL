package quiz;

import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하시오");

        int num = sc.nextInt();
        if (num %3 == 0) System.out.println("3의 배수입니다.");

        num = sc.nextInt();
        System.out.println((int)Math.sqrt(num*num));

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((a>b)? a: b);
    }
}
