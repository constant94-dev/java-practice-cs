package com.work.cspractice.datastructure.linear;

import java.util.ArrayDeque;

public class QueueDS {

    public void runQueue() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

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
