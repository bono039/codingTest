import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    var st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int answer = 1;
	    
	    for(int i=1 ; i <= n ; i++) {
	        answer *= i;
	    } 
		System.out.println(answer);
	}
}