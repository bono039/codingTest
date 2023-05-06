import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer> tree[];
    static boolean visited[];
    static int answer[];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		
		tree = new ArrayList[N + 1];
		for(int i = 0 ; i < tree.length ; i++) {
		    tree[i] = new ArrayList<>();
		}
		
		for(int i = 1 ; i < N ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    tree[a].add(b);
		    tree[b].add(a);
		}
		
		DFS(1);
		
		for(int i = 2 ; i <= N ; i++) {
		    System.out.println(answer[i]);
		}
	}
	
	public static void DFS(int num) {
	    visited[num] = true;
	    
	    for(int i : tree[num]) {
	        if(!visited[i]) {
	            answer[i] = num;
	            DFS(i);
	        }
	    }
	}	
}