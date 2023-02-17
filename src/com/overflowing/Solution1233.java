package com.overflowing;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        Trie1233 root = new Trie1233();
        root.folder = "";
        for (String f : folder) {
            if(root.subTrie.isEmpty()){
                String[] folders = f.split("/");
                Trie1233 curr = root;
                for(String fol: folders) {
                    if("".equals(fol)) continue;
                    curr.subTrie.put(fol, new Trie1233());
                    curr = curr.subTrie.get(fol);
                }
                curr.folder=f;
            }
            else
                process(root, f);
        }
        return tostring(root);
    }

    public void process(Trie1233 root, String s) {
        int curr=0;
        String[] folders = s.split("/");
        for(String f: folders) {
            if(root.folder!=null)
                return;
            if("".equals(f)) continue;
            if(!root.subTrie.containsKey(f))
                root.subTrie.put(f, new Trie1233());
            root = root.subTrie.get(f);
        }
        root.folder=s;
        root.subTrie.clear();
    }

    public List<String> tostring(Trie1233 root) {
        List<String> result = new ArrayList<>();
        if(root.folder!=null && !"".equals(root.folder)) {
            result.add(root.folder);
            return result;
        }
        for(Trie1233 t: root.subTrie.values()) {
            result.addAll(tostring(t));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] folders = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        Solution1233 s = new Solution1233();
        for(String ss: s.removeSubfolders(folders)){
            System.out.println(ss);
        }
    }
}
class Trie1233 {
    public HashMap<String, Trie1233> subTrie;
    public String folder=null;
    public Trie1233(){
        subTrie = new HashMap<>();
        folder=null;
    }
}

