package com.company.kanuo.simple.listNode;

/**
 * JAVA链表结构
 */
public class ListNode {
    int node;
    ListNode nextNode;

    ListNode(int x) {
        node = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "node=" + node +
                ", nextNode=" + nextNode +
                '}';
    }
}
