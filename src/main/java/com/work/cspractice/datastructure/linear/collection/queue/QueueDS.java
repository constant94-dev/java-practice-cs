package com.work.cspractice.datastructure.linear.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDS {
    private static class Student implements Comparable<Student> {
        String name; // 학생 이름
        int priority; // 우선순위 값

        public Student(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Student student) {
            if (this.priority < student.priority) {
                return -1;
            } else if (this.priority == student.priority) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }

    /* NOTE solutionPriority() 메서드에서 PriorityQueue toString 메서드 호출했을 때 정렬이 안되어 있다.
    *   왜냐하면, PriorityQueue 클래스가 내부적으로 힙 구조를 사용하기 때문이다.
    *   toString 메서드를 사용할 때 순서를 유지하지 않고 최소 또는 최대 요소 접근을 위한 힙 속성을 유지한다.
    *   PriorityQueue 요소를 하나씩 꺼내서 확인한다면 우선순위에 따라 정렬된 순서로 출력된다. */
    public void solutionPriority() {
        Queue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Student("김씨네쌀",2));
        priorityQueue.offer(new Student("이씨네쌀",3));
        priorityQueue.offer(new Student("최씨네쌀",1));
        priorityQueue.offer(new Student("박씨네쌀",5));
        priorityQueue.offer(new Student("조씨네쌀",4));

        System.out.println(priorityQueue);
        /* [Student{name='최씨네쌀', priority=1},
         Student{name='이씨네쌀', priority=3},
         Student{name='김씨네쌀', priority=2},
         Student{name='박씨네쌀', priority=5},
         Student{name='조씨네쌀', priority=4}] */

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
        /* Student{name='최씨네쌀', priority=1}
        Student{name='김씨네쌀', priority=2}
        Student{name='이씨네쌀', priority=3}
        Student{name='조씨네쌀', priority=4}
        Student{name='박씨네쌀', priority=5} */
    }

    public void solutionDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(100); // [100]
        deque.offerFirst(101); // [101, 100]
        deque.offerFirst(102); // [102, 101, 100]
        deque.offerLast(103); // [102, 101, 100, 103]

        System.out.println(deque);

        deque.pollFirst(); // [101, 100, 103]
        System.out.println(deque);
        deque.pollLast(); // [101, 100]
        System.out.println(deque);
        deque.pollFirst(); // [100]
        System.out.println(deque);
        deque.pollLast(); // []
        System.out.println(deque);
    }

    public static void main(String[] args) {
        QueueDS test = new QueueDS();
        test.solutionDeque();
    }
}
