import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][];
        int[] person = new int[num];
        double[] result = new double[num];

//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int n = sc.nextInt();
            person[i] = n;
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            result[i] = (double) sum / person[i];
        }

        for (int i = 0; i<arr.length;i++){
            int count = 0;
            for (int j = 0; j<arr[i].length;j++){
                if(arr[i][j] > result[i]){
                    count++;
                }
            }
            System.out.printf("%.3f%%\n",(double)count/person[i]*100);
        }
    }
}
