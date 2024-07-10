package com.work.cspractice.datastructure.linear.collection.list;

import java.util.Arrays;
import java.util.Objects;

public class MySinglyLinkedList<E> {
    private Node<E> head; // 노드의 첫 부분을 가리키는 포인트
    private Node<E> tail; // 노드의 마지막 부분을 가리키는 포인트
    private int size; // 리스트에 있는 요소 갯수 (연결 된 노드 갯수)

    public MySinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // inner static class
    private static class Node<E> {
        private E item; // Node에 담을 데이터
        private Node<E> next; // 다음 Node 객체를 가리키는 레퍼런스

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    /* 우선 추가/삭제할 요소 탐색이 우선되어야 한다.
     * 요소를 탐색할 때는 첫 요소부터 탐색할 요소까지 순차작으로 찾는다. O(N)
     * LinkedList 검색의 경우 랜덤 액세스가 안된다. */
    public Node<E> search(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next; // next 필드 값이 바로 다음 Node를 가리킨다.
        }
        return node;
    }

    public void addFirst(E value) {
        Node<E> first = head;
        Node<E> newNode = new Node<>(value, first);

        size++;

        head = newNode;
        if (first == null) {
            tail = newNode;
        }
    }

    public void addLast(E value) {
        Node<E> last = tail;
        Node<E> newNode = new Node<>(value, null); // 마지막 노드니까 다음 노드는 null

        size++;

        tail = newNode;
        if (last == null) {
            head = newNode;
        } else { // 최초 추가 아닐 경우
            last.next = newNode; // 변경 전 tail 노드(last.next)는 새로운 노드(newNode)가 되고 새로운 노드(newNode) 다음이 null이 된다.
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void add(int index, E value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == (size - 1)) {
            addLast(value);
            return;
        }

        Node<E> prev_node = search(index - 1);
        Node<E> next_node = prev_node.next;

        Node<E> newNode = new Node<>(value, next_node);

        size++;

        prev_node.next = newNode;
    }

    public E removeFirst() {
        if (head == null) throw new IndexOutOfBoundsException();

        E returnValue = head.item;
        Node<E> first = head.next;

        head.item = null;
        head.next = null;

        head = first;
        size--;

        if (head == null) tail = null;

        return returnValue;
    }

    /* LinkedList 기본 remove() 제공
     * ArrayList 기본 remove() 제공 안함*/
    public E remove() {
        return removeFirst();
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();

        Node<E> prev_node = search(index - 1);
        Node<E> del_node = prev_node.next;
        Node<E> next_node = del_node.next;
        E returnValue = del_node.item;

        del_node.item = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;

        return returnValue;
    }

    public boolean remove(Object value) {
        if (head == null) throw new RuntimeException();

        Node<E> prev_node = null;
        Node<E> del_node = null;
        Node<E> next_node = null;
        Node<E> i = head;

        while (i != null) {
            if (Objects.equals(i.item, value)) {
                del_node = i;
                break;
            }
            prev_node = i;
            i = i.next;
        }

        if (del_node == null) return false;
        if (del_node == head) {
            removeFirst();
            return true;
        }

        next_node = del_node.next;
        del_node.item = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;

        return true;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        return search(index).item;
    }

    public void set(int index, E value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> replace_node = search(index);

        replace_node.item = null;
        replace_node.item = value;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";

        Object[] arr = new Object[size];
        Node<E> node = head;
        int index = 0;

        while (node != null) {
            arr[index] = node.item;
            node = node.next;
            index++;
        }

        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Number> l = new MySinglyLinkedList<>();

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
}
