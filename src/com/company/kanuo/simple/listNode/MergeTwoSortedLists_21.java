package com.company.kanuo.simple.listNode;

/**

 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {
        new ListNode(0);
        ListNode listNode = new ListNode(0);
    }


    /**
     * 递归方式
     */
    private static ListNode sort2(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.node < l2.node) {
            l1.nextNode = sort2(l1.nextNode,l2);
            return l1;
        }
        l2.nextNode = sort2(l1, l2.nextNode);
        return l2;
    }


    /**
     * 轮训方式
     */
    private static ListNode sort1(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode resultNode = new ListNode(0);
        ListNode p = resultNode;
        while (l1!=null && l2!=null) {
            if (l1.node < l2.node) {
                p.nextNode = l1;
                l1 = l1.nextNode;
            } else {
                p.node = l2.node;
                l2 = l2.nextNode;
            }
            p = p.nextNode;
        }
        if (l1!=null) p.nextNode = l1;
        if (l2!=null) p.nextNode = l2;
        return resultNode.nextNode;
    }


















//    public static void main(String[] args) {
//        List<Integer> l1 = new ArrayList<Integer>() {{
//            this.add(1);
//            this.add(3);
//            this.add(5);
//            this.add(7);
//            this.add(9);
//            this.add(11);
//            this.add(13);
//            this.add(15);
//            this.add(17);
//        }};
//
//        List<Integer> l2 = new ArrayList<Integer>() {{
//            this.add(2);
//            this.add(4);
//            this.add(6);
//            this.add(8);
//            this.add(10);
//            this.add(12);
//            this.add(14);
//            this.add(16);
//        }};
//
////        custom1(l1,l2);
//        custom2(l1,l2);
//    }
//
//    /**
//     * 使用java内置Compare函数
//     * @param l1
//     * @param l2
//     */
//    private static void custom1(List<Integer> l1,List<Integer> l2){
//        l1.addAll(l2);
//        l1.sort(Integer::compareTo);
//        System.out.println(l1);
//    }
//
//    /**
//     * 自定义双指针
//     * @param l1
//     * @param l2
//     */
//    private static void custom2(List<Integer> l1,List<Integer> l2){
//        if (Objects.isNull(l1) || l1.size() == 0) return;
//        if (Objects.isNull(l2) || l2.size() == 0) return;
//        int maxSize = l1.size() + l2.size();
//        List<Integer> result = new ArrayList<>(maxSize);
//        for (int index = 0 , l1Index = 0 ,l2Index = 0; index < maxSize; index++) {
//            if (l1Index > l1.size()-1) {
//                result.add(l2.get(l2Index));
//                l2Index++;
//            } else if (l2Index > l2.size()-1) {
//                result.add(l1.get(l1Index));
//                l1Index++;
//            } else if (l1.get(l1Index) <= l2.get(l2Index)){
//                result.add(l1.get(l1Index));
//                l1Index++;
//            } else {
//                result.add(l2.get(l2Index));
//                l2Index++;
//            }
//        }
//        System.out.println(result);
//    }
}
