package com.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Meituan3 {

    List<Integer> list = new ArrayList<>();
    List<Integer> l = new ArrayList<>();

    public int[] findMode(List<Integer> list) {
        //用map来辅助遍历

        int max = 1;
        int size = list.size();
        int count = 1;
        for (int i = 0; i < size; i++) {

            if (i<size-1 && list.get(i) == list.get(i + 1)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    l.clear();//将以前的清空
                    l.add(list.get(i));
                } else if (count == max) {
                    l.add(list.get(i));
                }
                count = 1;
            }
        }

        int[] result = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }
        return result;
    }

    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();
        a.add(-1);
        a.add(-1);
        a.add(-1);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(3);
        Meituan3 abc = new Meituan3();
        int[] result = abc.findMode(a);
        System.out.println(Arrays.toString(result));
    }


}
