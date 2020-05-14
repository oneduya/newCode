package com.leetcode.list;

import java.util.Stack;

/**
 * @ClassName: ReorderList
 * @Description: 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * @Author: WAHWJ
 * @Date: 2020/4/28 12:09
 * @Version: V0.1
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode halfNode = findHalf(head);
        ListNode end = reverseList(halfNode.next);
        halfNode.next = null;
        while(head!=null && end!=null){
            ListNode next1 = head.next;
            ListNode next2 = end.next;
            head.next = end;
            end.next = next1;
            head = next1;
            end = next2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        //每次记录下head的下一个，然后让head的下一个指向pre指向的节点，然后再更新pre，然后再更新head
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode findHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        /*ReorderList reorderList = new ReorderList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        reorderList.reorderList(a);*/
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(new Integer(2));
        stack2.push(new Integer(2));

        System.out.println(stack1.peek()==stack2.peek());
    }
}
