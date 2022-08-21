package com.overflowing;

import java.util.HashMap;
import java.util.Map;

public class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        TreeNode root = new TreeNode('\n');
        TreeNode curr = root;
        for(char c: sentence.toCharArray()) {
            if(c == ' ') {
                curr = root;
                continue;
            }
            if(curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            }
            else {
                curr.children.put(c, new TreeNode(c));
                curr = curr.children.get(c);
            }
        }
        curr = root;
        for(char c: searchWord.toCharArray()) {
            if(curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            }
            else
                return 0;
        }
        return curr.children.size();
    }

    public int isPrefixOfWord1(String sentence, String searchWord) {
        int result = 1;
        int s1=0;
        int s2=0;
        while(s1<sentence.length()) {
            if(sentence.charAt(s1)==searchWord.charAt(s2)) {
                s1++;
                s2++;
                if(s2==searchWord.length()) return result;
            }
            else {
                s2=0;
                while(s1<sentence.length() && sentence.charAt(s1)!=' ')
                    s1++;
                s1++;
                result++;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String sentence = "i love eating burger";
        String searchWord = "burg";
        Solution1455 s = new Solution1455();
        int a = s.isPrefixOfWord1(sentence, searchWord);
        System.out.println(a);
    }
}
class TreeNode {
    public char val;
    public Map<Character, TreeNode> children;
    TreeNode(char c) {
        this.val = c;
        children = new HashMap<>();
    }
}

