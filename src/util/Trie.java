package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    public ArrayList<Trie> subTrie;
    public Trie() {
        this.subTrie = new ArrayList<>(27);
        for(int i=0; i<27; i++) {
            this.subTrie.add(null);
        }
    }

    public Trie get(char c) {
        int index = c - 'a' + 1;
        Trie sub = this.subTrie.get(index);
        if(sub == null) {
            sub = new Trie();
            this.subTrie.set(index, sub);
        }
        return sub;
    }

    public boolean isLeaf() {
        return this.subTrie.get(0) != null;
    }

    public void add(String s) {
        if(s.length()==0) {
            this.subTrie.set(0, new Trie());
            return;
        }
        this.get(s.charAt(0)).add(s.substring(1));
    }

    public List<String> getString() {
        List<String> list = new ArrayList<>();
        if(this.isLeaf()) {
            list.add("|");
        }
        for(int i=1; i<27; i++) {
            Trie trie = this.subTrie.get(i);
            if(trie != null) {
                List<String> subString = trie.getString();
                list.add((char)(i+'a'-1) + "-" + subString.get(0));
                for(int j=1; j<subString.size(); j++) {
                    list.add(" ".repeat(2) + subString.get(j));
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s: this.getString()) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public static Trie build(String[] words){
        Trie root = new Trie();
        for(String s: words) {
            root.add(s);
        }
        return root;
    }

    public static void main(String[] args) {
        String[] words = {"food", "foot", "for", "app", "apple"};
        Trie root = Trie.build(words);
        System.out.println(root.toString());
//        String s = "a-p-p-|\n     -l-e-|\n       -y-|";
//        System.out.println(s);
    }
}
