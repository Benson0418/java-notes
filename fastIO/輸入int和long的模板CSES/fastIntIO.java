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
}