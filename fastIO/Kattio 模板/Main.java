import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/*
 * 由於 StreamTokenizer 會將數字先轉成 double
 * 因此對於超過 double 範圍的 long 會讀取錯誤
 * 另外對於科學記號的數字也會讀取錯誤
 * 所以封裝了 Kattio 模板來處理這個問題
 * 但 Kattio 的 IO 效率不如 StreamTokenizer
 * 因此只有在 StreamTokenizer 無法正確處理時，才考慮使用 Kattio
 */


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		System.out.println("請輸入 : 131237128371723187");
		System.out.println("並按回車");
		in.nextToken();
		long long1 = (long) in.nval;
		System.out.println("StreamTokenizer讀取到的數字 : ");
		System.out.println(long1);
		System.out.println();
		System.out.println("請輸入 : 5.6920E+0001");
		System.out.println("並按回車");
		in.nextToken();
		double double1 = in.nval;
		System.out.println("StreamTokenizer讀取到的數字 : ");
		System.out.println(double1);

		System.out.println("============================");

		Kattio io = new Kattio();
		System.out.println("請輸入 : 131237128371723187");
		System.out.println("並按回車");
		long long2 = io.nextLong();
		System.out.println("Kattio讀取到的數字 : ");
		System.out.println(long2);
		System.out.println();
		System.out.println("請輸入 : 5.6920E+0001");
		System.out.println("並按回車");
		double double2 = io.nextDouble();
		System.out.println("Kattio讀取到的數字 : ");
		System.out.println(double2);
		io.close();
	}

	// Kattio 的方法範例
	public static void show() {
		Kattio io = new Kattio(); // 自動接入輸入輸出流
		io.next(); // 讀取下一個字串，注意不是整行，是以空格或回車分割的字串，一個一個讀取
		io.nextInt(); // 讀取下一個 int
		io.nextDouble(); // 讀取下一個 double
		io.nextLong(); // 讀取下一個 long
		io.println("ans"); // 答案進入輸出流
		io.flush(); // 答案刷給後台
		io.close(); // 關閉 io
	}

	public static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		public Kattio() {
			this(System.in, System.out);
		}

		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(String intput, String output) throws IOException {
			super(output);
			r = new BufferedReader(new FileReader(intput));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) {
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
