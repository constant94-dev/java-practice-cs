package com.work.cspractice.datastructure.linear;

import java.util.Iterator;
import java.util.Vector;


/*
 * 컬렉션 프레임워크 출현 전 가변 개수 배열이 필요할 때 과거에 사용된 객체
 * 현 시점에는 성능 상 사용하지 않고 ArrayList를 사용한다.
 * */
public class DynamicArray {

    public void runArray() {
        Vector<Integer> v = new Vector<>();
        // 초기 용량(capacity) 지정
        //Vector<String> v2 = new Vector<>(10);
        // 초기 값 지정
        //Vector<Integer> v3 = new Vector<>(Arrays.asList(1, 2, 3));

        // 값 추가
        v.add(5);
        v.add(4);
        v.add(-1);
        // 인덱스 2 위치에 값 4 삽입 (삽입하기 위해 옆의 요소들은 뒤로 이동)
        v.add(2, 4);

        System.out.println("5 제거 전: " + v);

        v.remove(0); // 5 제거

        System.out.println("5 제거 후: " + v);

        System.out.println("현재 크기: " + v.size());

        Iterator<Integer> iter = v.iterator();
        while (iter.hasNext()) {
            System.out.println("Iterator 요소: " + iter.next());
        }

        v.clear(); // 모든 요소만 제거
        System.out.println("clear 후: " + v.capacity()); // 벡터 용량 확인
    }
}
