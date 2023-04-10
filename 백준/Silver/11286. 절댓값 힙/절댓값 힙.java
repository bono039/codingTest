import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
		    int first_abs = Math.abs(o1);
		    int second_abs = Math.abs(o2);
		    
		    if(first_abs == second_abs)
		        return o1 > o2 ? 1 : -1;    // 절댓값이 같다면 음수 우선출력
		    else
		    return first_abs - second_abs;  // 절댓값 기준 정렬
		});
		
		for(int i = 0 ; i < n ; i++) {
		    int num = Integer.parseInt(br.readLine());
		    
		    if(num == 0) {
		        if(pq.isEmpty()) 
		            sb.append("0").append("\n");
		        else
		            sb.append(pq.poll()).append("\n");
		    }
		    else {
		        pq.add(num);
		    }
		}

		System.out.println(sb.toString());
	}
}