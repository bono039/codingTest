import java.util.*;
import java.io.*;

public class Main {
    static int[] points;
    static int N,M;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    StringBuilder sb = new StringBuilder();
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    points = new int[N];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        points[i] = Integer.parseInt(st.nextToken());
	    }
        Arrays.sort(points);
	    
	    for(int i = 0 ; i < M ; i++) {
	        String[] str = br.readLine().split(" ");
	        int s = Integer.parseInt(str[0]);
	        int e = Integer.parseInt(str[1]);
	        
	        sb.append(binarySearch(s,e) + "\n");
	    }
	    
	    System.out.println(sb.toString());
	}
	
	private static int binarySearch(int x, int y) {
	    int start = 0;
	    int end = points.length - 1;
	    
	    while(start <= end) {
	        int mid = (start + end) / 2;
	        
	        if(points[mid] > y)
	            end = mid - 1;
	        else
	            start = mid + 1;
	    }

    	int eIdx = end + 1;
        
        start = 0;
        end = points.length - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(points[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        int sIdx = start;
        
        return eIdx - sIdx;
	}
}