package com.company;

public class Mergesort {

        public int[] mergesort(int []a, int size){
            if (size < 2) {
                return a;
            }
            int mid=size/2;
            int []left=new int [mid];
            int []right=new int [size-mid];
            int k = 0;
            for(int i = 0;i<size;++i){
                if(i<mid){
                    left[i] = a[i];
                }
                else{
                    right[k] = a[i];
                    k++;
                }
            }
            mergesort(left,mid);
            mergesort(right,size-mid);
            // Calling the merge method on each subdivision
            merge(left,right,a,mid,size-mid);
            return a;
        }
        public void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){

            int i=0,l=0,r = 0;
            //The while loops check the conditions for merging
            while(l<left_size && r<right_size){

                if(left_arr[l]<right_arr[r]){
                    arr[i++] = left_arr[l++];
                }
                else{
                    arr[i++] = right_arr[r++];
                }
            }
            while(l<left_size){
                arr[i++] = left_arr[l++];
            }
            while(r<right_size){
                arr[i++] = right_arr[r++];
            }
        }
    }