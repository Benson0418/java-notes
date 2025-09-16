import java.util.*;
import java.io.*;

public class Permutations{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n;
        in.nextToken();
        n = (int) in.nval;

        if (n==1){
            out.println(1);
        }
        else if (n<=3) {
            out.println("NO SOLUTION");
        }
        else{
            int l = 1, r = n,z = 0;
            while (r-l>3){
                if (z==0){
                    out.print(l);
                    out.print(" ");
                    ++l;
                    z = 1;
                }
                else{
                    out.print(r);
                    out.print(" ");
                    --r;
                    z = 0;
                }
            }
            if (z!=0){
                out.printf("%d %d %d %d\n", r-1,r-3,r,r-2);
            }
            else{
                out.printf("%d %d %d %d\n",l+1, l+3, l, l+2);
            }

        }
        out.close();
        br.close();

    } 

}
