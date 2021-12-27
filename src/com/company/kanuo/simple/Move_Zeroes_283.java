package com.company.kanuo.simple;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Move_Zeroes_283 {

    public static void main(String[] args) {
        int[] array = {0,1,0,3,12};
//        customSort1(array);
//        recommendSort1(array);
        globalSort(array);
    }

    /**
     * 自定义解法1：
     * 双指针，一个指针负责移动参数，一个负责记录为0的元素个数；
     * 但是需要做两次循环，效率不怎么理想
     * @param array
     */
    private static void customSort1(int[] array){
        int max = array.length;
        flag:for (int i = 0,setIndex = 0; i < max; i++) {
            if (array.length <= i) {
                for (int j=setIndex;j<array.length;j++) {
                    array[j] = 0;
                }
                break flag;
            } else if (array[i]!=0){
                array[setIndex++] = array[i];
            } else {
                max++;
            }
        }
        System.out.println(array);
    }

    /**
     * 官方推荐解法：
     * 双指针-如果参数非0，便于当前左边指针交换位置，
     * 最终，非0参数移动到了左边，0被置换到后边，只用循环一次
     * @param array
     */
    private static void recommendSort1(int[] array){
        int left = 0 , right = 0;
        while (right < array.length) {
            if (array[right]!=0) {
                int temp = array[left];
                array[left++]=array[right];
                array[right] = temp;
            }
            right++;
        }
        System.out.println();
    }

    /**
     * 自定义解法优化，全球投票排行榜
     * @param array
     */
    private static void globalSort(int[] array){
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=0) array[left++]=array[i];
        }
        while (left<array.length) array[left++]=0;
        System.out.println();
    }

}
