package com.company.kanuo.simple.array;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 逻辑分析：
 * f(1)=1;
 * f(2)=2
 * f(n)=f(n-1)+f(n-2)
 */
public class ShangLouTi_70 {

    public static void main(String[] args) {
        while (true) {
            System.out.println("输入楼梯台阶数：");
            Scanner scanner = new Scanner(System.in);
            Integer number = Integer.valueOf(scanner.next());

            //算法3
            System.out.println("方式3");
            long start3 = System.currentTimeMillis();
            System.out.println("方式3运算结果为："+forAction1(number)+"种");
            System.out.println("方式3耗时："+(System.currentTimeMillis()-start3)+"毫秒");

            //算法2
            System.out.println("方式2");
            long start2 = System.currentTimeMillis();
            System.out.println("方式2运算结果为："+recursiveAction2(number)+"种");
            System.out.println("方式2耗时："+(System.currentTimeMillis()-start2)+"毫秒");

            //算法1
            System.out.println("方式1");
            long start1 = System.currentTimeMillis();
            System.out.println("方式1运算结果为："+recursiveAction1(number)+"种");
            System.out.println("方式1耗时："+(System.currentTimeMillis()-start1)+"毫秒");

        }

    }

    /**
     * 递归方式1;
     * recursiveAction1((n-2))+recursiveAction1((n-1))
     * 中存在大量重复运算，时间复杂度大于n平方，因此，不考虑这种做法
     * @param n
     * @return
     */
    private static long recursiveAction1(int n){
        if (1==n) return 1;
        if (2==n) return 2;
        return recursiveAction1((n-2))+recursiveAction1((n-1));
    }

    public static HashMap<Integer, Long> dataSource = new HashMap<Integer, Long>(){{
        this.put(1,1l);
        this.put(2,2l);
    }};

    /**
     * 引入map做数据存储，讲运算结果存入map中，避免重复运算发生
     * @param n
     * @return
     */
    private static long recursiveAction2(int n){
        if (1==n) return dataSource.get(1);
        if (2==n) return dataSource.get(2);
        if (!Objects.isNull(dataSource.get(n))) {
            return dataSource.get(n);
        } else {
            long result = recursiveAction1((n - 2)) + recursiveAction1((n - 1));
            dataSource.put(n,result);
            return result;
        }
    }

    /**
     * 使用for替代递归，数值从底部网上累加。
     * 空间-时间复杂度为f(n),线性关系
     * @param n
     * @return
     */
    private static long forAction1(int n){
        if (1==n) return 1l;
        if (2==n) return 2l;
        long sum = 0;
        long first = 1l;
        long last = 2l;
        for (int i = 3; i <= n ; ++i) {
           sum = first + last;
           first = last;
           last = sum;
        }
        return sum;
    }
}
