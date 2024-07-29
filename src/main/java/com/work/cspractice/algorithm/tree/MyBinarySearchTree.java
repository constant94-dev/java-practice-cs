package com.work.cspractice.algorithm.tree;

public class MyBinarySearchTree {

    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("이진 탐색 트리 규칙 확인");

        MyNode root = new MyNode(7);
        root.insertRecursive(root, 3);
        root.insertRecursive(root, 8);
        root.insertRecursive(root, 2);
        root.insertRecursive(root, 5);
        root.insertRecursive(root, 1);

        System.out.println(root.getData());
        System.out.println(root.getLeft().getData());
        System.out.println(root.getRight().getData());
        System.out.println(root.getLeft().getLeft().getData());
        System.out.println(root.getLeft().getRight().getData());
        System.out.println(root.getLeft().getLeft().getLeft().getData());

        root.insertRecursive(root, 4);
        System.out.println(root.getLeft().getRight().getLeft().getData());

        System.out.println("--------------------");
        System.out.println("전위순회");

        MyNode preOrder = new MyNode(50);
        preOrder.insertRecursive(preOrder, 24);
        preOrder.insertRecursive(preOrder, 42);
        preOrder.insertRecursive(preOrder, 33);
        preOrder.insertRecursive(preOrder, 22);
        preOrder.insertRecursive(preOrder, 55);
        preOrder.insertRecursive(preOrder, 52);
        preOrder.insertRecursive(preOrder, 57);

        MyNode.traversePreOrderRecursive(preOrder);

        System.out.println("--------------------");
        System.out.println("중위순회");
        MyNode.traverseInOrderRecursive(preOrder);

        System.out.println("--------------------");
        System.out.println("후위순회");
        MyNode.traversePostOrderRecursive(preOrder);

        System.out.println("--------------------");
        MyNode preOrderCopy = MyNode.copyRecursive(preOrder);

        System.out.println("깊은 복사 트리: ");
        MyNode.traverseInOrderRecursive(preOrderCopy);

        System.out.println("--------------------");
        preOrder.getLeft().setData(111);
        System.out.println("원본 트리: ");
        MyNode.traverseInOrderRecursive(preOrder);
        System.out.println("깊은 복사 트리: ");
        MyNode.traverseInOrderRecursive(preOrderCopy);
    }
}
