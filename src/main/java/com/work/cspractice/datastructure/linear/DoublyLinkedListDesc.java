package com.work.cspractice.datastructure.linear;

import java.util.NoSuchElementException;
import java.util.Objects;

/* SingleLinkedList vs DualLinkedList
 * 단방향 연결 리스트는 끝 요소를 탐색할 때, 처음(head)부터 끝가지 순회하며 탐색하지만,
 * 양방향 연결 리스트는 이전(prev) 포인터를 가지고 있기 때문에 한번에 마지막 요소를 탐색할 수 있다.
 * java.util.LinkedList 에서 제공하는 형태는 DualLinkedList 이다.
 * */
public class DoublyLinkedListDesc<E> {
    private Node<E> head; // 노드의 첫 부분을 가리키는 레퍼런스
    private Node<E> tail; // 노드의 끝 부분을 가리키는 레퍼런스
    private int size; // 리스트 요소 갯수

    public DoublyLinkedListDesc() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 정적 클래스
    private static class Node<E> {
        private E item; // Node에 담을 데이터
        private Node<E> next; // 다음 Node 객체를 가리키는 레퍼런스
        private Node<E> prev; // 이전 Node 객체를 가리키는 레퍼런스

        // 생성자 (이전 노드 포인터 | 데이터 | 다음 노드 포인터)
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    // add, remove 메서드 구현에 사용하기 위한 내부 메서드
    // 추가/삭제할 요소 탐색이 우선되고 반복적으로 재사용된다.
    // 이전 보다 시간복잡도를 줄이는 방향으로 코드 작성
    private Node<E> search(int index) {
        Node<E> n; // 반환할 노드

        if ((size / 2) > index) {
            // 1. 만약 인덱스가 시작에 가까우면, 순차 탐색
            n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        } else {
            // 2. 만약 인덱스가 끝에 가까우면, 역순 탐색
            n = tail;
            for (int i = size - 1; i > index; i--) { // index까지 포함하지 않는 이유는 노드의 next 자체가 다음 노드를 가리킨다
                n = n.prev;
            }
        }

        return n;
    }

    public void addFirst(E value) {
        // 1. head를 임시 백업
        Node<E> first = head;
        // 2. 새 노드를 추가 (이때 첫번째 노드니까 prev는 null, next는 head가 가리키는 노드가 되게 된다)
        Node<E> new_node = new Node<>(null, value, first);

        size++; // 3. 노드 추가했으니 리스트 크기 증가
        head = new_node; // 4. 첫번째 노드 변경했으니 head를 삽입된 새 노드로 참조하도록 업데이트

        if (first == null) {
            // 5. 만약 빈 리스트에서 최초의 요수 추가할 경우, tail도 첫째 노드를 바라보도록 업데이트
            tail = new_node;
        } else {
            // 6. 만약 빈 리스트가 아닐 경우, 추가되기 이전 첫번째였던 노드에서 prev를 새 노드로 참조하도록 업데이트
            first.prev = new_node;
        }
    }

    public void addLast(E value) {
        // 1. tail 임시 백업
        Node<E> last = tail;
        // 2. 새 노드를 추가(이때 마지막 노드니까 next는 null, prev는 tail이 가리키는 노드가 되게 된다)
        Node<E> new_node = new Node<>(last, value, null);

        size++; // 3. 노드 추가했으니 리스트 크기 증가
        tail = new_node; // 4. 마지막 노드 변경했으니 tail를 삽입된 새 노드로 참조하도록 업데이트

        if (last == null) {
            // 5. 만약 빈 리스트에서 최초 요소 추가할 경우, head도 첫째 노드를 바라보도록 업데이트
            head = new_node;
        } else {
            // 6. 만약 빈 리스트 아닐 경우, 추가되기 이전 마지막이었던 노드에서 next를 새 노드로 참조하도록 업데이트
            last.next = new_node;
        }
    }

