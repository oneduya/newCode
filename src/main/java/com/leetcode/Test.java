package com.leetcode;

import com.Solution;
import com.leetcode.Tree.TreeNode;
import com.leetcode.list.ListNode;
import com.oracle.jrockit.jfr.Producer;
import com.sun.org.apache.xerces.internal.xs.XSTerm;
import javafx.util.Pair;

import javax.swing.text.StyledEditorKit;
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
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * @Author: WAHWJ
 * @Date: 2020/4/25 10:54
 * @Version: V0.1
 */
public class Test {
	public ListNode mergeKLists(ListNode[] lists) {
		return fenzhi(lists,0,lists.length-1);
	}

	public ListNode fenzhi(ListNode[] lists, int left, int right) {
		if(left==right) {
			return lists[left];
		}
		int mid = (left+right)/2;
		//递归得到分治计算结果
		ListNode l = fenzhi(lists,left,mid);
		ListNode r = fenzhi(lists,mid+1,right);
		ListNode head = new ListNode(0);
		ListNode headTmp = head;
		//开始合并
		while(l!=null && r!=null) {
			if (l.val<=r.val) {
				head.next = l;
				l = l.next;
			}
			else {
				head.next = r;
				r = r.next;
			}
			head = head.next;
		}
		//l没排完或者r没排完
		if (l!=null) {
			head.next = l;
		}
		if (r!=null) {
			head.next = r;
		}
		return headTmp.next;
	}



	public static void main(String[] args) throws Exception {
		Test test = new Test();
		
	}
}
