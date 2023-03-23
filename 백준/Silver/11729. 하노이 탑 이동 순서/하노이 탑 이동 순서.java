import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, n) - 1)).append("\n");
		
		Hanoi(n, 1, 2, 3);
		
		System.out.println(sb);	
	}
	
	
	//                                 출발지  임시 거처  목적지
	public static void Hanoi(int n, int start, int mid, int to) {
	    // 최소 단위
	    if(n == 1) {
	        sb.append(start + " " + to + "\n");
	        return;
	    }
	    
	    
	    // 1) n-1개를 A→B로 이동
	    Hanoi(n-1, start, to, mid);
	    
	    // 2) 1개를 A→C로 이동
	    sb.append(start + " " + to + "\n");
	    
	    // 3) n-1개를 B→C로 이동
	    Hanoi(n-1, mid, start, to);
	}
}