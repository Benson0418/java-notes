import java.util.*;
import java.io.*;

public class MissingNumber{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        in.nextToken();
        int n = (int) in.nval;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i=0;i<n-1;++i){
            in.nextToken();
            arr.add((int) in.nval);
        }
        arr.sort(null);
        boolean flag = false;
        for (int i=1;i<n;++i){
            if (arr.get(i-1)!=i){
                out.println(i);
                flag = true;
                break;
            }
        }
        if (!flag){
            out.println(n); 
        }
        out.close();
        br.close();
    } 

}