package com.work.cspractice.algorithm.sort;

import java.util.Arrays;

public class MyBubbleSort {
    public void solution(int[] nums) {
        int arrayLength = nums.length;
        for (int i=0; i<arrayLength; i++){
            for (int j=0; j<arrayLength-i-1; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MyBubbleSort test = new MyBubbleSort();
        int[] nums = {7,3,4,5,1,2,6};
        test.solution(nums);
    }
}