    // LinkedList API 스펙도 add() 메서드 호출시 addLast() 호출
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void add(int index, E value) {
        // 1. 인덱스 범위 확인
        // 인덱스 0보다 작거나 size 보다 클 경우 에러 발생
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // 2. 추가하려는 index가 0이면 addFirst 호출
        if (index == 0) {
            addFirst(value);
            return;
        }

        // 3. 추가하려는 index가 size와 같으면 addLast 호출
        if (index == size) {
            addLast(value);
            return;
        }

        // 4. 추가하려는 위치 다음 노드 얻기
        Node<E> next_node = search(index);
        // 5. 추가하려는 위치 이전 노드 얻기
        Node<E> prev_node = next_node.prev;
        // 6. 새 노드 생성 (바로 이전 / 다음 노드와 연결)
        Node<E> new_node = new Node<>(prev_node, value, next_node);

        size++; // 7. 노드를 추가했으니 리스트 크기 증가
        prev_node.next = new_node; // 8. 이전 노드의 next를 새 노드에 연결
        next_node.prev = new_node; // 9. 다음 노드의 prev를 새 노드에 연결
    }

    public E removeFirst() {
        // 1. 만약 삭제할 요소가 아무것도 없으면 에러 발생
        if (head == null) {
            throw new NoSuchElementException();
        }

        E value = head.item; // 2. 삭제될 첫번째 요소 데이터를 백업
        Node<E> first = head.next; // 3. 두번째 노드를 임시 저장

        // 4. 첫번째 노드 내부 요소를 모두 삭제
        head.next = null;
        head.item = null;

        size--; // 5. 요소 삭제되었으니 크기 감소
        head = first; // 6. head가 다음 노드를 가리키도록 업데이트

        if (first == null) {
            // 7. 만약 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
            tail = null;
        } else {
            // 8. 만약 빈 리스트가 아닐 경우, 삭제되기 이전 두번째였던 first가 첫번째 노드가 되니 prev를 null 처리
            first.prev = null;
        }

        return value; // 9. 마지막 삭제된 요소 반환
    }

    // LinkedList 스펙 상 remove() 동작은 add() 와 달리 첫째 요소 처리
    public E remove() {
        return removeFirst();
    }

    public E removeLast() {
        // 1. 만약 삭제할 요소 아무것도 없으면 에러 발생
        if (tail == null) {
            throw new NoSuchElementException();
        }

        // 2. 삭제될 마지막 요소 데이터 백업
        E value = tail.item;
        // 3. 마지막 노드의 이전 노드 임시 저장
        Node<E> last = tail.prev;

        // 4. 마지막 노드의 내부 요소 모두 삭제
        tail.item = null;
        tail.prev = null;

        size--; // 5. 요소 삭제 되었으니 크기 감소
        tail = last; // 6. tail 이전 노드를 가리키도록 업데이트

        if (last == null) {
            // 7. 만약 리스트 유일한 값을 삭제해서 빈 리스트가 될 경우, head도 null 처리
            head = null;
        } else {
            // 8. 만약 빈 리스트가 아닐 경우, 삭제되기 전 마지막의 이전 노드였던 last가 마지막 노드가 되니 next를 null 처리
            last.next = null;
        }

        return value; // 9. 마지막 삭제 요소 반환
    }

    public E remove(int index) {
        // 1. 인덱스가 0보다 작거나 size보다 크거나 같은 경우 에러 발생
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 인덱스가 0이면 removeFirst 메서드 수행
        if (index == 0) {
            return removeFirst();
        }

        // 3. 인덱스가 size - 1(마지막 요소 위치)일 때, removeLast 메서드 수행
        if (index == size - 1) {
            return removeLast();
        }

        Node<E> del_node = search(index); // 4. 삭제할 위치 노드 저장
        Node<E> prev_node = del_node.prev; // 5. 삭제할 위치 이전 노드 저장
        Node<E> next_node = del_node.next; // 6. 삭제할 위치 다음 노드 저장
        E value = del_node.item; // 7. 삭제될 첫번째 요소 데이터 백업

        // 8. 삭제 노드의 내부 요소 모두 삭제
        del_node.item = null;
        del_node.prev = null;
        del_node.next = null;

        size--; // 9. 요소 삭제 되었으니 크기 감소
        prev_node.next = next_node; // 10. 이전 노드가 다음 노드를 가리키도록 업데이트
        next_node.prev = prev_node; // 11. 다음 노드가 이전 노드를 가리키도록 업데이트

        return value; // 12. 마지막 삭제된 요소 반환
    }

