package leetcode;

import java.util.*;

class MaxSubArraySolution {
    //[-2,1,-3,4,-1,2,1,-5,4],
    // [5,-3,4,6,-6,-2] -> 12
    // [1] -> 1
    // ideas 1: brutal force
    // - Get all the subArray and a value for each subArray sum and find max O(n^2)
    public int maxSubArray(int[] nums) {
        List<Integer> sumList = new ArrayList<Integer>();
        for (int i = 0 ; i < nums.length; i ++){
            int sum = nums[i];
            sumList.add(sum);
            for (int j = i + 1; j < nums.length; j ++){
                sum += nums[j];
                sumList.add(sum);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int sum : sumList){
            if (max < sum) max = sum;
        }
        
        return max;
    }
    // ideas 2:  get sum and find max sum O(n)
    //[-2,1,-3,4,-1,2,1,-5,4],
    public int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i ++){
            runningSum = Math.max(nums[i], runningSum + nums[i]);
            System.out.println(runningSum);
            
            result = Math.max(result, runningSum);
            System.out.println(result);
            System.out.println();
        }
        return result;
    }
}