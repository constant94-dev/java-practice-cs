package com.work.cspractice.datastructure.linear;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDS {

    public void runQueue() {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            deque.offer(i);
        }

        while (!deque.isEmpty()) {
            System.out.print(deque.poll() + "\t");
        }

        // output
        // 0 1 2 3 4 5 6 7 8 9
    }
}
