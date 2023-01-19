package ch11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap grade = new HashMap();
        grade.put("최한태",(100));
        grade.put("홍길동",60);
        grade.put("아무개",10);

        Set set = grade.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("이름 : "+e.getKey() + ", 점수 : "+e.getValue());
        }

        set = grade.keySet();
        System.out.println("참가자 명단 : "+ set);

//        Collection values = grade.values();
        Collection values = grade.values();
        it = values.iterator();

        int total = 0;

        while(it.hasNext()){
            Integer i = (Integer) it.next();
            total += i.intValue();
        }

        System.out.println("총점 : "+ total);
        System.out.println("평균 : "+ (float)total/set.size());
        System.out.println("최고점수 : "+ Collections.max(values));
        System.out.println("최저점수 : "+ Collections.min(values));

    }
}
