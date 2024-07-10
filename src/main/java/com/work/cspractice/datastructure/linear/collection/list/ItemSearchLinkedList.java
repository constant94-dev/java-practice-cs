package com.work.cspractice.datastructure.linear.collection.list;

import java.util.LinkedList;
import java.util.List;

public class ItemSearchLinkedList {
    public void solution() {
        List<Integer> originItem = new LinkedList<>(List.of(1,2,3,4,5));
        List<Integer> subItem = new LinkedList<>(List.of(2,4));

        originItem.size(); // 저장된 개수를 반환
        originItem.isEmpty(); // 비어있는지 확인
        originItem.contains(0); // 지정된 객체가 포함되어 있는지 확인
        originItem.containsAll(subItem); // 지정된 컬렉션이 모두 포함되어 있는지 확인
        originItem.indexOf(3); // 지정된 객체가 저장된 위치 인덱스 반환 (앞에서 부터 탐색)
        originItem.lastIndexOf(4); // 지정된 객체가 저장된 위치 인덱스 반환 (뒤에서 부터 탐색)
    }
}
