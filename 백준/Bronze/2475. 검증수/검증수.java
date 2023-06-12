import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long total = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < 5 ; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    total += num * num;
		}
		
		System.out.println(total % 10);
	}
}