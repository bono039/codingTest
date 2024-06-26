import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt;
    static char[] map;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    map = br.readLine().toCharArray();
	    
	    for(int i = 0 ; i < N-1 ; i++) {
	        if(map[i] == 'E' && map[i+1] == 'W') {
	            cnt++;
	        }
	    }
	    
	    System.out.println(cnt);
	}
}
