package com.company;

public class HeapSort {
    static Heap heap=new Heap();
    public int[] HEAPSORT(int arr[] ,int len){
        heap.Build_Max_Heap(arr , len);
        ///
        for (int r=len-1; r>=0 ; r--){
            int temp=arr[0];
            arr[0]=arr[r];
            arr[r]=temp;
            heap.MaxHeapify(arr,0,r);
        }
        return arr;
    }
}
