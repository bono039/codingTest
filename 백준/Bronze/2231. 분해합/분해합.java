import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int len = str.length() - 1;
		
		long answer = 0;
		for(long i = 1 ; i <= N ; i++) {
		    long tmp = 0;
		    long num = i;
		    while(num > 0) {
		        tmp += num % 10;
		        num /= 10;
		    }
		    if(i + tmp == N) {
		        answer = i;
		        break;
		    }
		}
		
		System.out.println(answer);
	}
}
