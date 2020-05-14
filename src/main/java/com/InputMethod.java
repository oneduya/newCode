package com;

import java.util.Scanner;

/*n m
int[n]
int[m]
如：
3 2
1 2 3
1 2
*/
public class InputMethod {
    public void method1(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] arrayA = new int[m];
            int[] arrayB = new int[n];
            for(int i=0;i<m;i++){
                arrayA[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                arrayB[i] = sc.nextInt();
            }
        }
    }


/*5 3
4 2 1 10 5
apple
orange
mango
6 5
3 5 1 6 8 1
peach
grapefruit
banana
orange
orange*/
    public void method2(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] arrayA = new int[m];
            String[] arrayB = new String[n];
            for(int i=0;i<m;i++){
                arrayA[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                arrayB[i] = sc.nextLine();
            }
        }
    }
}
