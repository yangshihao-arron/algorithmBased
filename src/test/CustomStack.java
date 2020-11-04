package test;

public class CustomStack {
    int[] nums;
    int pre,last;
    int capacity;
    public CustomStack(int maxSize) {
        nums = new int[maxSize + 1];
        capacity = maxSize + 1;
    }

    public void push(int x) {
        if((last + 1 ) % capacity != pre ){
            nums[last] = x;
            last = (last + 1) % capacity;
        }
        else{
            System.out.println("stack is full");
        }
    }

    public int pop() {
        if(pre == last){
            System.out.println("stack is empty");
            return  -1;
        }

        int temp = nums[last - 1];
        last = Math.abs((last - 1) % capacity);
        return temp;
    }

    public void increment(int k, int val) {
        int size = Math.abs(last - pre);
        int min = Math.min(size,k);
        int preTemp = pre;
        while(min > 0){
            nums[preTemp] += val;
            min--;
            preTemp = (preTemp + 1) % capacity;
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.increment(2,3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
