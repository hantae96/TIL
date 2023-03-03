package quiz;

import java.util.*;

class Solution {
    public int[] solution(String[] strList) {
        ArrayList<Integer> list = new ArrayList<>();
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}

public class Quiz19 {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