    public boolean remove(Object value) {
        // 1. 삭제 노드 저장할 변수
        Node<E> del_node = null;
        // 2. 리스트 순회할 변수
        Node<E> i = head;

        // 3. 노드의 next를 순회 해당 값 찾기
        while (i != null) {
            // 노드의 값과 매개변수 값이 같을 때
            if (Objects.equals(i.item, value)) {
                del_node = i; // 삭제 노드 요소를 대입하고 종료
                break;
            }

            i = i.next;
        }

        // 4. 만약 찾은 요소 없을 때 false 리턴
        if (del_node == null) {
            return false;
        }

        // 5. 만약 삭제 노드가 head(첫번째 요소)라면, 기존 removeFirst() 사용
        if (del_node == head) {
            removeFirst();
            return true;
        }

        // 6. 만약 삭제 노드가 last(마지막 요소)라면, 기존 removeLast() 사용
        if (del_node == tail) {
            removeLast();
            return true;
        }

        // 7. 이전 노드, 다음 노드 구하기
        Node<E> prev_node = del_node.prev;
        Node<E> next_node = del_node.next;

        // 8. 삭제 요소 데이터 모두 제거
        del_node.item = null;
        del_node.prev = null;
        del_node.next = null;

        size--; // 9. 요소가 삭제 되었으니 크기 감소
        prev_node.next = next_node; // 10. 이전 노드가 다음 노드를 가리키도록 업데이트
        next_node.prev = prev_node; // 11. 다음 노드가 이전 노드를 가리키도록 업데이트

        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return search(index).item;
    }

    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 1. search 메서드를 이용해 교체할 노드를 얻는다.
        Node<E> replace_node = search(index);

        // 2. 교체할 노드의 요소를 변경
        //replace_node.item = null;
        replace_node.item = value;
    }

    // 순차대로 검색해 위치 반환
    public int indexOf(Object value) {
        Node<E> n = head;
        int i = 0;
        while (n != null) {
            if (Objects.equals(value, n.item)) {
                return i; // 중복된 값이 있을 경우 가장 먼저 검색되는 요소 위치 반환
            }

            i++;
            n = n.next;
        }

        return -1; // 찾고자 하는 값이 없을 경우 -1
    }

    // 거꾸로 검색해 위치 반환
    public int lastIndexOf(Object value) {
        Node<E> n = tail;
        int i = size - 1;
        while (n != null) {
            if (Objects.equals(value, n.item)) {
                return i;
            }

            i--;
            n = n.prev;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // i.next가 null이면 마지막을 의미하니 null 이 아닐 때 까지 순회
        for (Node<E> i = head; i.next != null; ) {
            Node<E> next_node = i.next; // i에 관한 모든 값을 지울 것이기 때문에 미리 백업

            i.item = null;
            i.prev = null;
            i.next = null;

            i = next_node;
        }

        head = null;
        tail = null;

        size = 0; // 모든 요소 지웠으니 size 초기화
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1; // -1 아니라는 것은 요소가 리스트에 존재한다는 것
    }

    // 리스트 원소 주소 해시 값 뿐만 아니라 [이전 노드 주소|노드 아이템 값|다음 노드 주소] 형태로 출력한다
    @Override
    public String toString() {
        // 1. 만약 head가 null 일 때, 빈 배열 반환
        if (head == null) {
            return "[]";
        }

        Node<E> n = head;
        StringBuilder result = new StringBuilder();

        result.append("[\n");

        for (int i = 0; i < size; i++) {
            result.append("\tNode@")
                    .append(String.format("%-10s", Objects.requireNonNull(n).hashCode()))
                    .append(" → \t");

            if (n.prev != null) {
                result.append("[")
                        .append(n.prev.hashCode())
                        .append(" | ");
            } else {
                result.append("[")
                        .append("null")
                        .append(" | ");
            }

            result.append(n.item).append(" | ");

            if (n.next != null) {
                result.append(n.next.hashCode()).append("]");
            } else {
                result.append("null").append("]");
            }

            result.append(", \n");

            n = n.next;
        }

        result.append("]");

        return result.toString();
    }
}
