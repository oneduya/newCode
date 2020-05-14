package com.page2;

import java.util.Scanner;

public class Meituan1 {
    static int count = 0;
    public static int movingCount(char[] array, int rows, int cols)
    {
        if(rows<=0||cols<=0){
            return -1;
        }
        movingCountCore(array,rows,cols,0,0);
        return count;
    }

    public static void movingCountCore(char[] array, int rows, int cols, int row, int col){
        int index=row*cols+col;//匹配的第1个元素转换为一维数组的位置

        //终止条件  越界 已经走过的（true）
        if(row<0||col<0||row>=rows||col>=cols){
            return;
        }

        if(check(array[index],rows,cols,row,col)){
            if(index==rows*cols-1){
                count++;
            }
        }
        else{
            return;
        }
        movingCountCore(array,rows,cols,row,col+1);//向右
        movingCountCore(array,rows,cols,row+1,col+1);//右下
        movingCountCore(array,rows,cols,row-1,col+1);//右上
    }

    //越界判断
    public static boolean check(char s, int rows, int cols, int row, int col){
        if(row>=0 && rows>row && col>=0 && cols>col && s=='.'){
            return true;//可以走
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            char[] array = (line1+line2).toCharArray();
            int num = movingCount(array, 2, n);
            System.out.println(num==0 ? -1 : num);
        }

    }
}
