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
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        while(q<intervals.length) {
            if(intervals[p][1]<=intervals[q][0]) {
                p = q;
                q++;
            }
            else if(intervals[p][1]>=intervals[q][1]) {
                p = q;
                q ++;
                count++;
            }
            else if(intervals[p][1]>intervals[q][0] && intervals[p][0]<=intervals[q][1]) {
                count++;
                q++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        eraseOverlapIntervals.eraseOverlapIntervals(a);
    }

}
