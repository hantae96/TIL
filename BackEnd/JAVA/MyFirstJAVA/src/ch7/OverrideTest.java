package ch7;

import java.util.Scanner;

public class OverrideTest {
    public static void main(String[] args) {

        System.out.print("게임을 시작 할려면 4아니면 아무거나 ~ 끝낼려면 4 를 누르세요");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<3;i++) {
        int user = scanner.nextInt();
            int com = (int) (Math.random() * 2);
            int tmp = user - com;

            String[] arr = {"가위", "바위", "보"};

            System.out.println("나 : " + arr[user]);
            System.out.println("컴퓨터 : " + arr[com]);

            switch (tmp) {
                case 1:
                case -2: {
                    System.out.println("이김ㅋ");
                    break;
                }
                case 0: {
                    System.out.println(("비김ㅋ"));
                    break;
                }
                case -1:
                case 2: {
                    System.out.println("짐ㅋ");
                    break;
                }
            }
        }
    }
}

