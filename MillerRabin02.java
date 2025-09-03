import java.util.*;
import java.io.*;
import java.math.BigInteger;

//逃課法，isProbablePrime(k)表示方法內參數表示校驗k次，每個數字的偽陽性機率是1/(2^k)
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int t = Integer.valueOf(br.readLine());
		while (t-->0){
			BigInteger n = new BigInteger(br.readLine());
			out.println(n.isProbablePrime(7) ? "Yes" : "No");
		}
		out.close();
		br.close();
	}
}
