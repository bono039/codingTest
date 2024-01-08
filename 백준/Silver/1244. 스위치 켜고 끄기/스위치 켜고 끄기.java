import java.util.*;
import java.io.*;

public class Main {
    static int N, students;
    static int[] switches;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    switches = new int[N + 1];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 1 ; i <= N ; i++) {
	        switches[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    students = Integer.parseInt(br.readLine());
	    while(students --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int gender = Integer.parseInt(st.nextToken());
	        int cnt = Integer.parseInt(st.nextToken());
	        
	        solve(gender, cnt);
	    }
	    
	    print();
	}
	
	private static void solve(int gender, int cnt) {
	    if(gender == 1) {
	        for(int i = cnt ; i <= N ; i += cnt) {
	            switches[i] = switches[i] == 0 ? 1 : 0;
	        }
	    }
	    else {
	        switches[cnt] = switches[cnt] == 0 ? 1 : 0;
	        
	        int l = cnt - 1;
	        int r = cnt + 1;
	        
	        while(l >= 1 && r <= N && l <= r) {
	            if(switches[l] == switches[r]) {
	                switches[l] = switches[l] == 0 ? 1 : 0;
	                switches[r] = switches[r] == 0 ? 1 : 0;
	                l--;
	                r++;
	            }
	            else {
	                break;
	            }
	        }
	    }
	}
	
	private static void print() {
	    StringBuilder sb = new StringBuilder();
	    for(int i = 1 ; i <= N ; i++) {
	        sb.append(switches[i] + " ");
	        
	        if(i % 20 == 0) {
	            sb.append("\n");
	        }
	    }
	    System.out.println(sb);
	}
}
