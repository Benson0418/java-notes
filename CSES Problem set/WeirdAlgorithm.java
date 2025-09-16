import java.util.*;
import java.io.*;

public class WeirdAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken();
        long n = (long) in.nval;  

        while (true) {
            out.print(n);
            if (n == 1) break;
            out.print(" ");

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }

        out.println();
        out.flush();
    }
}
