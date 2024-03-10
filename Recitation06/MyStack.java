package rec_mar_01;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int topElement;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        topElement = x;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Top element: " + stack.top()); // Expected output: 2
        System.out.println("Popped element: " + stack.pop()); // Expected output: 2
        System.out.println("Is stack empty? " + stack.empty()); // Expected output: false
        System.out.println("Popped element: " + stack.pop()); // Expected output: 1
    }
}
