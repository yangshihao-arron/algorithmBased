package top_ten_sorting_algorithms.a3_selectionsort;

import java.util.Arrays;

public class SelectionSort {

    public int[] sort(int[] src){
        int pre = 0,pos = 0;
        int[] arr = Arrays.copyOf(src, src.length);
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(temp > arr[j]){
                    temp = arr[j];
                    pos = j;
                }
            }
            temp = arr[pos];
            arr[pos] = arr[pre];
            arr[pre] = temp;
            pre++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1,6,3,4,8,9,7};
        int[] dest = new SelectionSort().sort(array);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + " ");
        }
    }
}
