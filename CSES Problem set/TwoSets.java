import java.util.*;
import java.io.*;

public class TwoSets{
    public static void main(String[] args) throws IOException{
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = in.readInt();

		long sum = (long)n*(n+1)/2;
		if ((sum&1)==1){
			out.println("NO");
		}
		else{
			ArrayList<Integer> set1 = new ArrayList<>(), set2 = new ArrayList<>();
			sum>>=1;
			for (int i=n;i>=1;--i){
				if (sum>=i){
					set1.add(i);
					sum-=i;
				}
				else{
					set2.add(i);
				}
			} 
			out.println("YES");
			int s1 = set1.size(), s2 = set2.size();
			out.println(s1);
			for (int i = s1-1; i>=0;--i){
				out.print(set1.get(i));
				out.print(" ");
			}
			out.println();
			out.println(s2);
			for (int i = s2-1;i>=0;--i){
				out.print(set2.get(i));
				out.print(" ");
			} 

		}
		out.close();
    } 

}

class Reader{
	final private int BUFFER_SIZE = 1<<16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;
	
	public Reader() {
		this.din = new DataInputStream(System.in);
		this.buffer = new byte[BUFFER_SIZE];
		this.bufferPointer = 0;
		this.bytesRead = 0;
	}
	
	public int readInt() throws IOException {
		int ret = 0;
		byte c = read();
		
		while(c<=' ') {
			c = read();
		}
		
		boolean neg = c == '-';
		
		if(neg)c = read();
		
		do {
			ret = ret*10 + (c - '0');
			c = read();
		} while (c>='0'&&c<='9');
		
		return neg? -ret:ret;
	}
	
	public long readLong() throws IOException {
		long ret = 0;
		byte c = read();
		
		while(c<=' ') {
			c = read();
		}
		
		boolean neg = c == '-';
		
		if(neg)c = read();
		
		do {
			ret = ret*10 + (c - '0');
			c = read();
		} while (c>='0'&&c<='9');
		
		return neg? -ret:ret;
	}
	
	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if(bytesRead==-1)buffer[0] = -1;
	}
	
	private byte read() throws IOException {
		if(bufferPointer == bytesRead) {
			fillBuffer();
		}
		return buffer[bufferPointer++];
	}
    public String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        byte c = read();
        while (c <= ' ') c = read(); // 跳過空白
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');
        return sb.toString();
    }
    public double readDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + (c - '0');
            c = read();
        } while (c >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                div *= 10;
                ret += (c - '0') / div;
            }
        }
        return neg ? -ret : ret;
    }


}
