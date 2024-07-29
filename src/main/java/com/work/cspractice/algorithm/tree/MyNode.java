package com.work.cspractice.algorithm.tree;

public class MyNode {
    private int data;
    private MyNode left;
    private MyNode right;

    public MyNode(int data) {
        this.data = data;
    }

    /* FIXME 깊은 트리 복사 확인을 위한 임시 setter
    *   트리 요소를 업데이트 하고 싶다면 삭제 후 삽입 수행 해야 함 */
    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public MyNode getLeft() {
        return left;
    }

    public MyNode getRight() {
        return right;
    }

    public MyNode getNodeOrNull(MyNode node, int data) {
        if (node == null) return null;
        if (node.data == data) return node;
        if (node.left.data > data) return getNodeOrNull(node.left, data);

        return getNodeOrNull(node.right, data);
    }

    public MyNode insertRecursive(MyNode node, int data) {
        if (node == null) return new MyNode(data);
        if (data < node.data) node.left = insertRecursive(node.left, data);
        if (data >= node.data) node.right = insertRecursive(node.right, data);

        return node;
    }
    
    public static void traverseInOrderRecursive(final MyNode node) {
        if (node == null) return;

        traverseInOrderRecursive(node.left);
        System.out.println(node.data);
        traverseInOrderRecursive(node.right);
    }

    public static void traversePreOrderRecursive(final MyNode node) {
        if (node == null) return;

        System.out.println(node.data);
        traversePreOrderRecursive(node.left);
        traversePreOrderRecursive(node.right);
    }

    public static void traversePostOrderRecursive(final MyNode node) {
        if (node == null) return;

        traversePostOrderRecursive(node.left);
        traversePostOrderRecursive(node.right);
        System.out.println(node.data);
    }

    public static MyNode copyRecursive(final MyNode node) {
        if (node == null) return null;

        MyNode newMyNode = new MyNode(node.data);
        newMyNode.left = copyRecursive(node.left);
        newMyNode.right = copyRecursive(node.right);

        return newMyNode;
    }
}
