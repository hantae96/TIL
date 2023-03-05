package quiz;

import java.util.*;

class Solution {
    static String [] talkable = {"aya", "ye", "woo", "ma"};

    static boolean check(String string){
        for(String elem : talkable){
            if(string.equals(elem)){
                return true;
            }
        }
        return false;
    }


    public int solution(String[] babbling) {
        int answer = 0;

        for(String elem : babbling){
            boolean flag = false;
            String temp = "";
            for(int i = 0;i<elem.length();i++){
                if(check(temp)) {
                    flag = true;
                    temp = "";
                }
                temp += elem.charAt(i);
            }
            if(check(temp)){
                answer ++;
            }
        }

        return answer;
    }
}

public class Quiz19 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(s.solution(babbling));
    }
}
