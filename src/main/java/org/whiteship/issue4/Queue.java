package org.whiteship.issue4;

public class Queue {

    public static final int STACK_EMPTY = -100_000_000;

    private int[] queue = new int[2]; // empty와 full 을 구분하기 위해 totalSize + 1 크기의 배열을 할당
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    public void push(int data) {
        if((rear+1)%queue.length == front) {
            // 크기 약 2배늘리는 작업
            int[] newQueue = new int[queue.length*2+1];
            for(int i=0; i<queue.length; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;
            front = 0;
            rear = size;
        }
        size++;
        queue[rear] = data;
        rear = (rear+1)%queue.length;
        //System.out.println("push front:"+front+" rear:"+rear);
    }

    public int poll() {
        if(front == rear) {
            System.out.println("Queue Empty..");
            return STACK_EMPTY;
        }
        size--;
        int data = queue[front];
        front = (front+1)%queue.length;
        //System.out.println("poll front:"+front+" rear:"+rear);
        return data;
    }

    public void showList() {
        int curr = front;
        while(curr != rear) {
            System.out.print("("+queue[curr]+")-");
            curr = (curr+1)%queue.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);

        queue.showList();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
