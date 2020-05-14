package com.leetcode.rollback;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SplitIntoFibonacci
 * @Description: 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
 * @Author: WAHWJ
 * @Date: 2020/5/13 15:23
 * @Version: V0.1
 */
public class SplitIntoFibonacci {
    ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        return dfs(0,S,0,0,0) ? result :new ArrayList<Integer>();
    }

    public boolean dfs(int index, String S,int pre2,int pre1,int level) {
        int len = S.length();
        if(index == len) {
            return level>=3;
        }
        for(int i=1;i<=11;i++) {
            //超出长度或者以0开头直接break;
            if(index+i>len || (S.charAt(index)=='0'&& i>1)){
                break;
            }
            //截取字符串
            String s = S.substring(index,index+i);
            long l = Long.valueOf(s);
            //判断是否超出范围,或者level不是0,1却大于他的前两个数之和(剪枝)
            if(l>Integer.MAX_VALUE || (level != 0 && level != 1 && l > (pre1 + pre2))) {
                break;
            }
            //转换成int
            Integer num = (int) l;
            //满足条件的数,递归加回溯
            if(level == 0 || level == 1 ||num.equals(pre1+pre2)) {
                result.add(num);
                if(dfs(index+i,S,pre1,num,level+1))
                return true;
                result.remove(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitIntoFibonacci splitIntoFibonacci = new SplitIntoFibonacci();
        System.out.println();
    }
}
