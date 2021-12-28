package com.company.kanuo.simple.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *  448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindAllNumbersDisappearedInAnArray448 {

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        custom(array);
    }

    private static void custom(int[] arrays){
        if (Objects.isNull(arrays) || arrays.length == 0) return;

        //角标与元素的关系为：角标+1 = 元素值
        int index = 0;
        while (index < arrays.length) {
            //如果符合约束条件就前进一步指针
            if (arrays[index] == index+1) {
                index++;
            } else {
                //如果需要移动的角标发现目标位置有符合逻辑的角标就不移动了，指针向右移动一位；
                int tempIndex = arrays[index] - 1 ;
                if (arrays[index] == arrays[tempIndex]) {
                    index++;
                    continue;
                }
                //交换目标到合适的位置，指针位置不变，继续比对当前指针位
                int temp = arrays[tempIndex];
                arrays[tempIndex] = arrays[index];
                arrays[index] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            if (i+1 != arrays[i]) {
                result.add(i+1);
            }
        }
        System.out.println();

    }


}
