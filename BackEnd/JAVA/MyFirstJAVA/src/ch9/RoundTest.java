package ch9;
import java.util.Scanner;
import java.util.Arrays;

public class RoundTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        String B = sc.next();
//        System.out.println(B.getClass().getName());
        int res = 0;
        for (int i =0; i<A;i++){
//            System.out.println(B[i]);
            res += B.charAt(i) - '0';
        }

        System.out.println(res);

        }
    }
