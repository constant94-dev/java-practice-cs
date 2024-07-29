package com.work.cspractice.algorithm.sort;

import java.util.Arrays;

public class MySelectSort {
    byte age;
    byte order;
    public void solution(int[] nums) {
        int arrLength = nums.length;
        for (int i = 0; i < arrLength; i++) {
            int minIndex = findMinIndex(nums, i, arrLength);
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        int a = this.age << 8;

        System.out.println(Arrays.toString(nums));
    }

    private int findMinIndex(int[] nums, int targetIndex, int arrLength) {
        int startIndex = targetIndex+1;
        for (int i = startIndex; i < arrLength; i++) {
            if (nums[i] < nums[targetIndex]) {
                targetIndex = i;
            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        MySelectSort test = new MySelectSort();
        int[] nums = {7, 3, 4, 5, 6, 1, 2};
        test.solution(nums);
    }
}
