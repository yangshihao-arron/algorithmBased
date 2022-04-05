package top_ten_sorting_algorithms.a8_countingsort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        int[] res = new CountingSort().sort(nums);
        for(int i : res)
            System.out.print(i + ", ");
    }

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(arr);
        return countingSort(arr, maxValue);
    }
    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1; //加1是因为数组下标是从0开始的
        int[] bucket = new int[bucketLen];  //没有按照maxValue - minValue + 1来创建数组，是为了简化操作

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }
    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
