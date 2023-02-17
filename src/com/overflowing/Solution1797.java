package com.overflowing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1797 {
}
class AuthenticationManager {
    private final int timeToLive;
    private List<Pair<Integer, String>> tokenQueue;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenQueue = new ArrayList<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.countUnexpiredTokens(currentTime);
        this.tokenQueue.add(new Pair<>(currentTime, tokenId));
    }

    public void renew(String tokenId, int currentTime) {
        this.countUnexpiredTokens(currentTime);
        if(this.tokenQueue.removeIf(p -> tokenId.equals(p.k2)))
            this.tokenQueue.add(new Pair<>(currentTime, tokenId));
    }

    public int countUnexpiredTokens(int currentTime) {
        if(this.tokenQueue.isEmpty()) return 0;
        int expireTime = currentTime - this.timeToLive;
        boolean clear = false;
        for(int i=0; i<this.tokenQueue.size();i++){
            if(this.tokenQueue.get(i).k1>expireTime) {
                this.tokenQueue = this.tokenQueue.subList(i, this.tokenQueue.size());
                clear = true;
                break;
            }
        }
        if(!clear) this.tokenQueue.clear();
        return this.tokenQueue.size();
    }

    static class Pair<K1, K2>{
        public K1 k1;
        public K2 k2;
        public Pair(K1 k1, K2 k2) {
            this.k1 = k1;
            this.k2 = k2;
        }
    }
}
