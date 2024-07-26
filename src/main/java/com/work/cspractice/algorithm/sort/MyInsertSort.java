package com.work.cspractice.algorithm.sort;

import java.util.Arrays;

public class MyInsertSort {
    public void solution(int[] nums) {
        int arrLength = nums.length;
        for (int i=0; i<arrLength; i++){
            if (i==0) continue;

            int leftIndex = i-1;
            while (nums[leftIndex] > nums[i]){
                int temp = nums[i];
                nums[i] = nums[leftIndex];
                nums[leftIndex] = temp;

                i = leftIndex;
                leftIndex--;

                if (leftIndex < 0) break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MyInsertSort test = new MyInsertSort();
        int[] nums = {5,4,1,2,6,7,3};
        test.solution(nums);
    }
}
