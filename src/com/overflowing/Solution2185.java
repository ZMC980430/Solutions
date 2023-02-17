//package com.overflowing;
//
//import java.util.HashMap;
//
//public class Solution2185 {
//    public int prefixCount(String[] words, String pref) {
//        Trie root = new Trie();
//        for(String s: words) {
//            root.build(s);
//        }
//        Trie curr = root;
//        for(char c: pref.toCharArray()) {
//            if(!curr.sub.containsKey(c))
//                return 0;
//            curr = curr.sub.get(c);
//        }
//        return curr.count();
//    }
//    class Trie {
//        public HashMap<Character, com.overflowing.Trie> sub;
//        Trie() {
//            this.sub = new HashMap<>();
//        }
//        public void build(String word) {
//            if(word.length()==0) {
//                this.sub.put('\n', null);
//                return;
//            }
//            char c = word.charAt(0);
//            if(!this.sub.containsKey(c)) {
//                this.sub.put(c, new com.overflowing.Trie());
//            }
//            this.sub.get(c).build(word.substring(1));
////        if(word.length()==0) {
////            Trie end = new Trie();
////            end.sub.put('\n', null);
////            return end;
////        }
////        char c = word.charAt(0);
////        if(this.sub.containsKey(c)) {
////            Trie subTrie = this.sub.get(c);
////            subTrie.sub.put(c, subTrie.build(word.substring(1)));
////        }
////        else {
////            Trie subTree = new Trie();
////            this.sub.put(c, subTree.build(word.substring(1)));
////        }
////        return this;
//        }
//        public int count() {
//            int result = 0;
//            for(com.overflowing.Trie subTrie: this.sub.values()) {
//                if(subTrie == null)
//                    result ++;
//                else
//                    result += subTrie.count();
//            }
//            return result;
//        }
//    }
//    public static void main(String[] args) {
//        String[] words = {"wsd","ws","wsds"};
//        String pref = "w";
//        Solution2185 s = new Solution2185();
//        System.out.println(s.prefixCount(words, pref));
//    }
//}
