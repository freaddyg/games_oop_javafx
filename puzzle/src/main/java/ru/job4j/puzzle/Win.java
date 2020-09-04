package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        int[] diag = getDiag(board);

        for (int i = 0; i < diag.length; i++) {
            if (diag[i] == 1) {
                if (checkHorizontalLine(board, i) || checkVerticalLine(board, i)) {
                    rsl = true;
                    break;
                }
            }
        }

        return rsl;
    }

    private static boolean checkHorizontalLine(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean checkVerticalLine(int[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }


    private static int[] getDiag(int[][] table) {
        int[] diag = new int[table.length];
        for (int i = 0; i < table.length; i++) {
            diag[i] = table[i][i];
        }
        return diag;
    }
}
