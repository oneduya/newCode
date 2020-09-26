package com;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class PaiXu {
    public static void swap(int[]array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //选择排序
    public static int[] xuanze(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[minIndex]>array[j]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //冒泡排序
    public static int[] maopao(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0; j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    //插入排序
    public static int[] charu(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1]=temp;
                }
            }
        }
        return array;
    }

    //希尔排序
    public static int[] shellSort(int[] array){
        int d = array.length/2;
        while(d >= 1){
            for(int i=d; i<array.length; i++){
                for(int j=i; j-d>=0; j-=d){
                    if(array[j]<array[j-d]){
                        int temp = array[j];
                        array[j] = array[j-d];
                        array[j-d]=temp;
                    }
                }
            }
            d = d/2;
        }
        return array;
    }

    //归并排序
    public static void merge(int[] array, int low,int mid, int high){
        int[] result = new int[high-low+1];
        int p = low;
        int q = mid+1;
        int i = 0;
        while(p<mid+1 && q<high+1){
            if(array[p]<=array[q]){
                result[i++] = array[p++];
            }
            else{
                result[i++] = array[q++];
            }
        }
        while(p<mid+1){
            result[i++] = array[p++];
        }
        while(q<high+1){
            result[i++] = array[q++];
        }
        for(int j=low; j<high+1; j++){
            array[j] = result[j-low];
        }
    }

    public static void mergeCore(int[] array, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low+high)/2;
        mergeCore(array,low,mid);
        mergeCore(array,mid+1,high);
        merge(array, low, mid, high);
    }


    /**
     * @Author WAHWJ
     * @Description 双向快排
     * @Date 15:22 2020/4/21
     * @Param [array, low, high]
     * @return void
     **/
    public static void fastSort(int[] array, int low, int high){
        if(low==high){
            return;
        }
        int lowtmp = low;
        int hightmp = high;
        int pivot = array[lowtmp];
        while(lowtmp < hightmp){
            while(lowtmp < hightmp && array[hightmp] >= pivot) {
                hightmp--;
            }
            array[lowtmp] = array[hightmp];
            while(lowtmp<hightmp && array[lowtmp] <= pivot) {
                lowtmp++;
            }
            array[hightmp] = array[lowtmp];
        }
        array[lowtmp] = pivot;
        if(low<lowtmp) {
            fastSort(array,low,lowtmp-1);
        }
        if(high>lowtmp) {
            fastSort(array,lowtmp+1,high);
        }
    }
/**
 * @Author WAHWJ
 * @Description 单向快排
 * @Date 15:22 2020/4/21
 * @Param [array, start, end]
 * @return void
 **/
    public static void quickSort2(int[] array, int start, int end) {
        if(array.length<=1){
            return;
        }
        int smallIndex = partirion(array, start, end);
        if(smallIndex>start){
            quickSort2(array,start,smallIndex-1);
        }
        if(smallIndex<end){
            quickSort2(array,smallIndex+1,end);
        }

    }

    public static int partirion(int[] array, int start, int end) {
        int smallIndex = start-1;
        int pivot = array[start];
        swap(array,start,end);
        for(int i=start;i<=end;i++){
            if(array[i]<=pivot){
                smallIndex++;
                if(smallIndex<i){
                    swap(array,smallIndex,i);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 稳定快排XXX写不出
     *
     * @param array
     * @param low
     * @param high
     * @throws
     * @author WAHWJ
     * @date 2020/8/14 WAHWJ
     */
    public static void fastSort3(int[] array, int low, int high){
        if (low == high) {
            return;
        }
        int[] tmp = new int[array.length];
        //这个高低指针用于记录对原数组遍历的位置
        int low1 = low,high1 = high;
        //这个高低指针用于记录原数组变化的指针，因为要每次往数组里面放下一次的值
        int low2 = low,high2 = high;
        int low3 = low,high3 = high;
        int pivot = array[low];
        while (low1<high1) {
            while (low1 < high1 && array[high1]>=pivot) {
                array[high2--] = array[high1--];
            }
            while (low1 < high1 && array[low1]<pivot) {
                array[low2++] = array[low1++];
            }
            if (low1 < high1) {
                tmp[low3++] = array[low1++];
                tmp[high3--] = array[high1--];
            }
        }
        for (int i=high3+1; i<=high; i++) {
            array[low2++] = tmp[i];
        }
        for (int i=low; i<low3; i++) {
           array[low2++] = tmp[i];
        }
        if (low1>low) {
            fastSort3(array, low, low1-1);
        }
        if (low1<high) {
            fastSort3(array,low1+1,high);
        }
    }

    /**
     * @Author WAHWJ
     * @Description 堆排序
     * @Date 15:20 2020/4/21
     * @Param [array]
     * @return void
     **/
    public static void heapSort(int[] array){
        int length = array.length;
        for(int i=length/2-1;i>=0;i--){
            adjustHeap(array,i,length);
        }

        for(int j=length-1;j>0;j--){
            swap(array,0,j);
            adjustHeap(array,0,j);
        }
    }

    public static void adjustHeap(int[] array, int i, int length){
        //构建大顶堆
        int temp = array[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length && array[k] < array[k+1]){
                k++;
            }
            if(temp < array[k]){
                array[i] = array[k];
                i = k;
            }else{
                //不徒增复杂度
                break;
            }
        }
        array[i] = temp;
    }


    /**
     * @Author WAHWJ
     * @Description Top K问题
     * @Date 15:20 2020/4/21
     * @Param [array, low, high, k]
     * @return int
     **/
    public static int fastSortTopK(int[] array, int low, int high, int k) {
        if (k >= array.length) {
            return -1;
        }
        if (low == high) {
            return array[low];
        }
        int lowtmp = low;
        int hightmp = high;
        int pivot = array[low];
        while (lowtmp < hightmp) {
            while (lowtmp < hightmp && array[hightmp] >= pivot) {
                hightmp--;
            }
            array[lowtmp] = array[hightmp];
            while (lowtmp < hightmp && array[lowtmp] <= pivot) {
                lowtmp++;
            }
            array[hightmp] = array[lowtmp];
        }
        array[lowtmp] = pivot;

        if (k == lowtmp) {
            return array[k];
        } else if (k > lowtmp) {
            return fastSortTopK(array, lowtmp + 1, high, k);
        } else {
            return fastSortTopK(array, low, lowtmp - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] array = {34, 21, 53, 8, 78, 123, 21, 53, 34, 111};
        maopao(array);
        System.out.println(Arrays.toString(array));
    }
}
