package quiz;

import java.util.Scanner;

public class Quiz6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("학점을 입력하세요 : ");
        int alpa = sc.next().charAt(0);
        if (64 < alpa && alpa <  67){
            System.out.println("참잘했어요");
        }else if(66< alpa && alpa < 69){
            System.out.println("분발합시다.");
        }else if(alpa == 70){
            System.out.println("");
        }

        System.out.print("윤년 판단을 위해 년도를 입력하세요 : ");
        int year = sc.nextInt();

        if(year%4==0){
            if(year%100==0){
                if(year % 400 == 0){
                    System.out.println(year + "윤년");
                }else{
                    System.out.println(year + "평년");
                }
            }else{
                System.out.println(year + " 윤년");
            }
        }
    }
}
