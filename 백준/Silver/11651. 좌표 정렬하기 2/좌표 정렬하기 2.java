import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    int[][] arr = new int[n][2];          
        
	    for(int i = 0 ; i < n ; i++) {
	        var st = new StringTokenizer(br.readLine()," ");
	        
	        arr[i][0] = Integer.parseInt(st.nextToken());
	        arr[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    // y좌표가 증가하는 순으로 정렬
	    // y좌표가 같으면 x좌표가 증가하는 순으로 정렬
	    Arrays.sort(arr, new Comparator<int[]>() {
	        @Override
	        public int compare(int[] o1, int[] o2) {
	            if(o1[1] == o2[1])
	                return o1[0] - o2[0];
	            else
	                return o1[1] - o2[1]; 
	        }
	    });
	    
	    var sb = new StringBuilder();
	    for(int i = 0 ; i < n ; i++) {
	        sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
	    }
	 
		System.out.println(sb);
	}
}