package com.work.cspractice.datastructure.linear.array;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ItemCopyArray {
    /* for문 보다 Java API 메서드 사용이 두배 빠르다
     * */
    public void solution() {

        int[] arr1 = {10,20,30,40,50};
        int[] arr2 = new int[arr1.length * 2];

        // 루프문 순회하며 복사
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        System.out.println(Arrays.toString(arr2));
    }

    public void solution2() {
        int[] arr1 = {10,20,30,40,50};
        int[] arr2 = new int[arr1.length * 2];

        arr2 = Arrays.copyOf(arr1, arr1.length); // arr1 배열을 arr1.length 만큼 복사 arr2 할당
        System.out.println(Arrays.toString(arr2));

        arr2 = Arrays.copyOfRange(arr1, 1, 3); // arr1 배열을 시작점 1 부터 끝점 3 전까지 복사 arr2 할당
        System.out.println(Arrays.toString(arr2));
    }

    public static void main(String[] args) {
        Instant beforeTime = Instant.now();

        ItemCopyArray test = new ItemCopyArray();
        test.solution2();

        Instant afterTime = Instant.now();
        double mills = Math.pow(10,-6);
        double diffTime = Duration.between(beforeTime, afterTime).getNano() * mills;
        System.out.println("실행시간: " + diffTime);
    }

    /** element 5
     * solution1: min 0.11 max 0.33 or 37 or 45
     * solution2: min 0.11 max 0.32 or 35 or 37
     * */
}
