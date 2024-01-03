package com.work.cspractice;

import com.work.cspractice.datastructure.linear.DualLinkedList;
import com.work.cspractice.datastructure.linear.DynamicArray;
import com.work.cspractice.datastructure.linear.QueueDS;
import com.work.cspractice.datastructure.linear.SingleLinkedList;
import com.work.cspractice.datastructure.linear.StackDS;
import com.work.cspractice.datastructure.linear.StaticArray;
import com.work.cspractice.java.nio.JavaNIO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsPracticeApplication.class, args);

        JavaNIO nio = new JavaNIO();
        nio.createFileAndRead();
    }

    private static void runSingleLinkedList() {
        SingleLinkedList<Number> l = new SingleLinkedList<>();

        l.add(3);
        l.add(6);
        l.add(4);
        l.add(3);
        l.add(8);
        l.add(10);
        l.add(11);
        System.out.println(l); // [3, 6, 4, 3, 8, 10, 11]

        l.add(6, 100);
        l.add(0, 101);
        l.add(1, 102);
        System.out.println(l); // [101, 102, 3, 6, 4, 3, 8, 10, 11, 100]

        l.removeFirst();
        l.removeFirst();
        l.remove(1);
        System.out.println(l); // [3, 4, 3, 8, 10, 11, 100]

        l.remove(Integer.valueOf(3));
        l.remove(Integer.valueOf(3));
        System.out.println(l); // [4, 8, 10, 11, 100]

        System.out.println(l.get(4)); // 100

        l.set(4, 999);
        System.out.println(l); // [4, 8, 10, 11, 999]
    }

    private static void runDualLinkedList() {
        DualLinkedList<Number> list = new DualLinkedList<>();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(list.toString());

        list.removeFirst();

        System.out.println(list.toString());

        list.removeLast();

        System.out.println(list.toString());

        System.out.println(list.remove(2.5)); // 없는 요소 삭제

        System.out.println(list.toString());

        System.out.println(list.get(2));
        list.set(1, 3.5); // 첫번째 요소 수정 (3 -> 3.5)

        System.out.println(list.toString());
    }

    private static void runStaticArray() {
        StaticArray sArrays = new StaticArray();
        sArrays.runArray();
    }

    private static void runDynamicArray() {
        DynamicArray dArrays = new DynamicArray();
        dArrays.runArray();
    }

    private static void runStackDS() {
        StackDS stack = new StackDS();
        stack.runStack();
    }

    private static void runQueueDS() {
        QueueDS queue = new QueueDS();
        queue.runQueue();
    }
}
