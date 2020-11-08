package test;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else if (stack2.empty() && !stack1.empty()) {
            while (!stack1.empty())
                stack2.push(stack1.pop());
            return stack2.pop();
        } else return -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.empty())
            return stack2.peek();
        if (stack2.empty() && !stack1.empty()) {
            while (!stack1.empty())
                stack2.push(stack1.pop());
            return stack2.peek();
        }
        return -1;

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.empty());
        System.out.println("peek:" + myQueue.peek());
        System.out.println("pop:" + myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println("peek:" + myQueue.peek());
        System.out.println("pop:" + myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println("peek:" + myQueue.peek());
        System.out.println("pop:" + myQueue.pop());
        System.out.println(myQueue.empty());

    }
}

