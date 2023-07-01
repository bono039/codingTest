import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String str = "*";
		
		for(int i = 1 ; i <= N ; i++) {
		    sb.append(str.repeat(i)).append("\n");
		}
		System.out.println(sb);
	}
}
