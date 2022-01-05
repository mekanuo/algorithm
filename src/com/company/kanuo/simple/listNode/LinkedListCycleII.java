package com.company.kanuo.simple.listNode;

import java.util.Objects;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * 提示：
 *     链表中节点的数目范围在范围 [0, 104] 内
 *     -105 <= Node.val <= 105
 *     pos 的值为 -1 或者链表中的一个有效索引
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(7);
        listNode6.nextNode = listNode7;
        listNode5.nextNode = listNode6;
        listNode4.nextNode = listNode5;
        listNode3.nextNode = listNode4;
        listNode2.nextNode = listNode3;
        listNode1.nextNode = listNode2;
        listNode7.nextNode = listNode1;

        ListNode listNode = checkListNode(listNode1);
        System.out.println(listNode);
    }

    public static ListNode checkListNode(ListNode listNode){
        if (listNode == null) return  null;
        ListNode slowPtr = listNode,fastPtr = listNode;
        boolean loopExists = false;
        while (slowPtr.nextNode !=null && fastPtr.nextNode.nextNode!=null) {
            slowPtr = slowPtr.nextNode;
            fastPtr = fastPtr.nextNode.nextNode;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }

        if (loopExists) {
            slowPtr = listNode;
            while (slowPtr != fastPtr) {
                fastPtr = fastPtr.nextNode;
                slowPtr = slowPtr.nextNode;
            }
            return slowPtr;
        }
        return null;
    }



















//        if (Objects.isNull(listNode) || Objects.isNull(listNode.nextNode) || Objects.isNull(listNode.nextNode.nextNode)) return null;
//        boolean flag = false;
//        ListNode fastNode = listNode.nextNode.nextNode,slowNode = listNode;
//        while (fastNode != slowNode) {
//          if (Objects.isNull(slowNode.nextNode) || Objects.isNull(fastNode.nextNode) || Objects.isNull(fastNode.nextNode.nextNode)) {
//              return null;
//          }
//          slowNode = slowNode.nextNode;
//          fastNode = fastNode.nextNode.nextNode;
//          if (fastNode == slowNode) {
//              flag = true;
//              break;
//          }
//        }
//
//        if (flag) {
//            slowNode = listNode;
//            fastNode = fastNode.nextNode;
//            while (slowNode != fastNode) {
//                slowNode = slowNode.nextNode;
//                fastNode = fastNode.nextNode;
//                if (slowNode == fastNode) {
//                    return fastNode;
//                }
//            }
//        }
//
//        return null;
//    }
}
