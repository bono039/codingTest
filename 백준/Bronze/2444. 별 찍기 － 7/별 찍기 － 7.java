import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		for(int i = 1 ; i <= N - 1 ; i++) {
		    sb.append(" ".repeat(N - i));            // 띄어쓰기
            sb.append("*".repeat(2*(i - 1) + 1));    // 별
            sb.append("\n");
		}
		
		for(int i = 1 ; i <= N ; i++) {
		    sb.append(" ".repeat(i - 1));           // 띄어쓰기
		    sb.append("*".repeat(2*(N - i) + 1));   // 별
		    sb.append("\n");
		}

		System.out.println(sb);
	}
}
