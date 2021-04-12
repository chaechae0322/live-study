package org.whiteship.issue5;

public class BinaryTree {
    Node tree;

    public void makeTree(int[] values) {

    }

    public void dfs() {

    }

    public void bfs() {

    }

    public static void main(String[] args) {
        int[] values = {1,2,3,4,5,6,7,8,9,10};

        BinaryTree tree = new BinaryTree();
        tree.makeTree(values);

        // BFS

        // DFS
    }
}

class Node {
    int value;
    BinaryTree left;
    BinaryTree right;
}
