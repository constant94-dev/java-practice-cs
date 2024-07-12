package com.work.cspractice.datastructure.nonlinear.map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class MyHashtable {
    private static class Node {
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private LinkedList<Node>[] data;

    public MyHashtable(int size) {
        this.data = new LinkedList[size];
    }

    /* NOTE Hashtable 에서 사용할 해싱 알고리즘
    *   전달받은 문자열을 각 문자의 ASCII 값을 더해 해시코드를 반환 */
    public int getHashCode(String key) {
        char[] c = key.toCharArray();
        int hashCode = 0;
        for (char ch : c) {
            hashCode += ch;
        }
        return hashCode;
    }

    /* NOTE 해시코드를 받아 해싱알고리즘 후 저장할 방(배열) 번호(Index)를 얻는다. */
    public int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    /* NOTE 배열에 저장된 방 번호에 들어와 실제 값을 탐색할 때 전달받은 key와 똑같은 key가 있으면 반환 */
    public Node searchKey(LinkedList<Node> nodes, String key) {
        if (nodes == null) return null;

        for (Node node : nodes) {
            if (Objects.equals(node.key, key)) return node;
        }

        return null;
    }

    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        System.out.println(key +", hashcode("+ hashCode +"), index(" + index+")");

        LinkedList<Node> nodes = data[index];
        if (nodes == null) {
            nodes = new LinkedList<>(); // 배열 방이 비어있으니 생성 (임시 변수에만 할당된 상태)
            data[index] = nodes; // 생성된 방(연결리스트)을 해시테이블 방에 대입
        }

        Node node = searchKey(nodes, key);
        if (node == null) { // 기존 node에 key 없으니 새로 추가
            data[index].addLast(new Node(key, value));
        } else { // 기존 node에 key 있으니 value만 변경
            node.setValue(value);
        }
    }
    
    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> nodes = data[index];

        Node node = searchKey(nodes, key);

        if (node == null){
            return "Not Found";
        }

        return node.getValue();
    }

    @Override
    public String toString() {
        return "MyHashtable{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args) {
        MyHashtable h = new MyHashtable(3);

        h.put("sung", "She is pretty");
        h.put("jin", "She is a model");
        h.put("hee", "She is an angel");
        h.put("min", "She is cute");

        //덮어쓰기
        h.put("sung", "She is beautiful");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));

        //없는 데이터 호출
        System.out.println(h.get("jae"));
    }
}
