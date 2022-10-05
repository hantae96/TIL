import java.io.EOFException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 10){
            num *= 10;
        }

        int count = 1;
        int res = 0;
        int a,b,tmp;

        while(num!=res){
            if (count == 1){
                a = num/10;
                b = num%10;
                tmp = (a+b)%10;
                res = (num%10)*10 + tmp;
            }else{
                a = res/10;
                b = res%10;
                tmp = (a+b)%10;
                res = (res%10)*10 + tmp;
            }
            count++;
        }


        System.out.println(count);
    }
}
