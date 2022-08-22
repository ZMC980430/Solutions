package com.overflowing;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeNode<T> {
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public T val;
    public BinaryTreeNode(T val){
        this.val = val;
    }
    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public BinaryTreeNode(T[] nodes) {
        Queue<BinaryTreeNode<T>> q = new ArrayDeque<>();
        this.val = nodes[0];
        q.add(this);
        for(int i=1; i<nodes.length; i++) {
            BinaryTreeNode<T> curr = q.remove();
            if(nodes[i] != null) {
                curr.left = new BinaryTreeNode<>(nodes[i]);
                q.add(curr.left);
            }
            i++;
            if(i<nodes.length) {
                if (nodes[i] != null) {
                    curr.right = new BinaryTreeNode<>(nodes[i]);
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] tree = {1, 2, null, 3};
        BinaryTreeNode<Integer> t = new BinaryTreeNode<>(tree);
    }
}
