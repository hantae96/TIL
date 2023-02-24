package quiz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Quiz16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        String[] [] Array = new String[5][];

        while(cnt < 5){
            System.out.println(cnt+1 + "번쨰 정보 입력");
            String name = sc.next();
            String age = sc.next();
            String [] temp = new String[]{name,age};
            Array[cnt] = temp;
            cnt++;
        }

        Arrays.stream(Array).sorted();

        for(int i =0;i<Array.length;i++){
            System.out.println(i+1 + "정보");
            System.out.printf("이름 : "+Array[i][0]);
            System.out.println("나이 : "+Array[i][1]);
            }

    }
}
