package quiz;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("줄수를 입력하세요 : ");
        int line = sc.nextInt();

        String star = "*";
        String blank = " ";
        int length = line / 2;

        for (int i = 0; i < line; i++) {
            if (i < length) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(blank);
                }
                for (int k = 0; k < i * 2 + 1; k++) {
                    System.out.print(star);
                }
            } else if (i > length) {
                for (int k = 0; k < (i - length); k++) {
                    System.out.print(blank);
                }
                for (int j = 0; j < 2 * (line - i) - 1; j++) {
                    System.out.print(star);
                }
            } else {
                for (int m = 0; m < line; m++)
                    System.out.print(star);
            }
            System.out.println();
        }

        System.out.println();

        for (int j = 0; j < line; j++) {
            if(j<length) {
                for (int i = j; i < length; i++) {
                    System.out.print(star);
                }
                for (int i = 0; i < (length - (length - j) + 1)*2; i++) {
                    System.out.print(blank);
                }
                for (int i = j; i < length; i++) {
                    System.out.print(star);
                }
            }
            else if(j>length){
                for (int i = 0; i < (j-length); i++) {
                    System.out.print(star);
                }
                for (int i = ((line - j)*2); i > 0; i--) {
                    System.out.print(blank);
                }
                for (int i = 0; i < (j-length); i++) {
                    System.out.print(star);
                }
            }
            else{
                for (int m = 0; m < line; m++)
                    System.out.print(blank);
            }
            System.out.println();
        }
    }
    }

