import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int ansX = 0;
		int ansY = 0;

		for(int i = - 999 ; i <= 999 ; i++) {
		    for(int j = - 999 ; j <= 999 ; j++) {
		        if((a*i + b*j == c) && (d*i + e*j == f)) {
		            ansX = i;
		            ansY = j;
		            break;
		        }
		    }
		}
		
		System.out.println(ansX + " " + ansY);
	}
}