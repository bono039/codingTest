import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    
	    var st = new StringTokenizer(br.readLine(), " ");	    
	    for(int i=0 ; i < n ; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;        
        for(int i=0 ; i < n ; i++) {
            if(!map.containsKey(sorted[i]))
                map.put(sorted[i], cnt++);
        }
        
        var sb = new StringBuilder();
        for(int i : arr) {
            sb.append(map.get(i)).append(' ');
        }
        
        System.out.println(sb);
	}
}