package com.leetcode.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: EraseOverlapIntervals
 * @Description: 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。435
 * @Author: WAHWJ
 * @Date: 2020/5/4 23:18
 * @Version: V0.1
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int p = 0;
        int q = 1;
        int count = 0;
        //贪心法，先按区间开始排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        while(q<intervals.length) {
            //当区间恰好不相交则跳过
            if(intervals[p][1]<=intervals[q][0]) {
                p = q;
                q++;
            }
            //当后面的右边界比前面的小在前面的区间内则删除前面的
            else if(intervals[p][1]>=intervals[q][1]) {
                p = q;
                q ++;
                count++;
            }
            //如果后面的和前面的相交而且区间右边界比前面的大则删除后面的
            else if(intervals[p][1]>intervals[q][0] && intervals[p][0]<=intervals[q][1]) {
                count++;
                q++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {{0,2},{3,10},{2,4},{3,5},{4,6}};
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        eraseOverlapIntervals.eraseOverlapIntervals(a);
    }

}
