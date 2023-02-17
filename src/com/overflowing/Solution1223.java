package com.overflowing;

public class Solution1223 {
    public int dieSimulator(int n, int[] rollMax) {
        int[][] states = new int[7][n+1];
        int mod = 1000000007;
        for(int[] state: states) {
            state[1] = 1;
        }
        states[6][1] = 6;
        states[6][0] = 1;
        for(int i=2; i<n+1; i++) {
            for(int j=0; j<6; j++) {
                states[j][i] = states[6][i-1];
                if(i>rollMax[j]) {
                    states[j][i] = (states[j][i] - states[6][i-rollMax[j]-1] + mod) % mod;
                    states[j][i] = (states[j][i-rollMax[j]-1] + states[j][i]) % mod;
//                    states[j][i] += states[j][i-rollMax[j]];
                }
                states[6][i] = (states[6][i] + states[j][i]) % mod;
            }
        }
        return states[6][n];
    }

    public int dieSimulator1(int n, int[] rollMax) {
        int MOD = 1000000007;
        int[][] d = new int[n + 1][6];
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                int pos = Math.max(i - rollMax[j] - 1, 0);
                int sub = ((sum[pos] - d[pos][j]) % MOD + MOD) % MOD;
                d[i][j] = ((sum[i - 1] - sub) % MOD + MOD) % MOD;
                if (i <= rollMax[j]) {
                    d[i][j] = (d[i][j] + 1) % MOD;
                }
                sum[i] = (sum[i] + d[i][j]) % MOD;
            }
        }
        return sum[n];
    }

    public static void main(String[] args) {
        Solution1223 solution1223 = new Solution1223();
        System.out.println(solution1223.dieSimulator1(20, new int[]{8,5,10,8,7,2}));
    }
}
