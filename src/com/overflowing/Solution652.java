package com.overflowing;

import util.BinaryTreeNode;
import util.Pair;

import java.util.*;

public class Solution652 {
    public int index=1;
    public Map<String, Pair<Integer, BinaryTreeNode<Integer>>> map = new HashMap<>();
    public Set<BinaryTreeNode<Integer>> result = new HashSet<>();

    public List<BinaryTreeNode<Integer>> findDuplicateSubtrees(BinaryTreeNode<Integer> root) {
        getIndex(root);
        return new ArrayList<>(result);
    }
    public int getIndex(BinaryTreeNode<Integer> root) {
        if(root==null) return 0;
        String sub = Arrays.toString(new int[]{root.val, getIndex(root.left), getIndex(root.right)});
        if(map.containsKey(sub)) {
            result.add(map.get(sub).value);
            return map.get(sub).key;
        }
        else {
            Pair<Integer, BinaryTreeNode<Integer>> pair = new Pair<>(++index, root);
            map.put(sub, pair);
            return index;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(new Integer[]{1,2,3,4,1,2,4,null,null,null,null,4,1,3});
        Solution652 s = new Solution652();
        System.out.println(s.findDuplicateSubtrees(root));
    }
}
