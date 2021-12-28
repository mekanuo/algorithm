package com.company.kanuo.simple.array;

import java.util.HashMap;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        //数组初始化
        int sum = 17997;
        int size = 9000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        //算法1
        long start3 = System.currentTimeMillis();
        System.out.println("方式1-执行穷举");
        bruteForce(arr,sum);
        System.out.println("方式1耗时："+(System.currentTimeMillis()-start3)+"毫秒");

        //算法2
        long start2 = System.currentTimeMillis();
        System.out.println("方式2-执行哈希表");
        addHash(arr,sum);
        System.out.println("方式2耗时："+(System.currentTimeMillis()-start2)+"毫秒");
    }

    /**
     * 穷举法
     * @param arr
     * @param sum
     */
    private static void bruteForce(int[] arr,int sum){
       flag: for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i == j){
                        break;
                    } else if (sum == arr[i] + arr[j]) {
                        System.out.println(i+","+j);
                        break flag;
                    }
                }
            }
    }

    /**
     * 加入hash表映射
     */
    private static void addHash(int[] arr,int sum){
        //indexOf函数底层使用的是for
        //Arrays.asList(arr).indexOf()
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer integer = hashMap.get(i);
            if (Objects.isNull(integer)) {
                hashMap.put(arr[i],i);
                integer = arr[i];
            }
            if (!Objects.isNull(hashMap.get(sum-integer))) {
                System.out.println(i +","+ hashMap.get(sum-integer));
                break;
            }
        }

    }


}
