package com.work.cspractice.datastructure.linear;

import java.util.Arrays;
import java.util.Objects;

/* LinkedList vs ArrayList
 * 가장 큰 차이는 '노드(Node)'라는 저장소를 이용하여 연결한다는 점이다.
 * 노드라는 것은 그냥 객체이고 이 객체는 자료를 저장할 'Data' 필드와 다음 연결 요소의 주소를 저장하는 'Next' 필드를 가지고 있을 뿐이다.
 * ArrayList는 오브젝트 배열(Object[])을 사용해 데이터를 담아두고, LinkedList는 여러 노드 객체들을 체인(Chain)처럼 연결한다.
 * */
public class SingleLinkedList<E> {
    private Node<E> head; // 노드의 첫 부분을 가리키는 포인터
    private Node<E> tail; // 노드의 마지막 부분을 가리키는 포인터
    private int size; // 요소 갯수

    /* Node 클래스를 SingleLinkedList 클래스 밖에 선언해도 문제 없다.
     * 하지만, Node 클래스는 오로지 SingleLinkedList 클래스에서만 이용되며 다른 클래스에서는 전혀 이용하지 않는다.
     * 내부 클래스를 static 선언한 이유는 메모리 누수(memory leak)를 막기 위해서이다.
     * */
    private static class Node<E> {
        private E item; // Node에 담을 데이터
        private Node<E> next; // 다음 Node 객체를 가리키는 레퍼런스

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0; // 리스트에 있는 요소 개수 (연결된 노드의 개수)
    }

    /* add와 remove를 구현하기 위해선 우선 추가/삭제할 요소 탐색이 우선이 되기 때문에
     * 반복적으로 재사용되어 따로 메서드로 빼내어 작성
     * LinkedList 검색의 경우 인덱스가 없기에 랜덤 액세스 불가능. 따라서 N개의 노드를 검색할 때 O(N)이 발생
     * 노드의 next 필드 자체가 다음 노드를 가리킨다*/
    private Node<E> search(int index) {
        // head(처음 위치) 부터 차례로 index 까지 검색
        Node<E> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next; // next 필드 값(다음 노드 주소)를 재대입하면서 순차적으로 요소를 탐색
        }

