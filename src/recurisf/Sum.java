package recurisf;

public class Sum {
   public int addAll(int[] nums, int i){
        if(i == nums.length)
            return 0;
       int result = nums[i] + addAll(nums,i+1);
       return  result;
   }
   public static int sum(int[] arr){
       return sum(arr,0);
   }
   //计算arr[l...n]这个区间所有数字的和
   private static int sum(int[] arr,int l){
       if(l == arr.length)
           return 0;
       //return arr[l] + sum(arr,l+1);
       int x = sum(arr,l +1);
       int res = arr[l] +x;
       return  x;
   }
   public static void main(String[] args){
       int[] nums = {1,2,3,4};
       System.out.println(new Sum().sum(nums));
   }

}
