package com.ll.demo.sort;

/**
 * Created by lily on 2017/7/17.
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] < arr[i-1]) {//若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j = i-1;
                int x = arr[i];  //复制为哨兵，即存储待排序元素
                arr[i] = arr[i-1]; //先后移一个元素
                if (j==0 && x < arr[j]) {
                    arr[j] = x;
                    continue;
                }
                while(j>0 && x < arr[j]){//查找在有序表的插入位置
                    arr[j] = arr[j-1];
                    j--;//元素后移
                }
                arr[j+1] = x;//插入到正确位置
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,7,2,4,9,6};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ",");
        }
    }

}
