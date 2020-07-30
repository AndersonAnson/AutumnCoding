package stack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int res = s1.pop();
        while (s2.size() > 0) {
            s1.push(s2.pop());
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int res = s1.peek();
        while (s2.size() > 0) {
            s1.push(s2.pop());
        }
        return res;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }
}
