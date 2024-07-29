package com.work.cspractice.algorithm.sort;

import java.util.Arrays;

public class MyQuickSort {
    public void solution(int[] nums) {
        quickSortRecursive(nums, 0, nums.length-1);
    }

    private void quickSortRecursive(int[] nums, int left, int right) {
        if (left >= right) return; // 좌측은 작은 값, 우측은 큰 값 (좌측의 기준값이 크거나 같으면 종료)

        int pivotPos = partition(nums, left, right); // 각 회차의 정렬을 수행하는 함수

        quickSortRecursive(nums, left, pivotPos-1); // 분할한 부분의 왼쪽 부분을 정렬
        quickSortRecursive(nums, pivotPos+1, right);// 분할한 부분의 오른쪽 부분을 정렬
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // 가장 오른쪽 요소를 기준 값

        int i = left - 1; // 좌측 기준 값
        for (int j=left; j<right; j++){
            if (nums[j] < pivot) {
                i++;
                mySwap(nums, i, j);
            }
        }

        int pivotPos = i + 1; // 초기 기준값과 최종 좌측 값 교체 (위 반복문을 통해 기준값 좌측은 작은 값 모임)
        mySwap(nums, pivotPos, right);

        System.out.println("현재 "+pivotPos+"번째: "+Arrays.toString(nums));

        return pivotPos;
    }

    private void mySwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        MyQuickSort test = new MyQuickSort();
        int[] nums = {7,3,4,5,6,1,2};
        test.solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}