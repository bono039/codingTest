import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A > B) sb.append(">");
		else if(A < B) sb.append("<");
		else sb.append("==");
		
		System.out.println(sb);
	}
}