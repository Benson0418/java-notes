import java.util.*;
import java.io.*;

public class IncreasingArray{ 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        in.nextToken();
        int n = (int) in.nval;
        long res = 0L;
        int curr = 0;
        int e;
        for (int i=0;i<n;++i){
            in.nextToken();
            e = (int) in.nval;
            if (e<curr){
                res+=curr-e;
            }
            else{
                curr=e;
            }
        }
        out.println(res);
        out.close();
        br.close();


    } 

}