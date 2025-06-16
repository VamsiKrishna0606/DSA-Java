package Stacks_and_Queues.Medium;
/*
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */
import java.util.*;
public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (st.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(20);
        obj.push(5);
        obj.push(15);

        System.out.println("Top value: " + obj.top());
        System.out.println("Min value: " + obj.getMin());

        obj.pop();
        System.out.println("Top after pop: " + obj.top());
        System.out.println("Min after pop: " + obj.getMin());

        obj.pop();
        obj.pop();
        System.out.println("Top after popping all: " + obj.top());
        System.out.println("Min after popping all: " + obj.getMin());
    }
}
