import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long result = gcd(a, b);
		long num = 0;
		
		while(result > 0) {
		    bw.write("1");
		    result--;
		}
    	bw.flush();
    	bw.close();		
	}

	// 최대공약수 계산
	public static long gcd(long a, long b) {
	    if(b == 0)
	        return a;
	    else
	        return gcd(b, a % b);
	}
}