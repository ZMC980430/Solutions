package com.overflowing;

import util.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution662 {
    class Pair {
        public BinaryTreeNode<Integer> treeNode;
        public int offset;
        public Pair(int o, BinaryTreeNode<Integer> t) {
            this.treeNode = t;
            this.offset = o;
        }
    }
    public int widthOfBinaryTree(BinaryTreeNode<Integer> root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        q.add(new Pair(-1, null));
        int left=0, right, result=0;
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            if(curr.offset == -1) {
                if(q.isEmpty()) break;
                q.add(new Pair(-1, null));
                left = q.peek().offset;
                continue;
            }
            if(q.peek().offset == -1) {
                right = curr.offset;
                if(right-left>result)
                    result = right-left;
            }
            if(curr.treeNode.left != null) {
                q.add(new Pair(curr.offset * 2, curr.treeNode.left));
            }
            if(curr.treeNode.right != null) {
                q.add(new Pair(curr.offset * 2 + 1, curr.treeNode.right));
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        Solution662 s = new Solution662();
        Integer[] i = {0,0,0,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0};
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(i);
        System.out.println(s.widthOfBinaryTree(root));
    }
}
