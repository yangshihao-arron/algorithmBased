package top_ten_sorting_algorithms.a7_heapsort;


import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        int[] res = new HeapSort().sort(nums);
        for(int i : res)
            System.out.print(i + ", ");
    }
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) { //把大根堆变成小根堆
            swap(arr, 0, i);
            len--;  //保证从0-len是大根堆，
            heapify(arr, 0, len);
        }
        return arr;
    }
    //构造大根堆
    private void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) { //对一半进行heapify就可以完成排序了
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {  //保证i节点和i的后代节点满足大根堆
        int left = 2 * i + 1;   //i的左孩子
        int right = 2 * i + 2;  //i的右孩子
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {  //说明孩子比父亲大了
            swap(arr, i, largest);  //交换
            heapify(arr, largest, len);  //交换后可能导致下面的堆结构的改变，因此也需要heapify操作
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}