package com.leetcode.rollback;

/**
 * @ClassName: TranslateNum
 * @Description: 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @Author: WAHWJ
 * @Date: 2020/6/9 22:28
 * @Version: V0.1
 */
public class TranslateNum {
    /**
     * @Author WAHWJ
     * @Description //动态规划
     * @Date 23:10 2020/6/9
     * @Param [num]
     * @return int
     **/
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        // pree表示到前一个数字的组合个数
        // pre表示当前数字为单字母时的组合个数
        // now表示当前数字组合个数
        int pree = 0,pre=0,now=1;
        for (int i = 0; i < numStr.length(); i++) {
            pree = pre;
            pre = now;
            now = 0;
            now += pre;
            //如果是第一位那只有一种可能
            if(i==0) {
                continue;
            }
            String tmp = numStr.substring(i-1,i+1);
            if(tmp.compareTo("25")<=0 && tmp.compareTo("10")>=0) {
                now +=pree;
            }
        }
        return now;
    }


    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum(506));
    }
}
