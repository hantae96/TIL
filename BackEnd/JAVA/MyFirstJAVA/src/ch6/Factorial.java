package ch6;

public class Factorial {
    public static void main(String args []) {
        int [] arr = new int[] {3,2,1,6,5,4};

        printArr(arr);
        printArr(arr);
        System.out.println("sum = " + sumArr(arr));
    }

    static void printArr(int[] arr){
        System.out.print("[");

        for (int i : arr)
            System.out.print(i+",");
        System.out.println("]");
    }

    static int sumArr(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
            sum += arr[i];
        return sum;
    }
    }

