package top_ten_sorting_algorithms.a2_insertsort;

import java.util.Arrays;

public class InsertSort {
    public int[] sort(int[] src){
       int[] arr = Arrays.copyOf(src,src.length);
       for(int i  = 1; i < arr.length; i++){
           for(int j = i ; j > 0; j--){
               if(arr[j] < arr[j - 1]){
                   int temp = arr[j-1];
                   arr[j-1] = arr[j];
                   arr[j] = temp;
               }
           }
       }
       return arr;
    }
    public static void main(String[] args) {
        int[] array = {1,6,3,4,8,9,7};
        int[] dest = new InsertSort().sort(array);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + " ");
        }
    }
}
