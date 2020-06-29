package com.leetcode;

import com.Solution;
import com.leetcode.Tree.TreeNode;
import com.leetcode.list.ListNode;
import com.oracle.jrockit.jfr.Producer;
import com.sun.org.apache.xerces.internal.xs.XSTerm;
import javafx.util.Pair;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.*;
import java.util.function.Consumer;

/**
 * @ClassName: Test
 * @Description: 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 * 注意：本题中，每个活字字模只能使用一次。
 * @Author: WAHWJ
 * @Date: 2020/4/25 10:54
 * @Version: V0.1
 */
public class Test {
    public int trap(int[] height) {
        int sum = 0;
        int left_max = 0;
        int right_max = 0;
        int left = 1;
        int right = height.length-2;
        while(left<=right) {
            /*设一开始left-1大于right+1，则之后right会一直向左移动，
            直到right+1大于left-1。在这段时间内right所遍历的所有点都是
            左侧最高点maxleft大于右侧最高点maxright的，
            所以只需要根据原则判断maxright与当前高度的关系就行。反之left右移，
            所经过的点只要判断maxleft与当前高度的关系就行。*/
            if(height[left-1] < height[right+1]) {
                left_max = Math.max(height[left-1],left_max);
                if(left_max > height[left]) {
                    sum += left_max-height[left];
                }
                left++;
            }else {
                right_max = Math.max(height[right+1],right_max);
                if(right_max > height[right]) {
                    sum += right_max - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test = new Test();
        System.out.println(test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
