package com.company.kanuo.simple.listNode;

import java.util.Objects;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        listNode5.nextNode = listNode6;
        listNode4.nextNode = listNode5;
        listNode3.nextNode = listNode4;
        listNode2.nextNode = listNode3;
        listNode1.nextNode = listNode2;
        System.out.println(listNode1.toString());
        sortedList(listNode1);
        System.out.println(listNode1.toString());
    }

    /**
     * 自定义剔除方法
     * @param listNode
     */
    private static void sortedList(ListNode listNode){
        if (Objects.isNull(listNode.nextNode)) return;
        //如果一样，就把下下一个作为node.nextNode
        if (listNode.node == listNode.nextNode.node) {
            listNode.nextNode = listNode.nextNode.nextNode;
        } else {
            //如果不一样，就把下一个赋值给下个节点。这样list就一直在寻找下一个节点。
            listNode = listNode.nextNode;
        }
        sortedList(listNode);
    }


}
