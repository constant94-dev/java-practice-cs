package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;

public class InitArray {
    public void solution(){
        int[] arr = {1,2,3,4,5,6};
        System.out.println(arr); // [I@4617c264 -> 메모리 배열 주소 값(타입@주소)
        // [I : 배열 integer
        // @4617c264 : 주소값

        char[] arr2 = {'A','B','C'};
        System.out.println(arr2);

        String[] arr3 = new String[3];
        arr3[0] = "we";
        arr3[1] = "are";
        arr3[2] = "the world";
        System.out.println(Arrays.toString(arr3));
    }

    public static void main(String[] args) {
        InitArray test = new InitArray();
        test.solution();
    }
}
