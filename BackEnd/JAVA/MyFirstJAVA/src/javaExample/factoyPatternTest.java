package javaExample;

import java.util.Arrays;

import java.util.*;

class Solution1 {
    public ArrayList<Integer> solution(int num, int total) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = -total;i<total;i++){
            int temp = 0;
            int start = i;
            for(int j = 0;j<num;j++){
                temp += start+j;
                answer.add(start+j);
            }

            if (temp == total){
                break;
            }else{
                answer.clear();
            }
        }
        return answer;
    }
}

public class factoyPatternTest {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        ArrayList<Integer> test = s.solution(3,0);
        for (Integer integer : test) {
            System.out.println(integer);
        }
    }
}


