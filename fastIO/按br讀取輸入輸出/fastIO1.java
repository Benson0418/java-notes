import java.util.*;
import java.io.*;
/*
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.StringTokenizer;
 */

public class fastIO1 {
    //和C++不同，Java的所有操作都在類中，因此聲明全局變量時要加static關鍵字，而C++直接在外面聲明即可
    public static int MAXN = 501; // 二維陣列的最大行列數
    public static int[][] mat = new int[MAXN][MAXN]; // 宣告二維陣列
    public static int[] arr = new int[MAXN]; // 宣告一維陣列
    public static int n, m; // 二維陣列的行列數
    public static void main(String[] args) throws IOException { //不處裡 IOException，Java 特色
        // Scanner sc = new Scanner(System.in); //效率慢，捨棄!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) { //多測資
            // n,m 二維陣列的行列
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            int[][] mat1 = new int[n][m]; // 動態宣告二維陣列，在多個case時會多次申請記憶體，
            for (int i = 0; i < n; ++i) {
                for (int j = 0;j < m; ++j) {
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            out.println(); 
        }
        out.flush(); //把緩衝區的東西印出來
        out.close(); //關閉輸出流
    }
}
