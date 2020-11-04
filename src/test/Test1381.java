package test;


import java.util.Iterator;
import java.util.LinkedList;

public class Test1381 {
    LinkedList<Integer> stack;
    private int size;
    private int capacity;
    public Test1381(int maxSize){
        stack =  new LinkedList<>();
        capacity = maxSize;
    }

    public void push(int x) {
        if (size < capacity){
            stack.addLast(x);
            size++;
        }
        else{
            System.out.println("stack is full");
        }

    }

    public int pop() {
        if(size > 0){
            size--;
            return stack.removeFirst();
        }
       else
           return -1;
    }

    public void increment(int k, int val) {
        int min = Math.min(k,size);
           for(int i = 0; i < min; i++){
               stack.set(i,stack.get(i) + 3);
           }
    }

    public static void main(String[] args) {
        Test1381 test1381 = new Test1381(3);
        test1381.push(1);
        test1381.push(2);
        test1381.push(3);
        test1381.push(4);
        System.out.println(test1381.pop());
        System.out.println(test1381.pop());
        System.out.println(test1381.pop());
        System.out.println(test1381.pop());

    }
}
