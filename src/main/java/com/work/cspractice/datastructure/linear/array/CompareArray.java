package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;

public class CompareArray {
    // 배열 구성 요소가 같은지 아닌지 for문 순회하지 않고 확인하는 방법
    // 배열 구성 요소가 같다는 것은 값과 순서가 모두 같아야한다
    // 반대라면 다른 배열로 인식한다
    public void solution() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};

        String[] arr3 = {"홍길동","고담시티","페이커"};
        String[] arr4 = {"페이커","코담시티","홍길동"};
        String[] arr5 = {"홍길동","고담시티","페이커"};

        System.out.println("arr1 == arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr3 == arr4: " + Arrays.equals(arr3, arr4));
        System.out.println("arr3 == arr5: " + Arrays.equals(arr3, arr5));
    }

    public static void main(String[] args) {
        CompareArray test = new CompareArray();
        test.solution();
    }
}
