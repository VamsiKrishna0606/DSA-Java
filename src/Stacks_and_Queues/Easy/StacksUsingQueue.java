package Stacks_and_Queues.Easy;

import java.util.*;
public class StacksUsingQueue {
        Queue<Integer> queue;
        public StacksUsingQueue() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int s = queue.size();
            queue.add(x);
            for (int i = 0; i < s; i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.size() == 0;
        }

        public static void main(String[] args) {
            StacksUsingQueue obj = new StacksUsingQueue();
            obj.push(10);
            obj.push(20);
            obj.push(30);

            System.out.println("Top value: " + obj.top()); // Expected: 30
            System.out.println("Pop value: " + obj.pop()); // Expected: 30
            System.out.println("Top after pop: " + obj.top()); // Expected: 20
            System.out.println("Is stack empty? " + obj.empty()); // Expected: false
        }
    }

