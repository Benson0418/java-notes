import java.util.*;
import java.io.*;
/*
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 import java.io.PrintWriter;
 import java.util.StringTokenizer;
 */

public class fastIO2 {

    public static String line;
    public static String[] parts;

    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        /*
        while ((line = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                out.println(st.nextToken());
            }
        }
        */
        while ((line = in.readLine()) != null) {
            parts = line.split();
            for (String part : parts) {
                out.println(part);
            }
        }
        out.flush();
        out.close();
        in.close();
    }
}
