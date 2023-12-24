package com.work.cspractice.datastructure.linear;

public class StaticArray {
    public void runArray() {
        int[] sArrays = new int[10];
        for (int i = 0; i < sArrays.length; i++) {
            sArrays[i] = i;
        }

        for (int sArray : sArrays) {
            System.out.print(sArray + "\t");
        }
        /* output
         * 0 1 2 3 4 5 6 7 8 9
         * */
    }
}
