package com.overflowing;

import java.util.*;

public class ACMachine {
    private int length;
    private final CharTreeNode root = new CharTreeNode('0');
    public ACMachine(String[] words){
        for(String w: words){
            CharTreeNode cur = root;
            for(char c: w.toCharArray()) {
                cur.addChild(c);
                cur = cur.getChild(c);
            }
        }
    }

    public void buildFail(){
        this.root.fail = this.root;
        Queue<CharTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            CharTreeNode cur = queue.remove();
            for(CharTreeNode child: cur.children) {
                if(child != null) {
                    if(cur.fail.getChild(child.val)!=null) {
                        child.fail = cur.fail.getChild(child.val);
                    }
                    child.fail = root;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] s = {"ample", "bsd", "apple", "apps", "ss"};
//        com.overflowing.ACMachine m = new com.overflowing.ACMachine(s);
        List<Integer>[] collection = new ArrayList[10];
    }
};
class CharTreeNode {
    public List<CharTreeNode> children;
    public CharTreeNode fail;
    public char val;
    public CharTreeNode(char val) {
        this.children = new ArrayList<CharTreeNode>();
        this.val = val;
        for(int i=0; i<26; i++){
            this.children.add(null);
        }
    }
    public void addChild(char val){
        int index = val - 'a';
        if(this.children.get(index) == null) {
            this.children.set(index, new CharTreeNode(val));
        }
    }
    public CharTreeNode getChild(char val){
        return this.children.get(val-'a');
    }
};