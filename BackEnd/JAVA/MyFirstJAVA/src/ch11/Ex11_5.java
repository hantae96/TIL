package ch11;

import java.util.*;


public class Ex11_5 {
    public static void main(String [] args){
        Collection c = new HashSet();
        Collection a = new ArrayList();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");

        Iterator it = c.iterator();

        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
//
//        for(int i = 0;i<list.size();i++){
//            Object obj = list.get(i);
//            System.out.println(obj);
//        }
    }
}
