package com.tec;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(3);
        queue.enqueue(12);
        queue.enqueue(0);
        queue.enqueue(89);
        queue.enqueue(77);
        queue.show();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.show();

        System.out.println(queue.peek());
        queue.show();
    }
}
