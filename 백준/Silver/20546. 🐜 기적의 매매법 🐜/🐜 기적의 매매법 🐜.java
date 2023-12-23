import java.util.*;
import java.io.*;

public class Main {
    static int money;
    static int[] arr;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		money = Integer.parseInt(br.readLine());
		arr = new int[14];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < 14 ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int money1 = money;
		int stock1 = 0;
		
		for(int i = 0 ; i < 14 ; i++) {
		    int tmp = money1 / arr[i];
		    
		    if(tmp > 0) {
		        money1 -= arr[i] * tmp;
		        stock1 += tmp;
		    }
		}
		
		int money2 = money;
		int stock2 = 0;
		
		for(int i = 3 ; i < 14 ; i++) {
		    if((arr[i - 3] < arr[i - 2]) && (arr[i - 2] < arr[i - 1])) {
		        if(stock2 == 0) continue;
		        
		        money2 += stock2 * arr[i];
		        stock2 = 0;		        
		    }
		    else if((arr[i - 3] > arr[i - 2]) && (arr[i - 2] > arr[i - 1])) {
		        int tmp = money2 / arr[i];
		        if(tmp > 0)  {
		            money2 -= tmp * arr[i];
		            stock2 += tmp;
		        }
		    }
		}
		
		int jj = money1 + arr[13] * stock1;
		int ss = money2 + arr[13] * stock2;
		
		if(jj > ss)         System.out.println("BNP");
		else if(jj < ss)    System.out.println("TIMING");
		else                System.out.println("SAMESAME");
	}
}
