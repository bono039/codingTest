import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine(), " ");
		
		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		if(((a1*n + a0) <= c * n) && c >= a1) {
		    System.out.println(1);
		} else {
		    System.out.println(0);
		}
	}
}