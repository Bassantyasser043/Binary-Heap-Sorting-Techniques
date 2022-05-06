package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
   static Heap H=new Heap();
   static HeapSort HS=new HeapSort();
   static Bubblesort bubble=new Bubblesort();
   static Mergesort merge=new Mergesort();

    public static int [] generate_integer(int size){
        Random generate = new Random(); // creating Random object
        int [] a=new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = generate.nextInt(); // storing random integers in an array
        }
        return a;
    }
    public static void createfile(String name){
        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writefile(String name,long data,int num){
        try {
            FileWriter myWriter = new FileWriter(name);
            myWriter.write("number= "+num+"\n"+data+"\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void print(int[] array){
       for (int i=0;i<array.length;i++){
           System.out.print(" " + array[i]);
       }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        createfile("bubblesort_time.txt");
        createfile("heapsort_time.txt");
        createfile("mergesort_time.txt");
        FileWriter myWriter1 = new FileWriter("bubblesort_time.txt");
        FileWriter myWriter2 = new FileWriter("heapsort_time.txt");
        FileWriter myWriter3 = new FileWriter("mergesort_time.txt");
        while(true) {
            System.out.println("\nEnter your choice:(build- insert - max - compare- Heapsort):  ");
            String desire = sc.next();
            switch (desire) {
                case "build":
                    System.out.println("Enter the heap array (separate elements with space between them): ");
                    List<Integer> list = new ArrayList<Integer>();
                    while (sc.hasNextInt())
                        list.add(sc.nextInt());
                    int[] arr = list.stream().mapToInt(i -> i).toArray();
                    H.Build_Max_Heap(arr, arr.length);
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print(" " + arr[i]);
                    }
                    break;

                case "insert":
                    System.out.println("Enter the heap array (separate elements with space between them): ");
                    while (sc.hasNextInt())
                        H.MaxHeapInsert(sc.nextInt());
                    System.out.print("\n\n");
                    System.out.print("After insertion: \n");
                    for (int f = 0; f <= H.size; f++) {
                        System.out.print(" " + H.heap[f]);
                    }
                    break;
                case "max":
                    if (H.size == -1) {
                        System.out.println("the heap is empty . please insert first...");
                    } else {
                        System.out.println("\n\nThe Maximum Of The Heap: " + H.HeapExtractMax());
                    }
                    break;
                case "Heapsort":
                    System.out.println("Enter the heap array (separate elements with space between them): ");
                    List<Integer> listsort = new ArrayList<Integer>();
                    while (sc.hasNextInt())
                        listsort.add(sc.nextInt());
                    int[] array = listsort.stream().mapToInt(i -> i).toArray();
                    HS.HEAPSORT(array, array.length);
                    System.out.println("The Heap Array After Sorting: ");
                    for (int i = 0; i < array.length; ++i) {
                        System.out.print(" " + array[i]);
                    }
                    break;
                case"compare":
                    System.out.println("Enter size of the array: ");
                    int size=sc.nextInt();
                    int []original=generate_integer(size);
                    long start=System.nanoTime();
                    int [] mergearray= merge.mergesort(original,size);
                    long end=System.nanoTime();
                    writefile("mergesort_time.txt",(end-start),size);
                    System.out.println("merge time="+(end-start));
                    long start1=System.nanoTime();
                    int [] bubblearray= bubble.bubbleSort(original);
                    long end1=System.nanoTime();
                    System.out.println("bubble time="+(end1-start1));
                    writefile("bubblesort_time.txt",(end-start),size);
                    ///////////////
                    long start2=System.nanoTime();
                    int [] heap= HS.HEAPSORT(original,original.length);
                    long end2=System.nanoTime();
                    System.out.println("HEAP_SORT time="+(end2-start2));
                    writefile("heapsort_time.txt",(end-start),size);
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }

        }

    }
}
