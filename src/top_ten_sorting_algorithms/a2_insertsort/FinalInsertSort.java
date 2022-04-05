package top_ten_sorting_algorithms.a2_insertsort;

import java.util.Arrays;

public class FinalInsertSort {

    public int[] sort(int[] src){

        int[] arr = Arrays.copyOf(src,src.length);
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            while(j > 0 && temp < arr[j-1]){
                arr[j] = arr[j - 1];  //把大的往后挪位
                j--;
            }
            if(j != i)
                arr[j] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array = {1,6,3,4,8,9,7};
        int[] dest = new FinalInsertSort().sort(array);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + " ");
        }
    }
}
