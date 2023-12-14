import java.util.*;
import java.io.*;

public class Main {
    static int DAY_OF_YEAR = 365;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] cntArr = new int[DAY_OF_YEAR + 1];
		
		while(N --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int S = Integer.parseInt(st.nextToken());
		    int E = Integer.parseInt(st.nextToken());
		    
		    for(int i = S ; i <= E ; i++) {
		        cntArr[i]++;
		    }
		}
		
		int total = 0;
		int w = 0;
		int maxH = 0;
		
		for(int i = 0 ; i <= DAY_OF_YEAR ; i++) {
		    if(cntArr[i] == 0) {
		        total += w * maxH;
		        
		        w = 0;
		        maxH = 0;
		        continue;
		    }
		    
		    w++;
		    maxH = Math.max(maxH, cntArr[i]);
		}
		
		total += w * maxH;
		System.out.println(total);
	}
}
