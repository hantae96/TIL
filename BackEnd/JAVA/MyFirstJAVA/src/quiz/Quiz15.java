package quiz;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Quiz15 {
    static int change(String num){
        char[] Arr = num.toCharArray();
        int sum = 0;

        for(int i = Arr.length-1;i >= 0 ;i--){
            int reverseIdx = (Arr.length-1)-i;
            sum += (Arr[i]-'0')*(Math.pow(2,reverseIdx));
        }
        return sum;
    }
    public static void main(String[] args) {
        String A = "1000"; // 8
        String B = "0111"; //7

        System.out.println(change(A)+change(B));
    }
}
