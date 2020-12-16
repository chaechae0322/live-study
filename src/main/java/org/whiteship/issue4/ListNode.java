package org.whiteship.issue4;

public class ListNode {
    int data;
    ListNode next;

    public ListNode() {};
    public ListNode(int data) {
        this.data = data;
    }

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if(position == 0) {
            head = nodeToAdd;
            return nodeToAdd;
        }
        ListNode curr = head;
        int count = 0;
        while(curr.next != null && count < position) {
            curr = curr.next;
            count++;
        }
        if(count == position - 1) curr.next = nodeToAdd;
        else {
            System.out.println("position이 너무 커요~");
        }
        return nodeToAdd;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        if(positionToRemove == 0) {
            head.data = 0;
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while(curr.next != null && count < positionToRemove) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        if(count == positionToRemove) {
            if(curr.next == null) prev.next = null;
            else prev.next = curr.next;
        }
        return curr;
    }

    public boolean contains(ListNode head, ListNode nodeTocheck) {
        ListNode curr = head;
        while(curr.next != null) {
            if(curr.equals(nodeTocheck)) return true;
            curr = curr.next;
        }
        return  false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof ListNode)) return false;
        ListNode node = (ListNode) obj;
        if(this.data == node.data) return true;
        return false;
    }

    public void showList() {
        ListNode curr = this;
        while(curr != null) {
            System.out.print("[node "+curr.data+"]-");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0); // position 0
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        head.add(head, n1, 1);
        head.add(head, n2, 2);
        head.add(head, n3, 3);
        head.add(head, n4, 4);
        head.add(head, n5, 5);
        head.add(head, n6, 6);

        head.showList();

        head.remove(head, 1); // remove n1
        head.remove(head, 3); // remove n4

        head.showList();

        System.out.println(head.contains(head, n1));
        System.out.println(head.contains(head, n4));
        System.out.println(head.contains(head, head));
        System.out.println(head.contains(head, n2));
        System.out.println(head.contains(head, null));
    }
}
