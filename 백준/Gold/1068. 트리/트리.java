import java.util.*;
import java.io.*;

public class Main {
    static int N, root, delNode, answer;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        A = new ArrayList[N];
        for(int i = 0 ; i < N ; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) {
                root = i;
            } else {
                A[num].add(i);
                A[i].add(num);                
            }
        }
        
        delNode = Integer.parseInt(br.readLine());
        if(delNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }
	}
	
	private static void dfs(int num) {
	    visited[num] = true;
	    boolean isLeaf = true;
	    
	    for(int next : A[num]) {
	        if(!visited[next] && next != delNode) {
	            isLeaf = false;
	            dfs(next);
	        }
	    }
	    
	    if(isLeaf) answer++;
	}
}
