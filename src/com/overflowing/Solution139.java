package com.overflowing;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = Trie.build(wordDict);
        return search(s, root, root);
    }

    public boolean search(String s, Trie root, Trie curr) {
        if(curr == null) return false;
        if(s.length()==0) return curr.isLeaf;
        char c = s.charAt(0);
        if(curr.get(c) == null && !curr.isLeaf) return false;
        boolean conti = curr.get(c) != null && search(s.substring(1), root, curr.get(c));
        if(conti) return true;
        return curr.isLeaf && search(s, root, root);
    }

    public static void main(String[] args) {
        String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> lst = Arrays.asList(wordDict);
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Solution139 solution139 = new Solution139();
        System.out.println(solution139.wordBreak(s, lst));
    }
}
class Trie {
    public Trie[] subTrie;
    public boolean isLeaf;
    public Trie() {
        this.subTrie = new Trie[26];
        Arrays.fill(this.subTrie, null);
        this.isLeaf = false;
    }
    public Trie get(char c) {
        int index = c - 'a';
        return this.subTrie[index];
    }
    public void add(String word) {
        if(word.length()==0) {
            this.isLeaf = true;
            return;
        }
        int index = word.charAt(0) - 'a';
        if(this.subTrie[index]==null) {
            this.subTrie[index] = new Trie();
        }
        this.subTrie[index].add(word.substring(1));
    }
    public static Trie build(List<String> wordDict) {
        Trie root = new Trie();
        for(String word: wordDict) {
            root.add(word);
        }
        return root;
    }
}