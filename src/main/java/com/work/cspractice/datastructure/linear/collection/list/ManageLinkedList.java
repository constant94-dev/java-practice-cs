package com.work.cspractice.datastructure.linear.collection.list;

import java.util.*;

public class ManageLinkedList {
    public void solution() {
        LinkedList<Integer> originItem = new LinkedList<>(List.of(1,2,3));
        originItem.set(0,9); // 지정된 위치의 객체를 9로 변경

        Object[] numberItem = originItem.toArray(); // originItem 에 저장된 모든 객체를 배열로 변환
        System.out.println(Arrays.toString(numberItem)); // [9, 2, 3]

        Object[] temp = {0,1,2,3,4,5};
        Object[] tmpItem = originItem.toArray(temp);
        System.out.println(Arrays.toString(tmpItem)); // [9, 2, 3, null, 4, 5]
        // null 삽입된 이유는 삽입된 리스트의 길이를 알리기 위해 null을 넣는 자바 스펙이다.
        // 내가 생각한 동작방식은 originItem 이 temp 로 변경되던가 originItem 기존 값을 남기고 뒤에 저장되는걸로 생각했다.
        // toArray(Object[] objArr) 메서드는 사용하지 말아야겠다...
    }

    /* 멀티 쓰레드 환경에서 동시에 컬렉션에 접근하지 못하게 방지하기 위한 동기화 처리된 리스트를 반환받아 사용 */
    public void solution2() {
        /* ArrayList 동기화 처리 */
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        /* LinkedList 동기화 처리 */
        List<String> list2 = Collections.synchronizedList(new LinkedList<>());
    }

    public static void main(String[] args) {
        ManageLinkedList test = new ManageLinkedList();
        test.solution();
    }
}
