package com.leetcode.tuple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: CanFinish
 * @Description: 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
 * 我们用一个匹配来表示他们：[0,1]给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * @Author: WAHWJ
 * @Date: 2020/5/3 21:04
 * @Version: V0.1
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] helper = new int[numCourses];
        int count = numCourses;
        for(int i=0;i<prerequisites.length;i++) {
            int m = prerequisites[i][0];
            helper[m] += 1;
        }
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++) {
            if(helper[i]==0) {
                queue.add(i);
                count--;
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0;k<size;k++) {
                int num = queue.remove();
                for(int i=0;i<prerequisites.length;i++) {
                    if(prerequisites[i][1]==num) {
                        helper[prerequisites[i][0]] -= 1;
                        if(helper[prerequisites[i][0]]==0) {
                            count--;
                            queue.add(prerequisites[i][0]);
                        }
                    }
                }
            }
        }
        return count==0;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        canFinish.canFinish(3,new int[][]{{1,0},{2,1}});
    }
}
