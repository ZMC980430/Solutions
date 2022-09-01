package com.overflowing;

import java.util.HashMap;
import java.util.Map;

public class TreeNode<T> {
    public Map<T, TreeNode<T>> children;
    public T val;
    public TreeNode(T val) {
        this.val = val;
        this.children = new HashMap<>();
    }
}
