import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int c = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < c ; i++) {
		    st = new StringTokenizer(br.readLine()," ");
		    
		    int cnt = Integer.parseInt(st.nextToken());
		    int[] arr = new int[cnt];
		    double sum = 0;
		    double avg = 0;
		    
		    for(int j = 0 ; j < cnt ; j++) {
		        arr[j] = Integer.parseInt(st.nextToken());
		        sum += arr[j];
		    }
		    
		    avg = sum / cnt;
		    
		    int over = 0;
		    for(int k : arr) {
		        if(k > avg) {
		            over++;
		        }
		    }
		    
		    System.out.printf("%.3f", over * 100 / (double)cnt);
		    System.out.print("%");
		    System.out.println();
		}	
	}
}