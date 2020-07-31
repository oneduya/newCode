package com.page3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] array = new String[n];
        sc.nextLine();*/



        /*int[] array = {1,5,7};
        Arrays.sort(array);
        int result = 0;
        for(int i=1;i<array.length;i++){
            array[i] += array[i-1];
            result += array[i];
        }*/

        int result = 0;
        int[] array = {2,2,3,3};
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<array.length;i++) {
            queue.add(array[i]);
        }
        while(!queue.isEmpty()){
            if(queue.size()<=1){
                break;
            }
            int a = queue.remove();
            int b = queue.remove();
            int ab = a+b;
            result += ab;
            queue.add(ab);
        }
        System.out.println(result);
        Long a = Long.valueOf(1000);
    }

}