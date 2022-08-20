import java.util.Scanner;
import java.awt.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        int[] numArr = new int[10];
        int[] counter = new int[10];

        for(int i = 0; i<numArr.length; i++){
            numArr[i] = (int)(Math.random() * 10);
        }

        System.out.println(Arrays.toString(numArr));

        for (int j : numArr) {
            counter[j]++;
            System.out.printf("%d\t",j);
        }

        System.out.println(Arrays.toString(counter));

    }

}
