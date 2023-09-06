import java.util.*;
import java.io.*;

public class Main {
	static int N, max = Integer.MIN_VALUE;
	static int[] durability, weight;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		durability = new int[N];
		weight = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0);
		System.out.println(max);
	}
	
	private static void back(int depth) {
		if(depth == N) {
			int cnt = 0;
			
			for(int i = 0 ; i < N ; i++) 
				if(durability[i] <= 0)
					cnt++;
			
			max = Math.max(max, cnt);
			return;
		}
        
		if(durability[depth] <= 0)
			back(depth + 1);
		else {
			boolean broken = false;
            
			for(int i = 0 ; i < N ; i++) {
				if(i == depth || durability[i] <= 0) 
					continue;
                
				broken = true;
				
				durability[i] -= weight[depth];
				durability[depth] -= weight[i];
                
				back(depth + 1);
                
				durability[i] += weight[depth];
				durability[depth] += weight[i];
			}
            
			if(!broken)
				back(depth + 1);
		}
	}
}