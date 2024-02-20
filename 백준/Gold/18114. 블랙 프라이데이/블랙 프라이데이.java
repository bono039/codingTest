import java.util.*;
import java.io.*;

public class Main {
    static int N,C;
    static List<Integer> w = new ArrayList<>();
    static boolean exists = false;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        w.add(Integer.parseInt(st.nextToken()));
	        
	        if(w.get(i) == C) {
	            System.out.println(1);
	            return;
	        }
	    }
	    Collections.sort(w);
	    
	    int s = 0;
	    int e = N - 1;
	    int weight = 0;
	    
	    while(s < e) {
	        weight = w.get(s) + w.get(e);
	        
	        if(weight > C) {
	            e--;
	        }
	        else if(weight == C) {
	            System.out.println(1);
	            return;
	        }
	        else {
	            if(s < w.indexOf(C - weight) && w.indexOf(C - weight) < e) {
	                System.out.println(1);
	                return;
	            }
	            s++;
	        }
	    }
	    
	    System.out.println(0);
	}
}
