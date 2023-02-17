package com.overflowing;

public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int[][][] edges = new int[grid.length+1][grid[0].length+1][2];
        int max=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    edges[i+1][j+1][0] = edges[i+1][j][0] + 1;
                    edges[i+1][j+1][1] = edges[i][j+1][1] + 1;
                }
                else {
                    continue;
                }
                if(max<1) max=1;
                for(int l=1; l<Math.min(edges[i+1][j+1][0], edges[i+1][j+1][1]); l++){
                    if(edges[i-l+1][j+1][0]>l && edges[i+1][j-l+1][1]>l) {
                        int edge = l+1;
                        edge*=edge;
                        if(edge>max) max=edge;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1,1,1},
                {1,0,1,1,1,0,1},
                {1,1,1,1,1,1,1},
                {1,0,1,1,1,1,1}
        };
        Solution1139 s = new Solution1139();
        System.out.println(s.largest1BorderedSquare(grid));
    }
}
