import java.util.*;
import java.io.*;

public class Main {
    static int[][] tree;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new int[26][2];

		while(N-->0) {
		    String[] tmp = br.readLine().split(" ");
            int  node  = tmp[0].charAt(0) - 'A';
            char left  = tmp[1].charAt(0);
            char right = tmp[2].charAt(0);
            
            tree[node][0] = (left == '.') ? -1 : (left - 'A');
            tree[node][1] = (right == '.') ? -1 : (right - 'A');
		}
		
		preOrder(0);
        System.out.println();
		
	    inOrder(0);
        System.out.println();
        
 		postOrder(0);
        System.out.println();
	}
	
	// 전위 순회
	private static void preOrder(int now) {
	    if(now == -1)   return;
	    System.out.print((char) (now + 'A'));
	    preOrder(tree[now][0]);
	    preOrder(tree[now][1]);
	    
	}
	
	// 중위 순회
	private static void inOrder(int now) {
	    if(now == -1)   return;
	    inOrder(tree[now][0]);
	    System.out.print((char) (now + 'A'));
	    inOrder(tree[now][1]);
	}

	// 후위 순회
	private static void postOrder(int now) {
	    if(now == -1)   return;
	    postOrder(tree[now][0]);
	    postOrder(tree[now][1]);
	    System.out.print((char) (now + 'A'));
	}	
}
	