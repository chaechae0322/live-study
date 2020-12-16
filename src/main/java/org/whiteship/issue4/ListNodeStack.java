package org.whiteship.issue4;

public class ListNodeStack {

    public static final int STACK_EMPTY = -100_000_000;

    private ListNode head = new ListNode();
    private int top = -1;

    public void push(int data) {
        head.add(head, new ListNode(data), ++top);
    }

    public int pop() {
        if (top == -1) {
            System.out.println("스택 Empty..");
            return STACK_EMPTY;
        }
        ListNode removedNode = head.remove(head, top--);
        return removedNode.data;
    }

    public void showList() {
        this.head.showList();
    }

    public static void main(String[] args) {
        ListNodeStack stack = new ListNodeStack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.showList();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
