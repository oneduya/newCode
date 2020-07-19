package com.leetcode.math;

/**
 * @ClassName: Mi2
 * @Description: 求2的n次方
 * @Author: WAHWJ
 * @Date: 2020/7/13 21:15
 * @Version: V0.1
 */
public class Mi2 {
	public static void main(String[] args) {
		int SIZE=2;//最多有2^31-1
		int n = 7;
		int res[] = new int[SIZE + 1];
		int i;
        /*for(i = 0;i < SIZE;++ i){
            res[i] = 0;
        }*/
		res[0] = 1;
		while(n > 0){
			for(i = 0;i < SIZE;++ i){
				res[i] *= 2;
			}
			for(i = 0;i < SIZE;++ i){
				if(res[i] > 9){
					res[i + 1] += res[i] / 10;//进位
					res[i] %= 10;//余数
				}
			}
			n --;
		}
		boolean bl = false;
		StringBuffer bf = new StringBuffer();
		for(i = SIZE;i >= 0;-- i){
			if(res[i] != 0 || bl){
				bf.append(res[i]);
				bl = true;
			}
		}
		System.out.println(bf);
	}
}