        return n;
    }

    // 첫 번째 위치에 요소 추가
    public void addFirst(E value) {
        // 1. 먼저 가장 앞 요소를 가져옴
        Node<E> first = head;
        // 2. 새 노드 생성 (이 때 데이터와 next 포인터를 준다)
        Node<E> newNode = new Node<>(value, first);

        // 3. 요소가 추가되었으니 크기 증가
        size++;

        // 4. 맨앞 요소가 추가되었으니 head 업데이트
        head = newNode;
        // 5. 만일 최초 요소가 add 된 것이면 head와 tail이 가리키는 요소는 같게 된다
        if (first == null) {
            tail = newNode;
        }
    }

    // 마지막 위치에 요소 추가
    public void addLast(E value) {
        // 1. 먼저 가장 뒤 요소를 가져옴
        Node<E> last = tail;
        // 2. 새 노드 생성 (맨 마지막 요소 추가되니까 next는 null이다)
        Node<E> newNode = new Node<>(value, null);

        // 3. 요소가 추가되었으니 크기 증가
        size++;
        // 4. 맨뒤 요소가 추가되었으니 tail 업데이트
        tail = newNode;

        if (last == null) {
            // 5. 만일 최초로 요소가 add 되면 head와 tail이 가리키는 요소가 같다
            head = newNode;
        } else {
            // 6. 최초 추가 아닐 때 last 변수(추가 되기 전 마지막 요소)에서 추가된 새 노드 가리키도록 업데이트
            last.next = newNode;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    // 중간 요소 추가
    public void add(int index, E value) {
        // 1. 인덱스가 0보다 작거나 size 보다 같거나 클 때 에러 발생
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 추가하려는 index가 0이면 addFirst 호출
        if (index == 0) {
            addFirst(value);
            return;
        }

        // 3. 추가하려는 index가 size - 1와 같으면 addLast 호출
        if (index == size - 1) {
            addLast(value);
            return;
        }

        // 4. 추가하려는 위치의 이전 노드 얻기
        Node<E> prev_node = search(index - 1);
        // 5. 추가하려는 위치의 다음 노드 얻기
        Node<E> next_node = prev_node.next;
        // 6. 새 노드 생성(바로 다음 노드와 연결)
        Node<E> newNode = new Node<>(value, next_node);

        // 7. 요소 추가 되었으니 크기 증가
        size++;
        // 8. 이전 노드를 새 노드와 연결
        prev_node.next = newNode;
    }

    // 맨 앞 요소를 제거 (제거한 요소 반환)
    public E removeFirst() {
        // 1. 만약 삭제할 요소가 아무것도 없으면 에러 발생
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 삭제될 첫번째 요소 데이터를 백업
        E returnValue = head.item;
        // 3. 두번째 노드를 임시 저장
        Node<E> first = head.next;

        // 4. 첫번째 노드 내부 요소를 모두 삭제
        head.next = null;
        head.item = null;

        // 5. head가 다음 노드를 가리키도록 업데이트
        head = first;
        // 6. 요소가 삭제되었으니 크기 감소
        size--;

        // 7. 만일 리스트의 유일한 값을 삭제해서 빈 리스트가 될 경우, tail도 null 처리
        if (head == null) {
            tail = null;
        }

        // 8. 마지막으로 삭제된 요소 반환
        return returnValue;
    }

    // 기본 remove 메서드 구현 (첫째 요소 처리)
    public E remove() {
        return removeFirst();
    }

    // 인자로 입력된 인덱스로 remove 메서드 구현
    public E remove(int index) {
        // 1. 인덱스가 0보다 작거나 size 보다 크거나 같을 때 에러 발생
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 2. 인덱스가 0이면 removeFirst 메서드 실행 후 리턴
        if (index == 0) {
            return removeFirst();
        }

        // 3. 삭제할 위치의 이전 노드 저장
        Node<E> prev_node = search(index - 1);
        // 4. 삭제할 위치의 노드 저장
        Node<E> del_node = prev_node.next;
        // 5. 삭제할 위치의 다음 노드 저장
        Node<E> next_node = del_node.next;
        // 6. 삭제될 첫번째 요소의 데이터 백업
        E returnValue = del_node.item;

        // 7. 삭제 노드의 내부 요소를 모두 삭제
        del_node.next = null;
        del_node.item = null;

        // 8. 요소가 삭제 되었으니 크기 감소
        size--;
        // 9. 이전 노드가 다음 노드를 가리키도록 업데이트
        prev_node.next = next_node;

        // 10. 마지막으로 삭제된 요소 반환
        return returnValue;
    }

    // 값으로 remove 메서드 구현
    public boolean remove(Object value) {
        // 1. 만약 삭제할 요소가 아무것도 없으면 에러 발생
        if (head == null) {
            throw new RuntimeException();
        }

        // 2. 이전 노드, 삭제 노드, 다음 노드를 저장할 변수 선언
        Node<E> prev_node = null;
        Node<E> del_node = null;
        Node<E> next_node = null;

        // 3. 루프 변수 선언
        Node<E> i = head;

        // 4. 노드의 next를 순회하면서 해당 값을 찾는다
        while (i != null) {
            if (Objects.equals(i.item, value)) {
                // 노드의 값과 매개변수 값이 같으면 삭제 노드에 요소를 대입하고 종료
                del_node = i;
                break;
            }

            // 싱글 연결 리스트에는 prev 정보가 없기 때문에 이전 노드에도 요소를 일일히 대입해야 함
            prev_node = i;
            i = i.next;
        }

        // 5. 만일 찾은 요소가 없다면 리턴
        if (del_node == null) {
            return false;
        }

        // 6. 만약 삭제하려는 노드가 head라면 첫번째 요소를 삭제하는 것이니 removeFirst() 사용
        if (del_node == head) {
            removeFirst();
            return true;
        }

        // 7. 다음 노드에 삭제 노드 next의 요소 대입
        next_node = del_node.next;

        // 8. 삭제 요소 데이터 모두 제거
        del_node.next = null;
        del_node.item = null;

        // 9. 요소가 삭제 되었으니 크기 감소
        size--;

        // 10. 이전 노드가 다음 노드를 참조하도록 업데이트
        prev_node.next = next_node;

        return true;
    }

    // addLast() 와 같이 tail을 이용해 상수 시간안으로 처리되도록 구현할 법 하지만,
    // 싱글 연결 리스트는 노드 prev 개념이 없어 삭제될 노드의 이전 요소를 참조할 방법이 없다
    // 결국, 처음부터 끝가지 순회한다
    public E removeLast() {
        return remove(size - 1);
    }

    // search 메서드로 노드를 검색해 값을 반환
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

        // 1. search 메서드를 이용해 교체할 노드를 얻는다
        Node<E> replace_node = search(index);

        // 2. 교체할 노드의 요소를 변경한다
        //replace_node.item = null;
        replace_node.item = value;
    }

    @Override
    public String toString() {
        // 1. 만일 head가 null 일 경우 빈 배열 반환
        if (head == null) {
            return "[]";
        }

        // 2. 현재 크기 만큼 배열 생성
        Object[] array = new Object[size];

        // 3. 노드 next를 순회하면서 배열에 노드값을 저장
        int index = 0;
        Node<E> n = head;
        while (n != null) {
            array[index] = n.item;
            index++;
            n = n.next;
        }

        return Arrays.toString(array);
    }
}
