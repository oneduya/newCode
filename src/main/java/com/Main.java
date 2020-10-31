package com;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int left = -1,right = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                left = i;
                right = i+1;
                break;
            }
        }
        for (int i = right; i<arr.length; i++) {
        	if (arr[i]<arr[right]) {
        		right = i;
			}
		}
        if (left != -1) {
			int tmp = arr[left]-'0';
			arr[left] = arr[right];
			arr[right] = (char) ('0' + tmp);
			System.out.println(new String(arr));
		}else {
			System.out.println(-1);
		}
    }

}
