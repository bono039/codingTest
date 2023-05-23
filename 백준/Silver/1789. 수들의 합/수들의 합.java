import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		
		long i = 1;
		long cnt = 0;
		while(true) {
		    if(i < (S - i)) {
		        S -= i;
		        cnt++;
		        i++;
		    }
		    else {
		        break;
		    }
		}
		
		System.out.println(cnt + 1);
	}
}