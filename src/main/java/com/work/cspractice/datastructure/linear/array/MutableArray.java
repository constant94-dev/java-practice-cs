package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;

public class MutableArray {
    // 가로 세로가 똑같은 정방 행렬로 만들지 않아도 됨
    // 이것을 가변 배열이라고 함
    public void solution() {
        int[][] arr1 = {
                {10,10,10,10,10},
                {20,20},
                {30,30,30},
                {40,40}
        };

        System.out.println(Arrays.deepToString(arr1));
    }

    public static void main(String[] args) {
        MutableArray test = new MutableArray();
        test.solution();
    }
}
