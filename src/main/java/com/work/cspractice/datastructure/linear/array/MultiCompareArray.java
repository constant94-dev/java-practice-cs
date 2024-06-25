package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;

public class MultiCompareArray {
    public void solution() {
        String[][] arr1 = {
                {"홍길동","임꺽정"},
                {"박혁거세","주몽","고담시티"}
        };
        String[][] arr2 = {
                {"홍길동","임꺽정"},
                {"박혁거세","주몽","고담시티"}
        };
        String[][] arr3 = {
                {"홍길동","임전무퇴"},
                {"고담시티"}
        };

        // 1차원 배열 비교 Arrays.equals()
        // 2차원 배열 비교 Arrays.deepEquals()
        // 배열 요소 비교시 순서와 값이 같아야 같은 배열로 인식
        System.out.println("arr1 == arr2: " + Arrays.deepEquals(arr1, arr2));
        System.out.println("arr1 == arr3: " + Arrays.deepEquals(arr1, arr3));
    }

    public static void main(String[] args) {
        MultiCompareArray test = new MultiCompareArray();
        test.solution();
    }
}
