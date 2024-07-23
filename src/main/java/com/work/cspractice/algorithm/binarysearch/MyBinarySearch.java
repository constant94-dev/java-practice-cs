package com.work.cspractice.algorithm.binarysearch;

public class MyBinarySearch {
    public int indexOfRotatedArray(int[] nums, int start, int end, int target) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;

        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target <= nums[mid]) return indexOfRotatedArray(nums, start, mid-1, target);
            return indexOfRotatedArray(nums, mid+1, end, target);
        }

        if (target >= nums[mid] && target <= nums[end]) {
            return indexOfRotatedArray(nums, mid+1, end, target);
        }
        return indexOfRotatedArray(nums, start, mid-1, target);
    }

    public static void main(String[] args) {
        int[] nums = {20,25,26,29,33,1,3,5,6,10,11,19}; // 33에서 1로 넘어갈 때 값이 튐
        int start = 0;
        int end = nums.length-1;

        MyBinarySearch test = new MyBinarySearch();
        int result = test.indexOfRotatedArray(nums, start, end, 11);
        System.out.println("내가 찾고 싶은 숫자의 인덱스 번호: "+result);
    }
}
