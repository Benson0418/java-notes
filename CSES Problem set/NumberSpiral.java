import java.util.*;
import java.io.*;

public class NumberSpiral{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n;
        in.nextToken();
        n = (int) in.nval;

        long e,res = 0L;
        for (long y,x,i = 0L; i<n; ++i){
            in.nextToken();
            y = (long) in.nval;
            in.nextToken();
            x = (long) in.nval;
            e = Math.max(y,x);
            res = e*e-(e-1);
            if ((e&1)==1){
                res+=x-y;
            }
            else res-=x-y;
            out.println(res);

        }
        out.close();
        br.close();

    } 

}
