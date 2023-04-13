import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		long A = Long.parseLong(br.readLine());
		long B = Long.parseLong(br.readLine());
		long C = Long.parseLong(br.readLine());
		
		long[] arr = new long[10];
		
		long result = A * B * C;
		
		while(result > 0) {
		    arr[(int)result % 10]++;
		    result /= 10;
		}
		
		for(long i : arr) {
		    System.out.println(i);
		}
	}
}