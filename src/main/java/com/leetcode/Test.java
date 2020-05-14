package com.leetcode;

import com.leetcode.list.ListNode;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/4/25 10:54
 * @Version: V0.1
 */
public class Test {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        for(int i=0;i<arr.length-k+1;i++) {
            int sum = 0;
            for(int j=i;j<i+k;j++) {
                sum += arr[j]-threshold;
            }
            if(sum>=0) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Test test = new Test();
        String s1 = "xx";
        String s2 = "yx";
        System.out.println(test.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));

    }
}
