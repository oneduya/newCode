package com;

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
            for(int j=i; j<array.length-1;j++){
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
            while(lowtmp < hightmp && array[hightmp] >= pivot){
                hightmp--;
            }
            array[lowtmp] = array[hightmp];
            while(lowtmp<hightmp && array[lowtmp] <= pivot){
                lowtmp++;
            }
            array[hightmp] = array[lowtmp];
        }
        array[lowtmp] = pivot;
        if(low<lowtmp){
            fastSort(array,low,lowtmp-1);
        }
        if(high>lowtmp+1){
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
    public static int fastSort3(int[] array, int low, int high, int k) {
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
            return fastSort3(array, lowtmp + 1, high, k);
        } else {
            return fastSort3(array, low, lowtmp - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] array = {4,3,9,1,6,7,5,6,10};
        heapSort(array);
        System.out.println(1);
    }
}
