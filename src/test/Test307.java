package test;

public class Test307 {
    private int[] sum;

    private int[] data;
    public Test307(int[] nums) {
        data = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];//sum[i]存储nums[0...i-1]的和
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j++) {
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }

    int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
