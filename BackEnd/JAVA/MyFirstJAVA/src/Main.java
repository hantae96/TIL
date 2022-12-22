import java.math.BigInteger;
public class Main {

    public static void main(String args[]) {
        Loop1 : for(int i = 2;i<10;i++){
            for(int j = 1;j<10;j++){
                if(j==5){
                    break Loop1;
                }
            }
        }

        int [] arr1 = new int[5];

        String test = "MyFirstJava";

        System.out.println(test.charAt(0));
        System.out.println(test.length());
        System.out.println(test.substring(1,3));
        System.out.println(test.toCharArray());

        System.out.println(test.equalsIgnoreCase("MYFirstJava"));

        int [][] arr = new int [][] {{1,2,3},{4,5,6}};

    }
}