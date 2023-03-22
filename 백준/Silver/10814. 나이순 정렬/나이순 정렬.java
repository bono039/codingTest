import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    String[][] arr = new String[n][2];
	    
	    // 입력
	    for(int i=0 ; i < n ; i++) {
	        var st = new StringTokenizer(br.readLine(), " ");
	        
	        arr[i][0] = st.nextToken();
	        arr[i][1] = st.nextToken();
	    }
	    
	    // 정렬
	    Arrays.sort(arr, new Comparator<String[]>() {
	       @Override
	       public int compare(String[] s1, String[] s2) {
	           return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
	       }
	    });
	    
	    // 출력
	    var sb = new StringBuilder();
	    for(int i=0 ; i < n ; i++) {
	        sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
	    }
	    
		System.out.println(sb);
	}
}