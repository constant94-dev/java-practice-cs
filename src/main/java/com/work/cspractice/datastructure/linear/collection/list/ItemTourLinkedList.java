package com.work.cspractice.datastructure.linear.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ItemTourLinkedList {
    public void solution() {
        List<Integer> originItem = new LinkedList<>(List.of(0,1,2));
        for (int item : originItem) {
            System.out.print(item);
        }

        System.out.println("\n---");
        Iterator<Integer> it = originItem.iterator();
        while (it.hasNext()){
            Integer item = it.next();
            System.out.println(item);
        }

        ListIterator<Integer> itList = originItem.listIterator(); // List 컬렉션만 사용 가능
        // listIterator 는 양방향을 지원 LinkedList 처럼 전,후 노드를 가져올 수 있다.
        while (itList.hasNext()){
            Integer item = itList.next();
            System.out.println(item);
        }
        System.out.println("---");
        while (itList.hasPrevious()){
            Integer item = itList.previous();
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        ItemTourLinkedList test = new ItemTourLinkedList();
        test.solution();
    }
}
