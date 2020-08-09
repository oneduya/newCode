package com.leetcode.rollback;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RestoreIpAddresses
 * @Description: 恢复IP地址
 * @Author: WAHWJ
 * @Date: 2020/8/9 9:59
 * @Version: V0.1
 */
public class RestoreIpAddresses {
	List<String> res;
	public List<String> restoreIpAddresses(String s) {
		res = new ArrayList<>();
		trackback(new StringBuilder(s),s.length(),0);
		return res;
	}

	public void trackback(StringBuilder sb, int index, int count) {
		if (index==0 && count==4) {
			res.add(sb.substring(1));
			return;
		}
		if (count>4) {
			return;
		}
		for (int i=index-1; i>=0; i--) {
			String tmp = sb.substring(i,index);
			if (tmp.length()>1 && tmp.startsWith("0")) {
				continue;
			}
			int num = Integer.valueOf(sb.substring(i,index));
			if (num>255) {
				break;
			}
			sb.insert(i,".");
			trackback(sb,i,count+1);
			sb.deleteCharAt(i);
		}
	}
}
