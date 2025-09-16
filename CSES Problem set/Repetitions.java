import java.util.*;
import java.io.*;

public class Repetitions{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        in.nextToken();
        String patt = in.sval;
        int res=0,rn=0;
        char cur='D';
       
        for (int i=0;i<patt.length();++i){
            if (patt.charAt(i)!=cur){
                res=Math.max(res,rn);
                rn=1;
                cur=patt.charAt(i);
            }
            else{
                ++rn;
            }
        }
        res=Math.max(res,rn);
        out.println(res);
        out.close();
        br.close();
    } 

}