package com.leetcode.recursion;

/**
 * java实现链表反序
 */

public class reverseLinkedList {
    class Node{
        int data;
        Node next;
    }

    public static void main(String[] args) {
        reverseLinkedList linkedList = new reverseLinkedList();
        String a ="a";
        String b ="b";
        System.out.println(a == b);
        Node node1 = linkedList.new Node();
        Node node2 = linkedList.new Node();
        Node node3 = linkedList.new Node();
        Node node4 = linkedList.new Node();
        //Node nodeNew = linkedList.new Node();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        Node nodeNew = reverseList(node1);
        outputAllNodes(nodeNew);
    }
    public static Node reverseList(Node head){
        //java中堆栈内存要区分清楚，new出来的在堆，声明的在栈
        if(head == null || head.next == null){
            return head;
        }
        // 递归反转 子链表
        Node newNode = reverseList(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        Node t1  = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        System.out.println(newNode.data);
        return newNode;
    }
    public static void outputAllNodes(Node node){
        if(node.next == null){
            System.out.println(node.data);
            return;
        }
        System.out.println(node.data);
        outputAllNodes(node.next);
    }
}
