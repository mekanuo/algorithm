package com.company.kanuo.simple.array;

import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的有效元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 *
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * 进阶：你可以设计实现一个时间复杂度为  O(m + n) 的算法解决此问题吗？
 */
public class MergeSortedArray_88 {

    public static void main(String[] args) {
//        int[] nums1 = new int[20000];
//        for (int i = 0; i < 20000; i++) {
//            nums1[i] = i;
//        }
//
//        int[] nums2 = new int[2000];
//        for (int i = 7000; i < 9000; i++) {
//            nums2[i-7000] = i;
//        }


        int[] nums1 = {1,3,5,7,9,0,0,0,0};

        int[] nums2 = {2,4,6,8};

        //算法1
//        long start1 = System.currentTimeMillis();
//        System.out.println("方式1使用默认快速排序");
//        arraysSort(nums1,5,nums2,4);
//        System.out.println("方式1耗时："+(System.currentTimeMillis()-start1)+"毫秒");

        //算法2
        long start2 = System.currentTimeMillis();
        System.out.println("方式2使用自定义排序");
        customSort2(nums1,5,nums2,4);
        System.out.println("方式2耗时："+(System.currentTimeMillis()-start2)+"毫秒");

    }

    /**
     * 使用快速排序法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void arraysSort(int[] nums1,int m,int[] nums2,int n){
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 自定义排序，引入一个临时的数组，时间复杂度优化为O=2(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void customSort1(int[] nums1,int m,int[] nums2,int n){
        int k = m+n;
        int[] temp = new int[k];
        for (int index = 0,nums1Index = 0,nums2Index = 0; index < k ; index++) {
            if (nums1Index >= m) {
                temp[index] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                temp[index] = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[index] = nums1[nums1Index++];
            } else {
                temp[index] = nums2[nums2Index++];
            }
        }
        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }
    }

    /**
     * 不用临时数组，利用第一个数组的后几位空挡，使用从大到小排序策略进行填充
     * 时间复杂度为O(M+N)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void customSort2(int[] nums1,int m,int[] nums2,int n){
        for (int index = nums1.length-1,nums1Index = m -1,nums2Index = n-1; index >= 0; index--) {
            if (nums1Index < 0) {
                break;
            } else if (nums2Index < 0) {
                nums1[index] = nums1[nums1Index--];
                break;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            } else {
                nums1[index] = nums2[nums2Index--];
            }
        }
        System.out.println(nums1);
    }
}
