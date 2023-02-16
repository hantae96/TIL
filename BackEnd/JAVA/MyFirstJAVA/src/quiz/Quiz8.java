package quiz;

import java.util.Scanner;

public class Quiz8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String home = "";
        String company = "";
        boolean run = true;

        while(run) {
            System.out.println("1. 우리집 등록");
            System.out.println("2. 회사 등록");
            System.out.println("3. 등록 보기");
            System.out.println("4. 종료");

            System.out.print("입력 : ");
            // 여기서 5/n을 칠때 nextInt가 5만 가져오고 /n은 입력버퍼에 남는다.
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    // nextLine()은 개행문자를 가져오기때문에, 버퍼에 남아있는 /n만 가져오고 switch 문이 끝난다.
                    //home = sc.nextLine();
                    home = sc.next();
                    break;
                case 2:
                    company = sc.next();
                    break;
                case 3:
                    System.out.println(home);
                    System.out.println(company);
                    break;
                case 4:
                    System.out.println("종료");
                    run = false;

            }
        }



    }
}
