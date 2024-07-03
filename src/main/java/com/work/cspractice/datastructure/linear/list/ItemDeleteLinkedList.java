package com.work.cspractice.datastructure.linear.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ItemDeleteLinkedList {
    public void solution() {
        LinkedList<Integer> originItem = new LinkedList<>(List.of(1,2,3,4,5));
        List<Integer> subItem = new ArrayList<>(List.of(2,4));

        //originItem.remove(); // 첫 번째 노드 삭제 [1]
        originItem.removeFirst(); // 첫 번째 노드 삭제 [1]
        originItem.removeLast(); // 마지막 노드 삭제 [5]
        originItem.remove(0); // 0번째 인덱스 노드 삭제
        originItem.removeAll(subItem); // 지정한 컬렉션에 저장된 동일한 노드 삭제
        originItem.retainAll(subItem); // 지정한 컬렉션에 저장된 동일한 노드만 남김
        originItem.clear(); // LinkedList 비우기 (각 노드들을 찾아다니며 null 설정)
    }
}
