package Stacks_and_Queues.Easy;
import java.util.*;
public class QueuesUsingStack {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public QueuesUsingStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.peek());
                s1.pop();
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.peek());
                s2.pop();
            }
        }

        public int pop() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }

        public static void main(String[] args) {
            QueuesUsingStack obj = new QueuesUsingStack();
            obj.push(10);
            obj.push(20);
            obj.push(30);

            System.out.println("Peek value: " + obj.peek()); // Expected: 10
            System.out.println("Pop value: " + obj.pop()); // Expected: 10
            System.out.println("Peek after pop: " + obj.peek()); // Expected: 20
            System.out.println("Is queue empty? " + obj.empty()); // Expected: false
        }
    }
