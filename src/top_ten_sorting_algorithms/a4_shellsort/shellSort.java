package top_ten_sorting_algorithms.a4_shellsort;

import java.util.Arrays;

public class shellSort {

    public int[] sort(int[] src){
        int[] arr = Arrays.copyOf(src, src.length);
        int temp;
        for(int step = arr.length / 2; step >= 1; step/=2){
            for(int i = step; i < arr.length; i++){ //为了每次可以和同一个分组的前面的元素进行比较，就是可以做直接插入排序
                temp = arr[i];
                int j = i - step;//同一个分组的上一个元素
                while (j >= 0 && arr[j] > temp) {  //找可以插入位置，顺便挪位置
                    arr[j + step] = arr[j];
                    j -= step; //继续找同一个分组的上一个元素
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
