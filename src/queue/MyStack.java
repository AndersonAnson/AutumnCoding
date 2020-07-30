package queue;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> queue;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList();
        size = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.push(x);
        size++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        for (int i = 1; i <= queue.size() - 1; i++) {
            queue.push(queue.pop());
        }
        size--;
        return queue.pop();
    }

    /**
     * Get the top element.
     */
    public int top() {
        for (int i = 1; i <= queue.size() - 1; i++) {
            queue.push(queue.pop());
        }
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
