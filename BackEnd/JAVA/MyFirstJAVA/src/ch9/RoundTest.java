package ch9;

import ch7.InterfaceTest;

import java.util.ArrayList;

public class RoundTest {
    public static void main(String[] args){
/*
        System.out.println("i="+ Integer.parseInt("100"));
*/
        System.out.println("i="+ Integer.parseInt("100",2));
        System.out.println("i="+ Integer.parseInt("100",16));
        System.out.println("i="+ Integer.parseInt("100",8));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(new Integer(100));

//        Integer i = list.get(0);
//        int i = list.get(0).intValue();
        int i = list.get(0);
        }
    }
