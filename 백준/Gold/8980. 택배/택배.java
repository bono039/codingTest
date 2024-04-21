import java.util.*;
import java.io.*;

public class Main {
    static int N,C,M;
    static Info[] arr;
    static int[] boxArr;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    M = Integer.parseInt(br.readLine());
	    
	    arr = new Info[M];
	    for(int i = 0 ; i < M ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int send = Integer.parseInt(st.nextToken());
	        int receive = Integer.parseInt(st.nextToken());
	        int box = Integer.parseInt(st.nextToken());
	        
	        arr[i] = new Info(send, receive, box);
	    }
	    Arrays.sort(arr);
	    
	    boxArr = new int[N + 1];
	    for(int i = 1 ; i < N ; i++) {
	        boxArr[i] = C;
	    }
	    
	    int answer = 0;
	    
	    for(int i = 0 ; i < M ; i++) {
	        Info info = arr[i];
	        
	        int max = Integer.MAX_VALUE;	        
	        for(int j = info.s ; j < info.r ; j++) {
	            max = Math.min(max, boxArr[j]);
	        }
	        
	        if(max >= info.box) {
	            for(int j = info.s ; j < info.r ; j++) {
	                boxArr[j] -= info.box;
	            }
	            answer += info.box;
	        }
	        else {
	            for(int j = info.s ; j < info.r ; j++) {
	                boxArr[j] -= max;
	            }
	            answer += max;
	        }
	    }
	    
	    System.out.println(answer);
	}
}

class Info implements Comparable<Info> {
    int s, r, box;
    
    public Info(int s, int r, int box) {
        this.s = s;
        this.r = r;
        this.box = box;
    }
    
    @Override
    public int compareTo(Info i) {
        if(this.s != i.s)
            return this.s - i.s;
        return this.r - i.r;
    }
}