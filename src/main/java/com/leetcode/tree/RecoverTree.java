package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RecoverTree
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/11 14:07
 * @Version: V0.1
 */
public class RecoverTree {
	List<Integer> list = new ArrayList<>(50);
	public void recoverTree(TreeNode root) {
		getMidTurn(root);
		int[] twoSwap = getTwoSwap();
		recover(root,2,twoSwap[0],twoSwap[1]);
	}

	public int[] getTwoSwap() {
		int n = list.size();
		int x = -1, y = -1;
		for(int i = 0; i < n - 1; ++i) {
			if (list.get(i + 1) < list.get(i)) {
				y = list.get(i + 1);
				// first swap occurence
				if (x == -1) x = list.get(i);
					// second swap occurence
				else break;
			}
		}
		return new int[]{x,y};
	}

	public void recover(TreeNode r, int count, int x, int y) {
		if (r != null) {
			if (r.val == x || r.val == y) {
				r.val = r.val == x ? y : x;
				if (--count == 0) return;
			}
			recover(r.left, count, x, y);
			recover(r.right, count, x, y);
		}
	}


	public void getMidTurn(TreeNode root) {
		if(root==null) {
			return;
		}
		getMidTurn(root.left);
		list.add(root.val);
		getMidTurn(root.right);
	}

}
