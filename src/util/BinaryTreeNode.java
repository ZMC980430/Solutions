package util;

import java.util.*;

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

    @Override
    public String toString() {
        Queue<BinaryTreeNode<T>> q = new LinkedList<>();
        q.add(this);
        List<T> string = new ArrayList<>();
        while(!q.isEmpty()) {
            BinaryTreeNode<T> curr = q.remove();
            if(curr == null) {
                string.add(null);
            }
            else {
                string.add(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        while(string.get(string.size()-1)==null)
            string.remove(string.size()-1);
        return string.toString();
    }

    public static void main(String[] args) {
        Integer[] tree = {1, 2, null, 3};
        BinaryTreeNode<Integer> t = new BinaryTreeNode<>(tree);
        System.out.println(t);
    }
}
