import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Node[] arr;
    static long answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new Node[N];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        long X = Long.parseLong(st.nextToken());
	        long A = Long.parseLong(st.nextToken());
	        arr[i] = new Node(X, A);
	        answer += A;
	    }
	    
	    Arrays.sort(arr);
	    
	    long sum = 0;
	    
	    for(Node now : arr) {
	        sum += now.a;
	        
	        if(sum >= (answer + 1) / 2) {
	            System.out.println(String.valueOf(now.x));
	            break;
	        }
	    }
	}
}

class Node implements Comparable<Node> {
    long x, a;
    
    public Node(long x, long a) {
        this.x = x;
        this.a = a;
    }
    
    @Override
    public int compareTo(Node n) {
        if(this.x == n.x)
            return (int)(this.a - n.a);
        return (int)(this.x - n.x);
    }
}
