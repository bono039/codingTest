import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusQ = new PriorityQueue<>();
		
		int one = 0;
		int zero = 0;
		
		for(int i = 0 ; i < N ; i++) {
		    int num = Integer.parseInt(br.readLine());
		    
		    if(num == 0)        zero++;
		    else if(num == 1)   one++;
		    else if(num > 1)    plusQ.add(num);
		    else if(num < 0)    minusQ.add(num);
		}
		
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		
		// 양수 우선순위 큐 크기가 2보다 작을 때까지
		while(plusQ.size() >= 2) {
		    data1 = plusQ.remove();
		    data2 = plusQ.remove();
		    
		    sum += data1 * data2;
		}
		
		if(!plusQ.isEmpty()) {
		    sum += plusQ.remove();
		}
		
		// 음수 처리
		while(minusQ.size() >= 2) {
		    data1 = minusQ.remove();
		    data2 = minusQ.remove();
		    
		    sum += data1 * data2;
		}
		
		if(!minusQ.isEmpty() && zero == 0) {
		    sum += minusQ.remove();
		}
		
		sum += one;
		System.out.println(sum);
	}
}