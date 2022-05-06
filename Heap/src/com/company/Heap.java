package com.company;

public class Heap {
     int size=-1;
     int []heap=new int[100];
    public static void MaxHeapify(int []arr,int index ,int len){
        int left , right , largest;
        largest=index;
        left=2*index +1;
        right=2*index +2;
        //dividing the heap into right and left parts
        if(left < len && arr[left] > arr[largest]){
            largest=left;
        }
        if(right< len && arr[right] > arr[largest]){
            largest=right;
        }
        if(largest != index){
            ///swapping
            int flag=arr[index];
            arr[index]=arr[largest];
            arr[largest]=flag;
            MaxHeapify(arr , largest ,len);
        }
    }
   public void Build_Max_Heap(int []arr, int len){
        int i;
        for (i= (int) Math.floor(len/2)-1; i>=0; i--){
            MaxHeapify(arr,i,len);
        }
    }

    public void ExchangeWithUp(int s){
        while (s>0 && heap[(s-1)/2] < heap[s]){
            int flag=heap[(s-1)/2];
            heap[(s-1)/2]=heap[s];
            heap[s]=flag;
            s=(s-1)/2;
        }
    }
    public void MaxHeapInsert(int element){
        size++;
        heap[size]=element;
        ExchangeWithUp(size);
    }
    public int HeapExtractMax(){
        int MAX=heap[0];
        heap[0]=heap[size];
        size--;
        MaxHeapify(heap,0,heap.length);
        return MAX;
    }
}
