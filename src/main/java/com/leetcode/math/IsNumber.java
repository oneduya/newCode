package com.leetcode.math;

/**
 * @ClassName: IsNumber
 * @Description: 验证给定的字符串是否可以解释为十进制数字。
 * @Author: WAHWJ
 * @Date: 2020/7/18 7:40
 * @Version: V0.1
 */
public class IsNumber {
	public boolean isNumber(String s) {
		if(s==null||s.length()==0) return false;
		boolean numSeen=false;
		boolean dotSeen=false;
		boolean eSeen=false;
		char arr[]=s.trim().toCharArray();
		for(int i=0; i<arr.length; i++){
			if(arr[i]>='0'&&arr[i]<='9'){
				numSeen=true;
			}
			//如果小数点出现了两次或者出现在e之后
			else if(arr[i]=='.'){
				if(dotSeen||eSeen){
					return false;
				}
				dotSeen=true;
			}else if(arr[i]=='E'||arr[i]=='e'){
				//如果e出现不止一次，或者前面不是数字，则直接返回，否则e置位
				if(eSeen||!numSeen){
					return false;
				}
				eSeen=true;
				//从e开始重新计算数字出现与否
				numSeen=false;
			}else if(arr[i]=='+'||arr[i]=='-'){
				if(i!=0&&arr[i-1]!='e'&&arr[i-1]!='E'){
					return false;
				}
			}else{
				return false;
			}
		}
		return numSeen;
	}

	/*public boolean isNumberHelper(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
e
		}
	}*/

	public static void main(String[] args) {
		IsNumber isNumber = new IsNumber();
		System.out.println(isNumber.isNumber("1.e"));
	}
}
