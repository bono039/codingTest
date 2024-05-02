import java.util.*;
import java.io.*;

public class Main {
    static int N,L,R,X;
    static Node[] arr;
    static boolean[] visited;
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    
	    arr = new Node[N];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
	    }
	    Arrays.sort(arr);
	    
	    for(int i = 2 ; i <= N ; i++) {
	        visited = new boolean[N];
	        dfs(i, 0);
	    }
	    
	    System.out.println(answer);
	}
	
	private static void dfs(int target, int cnt) {
	    if(cnt == target) {
	        int tmpSum = 0;
	        List<Integer> list = new ArrayList<>();
	        
	        for(int i = 0 ; i < N ; i++) {
	            if(visited[i]) {
	                list.add(i);
	                tmpSum += arr[i].lv;
	            }
	        }
	        
	        if(tmpSum >= L && tmpSum <= R && (arr[list.get(list.size() -1)].lv - arr[list.get(0)].lv >= X)) {
	            answer++;
	        }
	        
	        return;
	    }
	    
	    for(int i = cnt ; i < N ; i++) {
	        if(!visited[i]) {
	            visited[i] = true;
	            dfs(target, i + 1);
	            visited[i] = false;
	        }
	    }
	}
}

class Node implements Comparable<Node> {
    int idx, lv;
    
    public Node(int idx, int lv) {
        this.idx = idx;
        this.lv = lv;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.lv - n.lv;
    }
}