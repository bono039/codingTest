import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int tmp = 0;
		int len = 10;
		
		for(int i = 1 ; i <= num ; i++) {
		    if(i == len) {
		        cnt++;
		        len *= 10;
		    }
		    
		    tmp += cnt;
		}
		
		System.out.println(tmp);
	}
}
