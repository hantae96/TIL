package ch6;

public class MyMathTest {
    public static void main(String [] args){
        MyMath mm = new MyMath();

        long result2 = mm.substract(5L,3L);
        long result3 = mm.multiply(5L,3L);
        long result4 = mm.divide(5L,3L);


    }
}

class MyMath {
    long add(long a, long b){
        long result = a+b;
        return result;
    }
    long substract(long a,long b){return a-b;}
    long multiply(long a,long b){return a*b;}
    long divide(double a,double b){
        return (long) (a / b);
    }

}
