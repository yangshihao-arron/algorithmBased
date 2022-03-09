package top_ten_sorting_algorithms.a6_quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        int[] res = new QuickSort().sort(nums);
        for(int i : res)
            System.out.print(i + ", ");
    }
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    public int[] quickSort(int[] arr, int left, int right){
        if(left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, right);
        }
        return arr;
    }

    public int partition(int[]arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for(int i = left + 1; i <= right; i++){
            if(arr[pivot] > arr[i]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot,index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
