package com.overflowing;

import java.util.Arrays;

public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public void quickSort(int[] arr, int start, int end, int k) {
        if(start>=end) return;
        int pivot = arr[start];
        int i=start, j=end-1;
        while(i<j) {
            while(i<j && arr[j]>=pivot) j--;
            swap(arr, i, j);
            while(i<j && arr[i]<pivot) i++;
            swap(arr, i, j);
        }
        if(j==k) return;
        if(j<k) quickSort(arr, j+1, end, k);
        if(j>k) quickSort(arr, start, j, k);
    }

    public void swap(int[] arr, int i, int j) {
        if(i==j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {0,0,2,3,2,1,1,2,0,4};
        Offer40 s= new Offer40();
        System.out.println(Arrays.toString(s.getLeastNumbers(a, 10)));
    }
}
