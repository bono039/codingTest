import java.util.*;
import java.io.*;

public class Main {
    static int[] cards;
    
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        
        var st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i< N ; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);  // 이진 탐색을 위한 정렬
        int M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < M ; i++) {
            int result = binarySearch(Integer.parseInt(st.nextToken()));
            
            if(result != -1) sb.append(1 + " ");
            else             sb.append(0 + " ");
        }
        
        System.out.println(sb.toString());
	}
	
	// 이진 탐색
	private static int binarySearch(int target) {
	    int left = 0;
	    int right = cards.length - 1;
	    int mid;
	    
	    while(left <= right) {
	        mid = (left + right) / 2;
	        
	        if(cards[mid] < target)       left = mid + 1;
	        else if(cards[mid] > target)  right = mid - 1;
	        else                          return mid;
	    }
	    return -1;
	    
	} 
}