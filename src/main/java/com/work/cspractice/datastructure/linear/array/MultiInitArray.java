package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;

public class MultiInitArray {
    public void solution() {
        int[][] score = new int[4][3];
        score[0][0] = 10; // 첫 요소
        score[1][1] = 20;
        score[2][2] = 30;
        score[3][2] = 40; // 마지막 요소

        int[][] score2 = {
                {10,20,30},
                {40,50,60},
                {70,80,90},
                {100,110,120}
        };

        // for문 배열 순회 출력
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j]+" ");
            }
        }

        // Arrays 메서드 사용 출력
        // 1차원 Arrays.toString()
        // 2차원 Arrays.deepToString()
        System.out.println(Arrays.deepToString(score2));
    }

    public static void main(String[] args) {
        MultiInitArray test = new MultiInitArray();
        test.solution();
    }
}
