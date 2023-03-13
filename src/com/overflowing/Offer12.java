package com.overflowing;

public class Offer12 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0) && search(board, word, 1, i, j, visited))
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int start, int row, int column, boolean[][] visited) {
        if(start == word.length()) return true;
        visited[row][column] = true;
        if(row>0 && !visited[row-1][column] && board[row-1][column]==word.charAt(start)) {
            if(search(board, word, start+1, row-1, column, visited))
                return true;
        }
        if(row<board.length-1 && !visited[row+1][column] && board[row+1][column]==word.charAt(start)) {
            if(search(board, word, start+1, row+1, column, visited))
                return true;
        }
        if(column>0 && !visited[row][column-1] && board[row][column-1]==word.charAt(start)) {
            if(search(board, word, start+1, row, column-1, visited))
                return true;
        }
        if(column<board[0].length-1 && !visited[row][column+1] && board[row][column+1]==word.charAt(start)) {
            if(search(board, word, start+1, row, column+1, visited))
                return true;
        }

        visited[row][column] = false;
        return false;
    }

    public static void main(String[] args) {
        Offer12 o = new Offer12();
        char[][] c = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        System.out.println(o.exist(c, "SEE"));
    }
}
