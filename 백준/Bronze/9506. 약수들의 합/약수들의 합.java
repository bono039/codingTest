import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
        
		while(true) {
		    list.clear();    // 리스트 초기화
		    int num = Integer.parseInt(br.readLine());
		    int sum = 0;
		    
		    if(num == -1) break;
		    
		    for(int i=1 ; i < num ; i++) {
		        if(num % i == 0) {
		            list.add(i);
		            sum += i;
		        }
		    }
		    
		    if(sum == num) {
		        int len = list.size();
		        
		        System.out.print(num + " = ");
		        for(int i=0 ; i < len -1 ; i++) {
		            System.out.print(list.get(i) + " + ");
		        }
		        System.out.print(list.get(len -1));
		        System.out.println();
		    }
		    else {
		        System.out.println(num + " is NOT perfect.");
		    }   
		}
	}
}