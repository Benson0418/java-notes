import java.util.*;
import java.io.*;

public class TwoKnight{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n;
        in.nextToken();
        n = (int) in.nval;
        out.println(0);

        for (int i=2;i<=n;++i){
            out.println((long)(i*i)*(i*i-1)/2-4*(i-1)*(i-2));
        }
        out.close();
        br.close();
    } 

}
