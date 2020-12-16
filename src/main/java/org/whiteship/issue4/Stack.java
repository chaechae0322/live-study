package org.whiteship.issue4;

public class Stack {

    public static final int STACK_EMPTY = -100_000_000;

    private int[] stack = new int[1];
    private int top = -1;
    private int size = 0;

    public void push(int data) {
        if(this.size == this.stack.length) {
            // 2배 늘리는 작업
            int[] newstack = new int[size*2];
            for(int i=0; i<this.stack.length; i++){
                newstack[i] = this.stack[i];
            }
            this.stack = newstack;
            System.out.println("스택 크기 2배 늘림. 크기:"+this.stack.length);
        }
        this.stack[++top] = data;
        size++;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("스택 Empty..");
            return STACK_EMPTY;
        }
        size--;
        return this.stack[top--];
    }

    public void showStack() {
        for(int data: this.stack) {
            System.out.print("("+data+")-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        st.showStack();

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
