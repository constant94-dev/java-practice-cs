package com.work.cspractice.datastructure.linear;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDS {

    public void runStack() {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            deque.push(i);
        }

        while (!deque.isEmpty()) {
            System.out.print(deque.pop() + "\t");
        }

        // output
        // 9 8 7 6 5 4 3 2 1 0
    }
}
