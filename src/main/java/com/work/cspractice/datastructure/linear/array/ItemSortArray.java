package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;
import java.util.Collections;

public class ItemSortArray {
    public void solution() {
        int[] arr = {3,2,1,0,4};

        // 오름차순
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 내림차순
        Integer[] arrReverse = {3,2,1,0,4}; // Collections.reverseOrder() 내림차순 적용시 Primitive Type 불가능
        // Wrapper Class (Integer, String) 사용 가능
        Arrays.sort(arrReverse, Collections.reverseOrder());
        System.out.println(Arrays.toString(arrReverse));

        // 배열 일부분 정렬
        int[] arrRange = {3,2,1,0,4};
        Arrays.sort(arrRange, 0, 3); // 배열 인덱스 3 전까지 정렬
        System.out.println(Arrays.toString(arrRange));
    }

    public static void main(String[] args) {
        ItemSortArray test = new ItemSortArray();
        test.solution();
    }
}
