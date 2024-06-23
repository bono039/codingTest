import java.util.*;
import java.io.*;

public class Main {
    static int N, sum;
    static List<LowHigh> list = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        
	        int L = Integer.parseInt(st.nextToken());
	        int H = Integer.parseInt(st.nextToken());
	        
	        list.add(new LowHigh(L, H));
	    }
	    
	    Collections.sort(list, (o1, o2) -> o1.low - o2.low);
	    
	    sum = 0;
	    int maxHeightPoint = 0;
	    
	    LowHigh highC = list.get(0);
	    for(int i = 1 ; i < list.size() ; i++) {
	        LowHigh curC = list.get(i);
	        
	        if(highC.high <= curC.high) {
	            sum += (curC.low - highC.low) * highC.high;
	            highC = curC;
	            maxHeightPoint = i;
	        }
	    }
	    
	    highC = list.get(list.size() - 1);
	    for(int i = 1 ; i < list.size() - maxHeightPoint ; i++) {
	        LowHigh curC = list.get(list.size() - 1 - i);
	        
	        if(highC.high <= curC.high) {
	            sum += (highC.low - curC.low) * highC.high;
	            highC = curC;
	        }
	    }
	    
	    sum += list.get(maxHeightPoint).high;
	    
	    System.out.println(sum);
	}
}

class LowHigh {
    int low, high;
    
    public LowHigh(int low, int high) {
        this.low = low;
        this.high = high;
    }
}