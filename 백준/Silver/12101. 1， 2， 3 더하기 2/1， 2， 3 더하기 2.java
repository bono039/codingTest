import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<String>[] A = new ArrayList[n + 3];
		for(int i = 0 ; i < n + 3 ; i++) {
		    A[i] = new ArrayList<>();
		}
		
		A[1].add("1");
		A[2].add("1+1");
		A[2].add("2");
		A[3].add("1+2");
		A[3].add("1+1+1");
		A[3].add("2+1");
		A[3].add("3");
		
		for(int i = 4 ; i <= n ; i++) {
		    for(int j = 1 ; j <= 3 ; j++) {
		        for(String s : A[i - j]) {
		            A[i].add(s + "+" + j);
		        }
		    }
		}
		
		if(A[n].size() < k) {
		    System.out.println(-1);
		}
		else {
		    Collections.sort(A[n]);
		    System.out.println(A[n].get(k - 1));
		}
	}
}