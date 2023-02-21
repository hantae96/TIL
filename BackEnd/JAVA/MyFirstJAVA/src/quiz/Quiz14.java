package quiz;

import java.util.Scanner;

public class Quiz14 {
    public static void main(String[] args) {
        // 주어진 수에 대해서 3 6 9가 몇개가 들어 있는지 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 숫자를 입력하세요 : ");
        int num = sc.nextInt();
        int ans = 0;

        for (int i = 1; i < num + 1; i++) {
            ans += check(i);
            }
        System.out.println(ans);
    }

    static int check(int num) {
        int count = 0;
        while (num > 0) {
            int mod = num % 10;
            if (mod == 3 || mod == 6 || mod == 9) count++;
            num = num / 10;
        }
        return count;
    }
}