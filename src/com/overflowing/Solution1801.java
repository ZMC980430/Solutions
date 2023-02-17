package com.overflowing;

import java.util.LinkedList;
import java.util.List;

public class Solution1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        // order: price, amount, orderType
        LinkedList<int[]> backlogForSell = new LinkedList<>();    // order[2] == 1, ascend
        LinkedList<int[]> backlogForBuy = new LinkedList<>();     // order[2] == 0, descend
        for(int[] order: orders) {
            if(order[2] == 1) {
                while(backlogForBuy.size() > 0) {
                    int[] currOrder = backlogForBuy.remove();
                    if(currOrder[0]>=order[0]) {
                        if(currOrder[1] > order[1]) {
                            currOrder[1] = currOrder[1] - order[1];
                            backlogForBuy.addFirst(currOrder);
                            break;
                        }
                        else {
                            order[1] = order[1] - currOrder[1];
                        }
                    }
                    else {
                        backlogForBuy.addFirst(currOrder);
                        break;
                    }
                }
                insert(backlogForSell, order, false);
            }
            else {
                while(backlogForSell.size() > 0) {
                    int[] currOrder = backlogForSell.remove();
                    if(currOrder[0]<=order[0]) {
                        if(currOrder[1] > order[1]) {
                            currOrder[1] = currOrder[1] - order[1];
                            backlogForSell.addFirst(currOrder);
                            break;
                        }
                        else {
                            order[1] = order[1] - currOrder[1];
                        }
                    }
                    else {
                        backlogForSell.addFirst(currOrder);
                        break;
                    }
                }
                insert(backlogForBuy, order, true);
            }
        }
        int result = 0;
        int MOD = 1000000007;
        for(int[] order: backlogForBuy) {
            result += order[1];
            result %= MOD;
        }
        for(int[] order: backlogForSell) {
            result += order[1];
            result %= MOD;
        }
        return result;
    }


    public void insert(List<int[]> backlog, int[] order, boolean ascend) {
        if(order[1] == 0){
            return;
        }
        if(backlog.size() == 0) {
            backlog.add(order);
            return;
        }
        int left = 0;
        int right = backlog.size()-1;
        ascend = !ascend;
        while (left < right) {
            int mid = (left + right) / 2;
            if(backlog.get(mid)[0] < order[0] ^ ascend) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (backlog.get(left)[0] > order[0] ^ ascend) {
            backlog.add(left, order);
        }
        else {
            backlog.add(left+1, order);
        }
    }

    public static void main(String[] args) {
        int[][] orders = new int[][]{
                {7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}
        };
//        orders[0] = new int[] {1, 2, 0};
//        orders[1] = new int[] {2, 3, 1};
//        orders[2] = new int[] {4, 2, 1};
//        orders[3] = new int[]{2, 1, 0};
        Solution1801 s = new Solution1801();
        int result = s.getNumberOfBacklogOrders(orders);
//        backlog.add(0, order);
        System.out.println(result);
    }
}
