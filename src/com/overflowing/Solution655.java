package com.overflowing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution655 {
    public List<List<String>> printTree(BinaryTreeNode<Integer> root) {
        List<List<String>> results = new ArrayList<>();
        int height = depth(root);
        dfs(root, results, 0, (1<<height-1)-1, height);
        return results;
    }

    public void dfs(BinaryTreeNode<Integer> t, List<List<String>> res, int r, int c, int h) {
        if(t == null) return;
        if(res.size()<=r) {
            List<String> temp = new ArrayList<>((1<<h)-1);
            for(int i=0; i<(1<<h)-1; i++)
                temp.add("");
            res.add(temp);
        }
        res.get(r).set(c, String.valueOf(t.val));
        dfs(t.left, res, r+1, c-(1<<h-2-r), h);
        dfs(t.right, res, r+1, c+(1<<h-2-r), h);
    }

    public int depth(BinaryTreeNode<Integer> t){
        if(t == null) return 0;
        return Math.max(depth(t.left), depth(t.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] t = {1, 2, null, 3, 4, null, 5, 6, 7};
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(t);
        Solution655 s = new Solution655();
        List<List<String>> result = s.printTree(tree);
        System.out.println(result);

    }
}
