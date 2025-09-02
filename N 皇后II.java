class Solution {
    public static int MAXN = 9;
    public int totalNQueens(int n) {
        return f((1<<n)-1, 0, 0, 0);
    }

    public static int f(int limit, int col, int dia, int ndia){
        if (limit==col){
            return 1;
        }
        int ban = col | dia | ndia;
        int candidate = limit & (~ban);
        int place;
        int ans = 0;
        while (candidate!=0){
            place = candidate & (-candidate);
            candidate ^= place;
            ans+=f(limit, col | place, (dia | place)>>>1, (ndia|place)<<1);
        }
        return ans;
    }
}
