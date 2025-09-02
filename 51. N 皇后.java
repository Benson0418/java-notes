import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int limit = (1 << n) - 1;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        dfs(res, board, 0, 0, 0, 0, n);
        return res;
    }

    private static void dfs(List<List<String>> res, char[][] board, int col, int dia, int ndia, int row, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            res.add(solution);
            return;
        }

        int limit = (1 << n) - 1;
        int ban = col | dia | ndia;
        int candidate = limit & (~ban);

        while (candidate != 0) {
            int place = candidate & (-candidate); 
            candidate ^= place; 
            int c = Integer.numberOfTrailingZeros(place); 
            board[row][c] = 'Q';
            dfs(res, board, col | place, (dia | place) >> 1, (ndia | place) << 1, row + 1, n);
            board[row][c] = '.'; 
        }
    }
}
