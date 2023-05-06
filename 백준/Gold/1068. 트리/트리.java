import java.util.*;
import java.io.*;

public class Main {
    static int N, deleteNode, answer;
    static boolean visited[];
    static ArrayList<Integer>[] tree;
    
	public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder();
	    
		int N = sc.nextInt();
		visited = new boolean[N];
		
		tree = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
		    tree[i] = new ArrayList<>();
		}
		
        int root = 0;		
		for(int i = 0 ; i < N ; i++) {
		    int p = sc.nextInt();
		    
		    if(p != -1) {
		        tree[i].add(p);
		        tree[p].add(i);
		    } else {
		        root = i;
		    }
		}
		
		deleteNode = sc.nextInt();
		if(deleteNode == root) {
		    sb.append(0);
		} else {
		    DFS(root);
		    sb.append(answer);
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int num) {
	    visited[num] = true;
	    int cNode = 0;
	    
	    for(int i : tree[num]) {
	        if(!visited[i] && i != deleteNode) { 
	            cNode++;
	            DFS(i);
	        }
	    }
	    
	    if(cNode == 0) {
	        answer++;
	    }
	}
}