package ch7;
import java.util.Scanner;


public class MultiArr {
    public static void main(String[] args) {
        int sum = 0;
        sum = factorial(5);
        System.out.println(sum);
    }
    static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num-1);
        }
    }
}


