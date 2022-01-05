package com.company.kanuo.simple.listNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 提示：
 *
 *     链表中节点的数目范围是 [0, 104]
 *     -105 <= Node.val <= 105
 *     pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle {

    /**
     * 解法1：、
     * 引入一个哈希表，循环一个就放到哈希表中，下一个就有哈希表中比较是否存在，存在就是存在环，时间复杂度为O(N);非最优解法；
     *
     * 解法2：佛洛依德解法
     * 引入快慢指针概念，快指针一次移动2步，满指针每次移动1步，如果存在环两个指针肯定就会相遇
     * @param args
     */
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
//        listNode7.nextNode = listNode1;

        System.out.println(check(listNode1));
    }

    /**
     * 佛洛依德解法
     * @param listNode
     * @return
     */
    private static boolean check(ListNode listNode){
        if (listNode.nextNode == null) return false;
        ListNode fastNode = listNode.nextNode,slowNode = listNode;
        while (fastNode != slowNode) {
            if (slowNode.nextNode == null || fastNode.nextNode == null || fastNode.nextNode.nextNode == null) {
                return false;
            }
            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode.nextNode;
        }
        return true;
    }
}
