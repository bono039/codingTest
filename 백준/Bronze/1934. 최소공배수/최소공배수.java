import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    sb.append(a * b / getGCD(a, b)).append("\n");
		}

		System.out.println(sb);
	}
	
	static int getGCD(int a, int b) {
	    if(b == 0)  return a;
	    return getGCD(b, a % b);
	}
}
