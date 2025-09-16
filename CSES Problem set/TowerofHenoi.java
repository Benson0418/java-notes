import java.util.*;
import java.io.*;

public class TowerofHenoi{
	static Reader in = new Reader();
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
		int n = in.readInt();
		out.println((1<<n)-1);
		hanoi(n,1,2,3);
		out.close();
	}
	public static void hanoi(int n, int from, int via, int to){
		if (n==1){
			out.printf("%d %d\n",from , to);		
		}
		else{
			hanoi(n-1, from, to, via);
			out.printf("%d %d\n", from, to);
			hanoi(n-1, via,from,to);
		}
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
