package ch11;

import java.util.*;

class Tv{}
class Audio{}


public class Ex11_13 {
    public static void main(String[] args) {
        ArrayList<Tv> list = new ArrayList<Tv>();
        list.add(new Tv());
//        list.add(new Audio());
        Tv t = list.get(0);
    }
}
