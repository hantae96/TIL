package ch9;

class Test { }


public class Ex_9 {
    public static void main(String[] args){
       StringBuffer sb = new StringBuffer("abc");
       StringBuffer sb2 = new StringBuffer("abc");

       System.out.println(sb == sb2);
       System.out.println(sb.equals(sb2));

       String s = sb.toString();
       String s2 = sb2.toString();
//        String s = ""+sb;
//        String s2 = ""+sb2;

        System.out.println(sb);
       System.out.println(s.equals(s2));

       Test t = new Test();
       System.out.println(t.toString());
    }


}
