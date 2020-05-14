package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: TreeNode
 * @Description: 广度优先搜索遍历树
 * @Author: WAHWJ
 * @Date: 2020/4/19 9:05
 * @Version: V0.1
 */
public class BFS {
    //广度优先搜索遍历树
    public static void main(String[] args) {
        class Pointer{
            int point;
            int deep;
            Pointer(int point,int deep){
                this.point = point;
                this.deep = deep;
            }
        }
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> tb = new ArrayList<>(n+1);
            for(int i=0;i<n+1;i++){
                ArrayList<Integer> tmp = new ArrayList<>();
                tb.add(tmp);
            }
            for(int i=0;i<n-1;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                tb.get(a).add(b);
                tb.get(b).add(a);
            }
            Queue<Pointer> queue = new LinkedList<>();
            Pointer first = new Pointer(1,0);
            queue.add(first);
            int max = 0;
            boolean[] vit = new boolean[n+1];
            vit[1]=true;
            while(!queue.isEmpty()){
                Pointer temp = queue.poll();
                if(temp.deep>max){
                    max=temp.deep;
                }
                ArrayList<Integer> lst = tb.get(temp.point);
                if(!lst.isEmpty()){
                    for(Integer t : lst){
                        if(!vit[t]){
                            vit[t] = true;
                            queue.add(new Pointer(t,temp.deep+1));
                        }
                    }
                }
            }
            System.out.println(2*(n-1)-max);
        }
    }
}
