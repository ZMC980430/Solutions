package com.overflowing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] redAdj = new int[n];  // routes end with red edges
        int[] blueAdj = new int[n]; // routes end with blue edges
        Arrays.fill(redAdj, -1);
        Arrays.fill(blueAdj, -1);
        redAdj[0] = 0;
        blueAdj[0] = 0;
        List<int[]> unusedRedEdges = new LinkedList<>(Arrays.asList(redEdges));
        List<int[]> unusedBlueEdges = new LinkedList<>(Arrays.asList(blueEdges));
        int counter = 0;
        do {
            counter = 0;
            counter += oneStepAhead(redAdj, blueAdj, unusedRedEdges);
            counter += oneStepAhead(blueAdj, redAdj, unusedBlueEdges);

        } while (counter>0);

        for (int i = 0; i < n; i++) {
            if(redAdj[i]==-1)
                redAdj[i] = blueAdj[i];
            else if(blueAdj[i]>0 && blueAdj[i]<redAdj[i])
                redAdj[i] = blueAdj[i];
        }
        return redAdj;
    }

    public int oneStepAhead(int[] redAdj, int[] blueAdj, List<int[]> unusedRedEdges) {
        int counter=0;
        for (int[] edge : unusedRedEdges) {
            if (blueAdj[edge[0]] > -1) {
                if (redAdj[edge[1]] == -1 || redAdj[edge[1]] > blueAdj[edge[0]] + 1) {
                    redAdj[edge[1]] = blueAdj[edge[0]] + 1;
                    unusedRedEdges.remove(edge);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int n=6;
        int[][] red = new int[][]{{0,1},{1,2},{3,4},{0,4},{1,5}};
        int[][] blue = new int[0][0];
        Solution1129 s = new Solution1129();
        int[] result = s.shortestAlternatingPaths(n, red, blue);
        for(int i: result)
            System.out.println(i);
    }
}

