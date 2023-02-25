package quiz;

import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // 최종 수정 인덱스?
        int addIndex = 0;

        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                nums[addIndex] = nums[i+1];
                addIndex
            }
        }

    }
}


public class Quiz17 {
    public static void main(String[] args) {
//        int [] nums =new int []{1,1,2};
        int [] nums = new int []{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Solution.removeDuplicates(nums));
    }
}
