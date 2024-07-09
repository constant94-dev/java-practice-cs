package com.work.cspractice.datastructure.linear.list;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyDoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> search(int index) {
        Node<E> n;

        if ((size/2) > index){
            n = head;
            // 찾고자하는 인덱스가 head 가까움
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        } else {
            n = tail;
            // 찾고자하는 인덱스가 tail 가까움
            for (int i = size-1; i > index; i--) {
                n = n.prev;
            }
        }

        return n;
    }

    public void addFirst(E value) {
        Node<E> first = head;
        Node<E> new_node = new Node<>(null, value, first);

        head = new_node;
        size++;

        if (first == null) {
            tail = new_node;
        } else {
            first.prev = new_node;
        }
    }

    public void addLast(E value) {
        Node<E> last = tail;
        Node<E> new_node = new Node<>(last, value, null);

        tail = new_node;
        size++;

        if (last == null){
            head = new_node;
        } else {
            last.next = new_node;
        }
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void add(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " +index+ ", Size: " +size);
        }

        if (index == 0){
            addFirst(value);
            return;
        }
        if (index == (size-1)){
            addLast(value);
            return;
        }

        Node<E> target_node = search(index);
        Node<E> prev_node = target_node.prev;
        Node<E> next_node = target_node.next;
        Node<E> new_node = new Node<>(prev_node, value, next_node);

        size++;

        prev_node.next = new_node;
        next_node.prev = new_node;
    }

    public E removeFirst() {
        if (head == null) throw new NoSuchElementException();

        E returnValue = head.item;
        Node<E> first = head.next;

        head.item = null;
        head.next = null;

        size--;
        head = first;

        if (first == null) {
            tail = null;
        } else {
            first.prev = null;
        }

        return returnValue;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeLast() {
        if (tail == null) throw new NoSuchElementException();

        E returnValue = tail.item;
        Node<E> last = tail.prev;

        tail.item = null;
        tail.prev = null;

        size--;
        tail = last;

        if (last == null) {
            head = null;
        } else {
            last.next = null;
        }

        return returnValue;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) return removeFirst();
        if (index == (size-1)) return removeLast();

        Node<E> del_node = search(index);
        Node<E> prev_node = del_node.prev;
        Node<E> next_node = del_node.next;
        E returnValue = del_node.item;

        del_node.item = null;
        del_node.prev = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;
        next_node.prev = prev_node;

        return returnValue;
    }

    public boolean remove(Object value) {
        Node<E> del_node = null;
        Node<E> i = head;

        while (i != null) {
            if (Objects.equals(i.item, value)){
                del_node = i;
                break;
            }
            i = i.next;
        }

        if (del_node == null) return false;
        if (del_node == head) {removeFirst(); return true;}
        if (del_node == tail) {removeLast(); return true;}

        Node<E> prev_node = del_node.prev;
        Node<E> next_node = del_node.next;

        del_node.item = null;
        del_node.prev = null;
        del_node.next = null;

        size--;

        prev_node.next = next_node;
        next_node.prev = prev_node;

        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        return search(index).item;
    }

    public void set(int index, E value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> replace_node = search(index);

        replace_node.item = value;
    }

    public int indexOf(Object value) {
        Node<E> n = head;
        int i = 0;
        while (n != null) {
            if (Objects.equals(n.item, value)) {
                return i;
            }
            n = n.next;
            i++;
        }

        return -1;
    }

    public int lastIndexOf(Object value) {
        Node<E> n = tail;
        int i = size-1;
        while (n != null) {
            if (Objects.equals(n.item, value)){
                return i;
            }
            n = n.prev;
            i--;
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
        for (Node<E> i = head; i != null;){
            Node<E> next_node = i.next;

            i.item = null;
            i.prev = null;
            i.next = null;

            i = next_node;
        }

        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";

        Object[] arr = new Object[size];

        int index = 0;
        Node<E> n = head;
        while (n != null){
            arr[index] = n.item;
            n = n.next;
            index++;
        }

        return Arrays.toString(arr);
    }

    public String customToString() {
        if (head == null) return "[]";

        Node<E> n = head;
        StringBuilder result = new StringBuilder();
        result.append("[\n");

        for (int i = 0; i < size; i++){
            result.append(" Node@").append(n.hashCode()).append(" → ");
            if (n.prev != null) {
                result.append("[").append(n.prev.hashCode()).append(" | ");
            } else {
                result.append("[").append("null").append(" | ");
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

    public static void main(String[] args) {
        MyDoublyLinkedList<Number> list = new MyDoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(list.customToString());

        list.removeFirst();

        System.out.println(list.customToString());

        list.removeLast();

        System.out.println(list.customToString());

        list.remove(2.5);

        System.out.println(list.customToString());

        System.out.println(list.get(2));
        list.set(1, 3.5);

        System.out.println(list.customToString());
    }
}
