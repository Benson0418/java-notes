import java.util.*;
import java.io.*;

// BigInteger有內建米勒-拉賓質數法，可以逃課
// 本解法10E18內一定對? 我也不知道，至少丟過的OJ都有過
public class Main {
	public static long[] witness = {2, 325, 9375, 28128, 450775, 9780504, 1795265022};
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int t = Integer.valueOf(br.readLine());
		while ((t--)>0){
			long n = Long.valueOf(br.readLine());
			out.println(isPrime(n) ? "Yes" : "No");
		}
		out.close(); //包括flush功能
		br.close();

	}

	//慢乘法
	public static long mul(long a,long b, long mod){
		a = (a % mod + mod) % mod;
		b = (b % mod + mod) % mod;
		long ans = 0;
		while (b!=0){
			if (( b & 1 ) == 1){ //java不能拿數字當boolean，難受!
				ans = (ans + a) % mod;
			}
			a = (a + a) % mod;
			b >>= 1;
		}
		return ans;
	}
	
	public static long qpow(long a, long b, long mod){
		long res=1;
		a %= mod;
		while (b!=0){
			if (( b&1 ) == 1) res = mul(res,a,mod);
			a = mul(a,a,mod);
			b >>= 1;
		}
		return res;
	}

	public static boolean isPrime(long num){
		if (num<=2) return num==2;
		if ((num & 1)==0) return false;
		long s=0;
		long d=num-1;
		while ((d & 1)==0){
			++s;
			d>>=1;
		}
		for(long i:witness){
			long x=qpow(i,d,num);
			if (x==1 || x==num-1 || x==0) continue;
			boolean flag=false;
			for (long j=1;j<s;++j){
				x=mul(x,x,num);
				if (x==num-1){
					flag=true;
					break;
				}
			}
			if (flag) continue;
			return false;
		}
		return true;
	}
}
