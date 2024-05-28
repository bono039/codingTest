import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static LinkedList<Integer> list;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    arr = new int[N];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i = 1 ; Math.pow(2, i) < N ; i++) {
	        for(int j = 1 ; Math.pow(2, j) < N ; j++) {
	            list = new LinkedList<>();
	            for(int x = 1 ; x <= N ; x++) {
	                list.add(x);
	            }
	            
	            shuffle(i);
	            shuffle(j);
	            
	            if(chk()) {
	                System.out.println(i + " " + j);
	                return;
	            }
	        }
	    }
	}
	
	private static boolean chk() {
        for(int i = 0 ; i < N ; i++) {
            if(arr[i] != list.get(i))
                return false;
        }
        return true;
	}
	
	private static void shuffle(int k) {
	    int x = 1;
	    
	    while(k - x + 1 >= 0) {
	        int cnt = (int)Math.pow(2, k-x+1);
	        
	        for(int j = 0 ; j < cnt ; j++) {
	            if(x == 1)
	                list.addFirst(list.removeLast());
	            else
	                list.addFirst(list.remove((int)Math.pow(2, k-x+2) -1));
	        }
	        
	        x++;
	    }
	}
}
