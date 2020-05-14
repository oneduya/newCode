package com.leetcode.tanxin;

import java.util.*;

/**
 * @ClassName: MaxEvents
 * @Description: 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 *
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 *
 * 请你返回你可以参加的 最大 会议数目.
 * @Author: WAHWJ
 * @Date: 2020/5/13 11:51
 * @Version: V0.1
 */
public class MaxEvents {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i=0,early=1,count=0;
        while(i<events.length || !queue.isEmpty()) {
            while(i<events.length && events[i][0]==early) {
                queue.add(events[i++][1]);
            }
            while(!queue.isEmpty() && queue.peek()<early) {
                queue.remove();
            }
            if(!queue.isEmpty()) {
                queue.remove();
                count++;
            }
            early++;
        }
        System.out.println(count);
        return count;
    }


    public static void main(String[] args) {
        MaxEvents maxEvents = new MaxEvents();
        maxEvents.maxEvents(new int[][]{{1,5},{2,3},{2,3},{1,5},{1,5}});
    }
}
