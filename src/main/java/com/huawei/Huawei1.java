package com.huawei;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Huawei1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] array = in.split(",");
        if(array.length<1){
            System.out.println("error.0001");
            return;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<array.length;i++) {
            if(array[i].charAt(0)-'A'<0 || array[i].charAt(0)-'Z'>0){
                System.out.println("error.0001");
                return;
            }
            for(int p=1;p<array[i].length();p++){
                if(array[i].charAt(p)-'a'<0 || array[i].charAt(p)-'z'>0){
                    System.out.println("error.0001");
                    return;
                }
            }
            if(map.containsKey(array[i])) {
                int counttmp = map.get(array[i]);
                map.put(array[i],counttmp+1);
            }else{
                map.put(array[i],1);
            }
        }
        Set<String> set = map.keySet();
        String result = "";
        int max = 0;
        for(String key : set) {
            int num = map.get(key);
            if(num>max){
                result = key;
                max = map.get(key);
            }
            else if(num==max){
                int length = result.length()<=key.length() ? result.length() : key.length();
                boolean flag = false;
                for(int i=0;i<length;i++) {
                    if(result.charAt(i)==key.charAt(i))
                        continue;
                    if(result.charAt(i)<key.charAt(i)){
                        flag=true;
                        break;
                    }
                    else {
                        result = key;
                        max = map.get(key);
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    if(key.length()<result.length()){
                        result = key;
                        max = map.get(key);
                    }
                }
            }
        }
        System.out.println(result);
    }
}