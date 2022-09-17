import java.util.Scanner;
import java.awt.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main M = new Main();
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int R = sc.nextInt();
            char [] S= sc.next().toCharArray();
            M.print(S,R);
        }

    }
    private void print(char [] test, int step){
        for (int j = 0; j<test.length;j++){
            for (int k = 0; k<step;k++){
                System.out.print(test[j]);
            }
        }
        System.out.println();
    }
}
