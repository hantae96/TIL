package ch11;

import java.lang.reflect.Array;
import java.util.*;

public class Ex11_7 {
    public static void main(String[] args) {
       ArrayList list1 = new ArrayList(10);
       list1.add(new Integer(5));
       list1.add(4);
       list1.add(3);
       list1.add(0);
       list1.add(2);
       list1.add(1);

       ArrayList list2 = new ArrayList(list1.subList(1,4));
       print(list1,list2);

       Collections.sort(list1);
       Collections.sort(list2);
       print(list1,list2);

       System.out.println("list1.containsAll(list2):"+list1.containsAll(list2));

       list2.add("B");
       list2.add("C");
       list2.add("A");
       print(list1,list2);

       list2.set(3,"AA");
       print(list1,list2);

       System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
    }

    static void print(ArrayList list1, ArrayList list2){
        System.out.println("list1:" + list1);
        System.out.println("list2: "+ list2);
        System.out.println();
    }
}
