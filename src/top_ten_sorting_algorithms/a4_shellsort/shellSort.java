package top_ten_sorting_algorithms.a4_shellsort;

import java.util.Arrays;

public class shellSort {

    public int[] sort(int[] src){
        int[] arr = Arrays.copyOf(src, src.length);
        int temp;
        for(int step = arr.length / 2; step >= 1; step/=2){
            for(int i = step; i < arr.length; i++){
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] dest = new shellSort().sort(array);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + " ");
        }
    }
}
