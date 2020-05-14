package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RemoveZeroSumSublists
 * @Description: 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * @Author: WAHWJ
 * @Date: 2020/4/27 12:23
 * @Version: V0.1
 */
public class RemoveZeroSumSublists {
    /**
     * @Author WAHWJ
     * @Description //两次遍历map法
     * @Date 12:38 2020/4/27
     * @Param [head]
     * @return com.leetcode.list.ListNode
     **/
    public ListNode removeZeroSumSubLists2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }

    /**
     * @Author WAHWJ
     * @Description //一次遍历map法，复杂度反而高了
     * @Date 12:39 2020/4/27
     * @Param [head]
     * @return com.leetcode.list.ListNode
     **/
    public static ListNode removeZeroSumSublists(ListNode head) {
        //用map存放当前所有加和还有对应的node
        HashMap<Integer,ListNode> map = new HashMap();
        int sum = 0;
        ListNode result = new ListNode(0);
        result.next = head;
        map.put(sum,result);
        //如果map中保存了和为sum的键值对，则删除所有map里中间节点的加和，并且将next指针指向head.next
        while(head != null) {
            sum += head.val;
            if(map.containsKey(sum)) {
                ListNode node = map.get(sum);
                int tmp = sum;
                while(node.next!=head){
                    tmp+=node.next.val;
                    map.remove(tmp);
                    node.next = node.next.next;
                }
                node.next = head.next;
            }else {
                map.put(sum,head);
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        int[] array = new int[]{1,3,2,-3,-2,5,5,-5,1};

        ListNode head = new ListNode(array[0]);
        ListNode pre = head;
        for(int i=1;i<array.length;i++){
            ListNode node = new ListNode(array[i]);
            pre.next = node;
            pre = node;
        }
        removeZeroSumSublists(head);
        System.out.println("ok");
    }
}
