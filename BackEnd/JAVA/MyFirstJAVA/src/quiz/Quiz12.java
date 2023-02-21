package quiz;

public class Quiz12 {
    public static void main(String[] args) {
        for(int num = 1;num<=1000;num++){
            int sum = 0;
            for (int i = 1;i<num;i++){
                if(num%i==0 && num != i) sum+=i;
            }
//            System.out.println(sum);
            if(sum == num) System.out.println(num);
        }
    }
}
