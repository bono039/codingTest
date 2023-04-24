import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine(), " ");
	    
	    long N = Long.parseLong(st.nextToken());
	    long K = Long.parseLong(st.nextToken());
	    List<Long> list = new ArrayList<>();
	    
	    int cnt = 0;
		
		for(int i = 0 ; i < N ; i++) {
		    long num = Long.parseLong(br.readLine());
		    
		    if(num <= K) {
		        list.add(num);
		    }
		}
		
		for(int i = list.size() - 1 ; i >= 0 ; i--) {
		    if(list.get(i) <= K) {
	            cnt += (K / list.get(i));
	            K %= list.get(i);
		    }
		}
		
		System.out.println(cnt);
	}
}